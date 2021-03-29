package ua.com.alvel.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface AuthorDao {
    List<User> findAllAuthors(Connection connection) {
        String sqlSelectAll = "SELECT * FROM  user";
        List<User> users = new ArrayList<>();
        try { Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectAll);
            while (resultSet.next()) {
                if (resultSet.getBoolean(7))// is boolean is author
                    User user = new User(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getBoolean(5),
                            resultSet.getBoolean(6),
                            resultSet.getString(7),
                            resultSet.getInt(8),
                            resultSet.getInt(9));
                users.add(user);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return users;
    }

    List<User> findTopAuthors(int limit){
        String sqlSelectAll = "SELECT * FROM  user ORDER BY followerId ASC";

    }
}
