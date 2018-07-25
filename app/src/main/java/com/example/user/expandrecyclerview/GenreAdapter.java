package com.example.user.expandrecyclerview;

import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;


import java.util.List;

/**
 * Created by user on 28-06-2018.
 */

public class GenreAdapter extends ExpandableRecyclerViewAdapter<GenreViewHolder,FormSubViewHolder>{


    public GenreAdapter(List<? extends ExpandableGroup> groups) {

        super(groups);
    }

    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_genre,parent,false);
        return new GenreViewHolder(view);
    }

    @Override
    public FormSubViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sublist,parent,false);
        return new FormSubViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(FormSubViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

        FormPreFillData fromlist = ((Genre)group).getItems().get(childIndex);
        holder.setFormName(fromlist.getPrefilldescription());

    }

    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition, ExpandableGroup group) {
        ImageView imageView = holder.itemView.findViewById(R.id.list_item_genre_arrow);

        if(((Genre)group).getItems().size()==0)
        {
            imageView.setVisibility(View.GONE);
        }
        else
        {
            imageView.setVisibility(View.VISIBLE);
        }
        holder.setGenreTitle(group);

    }


}
