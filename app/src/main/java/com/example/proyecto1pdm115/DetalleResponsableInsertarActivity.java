package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleResponsableInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_detalle_responsable;
    EditText editId_coordinador;
    EditText editNomb_tipo_responsable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_responsable_insertar);
        helper = new ControlBD(this);
        editId_detalle_responsable=(EditText) findViewById(R.id.editId_detalle_responsable);
        editId_coordinador=(EditText) findViewById(R.id.editId_coordinador);
        editNomb_tipo_responsable=(EditText) findViewById(R.id.editNomb_tipo_responsable);
    }

    public void insertarDetalleResponsable(View v){
        DetalleResponsable detalleResponsable = new DetalleResponsable();
        detalleResponsable.setId_detalle_responsable(editId_detalle_responsable.getText().toString());
        detalleResponsable.setId_coordinador(editId_coordinador.getText().toString());
        detalleResponsable.setNomb_tipo_responsable(editNomb_tipo_responsable.getText().toString());

        helper.abrir();
        String regInsertados =helper.insertar(detalleResponsable);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId_detalle_responsable.setText("");
        editId_coordinador.setText("");
        editNomb_tipo_responsable.setText("");
    }
}