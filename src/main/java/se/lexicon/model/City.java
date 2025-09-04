package se.lexicon.model;

import java.util.Objects;

/**
 * Represents a City entity based on the 'city' table in the 'world' database.
 */
public class City {

    // Fields;
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    // Constructor for creating new cities (without ID):
    public City(String name, String countryCode, String district, int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    // Constructor for loading cities from the database (with ID):
    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    // Getters:
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    // Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // Methods:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- City Information --").append("\n");
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Name: ").append(getName()).append("\n");
        sb.append("Country code: ").append(getCountryCode()).append("\n");
        sb.append("District: ").append(getDistrict()).append("\n");
        sb.append("Population: ").append(getPopulation()).append("\n");
        sb.append("---------------------------").append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
