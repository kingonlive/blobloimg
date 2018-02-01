package com.yy.goodpicxiuxiu.data;


import java.util.List;

public class ImgFather {
    /**
     * 搜索关键字的encode编码
     */
    private String queryEnc;
    /**
     * 搜索关键字名称
     */
    private String queryExt;
    private int listNum;
    //396088
    private int displayNum;
    private String gsm;
    //约396,000
    private String bdFmtDispNum;

    private String bdSearchTime;
    private int isNeedAsyncRequest;
    private String bdIsClustered;
    private List<ImgData> data;

    public String getQueryEnc() {
        return queryEnc;
    }

    public void setQueryEnc(String queryEnc) {
        this.queryEnc = queryEnc;
    }

    public String getQueryExt() {
        return queryExt;
    }

    public void setQueryExt(String queryExt) {
        this.queryExt = queryExt;
    }

    public int getListNum() {
        return listNum;
    }

    public void setListNum(int listNum) {
        this.listNum = listNum;
    }

    public int getDisplayNum() {
        return displayNum;
    }

    public void setDisplayNum(int displayNum) {
        this.displayNum = displayNum;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getBdFmtDispNum() {
        return bdFmtDispNum;
    }

    public void setBdFmtDispNum(String bdFmtDispNum) {
        this.bdFmtDispNum = bdFmtDispNum;
    }

    public String getBdSearchTime() {
        return bdSearchTime;
    }

    public void setBdSearchTime(String bdSearchTime) {
        this.bdSearchTime = bdSearchTime;
    }

    public int getIsNeedAsyncRequest() {
        return isNeedAsyncRequest;
    }

    public void setIsNeedAsyncRequest(int isNeedAsyncRequest) {
        this.isNeedAsyncRequest = isNeedAsyncRequest;
    }

    public String getBdIsClustered() {
        return bdIsClustered;
    }

    public void setBdIsClustered(String bdIsClustered) {
        this.bdIsClustered = bdIsClustered;
    }

    public List<ImgData> getData() {
        return data;
    }

    public void setData(List<ImgData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ImgFather{" +
                "queryEnc='" + queryEnc + '\'' +
                ", queryExt='" + queryExt + '\'' +
                ", listNum=" + listNum +
                ", displayNum=" + displayNum +
                ", gsm='" + gsm + '\'' +
                ", bdFmtDispNum='" + bdFmtDispNum + '\'' +
                ", bdSearchTime='" + bdSearchTime + '\'' +
                ", isNeedAsyncRequest=" + isNeedAsyncRequest +
                ", bdIsClustered='" + bdIsClustered + '\'' +
                ", data=" + data +
                '}';
    }
}
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
//                ],
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