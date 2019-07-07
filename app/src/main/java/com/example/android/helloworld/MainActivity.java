 package com.example.android.helloworld;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText myname;
    private Button btn_ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton ()
    {
        myname=(EditText)findViewById(R.id.myname);
        btn_ok=(Button)findViewById(R.id.ok);
        btn_ok.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick (View v)
                    {
                        if (myname.getText().length()==0)
                        Toast.makeText(
                                MainActivity.this,"Error",Toast.LENGTH_SHORT
                        ).show();
                        else
                        {
//                            Toast.makeText(
//                                    MainActivity.this,"Hello "+myname.getText(),Toast.LENGTH_SHORT
//                            ).show();
                            AlertDialog.Builder a_build = new AlertDialog.Builder(MainActivity.this);
                            a_build.setMessage("Hello "+ myname.getText())
                                    .setCancelable(false)
                                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            finish();
                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog newd =a_build.create();
                            newd.setTitle("Close application..");
                            newd.show();
                        }
                    }
                }
        );

    }

}
