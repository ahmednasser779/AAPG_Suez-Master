package net.aapgsuez.aapgsuez.Objects;

public class MagazineObject {
    private int mImageResource;
    private String mName;
    private String mDate;
    private String mUrl;


    public MagazineObject(int imageResource, String name, String date, String url) {
        mImageResource = imageResource;
        mName = name;
        mDate=date;
        mUrl=url;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmName() {
        return mName;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }
}