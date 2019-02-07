package src;

// import java.util.ArrayList;
// import src.Coordinates;
// import src.Tower;

public class WeatherProvider extends Tower {

  private static String[] weather = {
    "RAIN",
    "FOG",
    "SUN",
    "SNOW"
  };
  private static WeatherProvider weatherProvider = null;

  private WeatherProvider() {
    super();
  }

  public static WeatherProvider getProvider() {
    if (weatherProvider == null) {
      weatherProvider = new WeatherProvider();
    }
    return (weatherProvider);
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

  public String getCurrentWeather(Coordinates coordinates) {
    return (weather[this._weatherHash(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight()) % 4]);
  }
}
