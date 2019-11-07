package com.example.proyectolavanderia.ui.reclamo;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectolavanderia.R;

import java.util.ArrayList;

public class ReclamoFragment extends Fragment {

    private ReclamofragmentViewModel mViewModel;

    public static ReclamoFragment newInstance() {
        return new ReclamoFragment();
    }

    ListView listaReclamos;
    ListViewAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_reclamo, container, false);


        String[] titulo = new String[]{
                "Trajeron Ropa que no era mia",
                "Dudas con el Cobro",
                "Mi repartidor no llego a la hora",
                "Mi ropa llego manchada",
                "Me falta prendas",
                "No aplico promocion",
                "Otros Reclamos",
        };

        int[] imagenes = {
                R.drawable.hombreenojado,
                R.drawable.dardinero,
                R.drawable.motocicleta,
                R.drawable.ropasucia,
                R.drawable.perchaderopa,
                R.drawable.porcentaje,
                R.drawable.libroabierto
        };
        listaReclamos = (ListView) vista.findViewById(R.id.listaReclamos);
        adapter = new ListViewAdapter(getActivity(), titulo , imagenes);
        listaReclamos.setAdapter(adapter);

        listaReclamos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "presiono " + i   , Toast.LENGTH_SHORT).show();
            }
        });
        return vista;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ReclamofragmentViewModel.class);
        // TODO: Use the ViewModel
    }

}
