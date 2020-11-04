package ie.ucc.bis.is4447.mylistviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TempResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_result);

        String result = getIntent().getExtras().getString("PASSING_RESULT");

        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText(result);
    }
}