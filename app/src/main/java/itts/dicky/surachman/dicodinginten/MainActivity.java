package itts.dicky.surachman.dicodinginten;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private TextView tvResult;
    final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == fifth.RESULT_CODE && result.getData() != null) {
                    int selectedValue = result.getData().getIntExtra(fifth.EXTRA_SELECTED_VALUE, 0);
                    tvResult.setText(String.format("Hasil : %s", selectedValue));
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1= findViewById(R.id.but1);
        but2= findViewById(R.id.butt2);
        but3= findViewById(R.id.button3);
        but4 =findViewById(R.id.button4);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5 =findViewById(R.id.tombol5);
        but5.setOnClickListener(this);
        tvResult=findViewById(R.id.hasillima);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but1:
                Intent goto2 = new Intent(MainActivity.this,second_acivity.class);
                startActivity(goto2);
                break;
            case R.id.butt2:
                Intent goto3 = new Intent(MainActivity.this,third.class);
                goto3.putExtra(third.EXTRA_NAME,"Dicky Surachman");
                goto3.putExtra(third.EXTRA_AGE,"38");
                startActivity(goto3);
                break;
            case R.id.button3:
                Company person = new Company();
                person.setName("Dicky Surachman");
                person.setAge(38);
                person.setEmail("dicky.surachman1@gmail.com");
                person.setCity("Tangerang");
                Intent goto4 = new Intent(MainActivity.this,fourth.class);
                goto4.putExtra(fourth.EXTRA_PERSON, person);
                startActivity(goto4);
                break;
            case R.id.button4:
                String number ="08526388844";
                Intent goto5= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(goto5);
                break;
            case R.id.tombol5:
                Intent moveForResultIntent = new Intent(MainActivity.this, fifth.class);
                //startActivity(moveForResultIntent);
                resultLauncher.launch(moveForResultIntent);
                //resultLauncher.launch(moveForResultIntent);
                break;


        }
    }
}