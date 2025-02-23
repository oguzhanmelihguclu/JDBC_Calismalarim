Feature: executeQuery testleri

  Background: Database baglantisi olusturulur.
    * Database baglantisi kurulur.

            # Database içindeki "deposits" toblosunda
            # "amount" değeri 100$ ile 500$ arasında olan
            # user_id'leri doğrulayınız
  @executeQuery01
  Scenario: Amount degerine göre Id sorgulama testi.

    * SQL Query'si hazirla ve calistir.
    * Sonucları dogrula.
    * Database baglantisini sonlandir.


     #Database içindeki "cron_schedules" tablosunda ilk 2 kaydın
    # "name" bilgisini doğrulayınız


  @executeQuery02
  Scenario: cron_schedules tablosundan "Name" bilgisi dogrulama testi.

    * (cron_schedules) SQL query'si  calistirilir
    * (cron_schedules) sonuclari  dogrulanir.
    * Database baglantisini sonlandir.