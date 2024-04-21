//package com.example.s21library_dbcontroller.service;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Objects;
//
//@Service
//public class NotificationListenerService {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public NotificationListenerService(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @PostConstruct
//    public void listenForNotifications() {
//        new Thread(() -> {
//            try (Connection conn = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
//                 Statement stmt = conn.createStatement()) {
//                stmt.execute("LISTEN your_notification_channel");
//                while (true) {
//                    ResultSet rs = stmt.getResultSet();
//                    if (rs.next()) {
//                        String notification = rs.getString(1);
//                        System.out.println("Received notification: " + notification);
//
//                    }
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }
//}
//
