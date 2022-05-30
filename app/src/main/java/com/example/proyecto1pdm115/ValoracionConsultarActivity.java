package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ValoracionConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdVal;
    EditText editVal;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion_consultar);
        helper = new ControlBD(this);
        editIdVal = (EditText) findViewById(R.id.conIdVal);
        editVal = (EditText) findViewById(R.id.editValoracion);

    }
    public void consultarAlumno(View v) {
        helper.abrir();
        Valoracion valoracion = helper.consultarValoracion(editIdVal.getText().toString());
        helper.cerrar();
        if(valoracion == null)
            Toast.makeText(this, "Valoracion con identificador " +
                    editIdVal.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{
            editVal.setText(valoracion.getValoracion());
        }
    }

    public void limpiarTexto(View v){
        editIdVal.setText("");
        editVal.setText("");

    }
}
