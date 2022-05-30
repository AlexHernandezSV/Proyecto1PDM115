package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void eliminarDetalleResponsable(View v){
        String regEliminadas;
        DetalleResponsable detalle =new DetalleResponsable();
        detalle.setId_detalle_responsable(editId_detalle_responsable.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminar(detalle);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}