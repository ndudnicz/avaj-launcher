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
    this.weatherQuotes.put("RAIN", ""); // TODO
    this.weatherQuotes.put("FOG", ""); // TODO
    this.weatherQuotes.put("SNOW", "My rotor is going to freeze!");
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
