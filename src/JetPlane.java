package src;

import src.Coordinates;
import src.Flyable;
import src.Aircraft;
import src.WeatherTower;

public class JetPlane extends Aircraft implements Flyable  {

  JetPlane(
    String name,
    Coordinates coordinates
  ) {
    super(name, coordinates);
    this.weatherQuotes.put("SUN", "Sunscreen, check. Sunglasses, check.");
    this.weatherQuotes.put("RAIN", "It's raining. Better watch out for lightings.");
    this.weatherQuotes.put("FOG", "Oh man, do we even have fog lights on this plane ?");
    this.weatherQuotes.put("SNOW", "OMG! Winter is coming!");
  }

  public void updateConditions() {
    switch (this.wt.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates.incLatitude(10);
        this.coordinates.incHeight(2);
      break;
      case "RAIN":
        this.coordinates.incLatitude(5);
      break;
      case "FOG":
        this.coordinates.incLatitude(1);
      break;
      case "SNOW":
        this.coordinates.incHeight(-7);
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
