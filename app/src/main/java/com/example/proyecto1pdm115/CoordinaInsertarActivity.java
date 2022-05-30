package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CoordinaInsertarActivity extends Activity {
    ControlBD helper;
    EditText editId_actividad;
    EditText editId_coordinador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordina_insertar);
        helper = new ControlBD(this);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editId_coordinador = (EditText) findViewById(R.id.editId_coordinador);

    }

    public void insertarHorario(View v) {
        String id_actividad=editId_actividad.getText().toString();
        String id_coordinador= editId_coordinador.getText().toString();
        String regInsertados;
        Coordina coordina=new Coordina();
        coordina.setId_actividad(id_actividad);
        coordina.setId_coordinador(id_coordinador);
        helper.abrir();
        regInsertados=helper.insertar(coordina);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_actividad.setText("");
        editId_coordinador.setText("");

    }
}