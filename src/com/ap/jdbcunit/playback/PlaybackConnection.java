/*
 * @author: Jean Lazarou
 * @date: June 1 2004
 */
package com.ap.jdbcunit.playback;

import java.util.Map;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;

public class PlaybackConnection implements Connection {

	public PlaybackConnection(Driver driver, String dbUrl) {
		this.driver = driver;
		this.dbUrl = dbUrl;
	}

	public Statement createStatement() throws SQLException {
		return new PlaybackStatement(this);
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return new PlaybackPreparedStatement(this, sql);
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public String nativeSQL(String sql) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public boolean getAutoCommit() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void commit() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void rollback() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void close() throws SQLException {
	}

	public boolean isClosed() throws SQLException {
		return true;
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		return new PlaybackDatabaseMetaData(driver.getClass(), dbUrl);
	}

	public void setReadOnly(boolean readOnly) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public boolean isReadOnly() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void setCatalog(String catalog) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public String getCatalog() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void setTransactionIsolation(int level) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public int getTransactionIsolation() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public SQLWarning getWarnings() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void clearWarnings() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public Map getTypeMap() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void setTypeMap(Map map) throws SQLException {
		throw new UnsupportedOperationException();
	}

	Driver driver;
	String dbUrl;
	
	public int getHoldability() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void setHoldability(int holdability) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public Savepoint setSavepoint() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void rollback(Savepoint savepoint) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public Savepoint setSavepoint(String name) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		throw new UnsupportedOperationException();
	}
	
}
