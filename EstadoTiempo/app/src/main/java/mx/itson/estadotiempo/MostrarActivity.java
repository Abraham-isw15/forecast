package mx.itson.estadotiempo;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import mx.itson.mx.itson.entidades.Pronostico;


public class MostrarActivity extends ActionBarActivity implements OnClickListener {
    List<Pronostico> lista = new ArrayList<>();
    private ListView DetallesMostrarActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        Pronostico pronostico = new Pronostico(getApplicationContext());


        lista = pronostico.obtenerTodos();



        Adaptor adaptador = new Adaptor(MostrarActivity.this, lista);
        DetallesMostrarActivity = (ListView)findViewById(R.id.listView1);

        DetallesMostrarActivity.setAdapter(adaptador);


        DetallesMostrarActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Intent i = new Intent(MostrarActivity.this, ContenidoActivity.class);
                i.putExtra("pronostico",lista.get(position) );
                startActivity(i);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mostrar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }


    }


    class Adaptor extends ArrayAdapter<Pronostico> {

        private List<Pronostico> data;
        private Activity mActivity;
        private LayoutInflater inflater = null;

        public Adaptor(Activity a, List<Pronostico> d) {
            super(a, R.layout.activity_detalles_mostrar, d);
            mActivity = a;
            data = d;
            inflater = (LayoutInflater) mActivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            if (vi == null)
                vi = inflater.inflate(R.layout.activity_detalles_mostrar, parent, false);

            TextView title = (TextView) vi.findViewById(R.id.txtDetallesCiudad);
            TextView subtitle = (TextView) vi.findViewById(R.id.txtDetallesTemperatura);

            title.setText("Ciudad: "+data.get(position).getCiudad());
            subtitle.setText(data.get(position).getEstadoTiempo().getTemperatura().getActual()+"°C");

            return vi;
        }

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }

}