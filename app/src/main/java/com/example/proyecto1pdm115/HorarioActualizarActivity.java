package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class HorarioActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editId_horario;
    EditText editDesde_horario;
    EditText editHasta_horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_actualizar);
        helper = new ControlBD(this);
        editId_horario = (EditText) findViewById(R.id.editId_horario);
        editDesde_horario = (EditText) findViewById(R.id.editDesde_horario);
        editHasta_horario = (EditText) findViewById(R.id.editHasta_horario);
    }

    public void actualizarHorario(View v) {
        Horario horario = new Horario();
        horario.setId_horario(editId_horario.getText().toString());
        horario.setDesde_horario(editDesde_horario.getText().toString());
        horario.setHasta_horario(editHasta_horario.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(horario);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_horario.setText("");
        editDesde_horario.setText("");
        editHasta_horario.setText("");
    }
}