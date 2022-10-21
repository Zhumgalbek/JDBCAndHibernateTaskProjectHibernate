package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {

//        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
//        userDaoJdbc.createUsersTable();
//        userDaoJdbc.dropUsersTable();
//        userDaoJdbc.saveUser("argen ","gena",(byte)8 );
//        userDaoJdbc.findByUserById(3);
//        userDaoJdbc.addUser(8,"juma0","aisal", (byte) 19);

//        userDaoJdbc.saveUser("syimyk ","mena",(byte)8 );
//        userDaoJdbc.saveUser("Kanat ","Subanov",(byte)13 );
//        userDaoJdbc.removeUserById(1);
//        for (User u: userDaoJdbc.getAllUsers()) {
//            System.out.println(u);
//        }
//        userDaoJdbc.cleanUsersTable();
//        userDaoHibernate.createUsersTable();
      // userDaoHibernate.createUsersTable();
        userDaoHibernate.dropUsersTable();
//        userDaoHibernate.saveUser("Kanat","Subanov", (byte) 23);
//        userDaoHibernate.saveUser("Zhnarbek","Allanov", (byte) 12);
//        userDaoHibernate.saveUser("Zanarbek","Allanov", (byte) 12);
//        userDaoHibernate.saveUser("hanarbek","Allanov", (byte) 12);
 // userDaoHibernate.dropUsersTable();
//        System.out.println(userDaoHibernate.getAllUsers());
      //  userDaoHibernate.cleanUsersTable();
//        userDaoHibernate.removeUserById(1);
     //   userDaoHibernate.createUsersTable();
     //   System.out.println(userDaoHibernate.getAllUsers());
//userDaoHibernate.cleanUsersTable();

       // userDaoHibernate.removeUserById(9);

    }
}
