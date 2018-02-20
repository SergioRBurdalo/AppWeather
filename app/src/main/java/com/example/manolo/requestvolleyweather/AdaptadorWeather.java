package com.example.manolo.requestvolleyweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC_Gaming on 20/02/2018.
 */

public class AdaptadorWeather extends BaseAdapter{

    Context context;
    ArrayList<DatosMeteorologicos> listaDatos;

    public AdaptadorWeather(Context context, ArrayList<DatosMeteorologicos> listaDatos) {
        this.context = context;
        this.listaDatos = listaDatos;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDatos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vista = view;
        LayoutInflater inflate =LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.item_weather, null);

        TextView tvFecha, tvTemperatura, tvHumedad, tvPresion, tvNubosidad, tvAspecto;
        tvFecha = vista.findViewById(R.id.tvFecha);
        tvHumedad = vista.findViewById(R.id.tvHumedad);
        tvNubosidad = vista.findViewById(R.id.tvNubosidad);
        tvPresion = vista.findViewById(R.id.tvPresion);
        tvTemperatura = vista.findViewById(R.id.tvTemperatura);
        tvAspecto = vista.findViewById(R.id.tvDescripcion);

        // IMPRIMO LOS VALORES DEL ARRAY LIST

        tvFecha.setText(listaDatos.get(i).getFechaHora().toString());
        tvHumedad.setText("Húmedad: " + listaDatos.get(i).getHumedad().toString() + "%");
        tvNubosidad.setText("Nubosidad: " + listaDatos.get(i).getNubosidad().toString() + "%");
        tvPresion.setText("Presión: " + listaDatos.get(i).getPresion().toString() + "mb");
        tvTemperatura.setText("Temperatura: " + String.valueOf(getTemperatureCelsius(Double.parseDouble(listaDatos.get(i).getTemperatura().toString()))) + "ºC");
        tvAspecto.setText("Aspecto --> " + listaDatos.get(i).getAspecto().toString());


        return vista;
    }

    public int getTemperatureCelsius(double tempKelvin){
        int tempCelsius;
        tempCelsius= (int) Math.round((tempKelvin-273.15));
        return tempCelsius;
    }
}
