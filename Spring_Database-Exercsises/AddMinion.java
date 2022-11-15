import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {
    private static final String GET_TOWN_BY_NAME = "select t.id from towns as t where t.name = ?";
    private static final String INSERT_TOWN = "insert into towns(name) values(?)";
    private static final String COLUMN_LABEL_ID = "id";
    private static final String INSERTED_TOWN = "Town %s was added to the database.%n";

    private static final String GET_VILLAIN_BY_NAME = "select v.id from villains as v where v.name = ?";

    private static final String INSERT_VILLAIN = "insert into villains(name, evilness_factor) values(?,?)";

    private static final String INSERTED_VILLAIN = "Villain %s was added to the database.%n";

    private static final String INSERT_MINION = "insert into minions(name, age, town_id) value(?, ?, ?)";
    private static final String LAST_MINION = "select m.id from minions as m order by m.id desc limit 1";

    private static final String INSERT_INTO_MINION_VILLAIN = "insert into minions_villains(minion_id, villain_id) value(?, ?)";

    private static final String RESULT = "Successfully added %s to be minion of %s.";
    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSqlConnection();

        Scanner scanner = new Scanner(System.in);

        final String[] minionData = scanner.nextLine().split(" ");
        final String minionName = minionData[1];
        final int minionAge = Integer.parseInt(minionData[2]);
        final String minionTown = minionData[3];

        final String[] villainData = scanner.nextLine().split(" ");
        final String villainName = villainData[1];

        final int townId = checkForTownDoesItExists(connection,
                minionTown,
                GET_TOWN_BY_NAME,
                INSERT_TOWN,
                INSERTED_TOWN,
                COLUMN_LABEL_ID);
        final int villainId = checkForVillainDoesItExists(connection,
                villainName,
                GET_VILLAIN_BY_NAME,
                INSERT_VILLAIN,
                INSERTED_VILLAIN,
                COLUMN_LABEL_ID);

        final PreparedStatement insertIntoMinionsQuery = connection.prepareStatement(INSERT_MINION);
        insertIntoMinionsQuery.setString(1,minionName);
        insertIntoMinionsQuery.setInt(2,minionAge);
        insertIntoMinionsQuery.setInt(3,townId);
        insertIntoMinionsQuery.executeUpdate();

        final PreparedStatement getLastMinion = connection.prepareStatement(LAST_MINION);
        final ResultSet foundLastMinion = getLastMinion.executeQuery();
            foundLastMinion.next();
        final int lastMinionId = foundLastMinion.getInt(COLUMN_LABEL_ID);

        final PreparedStatement insertIntoMinionVillain = connection.prepareStatement(INSERT_INTO_MINION_VILLAIN);
        insertIntoMinionVillain.setInt(1, lastMinionId);
        insertIntoMinionVillain.setInt(2, villainId);

        insertIntoMinionVillain.executeUpdate();

        System.out.printf(RESULT, minionName, villainName);
        connection.close();



    }

    private static int checkForTownDoesItExists(Connection connection, String minionTown, String GET_TOWN_BY_NAME, String INSERT_TOWN, String INSERTED_TOWN, String COLUMN_LABEL_ID) throws SQLException {
        final String townName = minionTown;

        final PreparedStatement getTownByName = connection.prepareStatement(GET_TOWN_BY_NAME);
        getTownByName.setString(1, townName);

        final ResultSet townResult = getTownByName.executeQuery();

        if (!townResult.next()) {
            final PreparedStatement insertTown = connection.prepareStatement(INSERT_TOWN);
            insertTown.setString(1, townName);
            insertTown.executeUpdate();
            final ResultSet insertedTown = getTownByName.executeQuery();
            insertedTown.next();

            System.out.printf(INSERTED_TOWN, townName);
            return insertedTown.getInt(COLUMN_LABEL_ID);
        }
        return townResult.getInt(COLUMN_LABEL_ID);
    }

    private static int checkForVillainDoesItExists(Connection connection, String villainName, String GET_VILLAIN_BY_NAME, String INSERT_VILLAIN, String INSERTED_VILLAIN, String COLUMN_LABEL_ID) throws SQLException {
        final String evilness = "evil";
        final PreparedStatement villainSelectQuery = connection.prepareStatement(GET_VILLAIN_BY_NAME);
        villainSelectQuery.setString(1, villainName);

        final ResultSet villainResult = villainSelectQuery.executeQuery();
        if (!villainResult.next()) {
            final PreparedStatement insertVillain = connection.prepareStatement(INSERT_VILLAIN);
            insertVillain.setString(1,villainName);
            insertVillain.setString(2,evilness);
            insertVillain.executeUpdate();
            final ResultSet insertedVillain = villainSelectQuery.executeQuery();
            insertedVillain.next();
            System.out.printf(INSERTED_VILLAIN, villainName);
            return insertedVillain.getInt(COLUMN_LABEL_ID);

        }

        return villainResult.getInt(COLUMN_LABEL_ID);
    }

}
