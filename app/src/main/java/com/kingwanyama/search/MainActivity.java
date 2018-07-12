package com.kingwanyama.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText mSearch;
    ListView seachList;
    String[] items;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch = findViewById(R.id.edtSearch);
        seachList = findViewById(R.id.listSearch);
        items = new String[] {"Kenay","Uganda","Tanzania","Mozamboque","Mauritius","Canada","Sudan","Jerusalem"
                ,"Uganda","Tanzania","Mozamboque","Mauritius","Canada","Sudan","Jerusalem"
                ,"Uganda","Tanzania","Mozamboque","Mauritius","Canada","Sudan","Jerusalem"
                ,"Uganda","Tanzania","Mozamboque","Mauritius","Canada","Sudan","Jerusalem"
                ,"Uganda","Tanzania","Mozamboque","Mauritius","Canada","Sudan","Jerusalem"
                ,"Uganda","Tanzania","Mozamboque","Mauritius","Canada","Sudan","Jerusalem"
                ,"Uganda","Tanzania","Mozamboque","Mauritius","Canada","Sudan","Jerusalem"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this,R.layout.item_layout,R.id.tvDisp,arrayList);
        seachList.setTextFilterEnabled(true);
        seachList.setAdapter(adapter);
        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.adapter.getFilter().filter(charSequence);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
