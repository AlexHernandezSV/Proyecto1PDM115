package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class HorarioConsultarActivity extends AppCompatActivity {
    //ControlBDMT17005 helper;
    EditText editId_horario;
    EditText editDesde_horario;
    EditText editHasta_horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_consultar);
        //helper = new ControlBDMT17005(this);
        editId_horario = (EditText) findViewById(R.id.editId_horario);
        editDesde_horario = (EditText) findViewById(R.id.editDesde_horario);
        editHasta_horario = (EditText) findViewById(R.id.editHasta_horario);
    }

    public void consultarHorario(View v) {
        //helper.abrir();
        //Horario horario = helper.consultarHorario(Integer.valueOf(editId_horario.getText().toString()));
        //helper.cerrar();
        /*if(horario == null)
            Toast.makeText(this, "Horario con ID " +
                    Integer.valueOf(editId_horario.getText().toString()) +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editDesde_horario.setText((CharSequence) horario.getDesde_horario());
            editHasta_horario.setText((CharSequence) horario.getHasta_horario());
        }*/
    }

    public void limpiarTexto(View v) {
        editId_horario.setText("");
        editDesde_horario.setText("");
        editHasta_horario.setText("");
    }
}