package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;

public class MiembroUniversitarioMenuActivity extends ListActivity {
    String[] menu={"Insertar Miembro Universitario","Eliminar Miembro Universitario","Consultar Miembro Universitario",
            "Actualizar Miembro Universitario"};
    String[]
            activities={"MiembroUniversitarioInsertarActivity","MiembroUniversitarioEliminarActivity","MiembroUniversitarioConsultarActivity",
            "MiembroUniversitarioActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(255, 255, 255));
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        String nombreValue=activities[position];
        l.getChildAt(position).setBackgroundColor(Color.rgb(255, 255, 255));
        try{
            Class<?> clase=Class.forName("com.example.proyecto1pdm115."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}