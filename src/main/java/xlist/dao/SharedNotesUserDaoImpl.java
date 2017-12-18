package xlist.dao;
import xlist.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SharedNotesUserDaoImpl implements SharedNotesUserDao {
    /**
     * Повернути користувачів що розшарюють заміку
     * @param id замітки
     * @return колекція із користувачів, що призначені до замітки яка має значення id
     */
    @Override
    public List<User> getUsersByNoteId(long id) {
        //створює об'єкт для завантаження драйвера
        DataSource dataSource = new DataSource();
        List<User> lstUsers = new ArrayList<>();
        //отримує зв'язок з БД
        try (Connection con = dataSource.createConnection();
             //створює об'єкт для виконання SQL запитів
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.id IN (SELECT user_id FROM sharednotesusers WHERE sharednotesusers.note_id=\"" + id + "\");");) {

            while(rs.next()){
                //створюємо об'єкт класу User на основі даних отриманих із БД
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                lstUsers.add(user);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return lstUsers;
    }
}
