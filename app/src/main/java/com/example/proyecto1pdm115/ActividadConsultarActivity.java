package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActividadConsultarActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_actividad_consultar);
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
    public void consultarActividad(View v) {
        helper.abrir();
        //Actividad actividad = helper.consultarActividad(editId_actividad.getText().toString());
        //helper.cerrar();
        /*if(actividad == null)
            Toast.makeText(this, "Actividad con ID " + editId_actividad.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{

            editId_tipo_actividad.setText(actividad.getId_tipo_actividad());
        editId_valoracion.setText(actividad.getId_valoracion());
        editId_reservante.setText(actividad.getId_reservante());
        editGrupo.setText(actividad.getGrupo());
        editDescripcion.setText(actividad.getDescripcion());
        editEstado.setText(actividad.getEstado());
        editFecha_actividad.setText((CharSequence) actividad.getFecha_actividad());
        editDesde_actividad.setText((CharSequence) actividad.getDesde_actividad());
        editHasta_actividad.setText((CharSequence) actividad.getHasta_actividad());
        }*/

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