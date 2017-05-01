package com.example.gokul.myapplication;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity implements View.OnClickListener
{

    EditText editRegno;
    TextView textGPA1,textGPA2,textGPA3,textGPA4,textGPA5,textCGPA,textName,textDob,textTyype,textBoard,textTot,textCut,textMob,textFamob,textMamob;
    Button btnView,btnShowInfo,clr,insert;

    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB obj = new DB(getApplicationContext());
        try {
            editRegno = (EditText) findViewById(R.id.editRegno);
            textName = (TextView) findViewById(R.id.textName);
            textGPA1 = (TextView) findViewById(R.id.textGPA1);
            textGPA2 = (TextView) findViewById(R.id.textGPA2);
            textGPA3 = (TextView) findViewById(R.id.textGPA3);
            textGPA4 = (TextView) findViewById(R.id.textGPA4);
            textGPA5 = (TextView) findViewById(R.id.textGPA5);
            textCGPA = (TextView) findViewById(R.id.textCGPA);
            textDob = (TextView) findViewById(R.id.textDob);
            textTyype = (TextView) findViewById(R.id.textTyype);
            textBoard = (TextView) findViewById(R.id.textBoard);
            textTot = (TextView) findViewById(R.id.textTot);
            textCut = (TextView) findViewById(R.id.textCut);
            textMob = (TextView) findViewById(R.id.textMob);
            textFamob = (TextView) findViewById(R.id.textFamob);
            textMamob = (TextView) findViewById(R.id.textMamob);
            btnView = (Button) findViewById(R.id.btnView);
            btnShowInfo = (Button) findViewById(R.id.btnShowInfo);
            clr = (Button) findViewById(R.id.clr);
            insert = (Button) findViewById(R.id.insert);

            clr.setOnClickListener(this);
            btnView.setOnClickListener(this);
            btnShowInfo.setOnClickListener(this);
            insert.setOnClickListener(this);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void onClick(View view) {
        try {
            if (view == insert) {
                Intent ins = new Intent(MainActivity.this, Auth.class);
                startActivity(ins);
            }
            if (view == clr) {
                clearText();
            }
            if (view == btnView) {
                if (editRegno.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter Register number");

                    return;
                }
                DB obj=new  DB(this);
                Cursor c = obj.getData(editRegno.getText().toString());
                if (c.moveToFirst()) {

                    Toast.makeText(MainActivity.this, "Register no. found", Toast.LENGTH_SHORT).show();

                    textName.setText(c.getString(1));
                    textDob.setText(c.getString(2));
                    textTyype.setText(c.getString(3));
                    textBoard.setText(c.getString(4));
                    textTot.setText(c.getString(5));
                    textCut.setText(c.getString(6));
                    textMob.setText(c.getString(7));
                    textGPA1.setText(c.getString(8));
                    textGPA2.setText(c.getString(9));
                    textGPA3.setText(c.getString(10));
                    textGPA4.setText(c.getString(11));
                    textGPA5.setText(c.getString(12));
                    textCGPA.setText(c.getString(13));
                    textFamob.setText(c.getString(14));
                    textMamob.setText(c.getString(15));


                } else {
                    showMessage("Error", "Invalid Rollno");
                    clearText();
                }



            }


            if (view == btnShowInfo) {
                showMessage("Student Database Application", "Developed By Gokul");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        editRegno.setText("");
        textName.setText("");
        textGPA1.setText("");
        textGPA2.setText("");
        textGPA3.setText("");
        textGPA4.setText("");
        textGPA5.setText("");
        textCGPA.setText("");
        textTyype.setText("");
        textDob.setText("");
        textBoard.setText("");
        textMob.setText("");
        textTot.setText("");
        textCut.setText("");
        textFamob.setText("");
        textMamob.setText("");
        editRegno.requestFocus();
        Toast.makeText(MainActivity.this, "Fields Cleared", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onResume() {
        super.onResume();

    }
}
