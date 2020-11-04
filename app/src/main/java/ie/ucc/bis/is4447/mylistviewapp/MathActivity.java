package ie.ucc.bis.is4447.mylistviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MathActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFirstNumber, etSecondNumber;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView tvResult;
    int num1, num2, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_math);

    etFirstNumber = findViewById(R.id.etFirstNumber);
    etSecondNumber = findViewById(R.id.etSecondNumber);

    btnAdd = findViewById((R.id.btnAdd));
    btnSubtract = findViewById((R.id.btnSubtract));
    btnMultiply = findViewById((R.id.btnMultiply));
    btnDivide = findViewById((R.id.btnDivide));

    tvResult = findViewById(R.id.tvResult);

       /* btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(etFirstNumber.getText().toString());
                int num2 = Integer.parseInt(etSecondNumber.getText().toString());
                int result = num1 + num2;

                tvResult.setText(String.valueOf(result));
            }
        }); */

       btnAdd.setOnClickListener(this);
       btnSubtract.setOnClickListener(this);
       btnDivide.setOnClickListener(this);
       btnMultiply.setOnClickListener(this);

}

    @Override
    public void onClick(View view) {
        num1 = Integer.parseInt(etFirstNumber.getText().toString());
        num2 = Integer.parseInt(etSecondNumber.getText().toString());

        switch(view.getId()){
            case R.id.btnAdd:
                result = num1 + num2;
                tvResult.setText(String.valueOf(result));
                //etFirstNumber.setText("");
                etFirstNumber.getText().clear();
                etSecondNumber.getText().clear();
                etFirstNumber.requestFocus();
                break;
            case R.id.btnMultiply:
                result = num1 * num2;
                tvResult.setText(String.valueOf(result));
                //etFirstNumber.setText("");
                etFirstNumber.getText().clear();
                etSecondNumber.getText().clear();
                etFirstNumber.requestFocus();
                break;
            case R.id.btnSubtract:
                result = num1 - num2;
                tvResult.setText(String.valueOf(result));
                //etFirstNumber.setText("");
                etFirstNumber.getText().clear();
                etSecondNumber.getText().clear();
                etFirstNumber.requestFocus();
                break;
            case R.id.btnDivide:
                result = num1 / num2;
                tvResult.setText(String.valueOf(result));
                //etFirstNumber.setText("");
                etFirstNumber.getText().clear();
                etSecondNumber.getText().clear();
                etFirstNumber.requestFocus();
                break;

        }
    }
}