Feature: "delay_value" ve "fixed_charge ya da percent_charge" değerlerine göre
          loan_plans tablosundaki ilk 3 "name" bilgisini doğrulayınız.

  @test15
  Scenario: Test
    * Database baglantisi kurulur.
    * (DB_US27) SQL Query hazirlanir ve calistirilir.
    * (DB_US27) dogrulanir.
    * database baglantisi sonlandirilir.
