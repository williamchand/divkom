package com.example.willi.newspedia;

/**
 * Created by willi on 11/26/2017.
 */
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class newspediaLoader extends AsyncTaskLoader<List<newspedia>> {
    public static final String LOG_TAG = newspediaLoader.class.getSimpleName();
    private static final String NEWS_REQUEST_URL =
            "https://content.guardianapis.com/search?q=bitcoin&api-key=31dcf8d7-2035-4caa-ae09-e61e471e6269";
    public newspediaLoader(Context context) {
        super(context);
    }
    @Override
    public List<newspedia> loadInBackground() {
        List<newspedia> list = Utils.fetchnewsData(NEWS_REQUEST_URL);
        return list;
    }
}