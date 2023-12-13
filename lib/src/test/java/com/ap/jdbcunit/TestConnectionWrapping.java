/*
 * @author: Jean Lazarou
 * @date: February 15 2004
 */
package com.ap.jdbcunit;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;

import junit.framework.TestCase;

import org.hsqldb.jdbc.JDBCDriver;
import com.ap.jdbcunit.util.DatabaseService;

public class TestConnectionWrapping extends TestCase {

  public TestConnectionWrapping(String name) {
    super(name);
  }

  public void testReplaceActualDriver() throws Exception {
    JDBCUnit.registerDriver("org.hsqldb.jdbc.JDBCDriver");
    Driver driver = DriverManager.getDriver("jdbc:hsqldb:mem:TestDatabase");
    assertTrue(driver instanceof DriverWrapper);
  }

  public void testReplaceActualConnection() throws Exception {
    DatabaseService.createDatabase();
    JDBCUnit.registerDriver("org.hsqldb.jdbc.JDBCDriver");
    Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:TestDatabase");
    con.close();
    assertTrue(con instanceof ConnectionWrapper);
  }

  public void testReplaceTwoDrivers() throws Exception {
    DatabaseService.createDatabase();
    JDBCUnit.registerDriver("org.postgresql.Driver");
    JDBCUnit.registerDriver("org.hsqldb.jdbc.JDBCDriver");

    ConnectionWrapper con = (ConnectionWrapper) DriverManager.getConnection(
        "jdbc:hsqldb:mem:TestDatabase");

    assertTrue(con != null);
    assertTrue(con.wrappedConnection() != null);
  }

  protected void setUp() throws Exception {
    JDBCDriver driver = new JDBCDriver();
    DriverManager.registerDriver(driver);
  }

  protected void tearDown() throws Exception {

    DatabaseService.clear();
    DriverWrapper.deregisterDrivers();

  }

}
