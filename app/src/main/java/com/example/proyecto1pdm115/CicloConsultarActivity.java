package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CicloConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_ciclo;
    EditText editCiclo;
    EditText editFecha_inicio;
    EditText editFecha_fin;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_consultar);
        helper = new ControlBD(this);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editFecha_inicio = (EditText) findViewById(R.id.editFecha_incio);
        editFecha_fin = (EditText) findViewById(R.id.editFecha_fin);

    }
    public void consultarCiclo(View v) {
        helper.abrir();
        Ciclo ciclo = helper.consultarCiclo(editId_ciclo.getText().toString());
        helper.cerrar();
        if(ciclo== null)
            Toast.makeText(this, "Ciclo con ID " + editId_ciclo.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editCiclo.setText(ciclo.getCiclo());
            editFecha_inicio.setText(ciclo.getFecha_inicio());
            editFecha_fin.setText(ciclo.getFecha_fin());

        }
    }
    public void limpiarTexto(View v){
        editId_ciclo.setText("");
        editCiclo.setText("");
        editFecha_inicio.setText("");
        editFecha_fin.setText("");
    }
}