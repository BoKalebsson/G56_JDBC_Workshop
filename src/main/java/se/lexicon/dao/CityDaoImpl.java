package se.lexicon.dao;

import se.lexicon.model.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Represents the implementation of CityDao for interacting with the 'city' table in the database.
 */
public class CityDaoImpl implements CityDao{

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Get a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public Optional<City> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<City> findByCode(String code) {
        return List.of();
    }

    @Override
    public List<City> findByName(String name) {
        return List.of();
    }

    @Override
    public List<City> findAll() {
        return List.of();
    }

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public void update(City city) {

    }

    @Override
    public void deleteById(int id) {

    }

}
