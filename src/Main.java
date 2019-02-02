package src;

import src.Aircraft;
import src.Coordinates;
import src.Tower;

public class Main {

  public static void main(String[] args) {

    try {
      System.out.printf("arg: %s",args[0]);
    } catch (Exception e) {
      System.out.printf("Error: %s\n", e);
      System.exit(1);
    }
    WeatherTower t = new WeatherTower();
    Coordinates c = new Coordinates(0,0,0);
    Helicopter h = new Helicopter("helico", c);
    Baloon b = new Baloon("baloon", c);
    t.register(h);
    t.register(b);
    t.unregister(b);
    t.unregister(h);
    t.closePrintWriter();
  }

}
