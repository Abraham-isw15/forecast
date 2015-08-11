package mx.itson.estadotiempo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
//import butterknife.InjectView;
import butterknife.OnClick;


public class FormActivity extends AppCompatActivity {


    //Injectar Vistas o elementos a usar
    //@InjectView(R.id.edt_first);
    @Bind(R.id.edt_first)
    EditText Nombre;

    //@InjectView(R.id.edt_last);
    @Bind(R.id.edt_last)
    EditText Apellido;


    //@InjectView(R.id.edt_pass1);
    @Bind(R.id.edt_pass1)
    EditText Passsword;


    // @InjectView(R.id.edt_confpass);
    @Bind(R.id.edt_confpass)
    EditText ConfPassword;


    // @InjectView(R.id.edt_telefono);
    @Bind(R.id.edt_telefono)
    EditText Telefono;


    //@InjectView(R.id.edt_correo);
    @Bind(R.id.edt_correo)
    EditText Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_registrar)
    public void OnClick(View view){
        Intent intent = new Intent(this,MainActivity.class);

        String nombre = Nombre.getText().toString();
        String apellido = Apellido.getText().toString();
        String password = Passsword.getText().toString();
        String confpassword = ConfPassword.getText().toString();
        String telefono = Telefono.getText().toString();
        String email = Email.getText().toString();


        intent.putExtra("Nombre",nombre);
        intent.putExtra("Apellido",apellido);
        intent.putExtra("Telefono",telefono);
        intent.putExtra("Email", email);

        startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
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
