package src;

import src.Coordinates;
import src.Flyable;
import src.Aircraft;
import src.WeatherTower;
import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable  {

  protected Baloon(
    String name,
    Coordinates coordinates
  ) {
    super(name, coordinates);
    this.weatherQuotes.put("SUN", "Let's enjoy the good weather and take some pics.");
    this.weatherQuotes.put("RAIN", "Damn you rain! You messed up my baloon.");
    this.weatherQuotes.put("FOG", ""); // TODO
    this.weatherQuotes.put("SNOW", "It's snowing. We're  gonna crash.");
  }

  public void updateConditions() {
  }

  public void registerTower(WeatherTower wt) {
    this.wt = wt;
    wt.register(this);
  }

  public String howIsTheWeather() {
    String currentWeather = this.wt.getWeather(this.coordinates);
    return String.format("", this.getType(), this.getName(), this.getId());
  }
}
