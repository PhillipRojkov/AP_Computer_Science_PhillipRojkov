/*
 * Arrays of objects
 * Edited by: Phillip Rojkov
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name", 
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());

      //Stations in a state
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      int numStations = 0; //number of weather stations in input state
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            numStations++;
            System.out.println("  " + ws.getId() + ": " + ws.getName());
         }
      }
      //Print the total number of weather stations in the state
      System.out.println("There are " + numStations + " weather stations in "+ state);

      //Print the lowest station by latitude
      System.out.println("Stations by latitude");
      double minLat;
      minLat = allstns.get(0).getLat();
      WeatherStation minStn = allstns.get(0);
      for (WeatherStation ws : allstns) {
         if (ws.getLat() < minLat) {
            minStn = ws;
            minLat = ws.getLat();
         }
      }
      System.out.println(minStn.getId() + ": " + minStn.getName() + " is furthest south at " + minLat);
   }
}