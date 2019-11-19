package net.elidon.airport;

import net.elidon.airport.models.Airport;
import net.elidon.airport.parsers.FlatParser;
import net.elidon.airport.parsers.IParser;

import java.util.List;

public class Main {
  public static void main(String[] args) {

    final IParser parser = new FlatParser();
    final List<Airport> airports = parser.parse("apt.dat");

    System.out.println("found airports " + airports.size());

    for (Airport airport : airports) {
      System.out.println(airport);
    }
  }
}
