Feature: "admin_notifications" tablosunda "is_read=1" ve
  "user_id = 1" olan kullanıcıların adedini doğrulayınız.

  @test14
  Scenario: Test
    * Database baglantisi kurulur.
    * (DB_US21) SQL Query hazirlanir ve calistirilir.
    * (DB_US21) dogrulanir.
    * Database baglantisini sonlandir.