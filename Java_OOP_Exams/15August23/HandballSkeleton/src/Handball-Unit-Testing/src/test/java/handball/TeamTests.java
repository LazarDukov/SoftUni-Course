package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamTests {
    private Team team;
    private HandballPlayer handballPlayer1;

    @Before
    public void setUp() {
        team = new Team("NaGoshoOtbora", 2);
        handballPlayer1 = new HandballPlayer("Gosho");
        team.add(handballPlayer1);
    }

    @Test(expected = NullPointerException.class)
    public void createTeamWithEmptyName() {
        Team team1 = new Team(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTeamWithNegativeVac() {
        Team team1 = new Team("NaPeshoOtbora", -3);
    }

    @Test
    public void getPosition() {
        int actual = team.getPosition();
        Assert.assertEquals(2, actual);
    }

    @Test
    public void getCount() {
        int actual = team.getCount();
        Assert.assertEquals(1, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addInFullTeam() {
        HandballPlayer handballPlayer2 = new HandballPlayer("Pesho");
        HandballPlayer handballPlayer3 = new HandballPlayer("Izlishniq");

        team.add(handballPlayer2);
        team.add(handballPlayer3);
    }

    @Test
    public void removeExistPlayer() {
        team.remove("Gosho");
        int actual = team.getCount();
        Assert.assertEquals(0, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistingPlayer() {
        team.remove("Misho");
    }

    @Test
    public void playerForAnotherTeamTest() {
        HandballPlayer handballPlayer = team.playerForAnotherTeam("Gosho");
        Assert.assertEquals("Gosho", handballPlayer.getName());
        Assert.assertFalse(handballPlayer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonExistPlayerForAnotherTeamTest() {
        HandballPlayer handballPlayer = team.playerForAnotherTeam("Misho");
    }

    @Test
    public void getStatistics() {
        String expected = "The player Gosho is in the team NaGoshoOtbora.";
        String actual = team.getStatistics();
        Assert.assertEquals(expected, actual);
    }
}
