package ar.edu.uade.tateti;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class GameActivity extends AppCompatActivity {

    TextView Jugador, Ganador;

    Button botonCentro, botonSuperiorCentral, botonInferiorCentral, botonCentroIzquierda, botonCentroDerecha, botonSuperiorDerecha, botonSuperiorIzquierda, botonInferiorDerecha, botonInferiorIzquierda;

    String n, ficha;

    boolean esMiTurno;

    ControlDeJuego cdj;

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        esMiTurno = true;
        n = getIntent().getStringExtra("n");
        ficha = getIntent().getStringExtra("ficha");
        cdj = new ControlDeJuego();
        Jugador = (TextView) findViewById(R.id.Jugador);
        Jugador.setText(n + " juega con " + ficha);
        botonCentro = (Button) findViewById(R.id.botonCentro);
        botonSuperiorCentral = (Button) findViewById(R.id.botonSuperiorCentral);
        botonInferiorCentral = (Button) findViewById(R.id.botonInferiorCentral);
        botonCentroDerecha = (Button) findViewById(R.id.botonCentroDerecha);
        botonCentroIzquierda = (Button) findViewById(R.id.botonCentroIzquierda);
        botonSuperiorDerecha = (Button) findViewById(R.id.botonSuperiorDerecha);
        botonSuperiorIzquierda = (Button) findViewById(R.id.botonSuperiorIzquierda);
        botonInferiorDerecha = (Button) findViewById(R.id.botonInferiorDerecha);
        botonInferiorIzquierda = (Button) findViewById(R.id.botonInferiorIzquierda);
        Ganador = (TextView) findViewById(R.id.Ganador);

        botonSuperiorIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonCentroIzquierda.getText().equals("")) {
                    controloBoton(v,0,0);
                }

            }
        });
        botonSuperiorCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonSuperiorCentral.getText().equals("")) {
                    controloBoton(v, 0, 1);
                }
            }
        });
        botonSuperiorDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonSuperiorDerecha.getText().equals("")) {
                controloBoton(v,0,2);
                }
            }
        });
        botonCentroIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonCentroIzquierda.getText().equals("")) {
                    controloBoton(v, 1, 0);
                }
            }
        });
        botonCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonCentro.getText().equals("")) {
                    controloBoton(v, 1, 1);
                }
            }
        });
        botonInferiorIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonInferiorIzquierda.getText().equals("")) {
                    controloBoton(v, 2, 0);
                }
            }
        });
        botonCentroDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonCentroDerecha.getText().equals("")) {
                    controloBoton(v, 1, 2);
                }
            }
        });
        botonInferiorCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonInferiorCentral.getText().equals("")) {
                    controloBoton(v, 2, 1);
                }
            }
        });
        botonInferiorDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botonInferiorDerecha.getText().equals("")) {
                    controloBoton(v, 2, 2);
                }
            }
        });
    }

    private void controloBoton(View v, int x, int y){
        if (esMiTurno){
            Button selec = (Button) v;
            if(ficha.equalsIgnoreCase("circulos"))
                selec.setText("0");
            else
                selec.setText("X");
            esMiTurno = false;
            selec.setEnabled(false);
            if (cdj.gano(x, y,botonCentro, botonSuperiorCentral, botonInferiorCentral, botonCentroIzquierda, botonCentroDerecha, botonSuperiorDerecha, botonSuperiorIzquierda, botonInferiorDerecha, botonInferiorIzquierda)) {
                Ganador.setText("El ganador es "+ n);
            } else {
                List<Integer> lugar = cdj.proximoMovimiento(ficha,botonCentro, botonSuperiorCentral, botonInferiorCentral, botonCentroIzquierda, botonCentroDerecha, botonSuperiorDerecha, botonSuperiorIzquierda, botonInferiorDerecha, botonInferiorIzquierda);
                if (cdj.gano(lugar.get(0), lugar.get(1),botonCentro, botonSuperiorCentral, botonInferiorCentral, botonCentroIzquierda, botonCentroDerecha, botonSuperiorDerecha, botonSuperiorIzquierda, botonInferiorDerecha, botonInferiorIzquierda)){
                    Ganador.setText("El ganador es la maquina");
                }
                esMiTurno = true;
            }
        }
    }

}
