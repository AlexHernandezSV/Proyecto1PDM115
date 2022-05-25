package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoEliminarActivity extends Activity {

    EditText editId_reservante;
    //ControlBDCarnet controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_eliminar);
        //controlhelper=new ControlBDCarnet (this);
        editId_reservante=(EditText)findViewById(R.id.editId_reservante);
    }

    public void eliminarEncargado(View v){
        String regEliminadas;
        Encargado reservante=new Encargado();
        reservante.setId_reservante(Integer.valueOf(editId_reservante.getText().toString()));
        //controlhelper.abrir();
        //regEliminadas=controlhelper.eliminar(reservante);
        //controlhelper.cerrar();
        //Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}