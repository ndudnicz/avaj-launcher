package src;

import java.util.ArrayList;
import src.Coordinates;
import src.Tower;

public class WeatherTower extends Tower {

  private static String[] _weathers = {
    "RAIN",
    "FOG",
    "SUN",
    "SNOW"
  };

  public WeatherTower() {
    super();
  }

  public String getWeather(Coordinates coordinates) {
    return (_weathers[(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4]);
  }

  void changeWeather() {
    // TODO
  }

}
