package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class ActividadActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_actividad;
    EditText editId_tipo_actividad;
    EditText editId_valoracion;
    EditText editId_reservante;
    EditText editGrupo;
    EditText editDescripcion;
    EditText editEstado;
    EditText editFecha_actividad;
    EditText editDesde_actividad;
    EditText editHasta_actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_insertar);
        helper = new ControlBD(this);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editId_tipo_actividad = (EditText) findViewById(R.id.editId_tipo_actividad);
        editId_valoracion = (EditText) findViewById(R.id.editId_valoracion);
        editId_reservante= (EditText) findViewById(R.id.editId_reservante);
        editGrupo=(EditText) findViewById(R.id.editGrupo);
        editDescripcion=(EditText) findViewById(R.id.editDescripcion);
        editEstado=(EditText) findViewById(R.id.editEstado);
        editFecha_actividad= findViewById(R.id.editFecha_actividad);
        editDesde_actividad= findViewById(R.id.editDesde_actividad);
        editHasta_actividad= findViewById(R.id.editHasta_actividad);

    }

    public void actualizarActividad(View v){
        Actividad actividad = new Actividad();
        actividad.setId_actividad(Integer.parseInt(editId_actividad.getText().toString()));
        actividad.setId_tipo_actividad(Integer.parseInt(editId_tipo_actividad.getText().toString()));
        actividad.setId_valoracion(Integer.parseInt(editId_valoracion.getText().toString()));
        actividad.setId_reservante(Integer.parseInt(editId_reservante.getText().toString()));
        actividad.setGrupo(editGrupo.getText().charAt(0));
        actividad.setDescripcion(editDescripcion.getText().toString());
        actividad.setEstado(editGrupo.getText().toString());
        actividad.setFecha_actividad((Date) editFecha_actividad.getText());
        actividad.setDesde_actividad((Date) editDesde_actividad.getText());
        actividad.setHasta_actividad((Date) editHasta_actividad.getText());

        helper.abrir();
        //String estado =helper.insertar(actividad);
        helper.cerrar();
        //Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();

    }

    public void limpiarTexto(View v) {
        editId_actividad.setText("");
        editId_tipo_actividad.setText("");
        editId_valoracion.setText("");
        editId_reservante.setText("");
        editGrupo.setText("");
        editDescripcion.setText("");
        editEstado.setText("");
        editFecha_actividad.setText("");
        editDesde_actividad.setText("");
        editHasta_actividad.setText("");
    }
}