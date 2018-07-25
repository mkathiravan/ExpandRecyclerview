package com.example.user.expandrecyclerview;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;


import java.util.List;

/**
 * Created by user on 28-06-2018.
 */

public class Genre extends ExpandableGroup<FormPreFillData>{

    int HdrIndex;

    public int getHdrIndex() {
        return HdrIndex;
    }

    List<String> HdrTitle;
    public Genre(String title, int Index, List<FormPreFillData> items) {
        super(title, items);
        HdrIndex=Index;
    }



}

