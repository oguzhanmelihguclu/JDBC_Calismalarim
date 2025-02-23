Feature: Database üzerinde "admin_notifications" tablosunda
  "user id= 1" ve "is_read=0"olan kullanıcı sayılarının adedini doğrulayınız.

  @test09
  Scenario: Test
    * Database ile baglanti kurulur. (Oguz)
    * (DB_US11) SQL Query sorgulari hazirlanir ve calistirilir.
    * (DB_US11) dogrulanir.
    * Database baglantisini sonlandir. (Oguz)