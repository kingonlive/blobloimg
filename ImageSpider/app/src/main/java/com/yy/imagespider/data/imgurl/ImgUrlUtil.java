package com.yy.imagespider.data.imgurl;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yy.imagespider.util.GlobalConfig;
import com.yy.imagespider.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImgUrlUtil {
    public static final String TAG = "ImgUrlUtil";
    private final  static String URL_FIRSET_SECTION = "http://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&queryWord=%E7%BE%8E%E5%A5%B3&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=&z=&ic=&word=%E7%BE%8E%E5%A5%B3&s=&se=&tab=&width=&height=&face=&istype=&qc=&nc=1&fr=&cg=girl&pn=";
    private final  static String URL_MIDDLE_SECTION = "&rn=30&gsm=5a&";

    private static int mPageNumber = 1;

    /**
     *  生成获取图片url列表的链接
     * @return
     */
    private static String generageNewURL(){
        return URL_FIRSET_SECTION + mPageNumber++ + URL_MIDDLE_SECTION + System.currentTimeMillis() + "=";
    }

    public static void getImagesUrl(final OnUrlGetListener listener){
        RequestQueue requestQueue = Volley.newRequestQueue(GlobalConfig.getInstance().getContext());
        requestQueue.add(new StringRequest(generageNewURL(), new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                List<String> resutl = getImagesUrl(response);
                listener.onGetUrl(resutl);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onGetUrl(Collections.<String>emptyList());
            }
        }));
    }

    private static List<String> getImagesUrl(String json){
        ArrayList<String> result = new ArrayList<String>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if (jsonObject1 == null) continue;

                String imgURL = jsonObject1.optString("ObjURL");

                //这里能拿到更高清的图片
                JSONArray hdImgArray = jsonObject1.optJSONArray("replaceUrl");
                if (hdImgArray != null && hdImgArray.length() > 0){
                    //从数组的第一个元素拿高清图
                    String hdImgURl = hdImgArray.getJSONObject(0).optString("ObjURL");
                    if (hdImgURl != null && !hdImgURl.equals("")){
                        //先用更高清的图片
                        imgURL = hdImgURl;
                    }
                }

                if (imgURL == null || imgURL.equals("")){
                    imgURL = jsonObject1.optString("hoverURL");
                }

                if (imgURL == null || imgURL.equals("")){
                    imgURL = jsonObject1.optString("thumbURL");
                }
                if (imgURL == null || imgURL.equals("")){
                    imgURL = jsonObject1.optString("middleURL");
                }

                if (imgURL != null && !imgURL.trim().equals("")){
                    result.add(imgURL);
                }
            }
        }catch (Throwable e){
            Log.d(TAG,"getImagesUrl error!",e);
        }
        return result;
    }
}
