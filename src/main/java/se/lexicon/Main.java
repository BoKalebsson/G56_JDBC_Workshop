package se.lexicon;

import se.lexicon.dao.CityDaoImpl;
import se.lexicon.model.City;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Represents the entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        CityDaoImpl cityDao = new CityDaoImpl();

/*        // Testing the findById()-method:
        int testId = 1;

        try {
            Optional<City> cityOptional = cityDao.findById(testId);

            if (cityOptional.isPresent()) {
                System.out.println("✅ The city was found:");
                System.out.println(cityOptional.get());
            } else {
                System.out.println("❌ No city with ID " + testId + " was found.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Something went wrong finding the city:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }*/

/*        // Testing findAll()-method:
        try {
            List<City> allCities = cityDao.findAll();
            allCities.forEach(System.out::println);
            System.out.println("Total amount of cities found: " + allCities.size());

        } catch (SQLException e) {
            System.err.println("❌ Something went wrong finding the cities:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }*/

/*        // Testing findByName()-method:
        String testName = "London";

        try {
            List<City> citiesByName = cityDao.findByName(testName);

            if (citiesByName.isEmpty()) {
                System.out.println("❌ No cities with the name '" + testName + "' was found.");
            } else {
                System.out.println("✅ Cities with '" + testName + "':");
                citiesByName.forEach(System.out::println);
            }

            System.out.println("Total amount of cities with country code '" + testName + "': " + citiesByName.size());

        } catch (SQLException e) {
            System.err.println("❌ Something went wrong finding the cities:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }*/

/*        // Testing findByCode()-method:
        String testCode = "GBR";

        try {
            List<City> citiesByCode = cityDao.findByCode(testCode);

            if (citiesByCode.isEmpty()) {
                System.out.println("❌ No cities with country code '" + testCode + "' was found.");
            } else {
                System.out.println("✅ Cities with country code '" + testCode + "':");
                citiesByCode.forEach(System.out::println);
            }

            System.out.println("Total amount of cities with country code '" + testCode + "': " + citiesByCode.size());

        } catch (SQLException e) {
            System.err.println("❌ Something went wrong finding the cities:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }*/

/*        // Testing save()-method:
        City newCity = new City("Köping", "SWE", "Västmanland", 18605);

        try {
            City savedCity = cityDao.save(newCity);
            System.out.println("✅ New city saved:");
            System.out.println(savedCity);
        } catch (SQLException e) {
            System.err.println("❌ Something went wrong saving the city:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }*/

/*        // Testing update()-method:
        try {
            int testId = 4080;

            cityDao.findById(testId).ifPresentOrElse(city -> {
                city.setName("Köping");
                city.setPopulation(18605);

                try {
                    cityDao.update(city);
                    System.out.println("✅ City updated:");
                    System.out.println(cityDao.findById(testId).get());
                } catch (SQLException e) {
                    System.err.println("❌ Error updating city:");
                    e.printStackTrace();
                }

            }, () -> {
                System.out.println("❌ City with ID " + testId + " was not found.");
            });

        } catch (SQLException e) {
            System.err.println("❌ Something went wrong updating the city:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }*/

/*        // Testing delete()-method:
        int testId = 4080;

        try {
            cityDao.deleteById(testId);
            System.out.println("✅ City with ID " + testId + " has been deleted.");

        } catch (SQLException e) {
            System.err.println("❌ Something went wrong deleting the city:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }*/

    }

}
