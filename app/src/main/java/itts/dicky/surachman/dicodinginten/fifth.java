package itts.dicky.surachman.dicodinginten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class fifth extends AppCompatActivity implements View.OnClickListener {

    Button buttonv;
    private RadioGroup rgNumber;
    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        rgNumber = findViewById(R.id.rg_number);
        buttonv = findViewById(R.id.buttonlima);
        buttonv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonlima:
                if (rgNumber.getCheckedRadioButtonId() != 0) {
                    int value = 0;
                    int id = rgNumber.getCheckedRadioButtonId();
                    if (id == R.id.rd_50) {
                        value = 50;
                    } else if (id == R.id.rd_100) {
                        value = 100;
                    } else if (id == R.id.rd_150) {
                        value = 150;
                    } else if (id == R.id.rd_200) {
                        value = 200;
                    }
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                    setResult(RESULT_CODE, resultIntent);
                    finish();
                }
                break;



        }
    }
}