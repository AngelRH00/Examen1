package com.example.examen1;

class Calculator {
    private double respuesta = 0;


    public double suma(double n1, double n2){
        respuesta = n1+n2;
        return respuesta;
    }
    public double resta(double n1, double n2){
        respuesta = n1-n2;
        return respuesta;
    }
    public double multiplicacion(double n1, double n2){
        respuesta = n1*n2;
        return respuesta;
    }
    public double division(double n1, double n2){
        if (n2==0)throw new IllegalArgumentException();
        else{
            respuesta = n1 / n2;
            return respuesta;
        }
    }
}
