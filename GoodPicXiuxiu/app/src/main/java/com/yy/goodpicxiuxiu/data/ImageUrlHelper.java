package com.yy.goodpicxiuxiu.data;

import com.yy.goodpicxiuxiu.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ImageUrlHelper {
    private static final String TAG = "ImageUrlHelper";

    private final  static String URL_FIRSET_SECTION = "http://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&queryWord=%E7%BE%8E%E5%A5%B3&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=&z=&ic=&word=%E7%BE%8E%E5%A5%B3&s=&se=&tab=&width=&height=&face=&istype=&qc=&nc=1&fr=&cg=girl&pn=";
    private final  static String URL_MIDDLE_SECTION = "&rn=30&gsm=5a&";

    private static int mPageNumber = 1;

    /**
     *  生成获取图片url列表的链接
     */
    public static String generageNewURL(){
        return URL_FIRSET_SECTION + mPageNumber++ + URL_MIDDLE_SECTION + System.currentTimeMillis() + "=";
    }


//    public static String getJSONFromURL(String imgURL){
//        HttpURLConnection conn = null; //连接对象
//        InputStream is = null;
//        String resultData = "";
//        try {
//            Log.d(TAG,"getJSONFromURL:" + imgURL);
//
//            URL url = new URL(imgURL); //URL对象
//            conn = (HttpURLConnection) url.openConnection(); //使用URL打开一个链接
//            conn.setDoInput(true); //允许输入流，即允许下载
//            conn.setUseCaches(true); //不使用缓冲
//            conn.setRequestMethod("GET"); //使用get请求
//            is = conn.getInputStream();   //获取输入流，此时才真正建立链接
//
//            Log.d(TAG,"ResponseCode:" + conn.getResponseCode());
//
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader bufferReader = new BufferedReader(isr);
//            String inputLine = "";
//            while ((inputLine = bufferReader.readLine()) != null) {
//                resultData += inputLine + "\n";
//            }
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (conn != null) {
//                conn.disconnect();
//            }
//        }
//        return resultData;
//
//    }


    public static List<String> getImagesUrl(String json){
        ArrayList<String> result = new ArrayList<String>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            android.util.Log.d(TAG,"" + json);
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
                        android.util.Log.d(TAG,"get Largest Imag:" + hdImgURl);
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
