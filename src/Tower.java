package src;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import src.Aircraft;
import src.Flyable;

public class Tower {
  private ArrayList<Flyable> observers;

  protected Tower() {
    this.observers = new ArrayList<Flyable>();
  }

  protected void conditionsChanged() {
    // TODO
  }

  public void register(Flyable flyable) {
    // if (!observers.contains(flyable)) {
      Aircraft a = (Aircraft)flyable;

      System.out.println("register");
      String str = String.format("Tower says: %s#%s (%d) registered to weather tower.\n", a.getType(), a.getName(), a.getId());
      this._writeInFile(str);
      observers.add(flyable);
    // }
  }

  public void unregister(Flyable flyable) {
    // if (observers.contains(flyable)) {
      Aircraft a = (Aircraft)flyable;

      System.out.println("unregister");
      String str = String.format("Tower says: %s#%s (%d) unregistered from weather tower.\n", a.getType(), a.getName(), a.getId());
      this._writeInFile(str);
      observers.remove(flyable);
    // }
  }

  private void _writeInFile(String str) {
    try {
      System.out.println(str);
      FileWriter fileWriter = new FileWriter("./simulation.txt");
      PrintWriter printWriter = new PrintWriter(fileWriter);
      printWriter.println(str);
      printWriter.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }

}
