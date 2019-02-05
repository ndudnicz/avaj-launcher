package src;

import src.Coordinates;
import java.util.HashMap;

public class Aircraft {
  protected WeatherTower wt;
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private static long idCounter = 0;
  HashMap<String, String> weatherQuotes;

  protected Aircraft(
    String name,
    Coordinates coordinates
  ) {
    this.name = name;
    this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
    this.id = this.nextId();
    idCounter++;
    this.weatherQuotes = new HashMap<String, String>();
  }

  private long nextId(){
    return (idCounter);
  }

  public long getId() {
    return (this.id);
  }

  public String getName() {
    return (this.name);
  }

  public String getType() {
    return (this.getClass().getSimpleName());
  }

  public String toString() {
    return String.format("%s#%s(%d)", this.getType(), this.getName(), this.getId());
  }

}
