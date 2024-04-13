package ar.edu.uade.tateti;

import android.widget.Button;

import java.util.ArrayList;

import java.util.List;
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
        try {
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x + 1).get(y).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) ==botones.get(x + 2).get(y).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x - 1).get(y).getText() .charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x + 1).get(y).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x - 1).get(y).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x - 2).get(y).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}

        } catch (Exception ignored) {}

        try {
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x).get(y + 1).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x).get(y + 2).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x).get(y - 1).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x).get(y + 1).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x).get(y - 1).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x).get(y - 2).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}
        }
        catch (Exception ignored) {}

        try {
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x + 1).get(y + 1).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x + 2).get(y + 2).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x - 1).get(y - 1).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x + 1).get(y + 1).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}
            try {
                if (botones.get(x).get(y).getText().charAt(0) == botones.get(x - 1).get(y - 1).getText().charAt(0) && botones.get(x).get(y).getText().charAt(0) == botones.get(x - 2).get(y - 2).getText().charAt(0)) {
                    return true;
                }
            }
            catch (Exception ignored) {}

        } catch (Exception ignored) {
        }
        return false;
    }

    public List<Integer> proximoMovimiento(String ficha, Button botonCentro, Button botonSuperiorCentral, Button botonInferiorCentral, Button botonCentroIzquierda, Button botonCentroDerecha, Button botonSuperiorDerecha, Button botonSuperiorIzquierda, Button botonInferiorDerecha, Button botonInferiorIzquierda) {
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
        if (ficha.equalsIgnoreCase("circulos")) {
            ficha = "X";
        } else {
            ficha = "O";
        }
        int x;
        int y;
        while (true) {
            x = aleatorio.nextInt(3);
            y = aleatorio.nextInt(3);
            if (botones.get(x).get(y).getText().equals("")) {
                botones.get(x).get(y).setText(ficha);
                break;
            }
        }
        List<Integer> resultado = new ArrayList<>();
        resultado.add(x);
        resultado.add(y);
        return resultado;
    }
}
