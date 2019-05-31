package com.example.moneyconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText cash_input;
    Button RptoUsd;
    TextView result;
    double number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cash_input = (EditText) findViewById(R.id.cash_input);
        RptoUsd = (Button) findViewById(R.id.RptoUsd);

        result =(TextView) findViewById(R.id.result);
    }

    public boolean uang(){
         if (cash_input.getText().toString().isEmpty()){
             Toast.makeText(this,"Input your money", Toast.LENGTH_SHORT).show();
             return false;
         }
         return true;
    }

    public void toUsd(View view){
            if (!uang()){
                return;
            }

            try {
                 number = Double.parseDouble(cash_input.getText().toString());
            }catch (Exception ex){
                Toast.makeText(this,"Input number", Toast.LENGTH_SHORT).show();
            }
            double outcome = number / 14369;
            result.setText(NumberFormat.getCurrencyInstance(Locale.US).format(outcome));
            Toast.makeText(this, "1 USD = Rp. 14369", Toast.LENGTH_SHORT).show();
    }
}
