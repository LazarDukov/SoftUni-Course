import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {

    private final static String GET_MINION_NAMES_AND_AGE_BY_VILLAIN_ID = "select m.name, m.age from minions m" +
            " join minions_villains mv on mv.minion_id = m.id" +
            " join villains v on v.id = mv.villain_id" +
            " where v.id = ?";
    private final static String GET_VILLAIN_NAME_BY_ID = "select v.name from villains as v where v.id = ?;";
    private final static String NO_VILLAIN = "No villain with ID %d exists in the database.";
    private final static String GET_LABEL_NAME = "name";
    private final static String GET_LABEL_AGE = "age";
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = Utils.getSqlConnection();

        final int villainId = Integer.parseInt(scanner.nextLine());

        final PreparedStatement statementForVillain = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        statementForVillain.setInt(1, villainId);
        final ResultSet resultSetVillain = statementForVillain.executeQuery();
        if (!resultSetVillain.next()) {
            System.out.printf(NO_VILLAIN, villainId);
            connection.close();
            return;
        }

        final String villainName = resultSetVillain.getString(GET_LABEL_NAME);
        System.out.printf("Villain: %s%n", villainName);
        final PreparedStatement statementForMinion = connection.prepareStatement(GET_MINION_NAMES_AND_AGE_BY_VILLAIN_ID);
        statementForMinion.setInt(1, villainId);
        final ResultSet resultSetMinion = statementForMinion.executeQuery();
        for (int i = 1; resultSetMinion.next(); i++) {
            final String minionName = resultSetMinion.getString(GET_LABEL_NAME);
            final String minionAge = resultSetMinion.getString(GET_LABEL_AGE);
            System.out.printf("%d. %s %s%n", i, minionName, minionAge);
        }


        connection.close();
    }
}
