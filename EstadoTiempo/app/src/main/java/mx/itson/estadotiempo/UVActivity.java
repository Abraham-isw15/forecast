package mx.itson.estadotiempo;

/**
 * Created by Propietario on 08/08/2015.
 */
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.itson.enumeradores.Riesgo;
import mx.itson.mx.itson.entidades.Pronostico;
import mx.itson.mx.itson.entidades.UV;


public class UVActivity extends ActionBarActivity implements View.OnClickListener{

    Pronostico pron = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uv);

        pron = (Pronostico) getIntent().getSerializableExtra("pron");

        Button btnAceptarUV =(Button)findViewById(R.id.btnGuardarUv);

        btnAceptarUV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UV uv = new UV();


                EditText txtRiesgo = (EditText) findViewById(R.id.txtRiesgo);
                EditText txtValor = (EditText) findViewById(R.id.txtValor);
                //TODO combo box a riesgo
                if(!txtRiesgo.getText().toString().trim().equals("")&&!txtValor.getText().toString().trim().equals("")) {

                    uv.setRiesgo(Riesgo.getRiesgo(Integer.valueOf(txtRiesgo.getText().toString())));
                    uv.setValor(Integer.valueOf(txtValor.getText().toString()));



                    pron.getEstadoTiempo().setUv(uv);


                    Intent i = new Intent(getApplicationContext(), PronosticoActivity.class);
                    i.putExtra("pron", pron);
                    startActivity(i);


                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_uv, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
