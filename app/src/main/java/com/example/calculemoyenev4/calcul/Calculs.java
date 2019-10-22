package com.example.calculemoyenev4.calcul;


import java.util.ArrayList;

public class Calculs {
    public static double  calculeMoyenne(ArrayList<Matiere> matieres){
        double somme_coef = 0, moyenne = 0;
        for (Matiere m : matieres) {
            moyenne += m.calculNote();
            somme_coef += m.getCoefficient();
        }

        return  moyenne / somme_coef;
    }
}

