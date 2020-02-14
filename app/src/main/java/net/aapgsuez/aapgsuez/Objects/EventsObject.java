package net.aapgsuez.aapgsuez.Objects;

public class EventsObject {
    private String mName;
    private String mDate;
    private String mDesc;
    private String mImg;
    private String mUrl;


    public EventsObject(String name, String date, String desc, String img,String url) {
        mName = name;
        mDate = date;
        mDesc = desc;
        mImg = img;
        mUrl=url;


    }

    public String getmName() {
        return mName;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmDesc() {
        return mDesc;
    }

    public String getmimg() {
        return mImg;
    }

    public String getmUrl() {
        return mUrl;
    }
}
