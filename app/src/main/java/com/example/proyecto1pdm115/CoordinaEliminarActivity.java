package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CoordinaEliminarActivity extends Activity {

    EditText editId_actividad,editId_coordinador;
    ControlBD controlhelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordina_eliminar);
        controlhelper=new ControlBD(this);
        editId_actividad=(EditText)findViewById(R.id.editId_actividad);
        editId_coordinador=(EditText)findViewById(R.id.editId_coordinador);

    }

    public void eliminarCoordina(View v){
        String regEliminadas;
        Coordina coordina=new Coordina();
        coordina.setId_actividad(editId_actividad.getText().toString());
        coordina.setId_coordinador(editId_coordinador.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(coordina);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiar(View v){
        editId_actividad.setText("");
        editId_actividad.setText("");

    }
}