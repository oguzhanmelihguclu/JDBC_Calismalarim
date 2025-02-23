package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import utilities.ConfigReader;
import utilities.JDBCReusableMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class stepDefinitions {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    PreparedStatement preparedStatement;
    int etkilenenSatirSayisi;
    String QUERY;
    QueryManage queryManage =new QueryManage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() throws SQLException {

    connection = DriverManager.getConnection(ConfigReader.getProperty("URL"),
                                    ConfigReader.getProperty("USERNAME"),
                                    ConfigReader.getProperty("PASSWORD"));

        // JDBCReusableMethods.createConnection();

    }
    @Given("SQL Query'si hazirla ve calistir.")
    public void sql_query_si_hazirla_ve_calistir() throws SQLException {

        String QUERY = "SELECT DISTINCT user_id FROM deposits WHERE amount BETWEEN 100 AND 500;";
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(QUERY);

        // resultSet = JDBCReusableMethods.executeQuery(QUERY);


    }
    @Given("Sonucları dogrula.")
    public void sonucları_dogrula() throws SQLException {

      /*
		    1
			9
			10
			12
			64
		*/
        List<Integer> expectedResult = new ArrayList<>();

        expectedResult.add(1);
        expectedResult.add(9);
        expectedResult.add(10);
        expectedResult.add(12); //12
        expectedResult.add(64);

        List<Integer> actualResult = new ArrayList<>();

        while(resultSet.next()){
            actualResult.add(resultSet.getInt(1));

        }

        assertEqualsNoOrder(actualResult,expectedResult);


    }
    @Given("Database baglantisini sonlandir.")
    public void database_baglantisini_sonlandir() {

        	/*
		resultSet.close();
		statement.close();
		connection.close();
       */

        JDBCReusableMethods.closeConnection();

    }

    // ----------------------  croon_schedules query --------------------------------


    @Given("\\(cron_schedules) SQL query'si  calistirilir")
    public void cron_schedules_sql_query_si_calistirilir() {

        QUERY = queryManage.getCroneSchedulesQuery();
        resultSet = JDBCReusableMethods.executeQuery(QUERY);

    }
    @Given("\\(cron_schedules) sonuclari  dogrulanir.")
    public void cron_schedules_sonuclari_dogrulanir() throws SQLException {

        List<String> expectedResultList = new ArrayList<>();
        expectedResultList.add("5 Minutes");
        expectedResultList.add("10 Minutes");

        List<String> actualResultList = new ArrayList<>();
        while(resultSet.next()){
            actualResultList.add(resultSet.getString(1));
        }

        assertEqualsNoOrder(actualResultList, expectedResultList);

    }


    // ************** UPDATE **********************

    @Given("Database ile baglanti kurulur.")
    public void database_ile_baglanti_kurulur() {

        JDBCReusableMethods.createConnection();

    }
    @Given("\\(users) Update sorgusu hazirlanir ve calistirilir.")
    public void users_update_sorgusu_hazirlanir_ve_calistirilir() throws SQLException {

        QUERY = queryManage.getUsersMobileUpdateQuery();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);

        // UPDATE users SET mobile = ? WHERE username LIKE ?;

        preparedStatement.setString(1, "555555");
        preparedStatement.setString(2, "%e_");
        etkilenenSatirSayisi =  preparedStatement.executeUpdate();


    }
    @Given("\\(users) sorgu sonuclari dogrulanir.")
    public void users_sorgu_sonuclari_dogrulanir() {

        int expectedResult = 5;
        System.out.println(etkilenenSatirSayisi);
        assertEquals( etkilenenSatirSayisi, expectedResult);

    }
    @Given("database baglantisi sonlandirilir.")
    public void database_baglantisi_sonlandirilir() {

        JDBCReusableMethods.closeConnection();

    }

// ********** INSERT **********

    @Given("\\(device_tokens) Insert sorgusu hazirlanir ve calistirilir.")
    public void device_tokens_ınsert_sorgusu_hazirlanir_ve_calistirilir() throws SQLException {

        QUERY = queryManage.getDeviceTokensInsertQuery();
        preparedStatement =JDBCReusableMethods.getConnection().prepareStatement(QUERY);

        // INSERT INTO device_tokens (id, user_id, is_app, token)VALUES(?,?,?,?);
        preparedStatement.setInt(1, 7);
        preparedStatement.setInt(2, 3);
        preparedStatement.setInt(3, 2);
        preparedStatement.setString(4,"NewToken");

        etkilenenSatirSayisi = preparedStatement.executeUpdate();

    }
    @Given("\\(device_tokens) sorgu sonuclari dogrulanir.")
    public void device_tokens_sorgu_sonuclari_dogrulanir() {

        int expectedResult = 1;
        System.out.println(etkilenenSatirSayisi);
        assertEquals(etkilenenSatirSayisi, expectedResult);

    }



    @Given("Database ile baglanti kurulur. \\(Oguz)")
    public void database_ile_baglanti_kurulur_oguz() {

        JDBCReusableMethods.createConnection();


    }
    @Given("\\(DB_US02) Sql querysi hazirlanir ve calistirilir.")
    public void db_us02_sql_querysi_hazirlanir_ve_calistirilir() {

        QUERY = queryManage.getAdminsTokenSelectQuery();
        resultSet=JDBCReusableMethods.executeQuery(QUERY);

    }
    @Given("\\(DB_US02) Sonuclar dogrulanir.")
    public void db_us02_sonuclar_dogrulanir() throws SQLException {

        List <String> expectedResultList =new ArrayList<>();
        expectedResultList.add("AHH6hbjYvWwdmdMXMII85Jx3aL8iHUFFfAACwPOkbFEWaFwn0tnfXyWJEduZ");

        JDBCReusableMethods.ListeyiYazdirmaMethodu(expectedResultList);

        List <String> actualResultList = new ArrayList<>();
        while (resultSet.next()) {
            actualResultList.add(resultSet.getString(1));
        }

        assertEqualsNoOrder(actualResultList,expectedResultList);

    }
    @Given("Database baglantisini sonlandir. \\(Oguz)")
    public void database_baglantisini_sonlandir_oguz() {

        JDBCReusableMethods.closeConnection();

    }

    @Given("\\(DB_US04) SQL querysi hazirlanir ve calistirilir.")
    public void db_us04_sql_querysi_hazirlanir_ve_calistirilir() {

        QUERY = queryManage.getDepositsChargeSelectQuery();
        resultSet= JDBCReusableMethods.executeQuery(QUERY);


    }
    @Given("\\(DB_US04) sonuclar dogrulanir")
    public void db_us04_sonuclar_dogrulanir() throws SQLException {

        List<Integer> expectedResultList = new ArrayList<>();
        expectedResultList.add(102);
        JDBCReusableMethods.ListeyiYazdirmaMethodu(expectedResultList);


        List<Integer> actualResultList = new ArrayList<>();
        while (resultSet.next()) {
            actualResultList.add(resultSet.getInt(1));
        }
        JDBCReusableMethods.ListeyiYazdirmaMethodu(actualResultList);

        assertEqualsNoOrder(actualResultList,expectedResultList);

    }

    @Given("\\(DB_US07) SQL queryleri hazirlanir ve calistirilir")
    public void db_us07_sql_queryleri_hazirlanir_ve_calistirilir() {

        QUERY = queryManage.getSubjectTicketSelectQuery();
        resultSet = JDBCReusableMethods.executeQuery(QUERY);

    }
    @Given("\\(DB_US07) sonuclar dogrulanir")
    public void db_us07_sonuclar_dogrulanir() throws SQLException {

        /*
        FREE fast ranks for loantechexper.com
        Increase sales for your local business
        Whitehat SEO for loantechexper.com
        Collaboration request
        Join the SellAccs.net Team: Partner Search
        Increase rankings with a SEO friendly web design
        Hi loantechexper.com Admin.
        Whitehat SEO for loantechexper.com
        Increase rankings with a SEO friendly web design
        Are you looking to bring in more customers for your business?
        Add loantechexper.com to Google Search Index!
        Get 10,000 Targeted Visits for Only $10!
        Hello loantechexper.com Webmaster!
        Container House at Factory Price
        Dear loantechexper.com Webmaster!
        Dear loantechexper.com Administrator!
        Alisveris hatasi
        */

        List<String> expectedResultList = new ArrayList<>();

        expectedResultList.add("FREE fast ranks for loantechexper.com");
        expectedResultList.add("Increase sales for your local business");
        expectedResultList.add("Whitehat SEO for loantechexper.com");
        expectedResultList.add("Collaboration request");
        expectedResultList.add("Join the SellAccs.net Team: Partner Search");
        expectedResultList.add("Increase rankings with a SEO friendly web design");
        expectedResultList.add("Hi loantechexper.com Admin.");
        expectedResultList.add("Whitehat SEO for loantechexper.com");
        expectedResultList.add("Increase rankings with a SEO friendly web design");
        expectedResultList.add("Are you looking to bring in more customers for your business?");
        expectedResultList.add("Add loantechexper.com to Google Search Index!");
        expectedResultList.add("Get 10,000 Targeted Visits for Only $10!");
        expectedResultList.add("Hello loantechexper.com Webmaster!");
        expectedResultList.add("Container House at Factory Price");
        expectedResultList.add("Dear loantechexper.com Webmaster!");
        expectedResultList.add("Dear loantechexper.com Administrator!");
        expectedResultList.add("Alisveris hatasi");

        JDBCReusableMethods.ListeyiYazdirmaMethodu(expectedResultList);

        List<String> actualResultList = new ArrayList<>();
        while (resultSet.next()) {
            actualResultList.add(resultSet.getString(1));
        }

        JDBCReusableMethods.ListeyiYazdirmaMethodu(actualResultList);

        assertEqualsNoOrder(actualResultList,expectedResultList);


    }

    @Given("\\(DB_US24) SQl query'leri hazirlanir ve calistirilir.")
    public void db_us22_s_ql_query_leri_hazirlanir_ve_calistirilir() {

        QUERY = queryManage.getAdminNotificationsUpdateQuery();
        etkilenenSatirSayisi = JDBCReusableMethods.updateQuery(QUERY);

        System.out.println("actualResult = " + etkilenenSatirSayisi);

    }
    @Given("\\(DB_US24) dogrulama yapilir.")
    public void db_us22_dogrulama_yapilir() {

        int expectedResult = 1;

        assertEquals(etkilenenSatirSayisi,expectedResult);

    }




    @Given("\\(DB_US18) SQL Query hazirlanir ve calistirilir")
    public void db_us18_sql_query_hazirlanir_ve_calistirilir() throws SQLException {

        QUERY = queryManage.getCategoriesNameDescprictionIntoQuery();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);

        preparedStatement.setString(1,"Oğuzhan Melih Güçlü");
        preparedStatement.setString(2,"Practise yaparken oluşturdum");

        etkilenenSatirSayisi=preparedStatement.executeUpdate();


    }
    @Given("\\(DB_US18) dogrulanmasi yapilir.")
    public void db_us18_dogrulanmasi_yapilir() {

        int expectedSatirSayisi=1;
        assertEquals(etkilenenSatirSayisi,expectedSatirSayisi);

    }

    @Given("\\(DB_US13) SQL Query hazirlanir ve calistirilir.")
    public void db_us13_sql_query_hazirlanir_ve_calistirilir() throws SQLException {

        QUERY = queryManage.getCron_job_logsIntoQuery();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(QUERY);

        preparedStatement.setInt(1,1);
        preparedStatement.setInt(2,1);
        preparedStatement.setString(3,"2019-01-01");
        preparedStatement.setString(4,"2024-06-22");

        etkilenenSatirSayisi= preparedStatement.executeUpdate();


    }
    @Given("\\(DB_US13) Dogrulanmasi yapilir.")
    public void db_us13_dogrulanmasi_yapilir() {

        int expectedSatirSayisi=1;

        assertEquals(etkilenenSatirSayisi,expectedSatirSayisi);


    }

    @Given("\\(DB_US05) SQL Query hazirlanir ve calistilir.")
    public void db_us05_sql_query_hazirlanir_ve_calistilir() throws SQLException {


        QUERY = queryManage.getAdminPasswordResetIntoQuery();

        // Birinci veri kümesi için
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);
        preparedStatement.setString(1, "oguzhanmguclu@gmail.com"); // email
        preparedStatement.setString(2, "1995"); // token
        preparedStatement.setInt(3, 1); // status
        preparedStatement.setDate(4, java.sql.Date.valueOf("2025-02-23")); // created_at (tarih formatı)
        etkilenenSatirSayisi = preparedStatement.executeUpdate();



        // İkinci veri kümesi için
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);
        preparedStatement.setString(1, "oguzhanmelihguclu@hotmail.com"); // email
        preparedStatement.setString(2, "1995"); // token
        preparedStatement.setInt(3, 1); // status
        preparedStatement.setDate(4, java.sql.Date.valueOf("2025-02-23")); // created_at (tarih formatı)
        etkilenenSatirSayisi += preparedStatement.executeUpdate(); // İkinci satırı ekliyoruz

    }
    @Given("\\(DB_US05) dogrulanir.")
    public void db_us05_dogrulanir() {

        int expectedSatirSayisi=2;

        assertEquals(etkilenenSatirSayisi,expectedSatirSayisi);

    }

    @Given("\\(DB_US08) SQL Query hazirlanir ve calistirilir.")
    public void db_us08_sql_query_hazirlanir_ve_calistirilir() throws SQLException {

        QUERY = queryManage.getUsersFirstnameLastnameQuery();
        resultSet=JDBCReusableMethods.executeQuery(QUERY);

    }
    @Given("\\(DB_US08) dogrulanir.")
    public void db_us08_dogrulanir() throws SQLException {
        List<String> expectedResultList=new ArrayList<>();
        expectedResultList.add("EZO");
        expectedResultList.add("clementine");

        JDBCReusableMethods.ListeyiYazdirmaMethodu(expectedResultList);

        List<String> actualResultList=new ArrayList<>();
        while (resultSet.next()) {

            actualResultList.add(resultSet.getString(1));
            actualResultList.add(resultSet.getString(2));
        }

        JDBCReusableMethods.ListeyiYazdirmaMethodu(actualResultList);

        assertEqualsNoOrder(actualResultList,expectedResultList);
    }



    @Given("\\(DB_US11) SQL Query sorgulari hazirlanir ve calistirilir.")
    public void db_us11_sql_query_sorgulari_hazirlanir_ve_calistirilir() {

        QUERY = queryManage.getAdminNotificationsQuery();
        resultSet=JDBCReusableMethods.executeQuery(QUERY);

    }
    @Given("\\(DB_US11) dogrulanir.")
    public void db_us11_dogrulanir() throws SQLException {

        List<Integer> expectedResultList =new ArrayList<>();
        expectedResultList.add(10);

        JDBCReusableMethods.ListeyiYazdirmaMethodu(expectedResultList);

        List<Integer> actualResultList =new ArrayList<>();
        while (resultSet.next()) {

            actualResultList.add(resultSet.getInt(1));
        }

        JDBCReusableMethods.ListeyiYazdirmaMethodu(actualResultList);

        assertEquals(actualResultList,expectedResultList);

    }

    @Given("Database baglantisi kurulur\\(Team148).")
    public void database_baglantisi_kurulur_team148() {

        JDBCReusableMethods.createConnection();

    }
    @Given("\\(DB_US23) SQL Query hazirlanir ve calistilir.")
    public void db_us23_sql_query_hazirlanir_ve_calistilir() {

        QUERY = queryManage.getDepositsQuery();
        resultSet=JDBCReusableMethods.executeQuery(QUERY);

    }
    @Given("\\(DB_US23) dogrulanir.")
    public void db_us23_dogrulanir() throws SQLException {

        List<Double> expectedResultList=new ArrayList<>();

        expectedResultList.add(22343.5);
        expectedResultList.add(22.0);
        JDBCReusableMethods.ListeyiYazdirmaMethodu(expectedResultList);

        List<Double> actualResultList=new ArrayList<>();
        while (resultSet.next()) {

            actualResultList.add(resultSet.getDouble(1));
            actualResultList.add(resultSet.getDouble(2));
        }
        JDBCReusableMethods.ListeyiYazdirmaMethodu(actualResultList);


        assertEqualsNoOrder(actualResultList,expectedResultList);

    }
    @Given("Database baglantisi sonlandir\\(Team148).")
    public void database_baglantisi_sonlandir_team148() {

        JDBCReusableMethods.closeConnection();

    }

    @Given("\\(DB_US29) SQL Query calismasi hazirlanir ve calistilir.")
    public void db_us29_sql_query_calismasi_hazirlanir_ve_calistilir() {
        QUERY = queryManage.getPagesDeleteQuery();
        etkilenenSatirSayisi=JDBCReusableMethods.updateQuery(QUERY);

        int expectedEtkilenenSatirSayisi=1;

        assertEquals(etkilenenSatirSayisi,expectedEtkilenenSatirSayisi);

    }

    @Given("\\(DB_US28) SQL Query hazirlanir ve calistilir.")
    public void db_us28_sql_query_hazirlanir_ve_calistilir() throws SQLException {

        QUERY = queryManage.getPagesUptadeQuery();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(QUERY);

        preparedStatement.setString(1,"oguzhan");
        etkilenenSatirSayisi=preparedStatement.executeUpdate();





    }
    @Given("\\(DB_US28) dogrulanir.")
    public void db_us28_dogrulanir() {

        int expectedEtkilenSatir=1;

        assertEquals(etkilenenSatirSayisi,expectedEtkilenSatir);

    }

    @Given("\\(DB_US31) SQL Query hazirlanir ve calistilir.")
    public void db_us31_sql_query_hazirlanir_ve_calistilir() throws SQLException {

        QUERY = queryManage.getPagesIntoQuery();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(QUERY);


        preparedStatement.setString(1,"Example Page");
        preparedStatement.setString(2,"example-page");
        preparedStatement.setString(3,"example-temp");
        preparedStatement.setString(4,"Sample section data");
        preparedStatement.setInt(5,1);
        preparedStatement.setString(6,"2025-02-23 12:00:00");
        preparedStatement.setString(7,"2025-02-23 12:00:00");

        etkilenenSatirSayisi=preparedStatement.executeUpdate();


    }
    @Given("\\(DB_US31) dogrulanir.")
    public void db_us31_dogrulanir() {

        int expectedEtkilenenSatirSayisi=1;

        assertEquals(etkilenenSatirSayisi,expectedEtkilenenSatirSayisi);

    }






}
