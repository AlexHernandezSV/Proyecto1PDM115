package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editId_carrera;
    EditText editNombre_carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_consultar);
        helper = new ControlBD(this);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editNombre_carrera = (EditText) findViewById(R.id.editNombre_carrera);
    }
    public void consultarCarrera(View v) {
        helper.abrir();
        Carrera carrera = helper.consultarCarrera(editId_carrera.getText().toString());
        helper.cerrar();
        if(carrera == null)
            Toast.makeText(this, "Carrera con ID " +
                    editId_carrera.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_carrera.setText(carrera.getNombre_carrera());
        }
    }
    public void limpiarTexto(View v) {
        editId_carrera.setText("");
        editNombre_carrera.setText("");
    }
}