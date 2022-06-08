package com.example.eetk;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class fragmentFriday extends ListFragment {
    String classID,tabID;
    ListAdapter adapter;

    public fragmentFriday() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Bundle bundle = getActivity().getIntent().getExtras();
        classID = bundle.getString("classID");


        switch (classID){

            case "1":
                adapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.aminova_sr));
                setListAdapter(adapter);
                break;
            case "2":
                adapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.saitova_sr));
                setListAdapter(adapter);
                break;
            case "3":
                adapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.popkova_sr));
                setListAdapter(adapter);
                break;

            case "4":
                adapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.serkova_sr));
                setListAdapter(adapter);
                break;
            case "5":
                adapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.koreganova_sr));
                setListAdapter(adapter);
                break;
            default:
                break;
        }



    }
   /* String prepodID;
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
            userCursor = sqlHelper.database.rawQuery("select * from " + DatabaseHelper.TABLE + " where class="+prepodID+" and day=4", null);
            String[] headers = new String[]{DatabaseHelper.COLUMN_GROUP};
            userAdapter = new SimpleCursorAdapter(getActivity(),
                    //взято из item.xml
                    R.layout.item, userCursor, headers, new int[]{R.id.para},0);
            mList.setAdapter(userAdapter);

        }
        catch (SQLException ex){}
    }*/
}