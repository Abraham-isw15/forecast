package mx.itson.estadotiempo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import mx.itson.mx.itson.entidades.Pronostico;


public class ContenidoActivity extends ActionBarActivity {

    Pronostico pronostico = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);



                pronostico = (Pronostico)getIntent().getSerializableExtra("pronostico");

                //pronostico
                TextView tvCiudad=(TextView)findViewById(R.id.tvCiudad);
                TextView tvDia=(TextView)findViewById(R.id.tvDia);
                TextView tvPresion=(TextView)findViewById(R.id.tvPresion);
                //EstadoTiempo|
                //Temperatura
                //Uv
                TextView tvMinima=(TextView)findViewById(R.id.tvMinima);
                TextView tvActual= (TextView)findViewById(R.id.tvActual);
                TextView tvMaxima=(TextView)findViewById(R.id.tvMaxima);
                TextView tvSensacionTermica=(TextView)findViewById(R.id.tvSensacionTermica);
                TextView tvHumedad=(TextView)findViewById(R.id.tvHumedad);
                TextView tvProbabilidad=(TextView)findViewById(R.id.tvProbabilidadLluvia);
                TextView tvValor=(TextView)findViewById(R.id.tvValor);
                TextView tvRiesgo=(TextView)findViewById(R.id.tvRiesgo);
                //viento
                TextView tvValorViento=(TextView)findViewById(R.id.tvValorViento);
                TextView tvMinimo=(TextView)findViewById(R.id.tMinimo);
                TextView tvMaximo=(TextView)findViewById(R.id.tMaximo);
                TextView tvDireccion=(TextView)findViewById(R.id.tvDireccion);
                //Astro
                TextView tvSalida=(TextView)findViewById(R.id.tvSalidaSol);
                TextView tvPuesta=(TextView)findViewById(R.id.tvPuestaSol);
                TextView tvTipo=(TextView)findViewById(R.id.tvTipoLuna);


                tvCiudad.setText("Ciudad: "+pronostico.getCiudad());
                tvDia.setText("Dia: "+pronostico.getDia());
                tvPresion.setText("Presion: "+pronostico.getPresion());
                tvMinima.setText("Minima: "+pronostico.getEstadoTiempo().getTemperatura().getMinima());
                tvActual.setText("Actual: "+pronostico.getEstadoTiempo().getTemperatura().getActual());
                tvMaxima.setText("Maxima: "+pronostico.getEstadoTiempo().getTemperatura().getMaxima());
                tvSensacionTermica.setText("Sensación termica: "+pronostico.getEstadoTiempo().getSensacionTermica());
                tvProbabilidad.setText("Probabilidad de lluvia: "+pronostico.getEstadoTiempo().getProbabilidadLluvia()+"%");
                tvValor.setText("Valor: "+pronostico.getEstadoTiempo().getUv().getValor());
                tvRiesgo.setText("Riesgo: "+pronostico.getEstadoTiempo().getUv().getRiesgo());
                tvValorViento.setText("Valor: "+pronostico.getViento().getValor());
                tvMinimo.setText("Minimo: "+pronostico.getViento().getMinimo());
                tvMaximo.setText("Maximo: "+pronostico.getViento().getMaximo());
                tvDireccion.setText("Direccion: "+pronostico.getViento().getDireccionViento());
                tvSalida.setText("Salida del sol: "+pronostico.getAstro().getSalidaSol());
                tvPuesta.setText("Puesta del sol: "+pronostico.getAstro().getPuestaSol());
                tvTipo.setText("Luna: "+pronostico.getAstro().getTipoLuna());
                tvHumedad.setText("Humedad: "+pronostico.getEstadoTiempo().getHumedad());



            }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contenido, menu);
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
