package com.yy.imagespider.data;

import com.yy.imagespider.util.Log;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by chenyanyin on 18/1/30.
 */

public class ImageUrlHelperTest {
    private static final String TAG = "ImageUrlHelperTest";
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getImageUrlsTest(){
        String url = ImageUrlHelper.generageNewURL(0);
        String json = ImageUrlHelper.getJSONFromURL(url);
        List<String> imglist = ImageUrlHelper.getImagesUrl(json);

        System.out.println(url);
        System.out.println(json);

//        {
//            "queryEnc": "%E7%BE%8E%E5%A5%B3",
//                "queryExt": "美女",
//                "listNum": 1969,
//                "displayNum": 396088,
//                "gsm": "21",
//                "bdFmtDispNum": "约396,000",
//                "bdSearchTime": "",
//                "isNeedAsyncRequest": 0,
//                "bdIsClustered": "1",
//                "data": [
//            {
//                "adType": "0",
//                    "hasAspData": "0",
//                    "thumbURL": "http://img2.imgtn.bdimg.com/it/u=2246315156,1662169434&fm=27&gp=0.jpg",
//                    "middleURL": "http://img2.imgtn.bdimg.com/it/u=2246315156,1662169434&fm=27&gp=0.jpg",
//                    "largeTnImageUrl": "",
//                    "hasLarge": 0,
//                    "hoverURL": "http://img2.imgtn.bdimg.com/it/u=2246315156,1662169434&fm=27&gp=0.jpg",
//                    "pageNum": 3,
//                    "objURL": "ippr_z2C$qAzdH3FAzdH3Ft42_z&e3Bp7rtwgz3_z&e3Bv54AzdH3F7rs5w1fAzdH3FBtzitAzdH3F4gcn_8dbad_z&e3B3r2",
//                    "fromURL": "ippr_z2C$qAzdH3FAzdH3Fooo_z&e3Bp7rtwgz3_z&e3Bv54AzdH3FktzitAzdH3FDN4jtgeAzdH3Fbncl_8dbax8ad9_z&e3Bip4s",
//                    "fromURLHost": "www.tupianzj.com",
//                    "currentIndex": "",
//                    "width": 1280,
//                    "height": 1024,
//                    "type": "jpg",
//                    "is_gif": 0,
//                    "filesize": "",
//                    "bdSrcType": "0",
//                    "di": "171146026150",
//                    "pi": "0",
//                    "is": "0,0",
//                    "replaceUrl": [
//                {
//                    "ObjURL": "http:\/\/img1.imgtn.bdimg.com\/it\/u=2246315156,1662169434&fm=214&gp=0.jpg",
//                        "FromURL": "http:\/\/www.zcool.com.cn\/work\/zntuwnjazmg==.html?switchpage=on"
//                },
//                {
//                    "ObjURL": "http:\/\/img.netbian.com\/file\/2017\/0220\/ea5a9713f508413aa8a4aefe7f4f35c5.jpg",
//                        "FromURL": "http:\/\/www.netbian.com\/desk\/17799-1920x1080.htm"
//                }
//      ],
//                "hasThumbData": "0",
//                    "bdSetImgNum": 0,
//                    "partnerId": 0,
//                    "spn": 0,
//                    "bdImgnewsDate": "1970-01-01 08:00",
//                    "fromPageTitle": "高清欧美性感<strong>美女<\/strong>壁纸【1280x1024】",
//                    "fromPageTitleEnc": "高清欧美性感美女壁纸【1280x1024】",
//                    "bdSourceName": "",
//                    "bdFromPageTitlePrefix": "",
//                    "isAspDianjing": 0,
//                    "token": "",
//                    "imgType": "",
//                    "cs": "2246315156,1662169434",
//                    "os": "2175231230,1722949537",
//                    "simid": "3403559837,412345884",
//                    "personalized": "0",
//                    "simid_info": null,
//                    "face_info": null,
//                    "xiangshi_info": null,
//                    "adPicId": "0",
//                    "source_type": ""
//            },


        for (String imgUrl : imglist){
            System.out.println("img:" + imgUrl);
        }
    }
}
