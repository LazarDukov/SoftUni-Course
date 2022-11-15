import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeNamesToUpperCase {
    private static final String AFFECTED_TOWNS = "%d town names were affected.%n";
    private static final String REPLACE_CITIES_WITH_UPPER_CASE = "UPDATE towns AS t" +
            " SET name = upper(name)" +
            " WHERE t.country = ?";
    private static final String SELECTED_TOWNS = "SELECT t.name FROM towns AS t WHERE country = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        String country = new Scanner(System.in).nextLine();
        final PreparedStatement getCities = connection.prepareStatement(REPLACE_CITIES_WITH_UPPER_CASE);
        getCities.setString(1, country);
        final int citiesCounter = getCities.executeUpdate();
        if (citiesCounter == 0) {
            System.out.println("No town names were affected.");
            return;
        }
        System.out.printf(AFFECTED_TOWNS, citiesCounter);
        List<String> citiesResult = new ArrayList<>();
        final PreparedStatement selectTowns = connection.prepareStatement(SELECTED_TOWNS);
        selectTowns.setString(1, country);
        final ResultSet selectedTowns = selectTowns.executeQuery();
        while (selectedTowns.next()) {

            citiesResult.add(selectedTowns.getString("name"));

        }
        System.out.println(citiesResult);
    }
}
