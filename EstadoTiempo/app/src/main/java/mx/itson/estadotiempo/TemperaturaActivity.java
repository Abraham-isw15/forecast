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

import mx.itson.mx.itson.entidades.Pronostico;
import mx.itson.mx.itson.entidades.Temperatura;


public class TemperaturaActivity extends ActionBarActivity implements View.OnClickListener {


    Pronostico pron = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        pron = (Pronostico) getIntent().getSerializableExtra("pron");

        Button btnGuardarTemperatura = (Button)findViewById(R.id.btnGuardarTemperatura);
        btnGuardarTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Temperatura t = new Temperatura();


                EditText txtMinima= (EditText) findViewById (R.id.txtMinima);
                EditText txtActual = (EditText) findViewById(R.id.txtActual);
                EditText txtMaxima = (EditText) findViewById(R.id.txtMaxima);
                if(!txtMinima.getText().toString().trim().equals("")&&!txtActual.getText().toString().trim().equals("")&&!txtMaxima.getText().toString().trim().equals("")){
                    t.setMinima(Double.valueOf(txtMinima.getText().toString()));
                    t.setActual(Double.valueOf(txtActual.getText().toString()));
                    t.setMaxima(Double.valueOf(txtMaxima.getText().toString()));
                    //   t.agregar();

                    pron.getEstadoTiempo().setTemperatura(t);

                    Intent i = new Intent(getApplicationContext(), UVActivity.class);
                    i.putExtra("pron", pron);
                    startActivity(i);

                }
            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperatura, menu);
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
