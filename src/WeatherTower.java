package src;

import java.util.ArrayList;
import src.Coordinates;
import src.Tower;
import src.WeatherProvider;

public class WeatherTower extends Tower {

  public WeatherTower() {
    super();
  }

  public String getWeather(Coordinates coordinates) {
    return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
  }

  void changeWeather() {
    this.conditionsChanged();
  }

  public void run(int simulationTimes) {
    for (long i = 0; i < simulationTimes; i++) {
      this.changeWeather();
    }
  }

}
