package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.RenderNode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView lbl_Result, lbl_Numbers;
    Button btn_PlusAction, btn_MinusAction, btn_DiviAction, btn_MultiActon, btn_Generate, btn_Reset;

    private int number1 = -1, number2 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init TextViews and Buttons
        lbl_Result = findViewById(R.id.lbl_Answer);
        lbl_Numbers = findViewById(R.id.lbl_Numbers);

        btn_PlusAction = findViewById(R.id.btn_PlusAction);
        btn_MinusAction = findViewById(R.id.btn_MinusAction);
        btn_DiviAction = findViewById(R.id.btn_DiviAction);
        btn_MultiActon = findViewById(R.id.btn_MultiAction);
        btn_Generate = findViewById(R.id.btn_Generate);
        btn_Reset = findViewById(R.id.btn_Reset);

        //Listener für Klick-Event setzen
        btn_Generate.setOnClickListener(GenerateListener);
        btn_PlusAction.setOnClickListener(PlusListener);
        btn_MinusAction.setOnClickListener(MinusListener);
        btn_DiviAction.setOnClickListener(DivisionListener);
        btn_MultiActon.setOnClickListener(MultiplicationListener);
        btn_Reset.setOnClickListener(ResetListener);

    }

    private View.OnClickListener GenerateListener = new View.OnClickListener() {

        public void onClick(View v)
        {
            Random randomGen = new Random();
            number1 = randomGen.nextInt(100)+1;
            number2 = randomGen.nextInt(100)+1;

            lbl_Numbers.setText(String.format("%d ? %d", number1, number2));

            Toast.makeText(MainActivity.this, "Bitte Operator (+,-,*,/) wählen.",
                    Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener PlusListener = new View.OnClickListener() {

        public void onClick(View v)
        {
            if(number1 != 1 && number1 != -1)
            {
                lbl_Result.setText(String.format("%d", (number1 + number2)));
                lbl_Numbers.setText(String.format("%d + %d", number1, number2));

            }
            else
                {
                    Toast.makeText(MainActivity.this, "Bitte einmal auf \"Neu\" klicken.",
                            Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener MinusListener = new View.OnClickListener() {

        public void onClick(View v)
        {
            if(number1 != 1 && number1 != -1)
            {
                lbl_Result.setText(String.format("%d", (number1 - number2)));
                lbl_Numbers.setText(String.format("%d - %d", number1, number2));
            }
            else
            {
                Toast.makeText(MainActivity.this, "Bitte einmal auf \"Neu\" klicken.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener MultiplicationListener = new View.OnClickListener() {

        public void onClick(View v)
        {
            if(number1 != 1 && number1 != -1)
            {
                lbl_Result.setText(String.format("%d", (number1 * number2)));
                lbl_Numbers.setText(String.format("%d * %d", number1, number2));
            }
            else
            {
                Toast.makeText(MainActivity.this, "Bitte einmal auf \"Neu\" klicken.",
                        Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener DivisionListener = new View.OnClickListener() {

        public void onClick(View v)
        {
            if(number1 != 1 && number1 != -1)
            {
                lbl_Result.setText(String.format("%.3f", ((double)number1 / (double)number2)));
                lbl_Numbers.setText(String.format("%d : %d", number1, number2));
            }
            else
            {
                Toast.makeText(MainActivity.this, "Bitte einmal auf \"Neu\" klicken.",
                        Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener ResetListener = new View.OnClickListener() {

        public void onClick(View v)
        {
            number1 = -1;
            number2 = -1;

            lbl_Numbers.setText("Rechenweg der Ergebnisse");
            lbl_Result.setText("Ergebnis der Berechnung");
        }
    };

}

