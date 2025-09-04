package se.lexicon;

import se.lexicon.dao.CityDaoImpl;
import se.lexicon.model.City;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Represents the entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        CityDaoImpl cityDao = new CityDaoImpl();

        // Testing the findById-method:
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
            System.err.println("❌ Something went wrong finding the person:");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }

    }
}
