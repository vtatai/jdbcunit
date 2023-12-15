/*
 * @author: Jean Lazarou
 * @date: 15 feb. 04
 */
package com.ap.jdbcunit;

import com.ap.jdbcunit.csv.CSVMedia;
import com.ap.store.JavaFile;
import com.ap.store.Store;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.junit.Test;

/**
 * Just used for manual testing for now.
 */
public class PsqlTestReplaying {
    @Test
    public void testSelect() throws Exception {
        File csv = new File("test-data/test-data.csv");
        Store store = new JavaFile(csv);
        CSVMedia media = new CSVMedia(store);

        JDBCUnit.registerDriver("org.postgresql.Driver");
        JDBCUnit.start(new MediaRecorder(media));

        JDBCUnit.record();

        String url = "jdbc:postgresql://localhost/jdbcunit";
        Properties props = new Properties();
        props.setProperty("user", "jdbcunit");
        props.setProperty("password", "jdbcunit");
        props.setProperty("ssl", "false");

        query(url, props);

        JDBCUnit.replay();

        query(url, props);

        JDBCUnit.stop();
    }

    private static void query(String url, Properties props) throws SQLException {
        Connection con = DriverManager.getConnection(url, props);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            System.out.printf("id %d name %s%n", rs.getInt(1), rs.getString(2));
        }
        rs.close();
        stmt.close();
    }

    public static void main(String[] args) throws Exception {
        new PsqlTestReplaying().testSelect();
    }
}
