package net.ivanvega.myaudiobooksclase.fragments;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.ivanvega.myaudiobooksclase.R;
import net.ivanvega.myaudiobooksclase.modelo.BookInfo;
import net.ivanvega.myaudiobooksclase.modelo.DAOBookInfo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetalleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetalleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleFragment extends Fragment {

    public static String ARG_POSITION = "index";
    AppCompatActivity activity;

    private OnFragmentInteractionListener mListener;

    public DetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate
                (R.layout.fragment_detalle,
                container, false);

        Bundle args = getArguments();

        if(args != null){
            int index = args.getInt(ARG_POSITION);
            setUpBookInfo (index, inflatedView);
        }else{
            setUpBookInfo (0, inflatedView);
        }

        return inflatedView;
    }

    private void setUpBookInfo(int index,
                               View inflatedView) {
        BookInfo book =
                DAOBookInfo.getAllBooks().get(index);

        TextView txtTitulo =
                (TextView)inflatedView.findViewById(R.id.textView1);
        TextView txtAutor =
                (TextView)inflatedView.findViewById(R.id.textView2);
        ImageView img =
                (ImageView)inflatedView.findViewById(R.id.imageView1);

        txtTitulo.setText(book.getName());
        txtAutor.setText(book.getAutor());
        img.setImageResource(book.getResourceImage());
    }
    public void updateBookView(int position){
        setUpBookInfo(position, getView());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
