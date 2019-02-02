package src;

import src.Coordinates;
import src.Flyable;
import src.Aircraft;

public class JetPlane extends Aircraft implements Flyable  {

  JetPlane(
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
