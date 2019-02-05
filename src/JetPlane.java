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
    this.weatherQuotes.put("SUN", ""); // TODO
    this.weatherQuotes.put("RAIN", "It's raining. Better watch out for lightings.");
    this.weatherQuotes.put("FOG", ""); // TODO
    this.weatherQuotes.put("SNOW", "OMG! Winter is coming!");
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
