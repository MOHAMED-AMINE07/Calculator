package com.example.appcalcul;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static double result=0;
    static int pending=0;
    /*pending
      1 +
      2 -
      3 x
      4 /
     */
    static String disp="0";
    static String dispdown="";
    static int decimal=0;
    TextView textView ,edittext;
    //alert dialog
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =  findViewById(R.id.textView3);
        edittext =  findViewById(R.id.textView2);

    }
    @SuppressLint("NonConstantResourceId")
    public void nbrEvent(View view){
        switch (view.getId()){
            case R.id.pion:
                dispdown+=".";
                break;
            case R.id.btn0:
                dispdown+="0";
                break;
            case R.id.btn1:
                dispdown+="1";
                break;
            case R.id.btn2:
                dispdown +="2";
                break;
            case R.id.btn3:
                dispdown+="3";
                break;
            case R.id.btn4:
                dispdown+="4";
                break;
            case R.id.btn5:
                dispdown+="5";
                break;
            case R.id.btn6:
                dispdown+="6";
                break;
            case R.id.btn7:
                dispdown+="7";
                break;
            case R.id.btn8:
                dispdown+="8";
                break;
            case R.id.btn9:
                dispdown+="9";
                break;
        }
      edittext.setText(dispdown);

    }



    public void clsa (View view)
    {
        result=0;
        pending=0;
        disp="0";
        dispdown="";
        decimal=0;
        textView.setText(disp);
        edittext.setText(dispdown);
    }

    public void plus (View view)
    {
        String message=dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message="0";
        if (message.equals(""))
        {
            disp = Double.toString(result);
            pending=1;
        }
        else
        {
            double n = Double.parseDouble(message);
            perform(n);
            disp = Double.toString(result);
            pending = 1;
        }
        textView.setText(disp);
        edittext.setText(disp+" +");
        dispdown="";
    }

    public void perform (double n)
    {
        switch (pending)
        {case 0:
        {
            result=n;
            break;
        }
            case 1:
            {
                result+=n;
                break;
            }
            case 2:
            {
                result-=n;
                break;
            }
            case 3:
            {
                result*=n;
                break;
            }
            case 4:
            {
                result/=n;
                break;
            }
            case 5:
            {
                result%=n;
                break;
            }

        }
        decimal=0;
    }
    public void minus (View view)
    {
        String message=dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message="0";
        if (message.equals(""))
        {
            disp = Double.toString(result);
            pending=2;
        }
        else
        {
            double n = Double.parseDouble(message);
            perform(n);
            disp = Double.toString(result);
            pending = 2;
        }
        textView.setText(disp);
        edittext.setText(disp+" -");
        dispdown="";
    }
    public void multiply (View view)
    {
        String message=dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message="0";
        if (message.equals(""))
        {
            disp = Double.toString(result);
            pending=3;
        }
        else
        {
            double n = Double.parseDouble(message);
            perform(n);
            disp = Double.toString(result);
            pending = 3;
        }
        textView.setText(disp);
        edittext.setText(disp+" ×");
        dispdown="";
    }
    public void divide (View view)
    {
        String message=dispdown;
        if (message.equals(".") || message.equals("-"))
            message="0";
        if (message.equals(""))
        {
            disp = Double.toString(result);
            pending=4;
        }
        else
        {
            double n = Double.parseDouble(message);
            perform(n);
            disp = Double.toString(result);
            pending = 4;
        }

        edittext.setText(disp+ " ÷");
        textView.setText(disp);
        dispdown="";
    }
    public void mod(View v){
        String message=dispdown;
        if (message.equals(".") || message.equals("-"))
            message="0";
        if (message.equals(""))
        {
            disp = Double.toString(result);
            pending=5;
        }
        else
        {
            double n = Double.parseDouble(message);
            perform(n);
            disp = Double.toString(result);
            pending = 5;
        }
        textView.setText(disp);
        edittext.setText(disp+ " %");
        dispdown="";
    }



    public void equal (View view)
    {
        String message=dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message="0";
        if (message.equals(""))
        {
            disp = Double.toString(result);
            pending=0;
        }
        else
        {
            double n = Double.parseDouble(message);
            perform(n);
            disp = Double.toString(result);
            pending = 0;
        }
        if(disp.equals("Infinity")){
            textView.setText("Error");
        }else{
            textView.setText("= "+disp);
            edittext.setText("= "+disp);

        }

        dispdown="";
    }

    public void del(View view) {
        if (dispdown.equals("")) {
            dispdown="";
        } else {
            dispdown = dispdown.substring(0, (dispdown.length() - 1));
            edittext.setText(dispdown);
        }
    }
    // pro (free) app
    public void alert(View view){
        alert = new AlertDialog.Builder(this);
        alert.setTitle("TRY PRO ");
        alert.setMessage("Get pro for lifetime");
        alert.setCancelable(false);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

}
