package src;

import java.util.ArrayList;
import src.Aircraft;
import src.Coordinates;
import src.Tower;
import src.InvalidLineException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import src.AircraftFactory;
import java.util.regex.*;
import src.AircraftFactory;

public class Main {

  private static long _simulationTimes = -1;
  private static Pattern _pattern = null;
  private static Matcher _matcher = null;
  private static ArrayList<Flyable> _tmp = new ArrayList<Flyable>();
  private static WeatherTower _tower = new WeatherTower();

  public static void main(String[] args) {

    ArrayList<String> lines = null;

    try {
      _readFile(args[0]);
      _transferTmpToTower();
      _tower.closePrintWriter();
    } catch (InvalidLineException e) {
      System.out.printf("Error: %s\n", e);
      System.exit(1);
    } catch (Exception e) {
      System.out.printf("Error: %s\n", e);
      System.exit(1);
    } finally {
      _tower.closePrintWriter();
    }
  }

  private static void _transferTmpToTower() {
    for (int i = 0; i < _tmp.size(); i++) {
      _tower.register(_tmp.get(i));
    }
  }

  private static boolean _validLine(String line) {
    if (_simulationTimes < 0) {
      _pattern = Pattern.compile("^[0-9]+$");
      _matcher = _pattern.matcher(line);
      if (_matcher.find()) {
        try {
          _simulationTimes = Integer.parseInt(line);
          // System.out.printf("_simulationTimes: %d\n",_simulationTimes); // DEBUG
        } catch(Exception e) {
          // System.out.printf("_validLine false: %s\n",line);//DEBUG
          return (false);
        }
      } else {
        System.out.printf("_validLine false: %s\n",line);//DEBUG
        return (false);
      }
    } else {
      _pattern = Pattern.compile("^(Baloon|JetPlane|Helicopter) ([a-zA-Z0-9]+) ([0-9]+) ([0-9]+) (100|[0-9]{1,2}$)");
      _matcher = _pattern.matcher(line);
      if (_matcher.find()) {
        int longitude = Integer.parseInt(_matcher.group(3));
        int latitude = Integer.parseInt(_matcher.group(4));
        int height = Integer.parseInt(_matcher.group(5));
        Flyable f = AircraftFactory.newAircraft(_matcher.group(1), _matcher.group(2), longitude, latitude, height);
        _tmp.add(f);
        System.out.printf("add flyable: %s\n", ((Aircraft)f).toString()); //DEBUG
      } else {
        System.out.printf("_validLine false: %s\n",line);//DEBUG
        return (false);
      }
    }
    return (true);
  }

  private static void _readFile(String filename) throws InvalidLineException {
    BufferedReader br = null;
    FileReader fr = null;

    try {
      fr = new FileReader(filename);
      br = new BufferedReader(fr);
      String sCurrentLine;

      while ((sCurrentLine = br.readLine()) != null) {
        if (_validLine(sCurrentLine) == false) {
          throw new InvalidLineException("Invalid Line");
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
  }
}
