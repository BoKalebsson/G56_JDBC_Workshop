package se.lexicon.dao;

import se.lexicon.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents the implementation of CityDao for interacting with the 'city' table in the database.
 */
public class CityDaoImpl implements CityDao{

    // Database credentials:
    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Get a database connection:
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public Optional<City> findById(int id) throws SQLException {
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()){
                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")
                    );
                    return Optional.of(city);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<City> findByCode(String code) throws SQLException{
        return List.of();
    }

    @Override
    public List<City> findByName(String name) throws SQLException{
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE Name LIKE = ?";
        List<City> cities = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

             preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")
                    );
                    cities.add(city);
                }
            }
        }
        return cities;
    }

    @Override
    public List<City> findAll() throws SQLException{
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city";
        List<City> cities = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()
             ) {

            while (resultSet.next()) {
                City city = new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")
                );
                cities.add(city);
            }
        }
        return cities;
    }

    @Override
    public City save(City city) throws SQLException{
        return null;
    }

    @Override
    public void update(City city) throws SQLException{

    }

    @Override
    public void deleteById(int id) throws SQLException{

    }

}
