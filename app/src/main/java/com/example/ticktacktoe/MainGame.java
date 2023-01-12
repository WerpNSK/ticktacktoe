package com.example.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainGame extends AppCompatActivity
{
    Button[] buttons;
    Boolean isCross = true;
    TextView textView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        buttons = new Button[9];
        {
            buttons[0] = findViewById(R.id.button1);
            buttons[1] = findViewById(R.id.button2);
            buttons[2] = findViewById(R.id.button3);
            buttons[3] = findViewById(R.id.button4);
            buttons[4] = findViewById(R.id.button5);
            buttons[5] = findViewById(R.id.button6);
            buttons[6] = findViewById(R.id.button7);
            buttons[7] = findViewById(R.id.button8);
            buttons[8] = findViewById(R.id.button9);
        }
        textView = findViewById(R.id.textView);
        textView.setText(R.string.x_turn);
    }

    Boolean checkWinner()
    {
        if (buttons[0].getText().equals(buttons[1].getText()) &&
                buttons[1].getText().equals(buttons[2].getText()) &&
                !buttons[0].getText().equals(" "))
            return true;
        if (buttons[3].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[5].getText()) &&
                !buttons[3].getText().equals(" "))
            return true;
        if (buttons[6].getText().equals(buttons[7].getText()) &&
                buttons[7].getText().equals(buttons[8].getText()) &&
                !buttons[6].getText().equals(" "))
            return true;

        if (buttons[0].getText().equals(buttons[3].getText()) &&
                buttons[3].getText().equals(buttons[6].getText()) &&
                !buttons[0].getText().equals(" "))
            return true;
        if (buttons[1].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[7].getText()) &&
                !buttons[1].getText().equals(" "))
            return true;
        if (buttons[2].getText().equals(buttons[5].getText()) &&
                buttons[5].getText().equals(buttons[8].getText()) &&
                !buttons[2].getText().equals(" "))
            return true;

        if (buttons[0].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[8].getText()) &&
                !buttons[0].getText().equals(" "))
            return true;
        if (buttons[2].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[6].getText()) &&
                !buttons[2].getText().equals(" "))
            return true;

        return false;
    }

    public void button_click(View v)
    {
        Button sender = (Button) v;
        if (sender.getText().toString().contains(" ") && !checkWinner())
        {
            if (isCross)
            {
                sender.setText("X");
                textView.setText(R.string.o_turn);
            } else
            {
                sender.setText("O");
                textView.setText(R.string.x_turn);
            }
            count += 1;
            if (checkWinner())
                if (isCross)
                    Toast.makeText(this, R.string.x_win, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this, R.string.o_win, Toast.LENGTH_LONG).show();
            else if (count >= 9)
                Toast.makeText(this, R.string.draw, Toast.LENGTH_LONG).show();
            isCross = !isCross;
        }
    }

    public void restartButton(View v)
    {
        for (int i = 0; i <= 9; i++)
        {
            buttons[i].setText(" ");
        }
        count=0;
        isCross=true;
        textView.setText(R.string.x_turn);
    }


}