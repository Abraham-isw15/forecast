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
import android.widget.TextView;

import mx.itson.enumeradores.DireccionViento;
import mx.itson.mx.itson.entidades.Pronostico;
import mx.itson.mx.itson.entidades.Viento;


public class VientoActivity extends ActionBarActivity implements View.OnClickListener{

    Pronostico pron = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viento);

        pron = (Pronostico) getIntent().getSerializableExtra("pron");

        Button btnGuardarViento= (Button)findViewById(R.id.btnGuardarViento);
        btnGuardarViento.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                Viento vi =new Viento();



                EditText txtValor=(EditText)findViewById(R.id.txtValorViento);
                EditText txtMinimo=(EditText)findViewById(R.id.txtMinimo);
                EditText txtMaximo= (EditText)findViewById(R.id.txtMaximo);
                EditText txtDireccion = (EditText)findViewById(R.id.txtDireccion);
                //TODO combobox en direccion del viento
                if(!txtMaximo.getText().toString().equals("")&&!txtMinimo.getText().toString().equals("")&&!txtValor.getText().toString().equals("")&&!txtDireccion.getText().toString().equals("")){
                    vi.setValor(Double.valueOf(txtValor.getText().toString()));
                    vi.setMaximo(Double.valueOf(txtMaximo.getText().toString()));
                    vi.setMinimo(Double.valueOf(txtMinimo.getText().toString()));
                    vi.setDireccionViento(DireccionViento.getDireccionViento(Integer.valueOf(txtDireccion.getText().toString())));
                    //          vi.agregar();

                    pron.setViento(vi);

                    Intent i = new Intent(getApplicationContext(), EstadoTiempoActivity.class);
                    i.putExtra("pron", pron);
                    startActivity(i);


                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_viento, menu);
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
