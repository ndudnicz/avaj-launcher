package src;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import src.Aircraft;
import src.Flyable;
import src.WeatherTower;

public class Tower {
  private ArrayList<Flyable> observers;
  private FileWriter fileWriter;
  private PrintWriter printWriter;

  protected Tower() {
    this.observers = new ArrayList<Flyable>();
  }

  protected void conditionsChanged() {
    for (int j = 0; j < this.observers.size(); j++) {
      String str = String.format("%s: %s", this.observers.get(j).toString(), this.observers.get(j).howIsTheWeather());
      this._writeInFile(str);
      this.observers.get(j).updateConditions();
      Aircraft a = (Aircraft)this.observers.get(j);
      if (a.getCoordinates().getHeight() <= 0) {
        this._writeInFile(String.format("%s coordinates: %s", a.toString(), a.getCoordinates().toString()));
        this._writeInFile(String.format("%s: landing.", a.toString()));
        this.unregister(this.observers.get(j));
      }
    }
  }

  public void register(Flyable flyable) {
    if (!observers.contains(flyable)) {
      Aircraft a = (Aircraft)flyable;
      String str = String.format("Tower says: %s registered to weather tower.", a.toString());
      this._writeInFile(str);
      observers.add(flyable);
    }
  }

  public void unregister(Flyable flyable) {
    if (observers.contains(flyable)) {
      Aircraft a = (Aircraft)flyable;
      String str = String.format("Tower says: %s unregistered from weather tower.", a.toString());
      this._writeInFile(str);
      observers.remove(flyable);
    }
  }

  private void _writeInFile(String str) {
    try {
      this.printWriter.println(str);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }

  public void openPrintWriter() {
    try {
      this.fileWriter = new FileWriter("./simulation.txt");
      this.printWriter = new PrintWriter(this.fileWriter);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }

  public void closePrintWriter() {
    this.printWriter.close();
  }

}
