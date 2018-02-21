package com.example.willi.newspedia;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class newspediaAdapter extends BaseAdapter {

    private List<newspedia> newspedias = new ArrayList<newspedia>();
    private static final String LOG_TAG = newspediaAdapter.class.getSimpleName();
    private LayoutInflater inflater;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param newspedias A List of newspedia objects to display in a list
     */
    public newspediaAdapter(Context context, List<newspedia> newspedias) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        this.newspedias = newspedias;
        inflater = LayoutInflater.from(context);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = inflater.inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link newspedia} object located at this position in the list
        newspedia currentnewspedia = (newspedia) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        // Get the version name from the current newspedia object and
        // set this text on the name TextView
        titleTextView.setText(currentnewspedia.getTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section);
        // Get the version number from the current newspedia object and
        // set this text on the number TextView
        sectionTextView.setText(currentnewspedia.getSection());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Get the version name from the current newspedia object and
        // set this text on the name TextView
        dateTextView.setText(currentnewspedia.getDate());

        // Return the whole list item layout (containing 4 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    @Override
    public Object getItem(int position) {
        return newspedias.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getCount() {
        return newspedias.size();
    }
    public String getUrl(int position) {
        return newspedias.get(position).getLink();
    }
    public void setnewspedia(List<newspedia> data) {
        newspedias.addAll(data);
        notifyDataSetChanged();
    }
}