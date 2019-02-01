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
    this.coordinates = coordinates;
    this.id = this.nextId();
    idCounter++;
  }

  private long nextId(){
    return (idCounter);
  }

  public long getId() {
    return (this.id);
  }
}
