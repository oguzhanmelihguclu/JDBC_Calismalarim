package manage;

public class QueryManage {


    private String croneSchedulesQuery = "SELECT name FROM cron_schedules LIMIT 2;";
    private String usersMobileUpdateQuery = "UPDATE users SET mobile = ? WHERE username LIKE ?;";
    private String deviceTokensInsertQuery = "INSERT INTO device_tokens (id, user_id, is_app, token)VALUES(?,?,?,?);";
    private String adminsTokenSelectQuery="SELECT remember_token FROM admins Where email = 'info@loantechexper.com';";
    private String depositsChargeSelectQuery="SELECT DISTINCT charge FROM deposits WHERE amount < 500000 AND trx = '4GC9SMZUS69S';";
    private String subjectTicketSelectQuery ="SELECT subject FROM support_tickets WHERE ticket LIKE  '4%';";
    private String adminNotificationsUpdateQuery="UPDATE admin_notifications SET is_read = 5 WHERE id = 13 AND is_read = 0;";
    private String categoriesNameDescprictionIntoQuery="INSERT INTO categories (name, description) VALUES (?, ?);";
    private String cron_job_logsIntoQuery ="INSERT INTO cron_job_logs (id,cron_job_id,start_at,end_at) VALUES (?,?,?,?);";
    private String adminPasswordResetIntoQuery="INSERT INTO admin_password_resets (email, token, status, created_at) VALUES (?, ?, ?, ?)";
    private String usersFirstnameLastnameQuery="SELECT firstname, lastname FROM users WHERE country_code != 'TR' AND id = 11;";
    private String adminNotificationsQuery="SELECT COUNT(*) AS istenilen_sonuc FROM admin_notifications WHERE user_id = 1 AND is_read = 0;";

    // ************ GETTERS **************
    public String getCroneSchedulesQuery() {
        return croneSchedulesQuery;
    }

    public String getUsersMobileUpdateQuery() {
        return usersMobileUpdateQuery;
    }

    public String getDeviceTokensInsertQuery() {
        return deviceTokensInsertQuery;
    }

    public String getAdminsTokenSelectQuery() {
        return adminsTokenSelectQuery;
    }
    public String getDepositsChargeSelectQuery() {
        return depositsChargeSelectQuery;
    }
    public String getSubjectTicketSelectQuery() {
        return subjectTicketSelectQuery;
    }

    public String getAdminNotificationsUpdateQuery() {
        return adminNotificationsUpdateQuery;
    }

    public String getCategoriesNameDescprictionIntoQuery() {
        return categoriesNameDescprictionIntoQuery;
    }

    public String getCron_job_logsIntoQuery() {
        return cron_job_logsIntoQuery;
    }

    public String getAdminPasswordResetIntoQuery() {
        return adminPasswordResetIntoQuery;


}
    public String getUsersFirstnameLastnameQuery() {
        return usersFirstnameLastnameQuery;
    }

    public String getAdminNotificationsQuery() {
        return adminNotificationsQuery;
    }

}