package ar.edu.uade.tateti.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class GameActivity extends AppCompatActivity {

    TextView Jugador, Ganador;

    Button botonCentro, botonCentroArriba, botonCentroAbajo, botonCentroIzquierda, botonCentroDerecha, botonArribaDerecha, botonArribaIzquierda, botonAbajoDerecha, botonAbajoIzquierda;

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
        Jugador.setText(n + "juega con" + ficha);
        botonCentro = (Button) findViewById(R.id.botonCentro);
        botonCentroArriba = (Button) findViewById(R.id.botonCentroArriba);
        botonCentroAbajo = (Button) findViewById(R.id.botonCentroAbajo);
        botonCentroDerecha = (Button) findViewById(R.id.botonCentroDerecha);
        botonCentroIzquierda = (Button) findViewById(R.id.botonCentroIzquierda);
        botonArribaDerecha = (Button) findViewById(R.id.botonArribaDerecha);
        botonArribaIzquierda = (Button) findViewById(R.id.botonArribaIzquierda);
        botonAbajoDerecha = (Button) findViewById(R.id.botonAbajoDerecha);
        botonAbajoIzquierda = (Button) findViewById(R.id.botonAbajoIzquierda);
        Ganador = (TextView) findViewById(R.id.Ganador);

        botonArribaIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonCentroArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonArribaDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonCentroIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonAbajoIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonCentroDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonCentroAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
        botonAbajoDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { controloBoton(v); }
        });
    }

    private void controloBoton(View v){
        if (esMiTurno){
            Button selec = (Button) v;
            if(ficha.equalsIgnoreCase("ciuculos"))
                selec.setText("0");
            else
                selec.setText("X");
            esMiTurno = false;
            selec.setEnabled(false);
            cdj.asignarValorJugado(1,1,ficha);
            if (cdj.gano()){
                Ganador.setText("El ganador es "+ n);
            } else {
                cdj.proximoMovimiento();
                if (cdj.gano()){
                    Ganador.setText("El ganador es la maquina");
                }
                esMiTurno = true;
            }
        }
    }

}
