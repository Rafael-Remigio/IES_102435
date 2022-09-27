package com.ies102435;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.ies102435.IpmaCityForecast; //may need to adapt package name
import com.ies102435.IpmaService;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class App {

    //todo: should generalize for a city passed as argument
    private static Logger logger = LogManager.getLogger(App.class);

    public static void  main(String[] args ) {

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects


        int CITY_ID_AVEIRO = Integer.parseInt(args[0]);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf( "Maximum Temperature for %s for the day %s  is  %4.1f %n",
                        forecast.getCountry(),
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));

                        logger.info("Info log message");
            } else {
                System.out.println( "No results for this request!");
                logger.error("Error log message");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
