package com.example.eetk;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class fragment2 extends Fragment {
    String prepodID;
    SimpleCursorAdapter userAdapter;
    DatabaseHelper sqlHelper;
    Cursor userCursor;
    ListView mList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fragment1, container, false);
        mList = (ListView) rootview.findViewById(R.id.listViewF1);
        return rootview;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sqlHelper = new DatabaseHelper(getActivity());
        sqlHelper.create_db();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            sqlHelper.open();
            userCursor = sqlHelper.database.rawQuery("select * from " + DatabaseHelper.TABLE + " where class="+prepodID+" and day=2", null);
            String[] headers = new String[]{DatabaseHelper.COLUMN_GROUP};
            userAdapter = new SimpleCursorAdapter(getActivity(),
                    //взято из item.xml
                    R.layout.item, userCursor, headers, new int[]{R.id.para},0);
            mList.setAdapter(userAdapter);

        }
        catch (SQLException ex){}
    }
}