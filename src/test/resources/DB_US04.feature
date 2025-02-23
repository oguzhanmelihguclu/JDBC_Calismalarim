

Feature: Database içindeki "deposits" tablosunda "amount" değeri 500.000$ altında olan datalardan
  "trx=4GC9SMZUS69S"olan datanın "charge" değerini doğrulayınız

@test02
  Scenario: test
  * Database ile baglanti kurulur. (Oguz)
  * (DB_US04) SQL querysi hazirlanir ve calistirilir.
  * (DB_US04) sonuclar dogrulanir
  * Database baglantisini sonlandir. (Oguz)
