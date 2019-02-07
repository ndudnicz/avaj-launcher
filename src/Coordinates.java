package src;

public class Coordinates {
  private int longitude;
  private int latitude;
  private int height;

  Coordinates(
    int longitude,
    int latitude,
    int height
  ) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.height = height;
  }

  public int getLongitude() {
    return (this.longitude);
  }

  public int getLatitude() {
    return (this.latitude);
  }

  public int getHeight() {
    return (this.height);
  }

  public void incLongitude(int inc) {
    if (inc > 0) {
      this.longitude += inc;
    }
  }

  public void incLatitude(int inc) {
    if (inc > 0) {
      this.latitude += inc;
    }
  }

  public void incHeight(int inc) {
    if (inc > 0) {
      this.height = this.height + inc > 100 ? 100 : this.height + inc;
    } else if (inc < 0) {
      this.height = -inc >= this.height ? 0 : this.height + inc;
    }
  }

  public String toString() {
    return (String.format("longitude: %d, latitude: %d, height: %d", this.getLongitude(), this.getLatitude(), this.getHeight()));
  }
}
