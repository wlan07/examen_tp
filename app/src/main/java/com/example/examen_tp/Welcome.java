package com.example.examen_tp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

public class Welcome extends Activity {
    TextView result;
    String tel;
    String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        result = (TextView) findViewById(R.id.tvResult);
        Intent myIntent = getIntent();
        String nom = myIntent.getStringExtra("nom");
         mail = myIntent.getStringExtra("email");
        tel = myIntent.getStringExtra("telephone");

        result.setText("Vos données : \nNom: " + nom +"\nAdresse mail : "+mail+"\nTéléphone : "+tel);
    }
    public void appeler(View v){
        Uri num = Uri.parse("tel:"+tel);
        Intent call = new Intent(Intent.ACTION_DIAL, num);
        startActivity(call);
    }

    public  void sendMail(View v){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ mail});
        email.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT GOES HERE");
        email.putExtra(Intent.EXTRA_TEXT, "MESSAGE GOES HERE");


        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}
