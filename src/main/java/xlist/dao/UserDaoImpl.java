package xlist.dao;

import xlist.models.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Клас, що реалізує методи інтерфейсу UserDao
 */
public class UserDaoImpl implements UserDao {
    /**
     * Шукає користувача за email
     * @param email має бути із форми логіна
     * @return claas User or null
     */
    @Override
    public User findUserByEmail(String email) {
        //створює об'єкт для завантаження драйвера
        DataSource dataSource = new DataSource();
        //отримує зв'язок з БД
        try (Connection con = dataSource.createConnection();
             //створює об'єкт для виконання SQL запитів
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.email=\"" + email + "\";");) {
            if(rs.next()){
                //створюємо об'єкт класу User на основі даних отриманих із БД
               System.out.print(email);
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                return user;
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User creatUser(String email, String password, String name) {
        DataSource dataSource = new DataSource();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String data = dtf.format(localDate); //2016/11/16
        PreparedStatement stmt = null;

        try (Connection con = dataSource.createConnection()) {

            stmt = con.prepareStatement("INSERT INTO users(users.email,users.password,users.name," +
                    "users.date,users.role)" +
                    " VALUE ('" + email + "','" + password + "','" + name + "','"
                    + data + "'," + "2" + ");");
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
