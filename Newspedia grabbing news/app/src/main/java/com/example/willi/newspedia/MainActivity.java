package com.example.willi.newspedia;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.net.Uri;
import android.content.Intent;

import java.lang.Override;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<List<newspedia>> {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    newspediaAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnews);
        Log.d("new","heyhey");
        // Create an ArrayList of newspedia objects
        // Get a reference to the ListView, and attach the adapter to the listView.
		newsAdapter = new newspediaAdapter(this,new ArrayList<newspedia>());
        ListView listView = (ListView) findViewById(R.id.listview_news);
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView2 = (ListView) findViewById(R.id.listview_news);
                newspedia obj = (newspedia)  listView2.getAdapter().getItem(position);
                Log.d("objtostring",obj.getLink());
                Uri uri = Uri.parse(obj.getLink());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();
    }

    @Override
    public Loader<List<newspedia>> onCreateLoader(int id, Bundle args) {
        return new newspediaLoader(MainActivity.this);
    }
    @Override
    public void onLoadFinished(Loader<List<newspedia>> loader, List<newspedia> data) {
        newsAdapter.setnewspedia(data);
    }
    @Override
    public void onLoaderReset(Loader<List<newspedia>> loader) {
        newsAdapter.setnewspedia(new ArrayList<newspedia>());
    }
}
