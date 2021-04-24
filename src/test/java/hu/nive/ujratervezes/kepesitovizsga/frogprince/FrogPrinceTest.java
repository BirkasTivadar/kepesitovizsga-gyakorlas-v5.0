package hu.nive.ujratervezes.kepesitovizsga.frogprince;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sun.source.doctree.SeeTree;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FrogPrinceTest {

    MysqlDataSource dataSource = new MysqlDataSource();

    @BeforeEach
    public void setUp() {
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

    }

    @Test
    public void getPlayersOfTale() {
        Set<PlayerOfTale> playersOfTale = new FrogPrince().getPlayersOfTale(dataSource, Tale.FROGPRINCE);

        assertTrue(playersOfTale.contains(new PlayerOfTale("Békakirályfi", 27, Tale.FROGPRINCE)));
        assertTrue(playersOfTale.contains(new PlayerOfTale("Kicsi királykisasszony", 21, Tale.FROGPRINCE)));
        assertFalse(playersOfTale.contains(new PlayerOfTale("Hófehérke", 23, Tale.SNOWWHITE)));
        assertFalse(playersOfTale.contains(new PlayerOfTale("Piroska", 9, Tale.LITTLEREDRIDINGHOOD)));
    }

}