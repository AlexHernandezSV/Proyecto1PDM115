package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HorarioEliminarActivity extends AppCompatActivity {
    EditText editId_horario;
    //ControlBDMT17005 controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_eliminar);
        //controlhelper=new ControlBDMT17005 (this);
        editId_horario=(EditText)findViewById(R.id.editId_horario);
    }

    public void eliminarHorario(View v){
        //String regEliminadas;
        Horario horario=new Horario();
        horario.setId_horario(Integer.valueOf(editId_horario.getText().toString()));
        //controlhelper.abrir();
        //regEliminadas=controlhelper.eliminar(horario);
        //controlhelper.cerrar();
        //Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}