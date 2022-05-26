package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoActualizarActivity extends Activity {

    //ControlBDCarnet helper;
    EditText editId_reservante;
    EditText editId_usuario;
    EditText editNom_reservante;
    EditText editTipo_reservante;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_actualizar);
        //helper = new ControlBDCarnet(this);
        editId_reservante = (EditText) findViewById(R.id.editId_reservante);
        editId_usuario = (EditText) findViewById(R.id.editId_usuario);
        editNom_reservante = (EditText) findViewById(R.id.editNom_reservante);
        editTipo_reservante = (EditText) findViewById(R.id.editTipo_reservante);
    }
    public void actualizarEncargado(View v) {
        Encargado encargado = new Encargado();
        encargado.setId_reservante(Integer.valueOf(editId_reservante.getText().toString()));
        encargado.setId_usuario(editId_usuario.getText().toString().charAt(2));
        encargado.setNombre_reservante(editNom_reservante.getText().toString());
        encargado.setTipo_reservante(editTipo_reservante.getText().toString());
        //helper.abrir();
        //String estado = helper.actualizar(encargado);
        //helper.cerrar();
        //Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_reservante.setText("");
        editId_usuario.setText("");
        editNom_reservante.setText("");
        editTipo_reservante.setText("");
    }
}