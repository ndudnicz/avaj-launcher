package src;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import src.Aircraft;
import src.Flyable;

public class Tower {
  private ArrayList<Flyable> observers;
  private FileWriter fileWriter;
  private PrintWriter printWriter;

  protected Tower() {
    this.observers = new ArrayList<Flyable>();
  }

  protected void conditionsChanged() {
    // TODO
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
