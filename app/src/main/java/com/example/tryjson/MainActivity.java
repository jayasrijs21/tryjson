package com.example.tryjson;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String JSON_STRING = "{\n" +
            "  \"users\": [\n" +
            "    {\"company\": \"amazon\"},\n" +
            "    {\"company\" :  \"google\"},\n" +
            "    {\"company\" :  \"microsoft\"}\n" +
            "  ]\n" +
            "}";




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            list =findViewById(R.id.listView);
            List<String> items = new ArrayList<>();

            JSONObject obj = new JSONObject(JSON_STRING);
            JSONArray object = obj.getJSONArray("users");

            for(int i = 0 ; i< object.length() ; i++) {

                JSONObject ans = object.getJSONObject(i);
                items.add(ans.getString("company"));

            }
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);

            if(list != null) {
                list.setAdapter(adapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}