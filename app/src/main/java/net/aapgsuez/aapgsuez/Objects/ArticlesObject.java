package net.aapgsuez.aapgsuez.Objects;

public class ArticlesObject {
    private String mName;
    private String mDesc;
    private String mimg;
    private String mUrl;



    public ArticlesObject(String name, String desc,String img,String Url) {
        mName = name;
        mDesc = desc;
        mimg = img;
        mUrl=Url;


    }

    public String getmName() {
        return mName;
    }


    public String getmDesc() {
        return mDesc;
    }

    public String getmimg() {
        return mimg;
    }

    public String getmUrl() {
        return mUrl;
    }
}
