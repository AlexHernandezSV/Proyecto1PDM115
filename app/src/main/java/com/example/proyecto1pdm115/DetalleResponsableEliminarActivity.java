package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DetalleResponsableEliminarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_detalle_responsable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_responsable_eliminar);
        helper = new ControlBD(this);
        editId_detalle_responsable=(EditText) findViewById(R.id.editId_detalle_responsable);
    }

    public void eliminarDetalleResponsable(){
        String regInsertados;
        DetalleResponsable detalle =new DetalleResponsable();
        detalle.setId_detalle_responsable(editId_detalle_responsable.getText().toString());
        //controlhelper.abrir();
        //regEliminadas=controlhelper.eliminar(detalle);
        //controlhelper.cerrar();
        //Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}