package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CoordinaConsultarActivity extends AppCompatActivity {


    ControlBD helper;
    EditText editId_actividad;
    EditText editId_coordinador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordina_consultar);
        helper = new ControlBD(this);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editId_coordinador = (EditText) findViewById(R.id.editId_coordinador);
    }
    public void consultarCoordina(View v) {
        helper.abrir();
        Coordina coordina = helper.consultarCoordina(editId_actividad.getText().toString());
        helper.cerrar();
        if(coordina == null)
            Toast.makeText(this, "Coordina no está registrada",
                    Toast.LENGTH_LONG).show();
        else{
            editId_coordinador.setText(String.valueOf(coordina.getId_coordinador()));
        }
    }
    public void limpiarTexto(View v) {
        editId_actividad.setText("");
        editId_coordinador.setText("");

    }
}