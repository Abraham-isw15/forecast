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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.io.Serializable;

import mx.itson.enumeradores.Dia;
import mx.itson.mx.itson.entidades.Pronostico;


public class PronosticoActivity extends ActionBarActivity {

    Pronostico pron = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronostico);
        Bundle extras = getIntent().getExtras();

        pron =(Pronostico)getIntent().getExtras().getSerializable("pron");

        Button btnGuardarPronostico =(Button)findViewById(R.id.btnGuardarPronostico);

        btnGuardarPronostico.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                EditText txtDia = (EditText)findViewById(R.id.txtDia);
                EditText txtPresion = (EditText)findViewById(R.id.txtPresion);
                EditText txtCiudad = (EditText)findViewById(R.id.txtCiudad);

                if(!txtDia.getText().toString().trim().equals("")&&!txtCiudad.getText().toString().trim().equals("")&&!txtPresion.getText().toString().trim().equals("")) {

                    pron.setDia(Dia.getDia(Integer.valueOf(txtDia.getText().toString())));
                    pron.setCiudad(String.valueOf(txtCiudad.getText().toString()));
                    pron.setPresion(Integer.valueOf(txtPresion.getText().toString()));

                    pron.setContext(getApplicationContext());
                    pron.agregar();

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity(i);


                }



            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pronostico, menu);
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
}
