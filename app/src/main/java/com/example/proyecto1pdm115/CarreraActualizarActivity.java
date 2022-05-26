package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editId_carrera;
    EditText editNombre_carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_actualizar);
        helper = new ControlBD(this);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editNombre_carrera = (EditText) findViewById(R.id.editNombre_carrera);
    }
    public void actualizarCarrera(View v) {
        Carrera carrera=new Carrera();
        carrera.setId_carrera(editId_carrera.getText().toString());
        carrera.setNombre_carrera(editNombre_carrera.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(carrera);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_carrera.setText("");
        editNombre_carrera.setText("");
    }
}