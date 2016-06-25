package com.davidi.gymglishbrowser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dror on 24-Jun-16.
 */
public class LinkAdapter extends ArrayAdapter<Link> {
    private final Context context;
    private final ArrayList<Link> values;

    public LinkAdapter(Context context, ArrayList<Link> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = inflater.inflate(R.layout.list_item, parent, false);

        TextView linkName = (TextView) item.findViewById(R.id.url_name);
        TextView linkUrl = (TextView) item.findViewById(R.id.url_link);

        linkName.setText(values.get(position).getName());
        linkUrl.setText(values.get(position).getUrl());
        return item;
    }
}

