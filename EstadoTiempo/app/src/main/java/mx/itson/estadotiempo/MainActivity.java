package mx.itson.estadotiempo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText edt_nom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt_nom = (EditText) findViewById(R.id.edt_nom);


        ////////////////////////////////////////////////////////////////////////////////////////////

        /**
         * Aquí voy a cachar los extra con el bundle zip.
         */

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        if(bundle != null){
            String fn = (String) bundle.get("Nombre");
            edt_nom.setText(fn);

        }


        if(bundle !=null){

            String fn = (String) bundle.get("Nombre");
            edt_nom.setText(fn);

        }




        ///////////////////////////////////////////////////////////////////////////////////////////





        Button btnAgregar = (Button) findViewById(R.id.btnAgregar);
        Button btnMostrar = (Button) findViewById(R.id.btnMostrar);




        btnMostrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i = new Intent(getApplicationContext(), MostrarActivity.class);


                startActivity(i);

            }
        });


        btnAgregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent i = new Intent(getApplicationContext(), AstroActivity.class);


                startActivity(i);


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





}
