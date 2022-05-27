package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DetalleResponsableConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_detalle_responsable;
    EditText editId_coordinador;
    EditText editNomb_tipo_responsable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_responsable_consultar);
        helper = new ControlBD(this);
        editId_detalle_responsable=(EditText) findViewById(R.id.editId_detalle_responsable);
        editId_coordinador=(EditText) findViewById(R.id.editId_coordinador);
        editNomb_tipo_responsable=(EditText) findViewById(R.id.editNomb_tipo_responsable);
    }

    public void consultarDetalleResponsable(){
        //helper.abrir();
        //DetalleResponsable detalle = helper.consultarEscuela(editId_detalle_responsable.getText().toString());
        //helper.cerrar();
        /*if(escuela == null)
            Toast.makeText(this, "Detalle del responsable con ID " + editId_escuela.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editId_coordinador.setText(detalle.getId_coordinador());
            editNomb_tipo_responsable.setText(detalle.getNomb_tipo_responsable());

        }*/
    }
    public void limpiarTexto(){
        editId_detalle_responsable.setText("");
        editId_coordinador.setText("");
        editNomb_tipo_responsable.setText("");
    }
}