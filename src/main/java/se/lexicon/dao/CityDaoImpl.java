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
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE CountryCode = ?";
        List<City> cities = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, code);

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
    public List<City> findByName(String name) throws SQLException{
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE Name LIKE ?";
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
    public City save(City city) throws SQLException {
        String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
            ) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("❌ Creating city failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int newId = generatedKeys.getInt(1);
                    return new City(newId, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation());
                } else {
                    throw new SQLException("❌ Creating city failed, no ID obtained.");
                }
            }
        }
    }

    @Override
    public void update(City city) throws SQLException {
        String sql = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("❌ Updating city failed, no rows affected. ID: " + city.getId());
            }
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM city WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("❌ Deleting city failed, no rows affected. ID: " + id);
            }
        }
    }

}
