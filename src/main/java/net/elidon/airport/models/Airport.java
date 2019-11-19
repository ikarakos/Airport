package net.elidon.airport.models;

public class Airport {

  private String name;
  private String icao;
  private int elevation;
  private String city;
  private String country;
  private String iata;

  public Airport() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcao() {
    return icao;
  }

  public void setIcao(String icao) {
    this.icao = icao;
  }

  public int getElevation() {
    return elevation;
  }

  public void setElevation(int elevation) {
    this.elevation = elevation;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getIata() {
    return iata;
  }

  public void setIata(String iata) {
    this.iata = iata;
  }

  @Override
  public String toString() {
    return "Airport{" +
        "name='" + getName() + '\'' +
        ", icao='" + getIcao() + '\'' +
        ", iata='" + getIata() + '\'' +
        ", elevation=" + getElevation() +
        ", city='" + getCity() + '\'' +
        ", country='" + getCountry() + '\'' +
        '}';
  }
}
