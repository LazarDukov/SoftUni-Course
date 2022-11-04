

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class GetVillainsNames {
    private static final String GET_VILLAINS_NAMES = "SELECT v.name, COUNT(DISTINCT mv.minion_id) AS countMinions FROM villains AS v" +
            " JOIN minions_villains mv on v.id = mv.villain_id" +
            " GROUP BY mv.villain_id" +
            " HAVING countMinions > ?" +
            " ORDER BY countMinions";

    public static void main(String[] args) throws SQLException {
        Connection con = Utils.getSqlConnection();

        final PreparedStatement prep = con.prepareStatement(GET_VILLAINS_NAMES);
        prep.setInt(1, 15);
        final ResultSet resultSet = prep.executeQuery();
        while (resultSet.next()) {
            final String villainName = resultSet.getString("name");
            final int minionsCount = resultSet.getInt("countMinions");
            System.out.printf("%s %d", villainName, minionsCount);
        }
        con.close();
    }
}
