package src;

import src.Aircraft;
import src.Coordinates;

public class Main {

  public static void main(String[] args) {

    Coordinates c = new Coordinates(0,0,0);
    Aircraft a = new Aircraft("toto plane", c);
    Aircraft b = new Aircraft("toto plane", c);
    Aircraft d = new Aircraft("toto plane", c);
    System.out.println(a.getId());
    System.out.println(b.getId());
    System.out.println(d.getId());

  }

}
