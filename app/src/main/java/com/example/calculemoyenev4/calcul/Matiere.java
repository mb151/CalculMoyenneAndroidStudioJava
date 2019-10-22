package com.example.calculemoyenev4.calcul;


public class Matiere {
    private  Double note;

    private Double coefficient;

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }
    public Matiere(Double note, Double coefficient) {
        this.note = note;
        this.coefficient = coefficient;
    }
    public Matiere() {

    }

    public  Double calculNote(){
        return  this.note * this.coefficient;
    }
}
