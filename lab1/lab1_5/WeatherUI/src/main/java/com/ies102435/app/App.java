package com.ies102435.app;


import com.ies102435.CityForecast;
import com.ies102435.IpmaService;
import com.ies102435.Demo;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.print("HERE");

        Demo newapp = new Demo();
        System.out.println(newapp.getCityWeather(1020500));

        System.out.println( "Hello World!" );
    }
}
