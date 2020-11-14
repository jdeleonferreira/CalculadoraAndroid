package com.example.calculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private TextView result;

    private Spinner combo;
    private String[] options;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //capture of used objects
        num1 = findViewById(R.id.txtNumeroUno);
        num2 = findViewById(R.id.txtNumeroDos);
        result = findViewById(R.id.lblResultado);
        combo = findViewById(R.id.cmbOperations);

        //Retrieve all operations
        options = getResources().getStringArray(R.array.operations);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, options);

        combo.setAdapter(adapter);
    }

    public void calculate(View v){
        double n1, n2, res = 0;
        int op;
        if(validate()){
            n1 = Double.parseDouble(num1.getText().toString());
            n2 = Double.parseDouble(num2.getText().toString());

            op = combo.getSelectedItemPosition();
            switch (op){
                case 0:
                    res = n1 + n2;
                    break;
                case 1:
                    res = n1 - n2;
                    break;
                case 2:
                    res = n1 * n2;
                    break;
                case 3:
                    res = n1 / n2;

            }
            result.setText(String.format("%.2f", res));
        }
    }

    public void clear(View v){
        num1.setText("");
        num2.setText("");
        result.setText("");
        num1.requestFocus();
    }

    public boolean validate(){
        int op = combo.getSelectedItemPosition();

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

        double n2 = Double.parseDouble(num2.getText().toString());

        if(n2 == 0 && op ==3 ){
            num2.setError(getString(R.string.mensaje_error_division_cero));
            num2.requestFocus();
            return false;
        }

        return true;
    }
}