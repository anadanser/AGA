package com.example.anagui.model;

public class Imc {
    private double peso;
    private double altura;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularImc() {
        double imc;
        imc = this.peso / (this.altura * this.altura);
        return imc;
    }

}
