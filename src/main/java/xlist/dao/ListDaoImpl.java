package xlist.dao;



import xlist.models.AllList;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


        @Override
       public AllList createList(String name, String comment, Long user_id)
        {
            DataSource dataSource = new DataSource();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            String data = dtf.format(localDate); //2016/11/16
            PreparedStatement stmt = null;
            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("INSERT INTO list(list.name,list.comment,list.user_id," +
                        "list.date)" +
                        " VALUE ('" + name + "','" + comment + "','" + user_id + "','"
                        + data + "');");
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public AllList deleteList(Long list_id)
        {
            DataSource dataSource = new DataSource();
            PreparedStatement stmt = null;

            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("DELETE FROM list WHERE  list.id=\"" + list_id + "\";");
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }


    }

