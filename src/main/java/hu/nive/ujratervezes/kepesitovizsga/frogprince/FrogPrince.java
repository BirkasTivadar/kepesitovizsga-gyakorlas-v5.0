package hu.nive.ujratervezes.kepesitovizsga.frogprince;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FrogPrince {

    public Set<PlayerOfTale> getPlayersOfTale(DataSource dataSource, Tale tale) {
        String sqlOrder = String.format("SELECT player_name, age, tale FROM tales WHERE tale='%s';", tale.name());
        Set<PlayerOfTale> result = new HashSet<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlOrder);
        ) {
            processResultSet(result, ps);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private void processResultSet(Set<PlayerOfTale> result, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("player_name");
                int age = rs.getInt("age");
                String title = rs.getString("tale");
                result.add(new PlayerOfTale(name, age, Tale.valueOf(title)));
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
    }
}
