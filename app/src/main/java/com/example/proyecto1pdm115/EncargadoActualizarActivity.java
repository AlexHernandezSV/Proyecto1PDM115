package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_reservante;
    EditText editNom_reservante;
    EditText editTipo_reservante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_actualizar);
        helper = new ControlBD(this);
        editId_reservante = (EditText) findViewById(R.id.editId_reservante);
        editNom_reservante = (EditText) findViewById(R.id.editNom_reservante);
        editTipo_reservante = (EditText) findViewById(R.id.editTipo_reservante);

    }
    public void actualizarEncargado(View v) {
        Encargado encargado=new Encargado();
        encargado.setId_reservante(editId_reservante.getText().toString());
        encargado.setNombre_reservante(editNom_reservante.getText().toString());
        encargado.setTipo_reservante(editTipo_reservante.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(encargado);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_reservante.setText("");
        editNom_reservante.setText("");
        editTipo_reservante.setText("");
    }
}