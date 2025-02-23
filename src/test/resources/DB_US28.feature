Feature: "update_logs" tablosunda "version=? " ve "id=?" olan datanın "update_log" değerini update edip doğrulayınız.

  @test12
  Scenario:Test
    * Database baglantisi kurulur.
    * (DB_US28) SQL Query hazirlanir ve calistilir.
    * (DB_US28) dogrulanir.
    * Database baglantisini sonlandir.