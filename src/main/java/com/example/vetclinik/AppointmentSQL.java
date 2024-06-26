package com.example.vetclinik;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentSQL {
    // Статическая переменная, которая содержит единственный экземпляр класса
    private static AppointmentSQL instance;

    // Приватный конструктор для предотвращения создания экземпляров класса извне
    private AppointmentSQL() {
    }
    public static synchronized AppointmentSQL getInstance() {
        if (instance == null) {
            instance = new AppointmentSQL();
        }
        return instance;
    }

    public boolean addAppointment(String name, LocalDate date, String time, String phone) {
        Connection connection = null;
        // UserSQL userSQL = UserSQL.getInstance();
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vetclinica",
                    "veloprokat", "Stud249013!");
            String query = "INSERT INTO приемы_с_владельцами (дата, время, животное_id, владелец_id, врач_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, java.sql.Date.valueOf(date));
            preparedStatement.setString(2, time);
            preparedStatement.setInt(3, PetSQL.getId(phone,name));
            preparedStatement.setInt(4,UserSQL.getId(phone) );
            if (DoctorSQL.getId(date,time)!= -1) {
                preparedStatement.setInt(5, DoctorSQL.getId(date, time));

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Приём с владельцем успешно добавлен!");
                }
                return true;
            }
            else {
                System.out.println("занят");
            }
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return success;
    }

    public boolean isOcupiedForUser(String phone,LocalDate date, String time){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Integer> bookings = new ArrayList<Integer>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT id" +
                    "FROM прием_с_владельцами" +
                    "WHERE владелец_id = ? " +
                    "AND дата = ? " +
                    "AND время = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, UserSQL.getId(phone));
            preparedStatement.setDate(2, java.sql.Date.valueOf(date));
            preparedStatement.setString(3, time);

            resultSet = preparedStatement.executeQuery();

            // Проверка результатов запроса
            if (resultSet.next()) {
                return true;
            }


            // Закрываем ресурсы
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                // Закрываем соединение в блоке finally для обеспечения его закрытия в любом случае
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return false;
    }
    public int isOcupiedForUser(int id_n){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = -1;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT id" +
                    "FROM приемы_с_владельцами" +
                    "WHERE id = ? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_n);


            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                //System.out.println("ID владельца: " + id);
            } else {
                System.out.println("не найден.");
            }


            // Закрываем ресурсы
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                // Закрываем соединение в блоке finally для обеспечения его закрытия в любом случае
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return id;
    }
}
