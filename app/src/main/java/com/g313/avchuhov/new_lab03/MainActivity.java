//Made by Avchuhov Vlad, group313
package com.g313.avchuhov.new_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textFrom;
    TextView textTo;
    Spinner spinFrom;
    Spinner spinTo;
    double from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFrom = findViewById(R.id.input_text);
        textTo = findViewById(R.id.output_text);
        spinFrom = findViewById(R.id.input_spinner);
        spinTo = findViewById(R.id.output_spinner);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spinFrom.setAdapter(adp);
        spinTo.setAdapter(adp);
    }

    boolean getNumber()
    {
        String strFrom = textFrom.getText().toString();
        try
        {
            from = Double.parseDouble(strFrom);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void onConvert (View v)
    {
        getNumber();
        if (getNumber() == false)
        {
            textTo.setText("Некорректный ввод");
            return;
        }

        String strSpinFrom = (String) spinFrom.getSelectedItem();
        String strSpinTo = (String) spinTo.getSelectedItem();

        double to = 0.0d;
        double m = 0.0d;

        if (strSpinFrom.equals("mm")) m = from / 1000.0d;
        if (strSpinFrom.equals("cm")) m = from / 100.0d;
        if (strSpinFrom.equals("m")) m = from;
        if (strSpinFrom.equals("km")) m = from * 1000.0d;

        if (strSpinTo.equals("mm")) to = m * 1000.0d;
        if (strSpinTo.equals("cm")) to = m * 100.0d;
        if (strSpinTo.equals("m")) to = m;
        if (strSpinTo.equals("km")) to = m / 1000.0d;

        textTo.setText(String.valueOf(to));
    }

}