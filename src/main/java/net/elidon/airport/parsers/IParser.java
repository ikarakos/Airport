package net.elidon.airport.parsers;

import net.elidon.airport.models.Airport;

import java.util.List;

public interface IParser {
  List<Airport> parse(String fileName);
}
