package src;

import src.WeatherTower;

public interface Flyable {
  public void updateConditions();
  public void registerTower(WeatherTower wt);
  public String howIsTheWeather();
}
