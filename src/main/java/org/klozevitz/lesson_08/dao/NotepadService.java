package org.klozevitz.lesson_08.dao;

import org.klozevitz.lesson_08.model.Notepad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotepadService implements DbConnection {
    Connection connection;
    // <тип драйвера>:<тип БД>://<хост>:<порт>/<название БД>
    private final String DB_URL = "jdbc:postgresql://localhost:5432/Notepads";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "Sk3295318";
    private final String DB_DRIVER = "org.postgresql.Driver";

    public NotepadService() {
        try {
            // инициализация  драйвера БД
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("подключение невозможно");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("драйвер не подключен");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Notepad> all() {
        String query = "SELECT * FROM Notepads";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Notepad> result = getALLFromResultSet(resultSet);
            result.forEach(System.out::println);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Notepad> getALLFromResultSet(ResultSet resultSet) throws SQLException {
        List<Notepad> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Notepad(resultSet));
        }
        return result;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Notepad idRequest(Integer id) {
           String query = ("SELECT * FROM Notepads WHERE ID = " + id);
        Statement statement;

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Notepad result = new Notepad(resultSet);
            System.out.println(result);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

 }
