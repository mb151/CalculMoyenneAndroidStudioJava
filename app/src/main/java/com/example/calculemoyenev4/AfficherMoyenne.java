package com.example.calculemoyenev4;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.calculemoyenev4.calcul.Calculs;
import com.example.calculemoyenev4.calcul.Matiere;

import java.util.ArrayList;

public class AfficherMoyenne extends AppCompatActivity {

    EditText note1, note2, note3, coef1, coef2, coef3;
    CheckBox chk;
    Spinner spinner1, spinner2, spinner3;
    TextView resultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichermoyenne);
        note1 = (EditText) findViewById(R.id.note1);
        note2 = (EditText) findViewById(R.id.note2);
        note3 = (EditText) findViewById(R.id.note3);
        coef1 = (EditText) findViewById(R.id.coefficient1);
        coef2 = (EditText) findViewById(R.id.coefficient2);
        coef3 = (EditText) findViewById(R.id.coefficient3);
        chk =  findViewById(R.id.checkBox);
        resultat = findViewById(R.id.resultat);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.matiere, android.R.layout.simple_spinner_item);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
    }

    public void afficher(View view){
        Toast toast = Toast.makeText(this, R.string.alert, Toast.LENGTH_SHORT);
        String t1 = spinner1.getSelectedItem().toString();
        String t2 = spinner2.getSelectedItem().toString();
        String t3 = spinner3.getSelectedItem().toString();
        if(t1 == t2 || t1 == t3 || t2 == t3){
            toast.show();
        }else {
            String note1_str = note1.getText().toString();
            double note1_doub = Double.parseDouble(note1_str);

            String note2_str = note2.getText().toString();
            double note2_doub = Double.parseDouble(note2_str);

            String note3_str = note3.getText().toString();
            double note3_doub = Double.parseDouble(note3_str);


            String coef1_str = coef1.getText().toString();
            double coef1_doub = Double.parseDouble(coef1_str);

            String coef2_str = coef2.getText().toString();
            double coef2_doub = Double.parseDouble(coef2_str);

            String coef3_str = coef3.getText().toString();
            double coef3_doub = Double.parseDouble(coef3_str);

            Matiere m1, m2, m3;


            m1 = new Matiere(note1_doub, coef1_doub);
            m2 = new Matiere(note2_doub, coef2_doub);
            m3 = new Matiere(note3_doub, coef3_doub);
            ArrayList<Matiere> liste = new ArrayList<>();
            liste.add(m1);
            liste.add(m2);
            liste.add(m3);
            double moyenne = Calculs.calculeMoyenne(liste);
            resultat.setText("La moyenne est : " + moyenne);
        }
    }

    public void ResetEditText(View view){
        EditText note1 = (EditText) findViewById(R.id.note1);
        EditText note2 = (EditText) findViewById(R.id.note2);
        EditText note3 = (EditText) findViewById(R.id.note3);
        EditText coef1 = (EditText) findViewById(R.id.coefficient1);
        EditText coef2 = (EditText) findViewById(R.id.coefficient2);
        EditText coef3 = (EditText) findViewById(R.id.coefficient3);
        TextView resultat  = findViewById(R.id.resultat);
        resultat.setText("");
        note1.setText("");
        note2.setText("");
        note3.setText("");
        coef1.setText("");
        coef2.setText("");
        coef3.setText("");
    }

    public void onChecked(View view){
        if (chk.isChecked()){
            coef1.setText("1");
            coef2.setText("1");
            coef3.setText("1");
        }else{
            coef1.setText("");
            coef2.setText("");
            coef3.setText("");
        }
    }

    public void quitter(View view){
        finish();
    }

}


