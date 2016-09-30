package net.ivanvega.myaudiobooksclase.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import net.ivanvega.myaudiobooksclase.R;
import net.ivanvega.myaudiobooksclase.SelectorAdapter;
import net.ivanvega.myaudiobooksclase.modelo.DAOBookInfo;

/**
 * Created by SERVIDOR on 26/09/2016.
 */

public class SelectorFragment extends Fragment {
    AppCompatActivity activity;
    GridView gridView;
    SelectorAdapter adaptador;



    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.activity =
                (AppCompatActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View inflatedView = inflater.inflate
                (R.layout.fragment_selector_layout,
                    container,
                   false
                        );

        gridView = (GridView)
                inflatedView.findViewById
                        (R.id.gridView);

        adaptador  = new SelectorAdapter(activity,
                DAOBookInfo.getAllBooks());

        gridView.setAdapter(adaptador);

        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view,
                                            int position,
                                            long id) {

                    }
                }
        );

        return inflatedView;

    }
}
