package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CicloConsultarActivity extends Activity {

    ControlBD helper;
    EditText editId_ciclo;
    EditText editCiclo;
    EditText editIFecha_inicio;
    EditText editIFecha_fin;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_consultar);
        helper = new ControlBD(this);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editIFecha_inicio = (EditText) findViewById(R.id.editFecha_incio);
        editIFecha_fin = (EditText) findViewById(R.id.editFecha_incio);

    }
    public void consultarCiclo(View v) {
        helper.abrir();
        Ciclo ciclo = helper.consultarCiclo(editId_ciclo.getText().toString());
        helper.cerrar();
        if(ciclo== null)
            Toast.makeText(this, "Ciclo con ID " + editId_ciclo.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editCiclo.setText(ciclo.getCiclo());
            editIFecha_inicio.setText(ciclo.getFecha_inicio());
            editIFecha_fin.setText(ciclo.getFecha_fin());

        }
    }
    public void limpiarTexto(View v){
        editId_ciclo.setText("");
        editCiclo.setText("");
        editIFecha_inicio.setText("");
        editIFecha_fin.setText("");
    }
}