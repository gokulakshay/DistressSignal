package com.example.gokul.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Insert extends Activity {
    EditText editRegno;
    TextView textGPA1,textGPA2,textGPA3,textGPA4,textGPA5,textCGPA,textName,textDob,textTyype,textBoard,textTot,textCut,textMob,textFamob,textMamob;
    Button ins1;
    String regno; String name; String dob; String tyype;String board;String tot;String cut;String mob;String GPA1;String GPA2;String GPA3;String GPA4;String GPA5;String CGPA;String famob;String mamob;
    DB obj=new DB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_insert);
        try {
            editRegno = (EditText) findViewById(R.id.editRegno);
            textName = (EditText) findViewById(R.id.textName);
            textGPA1 = (EditText) findViewById(R.id.textGPA1);
            textGPA2 = (EditText) findViewById(R.id.textGPA2);
            textGPA3 = (EditText) findViewById(R.id.textGPA3);
            textGPA4 = (EditText) findViewById(R.id.textGPA4);
            textGPA5 = (EditText) findViewById(R.id.textGPA5);
            textCGPA = (EditText) findViewById(R.id.textCGPA);
            textDob = (EditText) findViewById(R.id.textDob);
            textTyype = (EditText) findViewById(R.id.textTyype);
            textBoard = (EditText) findViewById(R.id.textBoard);
            textTot = (EditText) findViewById(R.id.textTot);
            textCut = (EditText) findViewById(R.id.textCut);
            textMob = (EditText) findViewById(R.id.textMob);
            textFamob = (EditText) findViewById(R.id.textFamob);
            textMamob = (EditText) findViewById(R.id.textMamob);
            startWork();
            ins1=(Button)findViewById(R.id.btnIns);
            ins1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  if(obj.insertContact(regno,name,dob,tyype,board,tot,cut, mob,GPA1,GPA2,GPA3,GPA4,GPA5,CGPA,famob,mamob))
                  {
                      Log.v("done done done","done done done");
                  }
                }
            });
        }
        catch(Exception e) {
            e.printStackTrace();
        }


    }

public void startWork()
{
     regno=this.editRegno.getText().toString();
     name=this.textName.getText().toString();
     dob=this.textDob.getText().toString();
     tyype=this.textTyype.getText().toString();
     board=this.textBoard.getText().toString();
     tot=this.textTot.getText().toString();
     cut=this.textCut.getText().toString();
     mob=this.textMob.getText().toString();
     GPA1=this.textGPA1.getText().toString();
     GPA2=this.textGPA2.getText().toString();
     GPA3=this.textGPA3.getText().toString();
     GPA4=this.textGPA4.getText().toString();
     GPA5=this.textGPA5.getText().toString();
     CGPA=this.textCGPA.getText().toString();
     famob=this.textFamob.getText().toString();
     mamob=this.textMamob.getText().toString();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insert, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
