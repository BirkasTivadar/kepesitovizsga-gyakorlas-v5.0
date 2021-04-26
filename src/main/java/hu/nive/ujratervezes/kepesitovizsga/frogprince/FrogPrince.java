package hu.nive.ujratervezes.kepesitovizsga.frogprince;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FrogPrince {

    public Set<PlayerOfTale> getPlayersOfTale(DataSource dataSource, Tale tale) {

        Set<PlayerOfTale> result = new HashSet<>();

        String sqlOrder = String.format("SELECT player_name, age, tale FROM tales WHERE tale='%s';", tale.name());

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlOrder);
        ) {

            while (rs.next()) {
                String name = rs.getString("player_name");
                int age = rs.getInt("age");
                String title = rs.getString("tale");
                result.add(new PlayerOfTale(name, age, Tale.valueOf(title)));
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }
}
