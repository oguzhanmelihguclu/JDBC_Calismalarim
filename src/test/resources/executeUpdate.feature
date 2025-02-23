Feature: ExecuteUpdate Testleri

  Background:
    * Database ile baglanti kurulur.


  # "users" tablosunda sondan bir önceki harfi e olan
  # "usernamelerin" "mobile" numarasını update ediniz

  @executeUpdate01
  Scenario: users tablosunda mobile number UPDATE edebilme testi.

    * (users) Update sorgusu hazirlanir ve calistirilir.
    * (users) sorgu sonuclari dogrulanir.
    * database baglantisi sonlandirilir.


    # Database üzerinde "device_tokens" tablosuna
    # istenen veriyi tek sorguda ekleyiniz.

  @executeUpdate02
  Scenario: device_tokens tablosuan veri ekleme testi.

    * (device_tokens) Insert sorgusu hazirlanir ve calistirilir.
    * (device_tokens) sorgu sonuclari dogrulanir.
    * database baglantisi sonlandirilir.