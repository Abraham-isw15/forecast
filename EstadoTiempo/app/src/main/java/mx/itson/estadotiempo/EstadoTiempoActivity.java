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

import mx.itson.mx.itson.entidades.EstadoTiempo;
import mx.itson.mx.itson.entidades.Pronostico;


public class EstadoTiempoActivity extends ActionBarActivity  implements View.OnClickListener{

    Pronostico pron= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_tiempo);

        pron = (Pronostico) getIntent().getSerializableExtra("pron");

        Button btnGuardarEstadoTiempo= (Button)findViewById(R.id.btnGuardarEstadoTiempo);
        btnGuardarEstadoTiempo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                EstadoTiempo eT = new EstadoTiempo();


                EditText txtSensacionTermica=(EditText)findViewById(R.id.txtSensacionTermica);
                EditText txtHumedad = (EditText)findViewById(R.id.txtHumedad);
                EditText txtProbabilidadLluvia = (EditText)findViewById(R.id.txtProbabilidadLluvia);
                if(!txtHumedad.getText().toString().equals("")&&!txtProbabilidadLluvia.getText().toString().equals("")&&!txtSensacionTermica.getText().toString().equals("")){

                    eT.setHumedad(Double.valueOf(txtHumedad.getText().toString()) );
                    eT.setProbabilidadLluvia(Double.valueOf(txtProbabilidadLluvia.getText().toString()));
                    eT.setSensacionTermica(Double.valueOf(txtSensacionTermica.getText().toString()));
                    // eT.agregar();

                    pron.setEstadoTiempo(eT);

                    Intent i = new Intent(getApplicationContext(), TemperaturaActivity.class);
                    i.putExtra("pron", pron);
                    startActivity(i);


                }
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_estado_tiempo, menu);
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
