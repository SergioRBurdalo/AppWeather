package com.example.manolo.requestvolleyweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    private static final String URL="http://api.openweathermap.org/data/2.5/forecast?id=3130616&APPID=f13fdba45983a01b4aa61b4bf120aa5b";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.tv1);

        RequestQueue request = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                String cad="";

                ArrayList <DatosMeteorologicos> listaDatos=new ArrayList<DatosMeteorologicos>();

                try {

                    JSONObject jsonObjectPrincipal=new JSONObject(response.toString(0));

                    JSONArray JSONList=jsonObjectPrincipal.getJSONArray("list");

                    //Saco todas las horas de mediciones (son 40, a razón de cada 3 horas, salen 5 días
                    for(int i=0; i<JSONList.length(); i++){
                        String temperatura = JSONList.getJSONObject(i).getJSONObject("main").getString("temp");
                        String presion = JSONList.getJSONObject(i).getJSONObject("main").getString("pressure");
                        String humedad = JSONList.getJSONObject(i).getJSONObject("main").getString("humidity");
                        String nubosidad = JSONList.getJSONObject(i).getJSONObject("clouds").getString("all");


                        String icono = JSONList.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icon");
                        String aspecto = JSONList.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main");


                        String velocidadViento = JSONList.getJSONObject(i).getJSONObject("wind").getString("speed");
                        String direccionViento = JSONList.getJSONObject(i).getJSONObject("wind").getString("deg");


                        String fechaHora = JSONList.getJSONObject(i).getString("dt_txt");



                        cad += fechaHora +":\nTemperatura: "+getTemperatureCelsius(Double.parseDouble(temperatura)) + "º   Presión: "+presion + "mb    Humedad: "+humedad
                                + "%   Nubosidad: " + nubosidad + "%    Velocidad del viento: "+ velocidadViento
                                + "m/s   Dirección del viento: "+ direccionViento+ "º    Aspecto: "+aspecto
                                + "    Icono: "+ icono +"\n\n";

                        DatosMeteorologicos registro=new DatosMeteorologicos(temperatura, presion, humedad, nubosidad, icono, velocidadViento, direccionViento, aspecto, fechaHora);

                        //Con la linea siguiente cargo el ArrayList de forma que ya podré intentar mostrar todos los datos a través de un ListView
                        listaDatos.add(registro);

                    }

                    //Todo esto es ya de la primera medición (indice 0)

                    JSONObject JSONList1=JSONList.getJSONObject(0);
                    cad +="\nFecha: " + JSONList1.getString("dt");

                    JSONObject JSON1Main=JSONList1.getJSONObject("main");
                    cad += "\nTemperatura: " + JSON1Main.getString("temp")+"º";
                    cad += "\nTemperatura Min: " + JSON1Main.getString("temp_min")+"º";
                    cad += "\nTemperatura Max: " + JSON1Main.getString("temp_max")+"º";
                    cad += "\nPresión atmosférica: " + JSON1Main.getString("temp_max")+"mb"; //http://sailandtrip.com/presion-atmosferica/


                    JSONArray JSON1Weather=JSONList1.getJSONArray("weather");
                    JSONObject JSON11Weather=JSON1Weather.getJSONObject(0);
                    cad += "\nCielo: " + JSON11Weather.getString("main");

                    JSONObject JSON1Clouds=JSONList1.getJSONObject("clouds");
                    cad += "\nPorcentaje de nubosidad: " + JSON1Clouds.getString("all")+"%";


                    JSONObject JSON1Wind=JSONList1.getJSONObject("wind");
                    cad += "\nVelocidad del viento: " + JSON1Wind.getString("speed")+"m/s";
                    cad += "\nDirección del viento: " + JSON1Wind.getString("deg")+"º";

                    cad += "\nFecha/hora de predicción: " + JSONList1.getString("dt_txt");



                    tv1.setText(cad);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }

        });
        request.add(jsonObjectRequest);
    }

    public int getTemperatureCelsius(double tempKelvin){
        int tempCelsius;
        tempCelsius= (int) Math.round((tempKelvin-273.15));
        return tempCelsius;
    }
}
