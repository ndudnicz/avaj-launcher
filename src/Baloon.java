package src;

import src.Coordinates;
import src.Flyable;
import src.Aircraft;
import src.WeatherTower;

public class Baloon extends Aircraft implements Flyable  {

  Baloon(
    String name,
    Coordinates coordinates
  ) {
    super(name, coordinates);
    this.weatherQuotes.put("SUN", "Let's enjoy the good weather and take some pics.");
    this.weatherQuotes.put("RAIN", "Damn you rain! You messed up my baloon.");
    this.weatherQuotes.put("FOG", "FML, I would have listened to my mother and become an airplane pilot.");
    this.weatherQuotes.put("SNOW", "It's snowing. We're  gonna crash.");
  }

  public void updateConditions() {
    switch (this.wt.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates.incLongitude(2);
        this.coordinates.incHeight(4);
      break;
      case "RAIN":
        this.coordinates.incHeight(-5);
      break;
      case "FOG":
        this.coordinates.incHeight(-3);
      break;
      case "SNOW":
        this.coordinates.incHeight(-15);
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
