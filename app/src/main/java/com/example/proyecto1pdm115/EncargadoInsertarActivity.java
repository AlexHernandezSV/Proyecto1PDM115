package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoInsertarActivity extends Activity {

    //ControlBDCarnet helper;
    EditText editId_reservante;
    EditText editId_usuario;
    EditText editNom_reservante;
    EditText editTipo_reservante
            ;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_insertar);
        //helper = new ControlBDCarnet(this);
        editId_reservante = (EditText) findViewById(R.id.editId_reservante);
        editId_usuario = (EditText) findViewById(R.id.editId_usuario);
        editNom_reservante = (EditText) findViewById(R.id.editNom_reservante);
        editTipo_reservante = (EditText) findViewById(R.id.editTipo_reservante);
    }
    public void insertarEncargado(View v) {
        Integer id_reservante = Integer.valueOf(editId_reservante.getText().toString());
        char id_usuario = editId_usuario.getText().toString().charAt(2);
        String nombre_reservante = editNom_reservante.getText().toString();
        String tipo_reservante = editTipo_reservante.getText().toString();
        String regInsertados;
        Encargado reservante = new Encargado();
        reservante.setId_reservante(id_reservante);
        reservante.setId_usuario(id_usuario);
        reservante.setNombre_reservante(nombre_reservante);
        reservante.setTipo_reservante(tipo_reservante);
        //helper.abrir();
        //regInsertados = helper.insertar(reservante);
        //helper.cerrar();
        //Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_reservante.setText("");
        editId_usuario.setText("");
        editNom_reservante.setText("");
        editTipo_reservante.setText("");
    }
}