package com.androand.widget_and;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.paperdb.Paper;

/**
 *
 * ANITA DWI MAHARANI
 * 1657051008
 *
 */


public class MainActivity extends AppCompatActivity {

    //inisiasi item **1
    Button btn_save;
    EditText edit_title, edit_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init Paper   **4
        Paper.init(this);


        //panggil id dari layout xml **2
        btn_save = (Button) findViewById(R.id.btn_save);
        edit_title = (EditText) findViewById(R.id.edit_title);
        edit_content = (EditText) findViewById(R.id.edit_content);

        btn_save.setOnClickListener(new View.OnClickListener() {  //**3
            @Override
            public void onClick(View view) {
                // **5
                Paper.book().write("title", edit_title.getText().toString());
                Paper.book().write("content", edit_content.getText().toString());


                // ** 10
                //Toast digunakan untuk kata respon ketika mengklik button save
                Toast.makeText(MainActivity.this, "Save!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
