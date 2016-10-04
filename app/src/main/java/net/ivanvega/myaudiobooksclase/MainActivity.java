package net.ivanvega.myaudiobooksclase;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import net.ivanvega.myaudiobooksclase.fragments.DetalleFragment;
import net.ivanvega.myaudiobooksclase.fragments.OnFragmentInteractionListener;
import net.ivanvega.myaudiobooksclase.fragments.SelectorFragment;
import net.ivanvega.myaudiobooksclase.modelo.DAOBookInfo;

public class MainActivity extends AppCompatActivity
implements OnFragmentInteractionListener
{
    GridView grv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        if (findViewById(R.id.fragment_container) != null
                && savedInstanceState ==null
                )
        {
            SelectorFragment primerFragment =
                    new SelectorFragment();
            getSupportFragmentManager().
                    beginTransaction()
                    .add(R.id.fragment_container,primerFragment)
                    .commit();
        }

//        grv = (GridView)findViewById(R.id.gridView);
//
//        SelectorAdapter adp
//                = new SelectorAdapter(this,
//                DAOBookInfo.getAllBooks());
//
//        grv.setAdapter(adp);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        DetalleFragment detalleFragment =
                (DetalleFragment)
                        getSupportFragmentManager()
                .findFragmentById(R.id.detalle_fragment);

        if (detalleFragment != null){
            detalleFragment.
                    updateBookView( Integer.parseInt( uri.toString()));
        }else{
            DetalleFragment nuevoFragment
                    = new DetalleFragment();
            Bundle args = new Bundle();
            args.putInt(DetalleFragment.ARG_POSITION,
                    Integer.parseInt( uri.toString()));
            nuevoFragment.setArguments(args);
            FragmentTransaction transaccion =
                    getSupportFragmentManager().beginTransaction();

            transaccion.replace(R.id.fragment_container, nuevoFragment);
            transaccion.addToBackStack(null);
            transaccion.commit();

        }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
