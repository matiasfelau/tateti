package ar.edu.uade.tateti;

import android.widget.Button;

import java.util.ArrayList;

import java.util.Random;

public class ControlDeJuego {

    public boolean gano(int x, int y, Button botonCentro, Button botonSuperiorCentral, Button botonInferiorCentral, Button botonCentroIzquierda,Button botonCentroDerecha, Button botonSuperiorDerecha, Button botonSuperiorIzquierda, Button botonInferiorDerecha, Button botonInferiorIzquierda) {
        ArrayList<ArrayList<Button>> botones = new ArrayList<>();
        ArrayList<Button> botonesCentral = new ArrayList<>();
        ArrayList<Button> botonesSuperior = new ArrayList<>();
        ArrayList<Button> botonesInferior = new ArrayList<>();
        botonesCentral.add(botonCentroIzquierda);
        botonesCentral.add(botonCentro);
        botonesCentral.add(botonCentroDerecha);
        botonesInferior.add(botonInferiorIzquierda);
        botonesInferior.add(botonInferiorCentral);
        botonesInferior.add(botonInferiorDerecha);
        botonesSuperior.add(botonSuperiorIzquierda);
        botonesSuperior.add(botonSuperiorCentral);
        botonesSuperior.add(botonSuperiorDerecha);
        botones.add(botonesSuperior);
        botones.add(botonesCentral);
        botones.add(botonesInferior);
        if (botones.get(x).get(y).getText().equals(botones.get(x+1).get(y).getText()) && botones.get(x).get(y).getText().equals(botones.get(x+2).get(y).getText())
                || botones.get(x).get(y).getText().equals(botones.get(x-1).get(y).getText()) && botones.get(x).get(y).getText().equals(botones.get(x+1).get(y).getText()) ||
                botones.get(x).get(y).getText().equals(botones.get(x-1).get(y).getText()) && botones.get(x).get(y).getText().equals(botones.get(x-2).get(y).getText())){
            return true;
        } else if (botones.get(x).get(y).getText().equals(botones.get(x).get(y+1).getText()) && botones.get(x).get(y).getText().equals(botones.get(x).get(y+2).getText())
                || botones.get(x).get(y).getText().equals(botones.get(x).get(y-1).getText()) && botones.get(x).get(y).getText().equals(botones.get(x).get(y+1).getText()) ||
                botones.get(x).get(y).getText().equals(botones.get(x).get(y-1).getText()) && botones.get(x).get(y).getText().equals(botones.get(x).get(y-2).getText())){
            return true;
        } else if (botones.get(x).get(y).getText().equals(botones.get(x+1).get(y+1).getText()) && botones.get(x).get(y).getText().equals(botones.get(x+2).get(y+2).getText())
                || botones.get(x).get(y).getText().equals(botones.get(x-1).get(y-1).getText()) && botones.get(x).get(y).getText().equals(botones.get(x+1).get(y+1).getText()) ||
                botones.get(x).get(y).getText().equals(botones.get(x-1).get(y-1).getText()) && botones.get(x).get(y).getText().equals(botones.get(x-2).get(y-2).getText())){
            return true;
        } else {
            return false;
        }
    }

    public void proximoMovimiento(String ficha, Button botonCentro, Button botonSuperiorCentral, Button botonInferiorCentral, Button botonCentroIzquierda, Button botonCentroDerecha, Button botonSuperiorDerecha, Button botonSuperiorIzquierda, Button botonInferiorDerecha, Button botonInferiorIzquierda){
        ArrayList<ArrayList<Button>> botones = new ArrayList<>();
        ArrayList<Button> botonesCentral = new ArrayList<>();
        ArrayList<Button> botonesSuperior = new ArrayList<>();
        ArrayList<Button> botonesInferior = new ArrayList<>();
        botonesCentral.add(botonCentroIzquierda);
        botonesCentral.add(botonCentro);
        botonesCentral.add(botonCentroDerecha);
        botonesInferior.add(botonInferiorIzquierda);
        botonesInferior.add(botonInferiorCentral);
        botonesInferior.add(botonInferiorDerecha);
        botonesSuperior.add(botonSuperiorIzquierda);
        botonesSuperior.add(botonSuperiorCentral);
        botonesSuperior.add(botonSuperiorDerecha);
        botones.add(botonesSuperior);
        botones.add(botonesCentral);
        botones.add(botonesInferior);
        Random aleatorio = new Random();
        if (ficha.equalsIgnoreCase("circulos")){
            ficha = "X";
        } else {
            ficha = "O";
        }
        while (true){
            int x = aleatorio.nextInt(3);
            int y = aleatorio.nextInt(3);
            if(botones.get(x).get(y).getText().equals("")){
                botones.get(x).get(y).setText(ficha);
                break;
            }
        }
    }
}
