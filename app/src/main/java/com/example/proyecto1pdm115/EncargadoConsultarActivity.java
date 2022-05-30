package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_reservante;
    EditText editNom_reservante;
    EditText editTipo_reservante;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_consultar);
        helper = new ControlBD(this);
        editId_reservante = (EditText) findViewById(R.id.editId_reservante);
        editNom_reservante = (EditText) findViewById(R.id.editNom_reservante);
        editTipo_reservante = (EditText) findViewById(R.id.editTipo_reservante);
    }

    public void consultarEncargado(View v) {
        helper.abrir();
        Encargado encargado = helper.consultarEncargado(editId_reservante.getText().toString());
        helper.cerrar();
        if(encargado == null)
            Toast.makeText(this, "Carrera con ID " +
                    editId_reservante.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{
            editNom_reservante.setText(encargado.getNombre_reservante());
            editTipo_reservante.setText(encargado.getTipo_reservante());

        }
    }

    public void limpiarTexto(View v){
        editId_reservante.setText("");
        editNom_reservante.setText("");
        editTipo_reservante.setText("");
    }


}