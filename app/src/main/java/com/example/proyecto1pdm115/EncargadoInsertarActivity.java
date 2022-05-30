package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_reservante;
    EditText editNom_reservante;
    EditText editTipo_reservante
            ;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_insertar);
        helper = new ControlBD(this);
        editId_reservante = (EditText) findViewById(R.id.editId_reservante);
        editNom_reservante = (EditText) findViewById(R.id.editNom_reservante);
        editTipo_reservante = (EditText) findViewById(R.id.editTipo_reservante);
    }
    public void insertarEncargado(View v) {
        String id_reservante=editId_reservante.getText().toString();
        String nombre_reservante=editNom_reservante.getText().toString();
        String tipo_reservante=editTipo_reservante.getText().toString();
        String regInsertados;
        Encargado encargado=new Encargado();
        encargado.setId_reservante(id_reservante);
        encargado.setNombre_reservante(nombre_reservante);
        encargado.setTipo_reservante(tipo_reservante);
        helper.abrir();
        regInsertados=helper.insertar(encargado);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_reservante.setText("");
        editNom_reservante.setText("");
        editTipo_reservante.setText("");
    }
}