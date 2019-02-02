package src;

import src.Coordinates;

public class Aircraft {
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private static long idCounter = 0;

  protected Aircraft(
    String name,
    Coordinates coordinates
  ) {
    this.name = name;
    this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
    this.id = this.nextId();
    idCounter++;
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
