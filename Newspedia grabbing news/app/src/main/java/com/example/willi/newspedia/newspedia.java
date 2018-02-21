package com.example.willi.newspedia;

/**
 * Created by willi on 11/24/2017.
 */

public class newspedia {
    private String title;
    private String section;
    private String date;
    private String link;

    public newspedia(String titleId, String sectionId, String datetime, String weburl)
    {
        title = titleId;
        section = sectionId;
        date = datetime;
        link = weburl;
    }

    public String getTitle() { return title; }

    public String getSection() { return section; }

    public String getDate() { return date; }

    public String getLink() { return link; }


}

