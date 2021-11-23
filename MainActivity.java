package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;

    TextView textView;
    Button btnCreate;


    String resultSu = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnResult1);
        btn2 = findViewById(R.id.btnResult2);
        btn3 = findViewById(R.id.btnResult3);
        btn4 = findViewById(R.id.btnResult4);
        btn5 = findViewById(R.id.btnResult5);
        btn6 = findViewById(R.id.btnResult6);

        textView = findViewById(R.id.txtResult);
        btnCreate = findViewById(R.id.btnRandomGo);

        btnCreate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        resultSu = "";
        Random random = new Random();

        int[] numArray = new int[6];

        for (int i = 0; i < 6; i++) {
            numArray[i] = random.nextInt(45) + 1;

            for (int j = 0; j < i; j++) {
                if (numArray[i] == numArray[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int k = 0; k < numArray.length; k++) {
            Log.d("jycom", "랜덤으로 얻어진 숫자는 ==>" + numArray[k]);

            if (k == 0) {
                btn1.setText(numArray[k] + "");
            } else if (k == 1) {
                btn2.setText(numArray[k] + "");
            } else if (k == 2) {
                btn3.setText(numArray[k] + "");
            } else if (k == 3) {
                btn4.setText(numArray[k] + "");
            } else if (k == 4) {
                btn5.setText(numArray[k] + "");
            } else if (k == 5) {
                btn6.setText(numArray[k] + "");
            }

            resultSu = resultSu + numArray[k] + "  ";
        }
        textView.setText(resultSu);


    }
}