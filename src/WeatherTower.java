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

  private int _abs(int i) {
    return (i < 0 ? -i : i);
  }
  private int _weatherHash(int longitude, int latitude, int height) {
    int hash = 0;
    for (int i = 0; i < 32; i += 8) {
      hash = this._abs((hash * 31 + (longitude & (0xff000000 >> i)))) % 15487469;
    }
    for (int i = 0; i < 32; i += 8) {
      hash = this._abs((hash * 31 + (latitude & (0xff000000 >> i)))) % 15487469;
    }
    for (int i = 0; i < 32; i += 8) {
      hash = this._abs((hash * 31 + (height & (0xff000000 >> i)))) % 15487469;
    }
    return (hash);
  }

  public String getWeather(Coordinates coordinates) {
    return (_weathers[this._weatherHash(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight()) % 4]);
  }

  void changeWeather() {
    // TODO
  }

}
