Feature: Database içindeki "support_tickets" tablosunda
  "ticket" değeri  4 ile başlayan dataların "subject" bilgisini doğrulayınız.


  @test04
  Scenario: Test

    * Database ile baglanti kurulur. (Oguz)
    * (DB_US07) SQL queryleri hazirlanir ve calistirilir
    * (DB_US07) sonuclar dogrulanir
    * Database baglantisini sonlandir. (Oguz)