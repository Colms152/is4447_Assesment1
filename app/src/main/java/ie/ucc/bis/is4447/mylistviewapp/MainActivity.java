package ie.ucc.bis.is4447.mylistviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSecondActivity = (Button) findViewById(R.id.btnSecondActivity);
        Button btnMath = (Button) findViewById(R.id.btnMath);
        Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
        Button btnTemp = (Button) findViewById(R.id.btnTemp);

        //launch an activity within our app
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), ListviewActivity.class);
                startIntent.putExtra("PASSINGSOMETHING", "hello world !!");
                startActivity(startIntent);
            }

        });

        btnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMath = new Intent(getApplicationContext(), MathActivity.class);
                startActivity(gotoMath);
            }

        });

        btnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoTemp = new Intent(getApplicationContext(), TemperatureActivity.class);
                startActivity(gotoTemp);
            }

        });

        //launch an activity outside our app
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "https://www.google.com";
                Uri webaddress = Uri.parse(google);


                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);

                if(gotoGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGoogle);
                }
            }
        });

    }
}