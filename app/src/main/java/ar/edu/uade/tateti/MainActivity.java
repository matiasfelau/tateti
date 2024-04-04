package ar.edu.uade.tateti.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ar.edu.uade.tateti.GameActivity;

import androidx.appcompat.app.AppCompatActivity;

import ar.edu.uade.tateti.R;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamar variables

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aux = new Intent(MainActivity.this, GameActivity.class);
                String n = nombre.getText().toString();
                if (n.isEmpty()) {
                    n = "Invitado";
                }
                aux.putExtra("nombre", n);
                if (circulo.isChecked()) {
                    aux.putExtra("ficha", "circulos");
                } else {
                    aux.putExtra("ficha", "equises");
                }
                startActivity(aux);
            }
        });
    }
}
