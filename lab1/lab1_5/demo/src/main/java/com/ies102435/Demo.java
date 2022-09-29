package com.ies102435;

import com.ies102435.IpmaService;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class Demo {

    //todo: should generalize for a city passed as argument


    public String getCityWeather(int city){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                  // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                String re = String.format( "Maximum Temperature for %s for the day %s  is  %4.1f %n",
                        forecast.getCountry(),
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));

                return re;
            } else {
                return "No results for this request!";

            }
        } catch (Exception ex) {
            ex.printStackTrace();

            return "An error occurred";
        }

    }

}
