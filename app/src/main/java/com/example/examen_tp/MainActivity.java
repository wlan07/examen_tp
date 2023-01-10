package com.example.examen_tp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;



public class MainActivity extends Activity {
    EditText nom, numero, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = (EditText) findViewById(R.id.etNom);
        numero = (EditText) findViewById(R.id.etNumero);
        mail = (EditText) findViewById(R.id.etMail);

    }
    public void annuler(View v){
        finish();
    }
    public void valider(View v){
        String _nom = nom.getText().toString();

        String _tel = numero.getText().toString();
        String _mail = mail.getText().toString();

if(!_nom.equals("") && !_tel.equals("") && !_mail.equals(""))
{

    Intent goToWelcome = new Intent(getApplicationContext(), Welcome.class);

    goToWelcome.putExtra("nom", _nom);
    goToWelcome.putExtra("email", _mail);
    goToWelcome.putExtra("telephone", _tel);

    startActivity(goToWelcome);
}


    }

}
