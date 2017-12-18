package xlist.dao;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Клас відповідає за завантаження бібіліотеки драйвера, що з'єднує джава і базу даних
 */
public class DataSource {

    Connection connection = null;
    /**
     * Назва драйвера, що буде зв'язаний із MySQL
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /**
     * Рядок підключення до нашої БД в MySQL. Нагадую, що в MySQL як правило є багато баз даних.
     * Наша база даних називається .
     */
    static final String DB_URL="jdbc:mysql://localhost/xlist?user=root&password=1111";


    /**
     * Завантажує драйвер java для зв'язку із БД
     */
    public DataSource()
    {
        try{
            //завантажує драйвер в програму. Після завантаження доступний клас DriverManager, що може дати
            //посилання на зв'язок із нашою БД
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * З'єднується через завантажений драйвер із БД. Об'єкт класу Connection посилає команди із нашої програми до БД
     * @return class Connection що має містить з'єднання із БД
     */
    public Connection createConnection()
    {
        Connection con = null;
        try
        {
            if( connection != null )
            {
                System.out.println("Cant create a New Connection");
            }
            else
            {
                //отримуємо зв'язом із нашою БД, нназва нашої бази є в змінній DB_URL
                con = DriverManager.getConnection(DB_URL);
            }
        }
        catch( Exception e )
        {
            System.out.println("Error Occured " + e.toString());
        }
        return con;
    }

}