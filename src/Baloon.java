package src;

import src.Coordinates;
import src.Flyable;
import src.Aircraft;

public class Baloon extends Aircraft implements Flyable  {

  protected Baloon(
    String name,
    Coordinates coordinates
  ) {
    super(name, coordinates);
    this.type = "Baloon";
  }

  public void updateConditions() {
  }

  public void registerTower() {
  }
}
