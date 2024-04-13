package ar.edu.uade.tateti;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import ar.edu.uade.tateti.GameActivity;

import androidx.appcompat.app.AppCompatActivity;

import ar.edu.uade.tateti.R;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = findViewById(R.id.boton);
        RadioButton circulo = findViewById(R.id.circulo);
        TextView nombre = findViewById(R.id.nombre);

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
                } else{
                    aux.putExtra("ficha", "equises");
                }
                startActivity(aux);
            }
        });
    }
}
