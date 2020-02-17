package com.dao;

import com.model.User;
import com.util.Database;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserDao {
    private static final String secret = "只有你自己知道";

    public User registerUser(String username, String nickname, String password) throws SQLException {
        password = encrypted(password);
        String sql = "INSERT INTO users (username, nickname, password) VALUES (?, ?, ?)";

        try (Connection connection = Database.getConnection()) {
            // Statement.RETURN_GENERATED_KEYS 表示返回插入的自增 id 值
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, username);
                statement.setString(2, nickname);
                statement.setString(3, password);

                statement.executeUpdate();
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    rs.next();
                    int id = rs.getInt(1);
                    return new User(id, username, nickname);
                }
            }
        } catch (SQLException e) {
            // 如果是用户名重复异常，属于客户端的问题，特殊处理下
            if (e.getMessage().contains("Duplicate entry")) {
                return null;
            }

            throw e;
        }
    }

    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "SELECT id, username, nickname FROM users WHERE username = ? AND password = ?";

        // try-with-resource
        try (Connection connection = Database.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);

                try (ResultSet rs = statement.executeQuery()) {
                    // 因为我们只期望有两个情况：1. 有一行 2. 一行都没有
                    // 所以，通过 if 而不需要 while 就可以区分出来了
                    if (!rs.next()) {
                        return null;
                    }

                    int id = rs.getInt(1);
                    // username 我们有了，不需要取
                    String nickname = rs.getString(3);

                    return new User(id, username, nickname);
                }
            }
        }

        /*
        Connection connection;
        try {
            connection = Database.getInstance().getConnection();
        } finally {
            connection.close();
        }
        */
    }
    private String encrypted(String password){
        password = password + secret;
        // 做 SHA-256(一种Hash)
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] input = password.getBytes("UTF-8");
            byte[] output = messageDigest.digest(input);
            StringBuilder sb = new StringBuilder();
            for (byte b:output) {
                sb.append(String.format("%02x",b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        String output = userDao.encrypted("你好世界Hx%4$@_");
        System.out.println(output.length());
        System.out.println(output);
    }
}
