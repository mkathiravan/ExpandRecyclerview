package com.example.user.expandrecyclerview;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;


import org.w3c.dom.Text;

/**
 * Created by user on 28-06-2018.
 */

public class FormSubViewHolder extends ChildViewHolder {

    private TextView childTextView;


    public FormSubViewHolder(View itemView) {
        super(itemView);

        childTextView = (TextView)itemView.findViewById(R.id.list_item_artist_name);
    }

    public void setFormName(String name)
    {
        childTextView.setText(name);
    }
}
