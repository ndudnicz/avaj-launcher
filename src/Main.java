package src;

import java.util.ArrayList;
import src.Aircraft;
import src.Coordinates;
import src.Tower;
import src.InvalidLineException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  private static long simulationTimes = 0;

  public static void main(String[] args) {

    ArrayList<String> lines = null;

    try {
      lines = _readFile(args[0]);
    } catch (InvalidLineException e) {
      System.out.printf("Error: %s\n", e);
      System.exit(1);
    } catch (Exception e) {
      System.out.printf("Error: %s\n", e);
      System.exit(1);
    }
  }

  private static boolean _validLine(String line) {
    System.out.println(line);
    return (true);
  }

  private static ArrayList<String> _readFile(String filename) throws InvalidLineException {
    ArrayList<String> lines = new ArrayList<String>();

    BufferedReader br = null;
    FileReader fr = null;

    try {
      fr = new FileReader(filename);
      br = new BufferedReader(fr);
      String sCurrentLine;

      while ((sCurrentLine = br.readLine()) != null) {
        if (_validLine(sCurrentLine) == false) {
          throw new InvalidLineException("Invalid Line");
        } else {
          lines.add(sCurrentLine);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null) {
          br.close();
        }
        if (fr != null) {
          fr.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return lines;
  }
}
