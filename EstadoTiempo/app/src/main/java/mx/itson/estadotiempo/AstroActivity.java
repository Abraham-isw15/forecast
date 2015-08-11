package mx.itson.estadotiempo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.itson.enumeradores.TipoLuna;
import mx.itson.mx.itson.entidades.Astro;
import mx.itson.mx.itson.entidades.Pronostico;


public class AstroActivity extends ActionBarActivity implements View.OnClickListener {

    AstroActivity astro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);
        astro = this;
        Button btnAceptar= (Button)findViewById(R.id.btnAceptar);






        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pronostico pron = new Pronostico();

                Astro a = new Astro();

                EditText txtSalida=(EditText)findViewById(R.id.txtSalida);
                EditText txtPuesta=(EditText)findViewById(R.id.txtPuesta);
                EditText txtTipo=(EditText)findViewById(R.id.txtTipo);
                //TODO Poner tipo luna como combo box
                if(!txtSalida.getText().toString().trim().equals("")&&!txtPuesta.getText().toString().trim().equals("")&&!txtTipo.getText().toString().trim().equals("")){
                    a.setSalidaSol(Double.valueOf(txtSalida.getText().toString()) );
                    a.setPuestaSol(Double.valueOf(txtPuesta.getText().toString()));
                    a.setTipoLuna(TipoLuna.getTipoLuna(Integer.valueOf(txtTipo.getText().toString())));
                    //  a.agregar();

                    pron.setAstro(a);

                    Intent i = new Intent(astro, VientoActivity.class);
                    i.putExtra("pron", pron);
                    startActivity(i);

                }

            }








        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

