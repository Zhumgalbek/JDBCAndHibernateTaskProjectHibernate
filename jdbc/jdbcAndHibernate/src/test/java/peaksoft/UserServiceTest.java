package peaksoft;

import org.junit.Assert;
import org.junit.Test;
import peaksoft.model.User;
import peaksoft.service.UserHibernateServiceImpl;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceTest {

    private final UserService userService = new UserServiceImpl();
    private final UserService userService1 = new UserHibernateServiceImpl();

    private final String testName = "Kanat";
    private final String testLastName = "Subanov";
    private final byte testAge = 23;

    public UserServiceTest() throws SQLException {
    }

    @Test
    public void dropUsersTable() {
        try {
            userService1.dropUsersTable();
            userService1.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
        }
    }

    @Test
    public void createUsersTable() {
        try {
            userService1.dropUsersTable();
            userService1.createUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
        try {
            userService1.dropUsersTable();
            userService1.createUsersTable();
            userService1.saveUser(testName, testLastName, testAge);

            User user = userService1.getAllUsers().get(0);
            System.out.println(userService1.getAllUsers().size());
            if (!testName.equals(user.getName())
                    || !testLastName.equals(user.getLastName())
                    || testAge != user.getAge()
            ) {
                Assert.fail("User был некорректно добавлен в базу данных");
            }

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }

    @Test
    public void removeUserById() {
        try {
            userService1.dropUsersTable();
            userService1.createUsersTable();
            userService1.saveUser(testName, testLastName, testAge);
            userService1.removeUserById(1L);
        } catch (Exception e) {
            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
        }
    }

    @Test
    public void getAllUsers() {
        try {
            userService1.dropUsersTable();
            userService1.createUsersTable();
            userService1.saveUser(testName, testLastName, testAge);
            List<User> userList = userService1.getAllUsers();

            if (userList.size() != 1) {
                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
        } catch (Exception e) {
            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
            userService1.dropUsersTable();
            userService1.createUsersTable();
            userService1.saveUser(testName, testLastName, testAge);
            userService1.cleanUsersTable();

            if (userService1.getAllUsers().size() != 0) {
                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
            }
        } catch (Exception e) {
            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
        }
    }
}
