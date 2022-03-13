package itts.dicky.surachman.dicodinginten;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class third extends AppCompatActivity {
    public static final String EXTRA_AGE = "3";
    public static final String EXTRA_NAME = "extra_name";
    TextView tulisan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        tulisan =findViewById(R.id.textView2);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        //String age = getIntent().getStringExtra(EXTRA_AGE);
        Integer age = Integer.parseInt(getIntent().getStringExtra(EXTRA_AGE).toString());
        String teks = "Nama :" + name + ", Your Age :"+  age;
        tulisan.setText(teks);
    }
}