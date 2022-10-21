package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public final Connection connection;

    public UserDaoJdbcImpl() throws SQLException {
        connection = new Util().getConnection();
    }

    public void createUsersTable() {
        String query = """
                create table users(
                id serial primary key,
                name varchar(50),
                lastName varchar(50),
                age int )""";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void dropUsersTable() {
        String query = "drop table if exists users";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "insert into users (name, lastName, age) values (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeUserById(long id) {
        String SQL = "delete from   where id = ? ";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User> getAllUsers() throws SQLException {
        String SQL = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                list.add(new User(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getByte("age")));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Table not found!!!");
            throw new SQLException();
        }
    }

    public void cleanUsersTable() {
        String SQL = "truncate table users ";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            System.out.println("Table not found !!!");
        }
    }


    public void findByUserById(long id) throws SQLException {
        String SQL = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                list.add(new User(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getByte("age")));
            }
        } catch (SQLException ex) {
            System.out.println("Table not found!!!");
        }
        for (User user : list) {
            if (user.getId() == id) {
                System.out.println(user);
            }
        }
    }

    public void addUser(long id, String name, String lastName, byte age) throws SQLException {
        String SQL = "update users set name = ?, lastName = ?, age = ? where id =?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setLong(4,id);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.getMessage();
        }

    }
}







