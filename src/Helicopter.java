package src;

import src.Coordinates;
import src.Flyable;
import src.Aircraft;
import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable  {

  Helicopter(
    String name,
    Coordinates coordinates
  ) {
    super(name, coordinates);
    this.weatherQuotes.put("SUN", "This is hot.");
    this.weatherQuotes.put("RAIN", "You know what, fuck you Evelyne Dheliat!");
    this.weatherQuotes.put("FOG", "flac-flac-flac");
    this.weatherQuotes.put("SNOW", "My rotor is going to freeze!");
  }

  public void updateConditions() {
    switch (this.wt.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates.incLongitude(10);
        this.coordinates.incHeight(2);
      break;
      case "RAIN":
        this.coordinates.incLongitude(5);
      break;
      case "FOG":
        this.coordinates.incLongitude(1);
      break;
      case "SNOW":
        this.coordinates.incHeight(-12);
      break;
      default:
      break;
    }
  }

  public void registerTower(WeatherTower wt) {
    this.wt = wt;
    wt.register(this);
  }

}
