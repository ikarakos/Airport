package net.elidon.airport.parsers;

import net.elidon.airport.models.Airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatParser implements IParser {

  final private static String ID_AIRPORT = "1";
  final private static String ID_META = "1302";

  final private static int META_NAME_START_INDEX = 2;
  final private static int AIRPORT_START_INDEX = 5;
  final private static String PARSER_REGEX = "\\s+";

  private String getNameFromParts(String[] parts, int start) {
    final String[] names = Arrays.copyOfRange(parts, start, parts.length);
    return String.join(" ", names);
  }

  private Airport createAirport(final String[] parts) {
    final Airport airport = new Airport();
    airport.setElevation(Integer.parseInt(parts[1]));
    airport.setIcao(parts[4]);
    airport.setName(getNameFromParts(parts, AIRPORT_START_INDEX));
    return airport;
  }

  private void addMetaData(Airport airport, final String[] parts) {
    switch (parts[1]) {
      case "city":
        airport.setCity(getNameFromParts(parts, META_NAME_START_INDEX));
        break;
      case "country":
        airport.setCountry(getNameFromParts(parts, META_NAME_START_INDEX));
        break;
      case "iata_code":
        airport.setIata(parts[META_NAME_START_INDEX]);
        break;
      default:
        break;
    }
  }

  @Override
  public List<Airport> parse(final String fileName) {
    final List<Airport> airports = new ArrayList<>();
    try {
      final BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String line = reader.readLine();
      Airport airport = null;
      while (line != null) {
        final String[] parts = line.split(PARSER_REGEX);
        if (parts.length > 0) {
          switch (parts[0]) {
            case ID_AIRPORT:
              airports.add(airport);
              airport = createAirport(parts);
              break;
            case ID_META:
              if (airport != null && parts.length > META_NAME_START_INDEX) {
                addMetaData(airport, parts);
              }
              break;
            default:
              break;
          }
        }
        line = reader.readLine();
      }
      reader.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return airports;
  }
}
