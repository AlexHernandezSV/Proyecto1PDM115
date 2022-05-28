package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DetalleResponsableActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_detalle_responsable;
    EditText editId_coordinador;
    EditText editNomb_tipo_responsable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_responsable_actualizar);
        helper = new ControlBD(this);
        editId_detalle_responsable=(EditText) findViewById(R.id.editId_detalle_responsable);
        editId_coordinador=(EditText) findViewById(R.id.editId_coordinador);
        editNomb_tipo_responsable=(EditText) findViewById(R.id.editNomb_tipo_responsable);
    }

    public void actualizarDetalleResponsable(){
        DetalleResponsable detalleResponsable = new DetalleResponsable();
        detalleResponsable.setId_detalle_responsable(editId_detalle_responsable.getText().toString());
        detalleResponsable.setId_coordinador(editId_coordinador.getText().toString());
        detalleResponsable.setNomb_tipo_responsable(editNomb_tipo_responsable.getText().toString());
        helper.abrir();
        //String estado =helper.actualizar(detalleResponsable);
        helper.cerrar();
        //Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(){
        editId_detalle_responsable.setText("");
        editId_coordinador.setText("");
        editNomb_tipo_responsable.setText("");
    }
}