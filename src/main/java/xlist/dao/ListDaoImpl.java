package xlist.dao;



import xlist.models.AllList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

   public class ListDaoImpl implements ListDao{

        /**
         * Виводить список заміток, що створив користувач
         * @param id User
         * @return List class AllList
         */
        public List<AllList> getListByUserId(long id) {
            //створює об'єкт для завантаження драйвера
            DataSource dataSource = new DataSource();
            //Контейнер для заміток
            List<AllList> lstList = new ArrayList<>();
            //отримує зв'язок з БД
            try (Connection con = dataSource.createConnection();
                 //створює об'єкт для виконання SQL запитів
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM list WHERE list.user_id=\"" + id + "\";");) {
                while(rs.next()){
                    //створюємо об'єкт класу User на основі даних отриманих із БД
                    AllList list = new AllList(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("comment"),
                            rs.getLong("user_id"),
                            rs.getString("date")
                    );
                    lstList.add(list);
                }

            }  catch (SQLException e) {
                e.printStackTrace();
            }
            return lstList;
        }

        @Override
        public AllList getListsById(long id) {
            //створює об'єкт для завантаження драйвера
            DataSource dataSource = new DataSource();
            //Контейнер для заміток
            List<AllList> lstList = new ArrayList<>();
            //отримує зв'язок з БД
            try (Connection con = dataSource.createConnection();
                 //створює об'єкт для виконання SQL запитів
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM list WHERE list.id=\"" + id + "\";");) {
                if(rs.next()){
                    //створюємо об'єкт класу User на основі даних отриманих із БД
                    AllList list = new AllList(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("comment"),
                            rs.getLong("user_id"),
                            rs.getString("date")
                    );
                    return list;
                }

            }  catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

