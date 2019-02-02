package src;

import src.Coordinates;
import src.Flyable;
import src.Aircraft;

public class Helicopter extends Aircraft implements Flyable  {

  Helicopter(
    String name,
    Coordinates coordinates
  ) {
    super(name, coordinates);
  }

  public void updateConditions() {
  }

  public void registerTower(/* TODO WeatherTower ...*/) {
  }
}
