package com.example.nam.gamebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class memo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        final ArrayList<String> memo = new ArrayList<String>();

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, memo);


        final ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);


        //추가버튼
        Button addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed = (EditText)findViewById(R.id.lv_memo);
                switch (view.getId()){
                    case R.id.add:
                        String text = ed.getText().toString();
                        if(text.length()!=0){
                            memo.add(text);
                            ed.setText("");
                            adapter.notifyDataSetChanged();
                        }
                        break;
                }



            }
        });
        //이름변경
        Button modifyButton = (Button) findViewById(R.id.modify);
        modifyButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count, checked;
                count = adapter.getCount();

                if (count > 0) {

                    checked = listview.getCheckedItemPosition();
                    if (checked > -1) {

                        EditText edd = (EditText)findViewById(R.id.lv_memo);
                        switch (view.getId()){
                            case R.id.add:
                                String text = edd.getText().toString();
                                if(text.length()!=0){
                                    memo.add(text);
                                    edd.setText("");
                                    adapter.notifyDataSetChanged();
                                }

                        }

                    }
                }
            }
        });
        //삭제
        Button deleteButton = (Button) findViewById(R.id.delete);
        deleteButton.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View view) {
                int count, checked;
                count = adapter.getCount();

                if (count > 0) {

                    checked = listview.getCheckedItemPosition();

                    if (checked > -1) {

                        memo.remove(checked);


                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}