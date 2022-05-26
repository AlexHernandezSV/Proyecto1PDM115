package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class HorarioInsertarActivity extends AppCompatActivity {
    //ControlBDMT17005 helper;
    EditText editId_horario;
    EditText editDesde_horario;
    EditText editHasta_horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_insertar);
        //helper = new ControlBDMT17005(this);
        editId_horario = (EditText) findViewById(R.id.editId_horario);
        editDesde_horario = (EditText) findViewById(R.id.editDesde_horario);
        editHasta_horario = (EditText) findViewById(R.id.editHasta_horario);
    }

    public void insertarHorario(View v) {
        String id_horario=editId_horario.getText().toString();
        String desde_horario= editDesde_horario.getText().toString();
        String hasta_horario= editHasta_horario.getText().toString();
        //String regInsertados;
        Horario horario=new Horario();
        horario.setId_horario(id_horario);
        horario.setDesde_horario(desde_horario);
        horario.setHasta_horario(hasta_horario);
        //helper.abrir();
        //regInsertados=helper.insertar(horario);
        //helper.cerrar();
        //Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_horario.setText("");
        editDesde_horario.setText("");
        editHasta_horario.setText("");
    }
}