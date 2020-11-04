package ie.ucc.bis.is4447.mylistviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        final EditText etEnterTemp = findViewById(R.id.etEnterTemp);
        final Spinner spType = (Spinner) findViewById(R.id.spType);
        Button btnConvert = (Button) findViewById(R.id.btnConvert);
        Button btnConvertInSecondActivity = (Button) findViewById(R.id.btnConvertInSecondActivity);
        final TextView tvResult = (TextView) findViewById(R.id.tvResult);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etEnterText = String.valueOf(etEnterTemp.getText());
                double convertedValue, finalValue;

                if (etEnterText.isEmpty()) {
                    Toast.makeText(TemperatureActivity.this, "Please Enter A Temperature", Toast.LENGTH_SHORT).show();
                }else{
                    final double tempValue = Double.parseDouble(String.valueOf(etEnterTemp.getText()));
                    switch (spType.getSelectedItemPosition()){
                        case 0:
                            Toast.makeText(TemperatureActivity.this, "Please Select A Temperature Type", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            convertedValue = convertToCelsius(tempValue);
                            finalValue = Math.round(convertedValue * 100.0)/100.0;
                            tvResult.setText(etEnterText +" Fahrenheit is\n" + String.valueOf(finalValue) + " Celsius" );
                            tvResult.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            convertedValue = convertToFahrenheit(tempValue);
                            finalValue = Math.round(convertedValue * 100.0)/100.0;
                            tvResult.setText(etEnterText +" Celsius is\n" + String.valueOf(finalValue) + " Fahrenheit" );
                            tvResult.setVisibility(View.VISIBLE);
                            break;
                    }
                }

            }
        });

        btnConvertInSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setVisibility(View.INVISIBLE);
                String etEnterText = String.valueOf(etEnterTemp.getText());
                double convertedValue, finalValue;

                if (etEnterText.isEmpty()) {
                    Toast.makeText(TemperatureActivity.this, "Please Enter A Temperature", Toast.LENGTH_SHORT).show();
                }else{
                    final double tempValue = Double.parseDouble(String.valueOf(etEnterTemp.getText()));
                    switch (spType.getSelectedItemPosition()){
                        case 0:
                            Toast.makeText(TemperatureActivity.this, "Please Select A Temperature Type", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            convertedValue = convertToCelsius(tempValue);
                            finalValue = Math.round(convertedValue * 100.0)/100.0;
                            tvResult.setText(etEnterText +" Fahrenheit is\n" + String.valueOf(finalValue) + " Celsius" );

                            break;
                        case 2:
                            convertedValue = convertToFahrenheit(tempValue);
                            finalValue = Math.round(convertedValue * 100.0)/100.0;
                            tvResult.setText(etEnterText +" Celsius is\n" + String.valueOf(finalValue) + " Fahrenheit" );

                            break;
                    }

                    Intent startIntent = new Intent(getApplicationContext(), TempResult.class);
                    startIntent.putExtra("PASSING_RESULT", tvResult.getText().toString());
                    startActivity(startIntent);
                }
            }
        });

    }

    public double convertToCelsius(double farValue){
        // c = (f-32)*5/9

        double resultValue;
        resultValue = (farValue - 32) * 5/9;
        return resultValue;
    }

    public double convertToFahrenheit(double celValue){
        // f = c * 9/5 + 32

        double resultValue;
        resultValue = (celValue * 9/5) + 32;
        return resultValue;
    }

    public double convertToKelvinFromCelsius(double kelValue){
        // k = c +  + 273.15

        double resultValue;
        resultValue = (kelValue  + 273.15);
        return resultValue;
    }

    public double convertToKelvinFromFahrenheit(double kelValue){
        // k = (f − 32) * 5/9 + 273.15

        double resultValue;
        resultValue = (kelValue - 32) * 5/9 + 273.15;
        return resultValue;
    }
}