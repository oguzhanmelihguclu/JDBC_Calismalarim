import java.sql.*;

public class JDBC {


    /*
type             jdbc:mysql
host/ip          195.35.59.18
port             3306
database_name      u201212290_qaloantec


username          u201212290_qaloanuser
password          HPo?+7r$
     */

    // Ham haldeki bu bilgiler ile JDBC baglantisi kurmak zordur.
    // O yuzden bu datalari analsilir bir URL haline getirmek zorundayiz.

    /*
    URL: jdbc:mysql://195.35.59.18/u201212290_qaloantec
    USERNAME: u201212290_qaloanuser
    PASSWORD: HPo?+7r$
     */


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1.ADIM   jdbc sürücüsü yükle!
        Class.forName("com.mysql.cj.jdbc.Driver");
        // bilgisayarımda mysql yüklü oldugu icin bu adım olmasa da calısırdı.

        //2.ADIM VERITABANI BAGLANTISI KURMA ( CONNECTİON)

        String URL = "jdbc:mysql://195.35.59.18/u201212290_qaloantec";
        String USERNAME="u201212290_qaloanuser";
        String PASSWORD ="HPo?+7r$";

       Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); // database baglantısı gerceklestirildi

        // 3.ADIM SQL SORGULARI OLUSTURMA ( QUERRY HAZIRLAMA)

        String QUERY = "SELECT * FROM users";

        // 4.ADIM SQL SORGULARI CALISTIRMA

       Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       // insensitive seçtiğimiz için database uptadelerini göremeyiz. güncel database ile anlık calismak istiyorsak sensitive seçmelyiz
       ResultSet resultSet= statement.executeQuery(QUERY);

       // 5.ADIM SONUCLARI ISLEME

        // Database'den gelen sonuclar resultset icerisinde
        // resultSet icerisinde "İterator" ile islem yapabilirim.

        resultSet.next();
        System.out.println(resultSet.getString("firstname"));   // Elf

        resultSet.next();
        System.out.println(resultSet.getString(4));  // tester

        resultSet.next();
        resultSet.next();
        System.out.println(resultSet.getInt(8));  // 85462


        resultSet.absolute(15);
        System.out.println(resultSet.getString(6));  // bidasa9700@xcmexico.com
        // absolute ile istediğimiz satira atlayabiliyoruz.


        resultSet.previous();
        System.out.println(resultSet.getString(2));  // Loan
        // previous ile next'in tam tersi olacak sekilde 1 geriye gider database tablosunda

        resultSet.first();
        System.out.println(resultSet.getString(3));   // Ferid
        // first ise database tablosunda ilk row'a gider
        System.out.println(resultSet.getString(4));  // acenk

        resultSet.beforeFirst();  // database'deki tabloda 1.satırın da üstüne hicliğe götürür. memory'i 0lar.
        System.out.println(resultSet.isBeforeFirst());  // true

        resultSet.afterLast();   // database'dekki tabloda en son satırın arkasına atar.

        int columnIndex= resultSet.findColumn("ref_by");

        System.out.println(columnIndex);   // 9


    }



}
