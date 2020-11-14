package com.example.calculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.txtNumeroUno);
        num2 = findViewById(R.id.txtNumeroDos);
        result = findViewById(R.id.lblResultado);
    }

    public void calculate(View v){
        if(validate()){
            double n1, n2, sum;
            n1 = Double.parseDouble(num1.getText().toString());
            n2 = Double.parseDouble(num2.getText().toString());
            sum = n1 + n2;
            result.setText(String.valueOf(sum));
        }
    }

    public void clear(View v){
        num1.setText("");
        num2.setText("");
        result.setText("");
        num1.requestFocus();
    }

    public boolean validate(){
        if(num1.getText().toString().isEmpty()){
            num1.setError(getString(R.string.input_error_one));
            num1.requestFocus();
            return false;
        }
        if(num2.getText().toString().isEmpty()){
            num2.setError(getString(R.string.input_error_two));
            num2.requestFocus();
            return false;
        }

        return true;
    }
}