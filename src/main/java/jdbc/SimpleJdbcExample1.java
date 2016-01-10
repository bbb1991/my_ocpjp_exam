package jdbc;

import java.sql.*;

/**
 * Created by bbb1991 on 1/8/16.
 */
public class SimpleJdbcExample1 {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "bbb1991", "")) {
            Statement statement = connection.prepareStatement("select surname, firstname from person");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                System.out.println(resultSet.findColumn("surname") + " " + resultSet.findColumn("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
