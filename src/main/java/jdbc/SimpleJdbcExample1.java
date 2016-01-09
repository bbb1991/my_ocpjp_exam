package jdbc;

import java.sql.*;

/**
 * Created by bbb1991 on 1/8/16.
 */
public class SimpleJdbcExample1 {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres")) {
            Statement statement = connection.prepareStatement("Select name from students");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                System.out.println(resultSet.findColumn("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
