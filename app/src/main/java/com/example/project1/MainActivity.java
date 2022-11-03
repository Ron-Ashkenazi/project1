package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    char operation;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);
    }

    public void buttonClickFunction(View view) {
        if (view instanceof Button){
            Button button = ( Button ) view;
            String str = button.getText().toString();
            result.append(str);
        }
}

    public void operationFun(View view) {
        if (view instanceof Button){
            String firstNum = result.getText().toString();
            num1 = Integer.parseInt(firstNum);
            Button button = ( Button ) view;
            operation = button.getText().toString().charAt(0);
            result.setText("");
        }
    }

    public void equalFunc(View view) {
        int finalRes = 0;
        String secondNum = result.getText().toString();
        num2 = Integer.parseInt(secondNum);
        switch (operation){
            case '+':
                finalRes = num1 + num2;
                break;
            case '-':
                finalRes = num1 - num2;
                break;
            case 'X':
                finalRes = num1 * num2;
                break;
            case '/':
                if(num2 != 0){
                    finalRes = num1 / num2;
                }
                else{
                    result.setText("Error");
                    return;
                }
                break;
        }
        result.setText(String.valueOf(finalRes));
    }

    public void acFunc(View view) {
        result.setText("");
    }
}