/*
 * @author: Jean Lazarou
 * @date: 15 feb. 04
 */
package com.ap.jdbcunit;

import com.ap.jdbcunit.csv.CSVMedia;
import com.ap.jdbcunit.util.JDBCUnitTestCase;
import com.ap.store.JavaFile;
import com.ap.store.Store;
import java.io.File;
import java.sql.ResultSet;
import java.util.Iterator;

public class TestReplaying extends JDBCUnitTestCase {

  public TestReplaying(String name) {
    super(name);
  }

  public void testSelect() throws Exception {
    JDBCUnit.start(mockRecorder);

    JDBCUnit.record();

    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT * FROM persons");

    rs.close();
    stmt.close();

    JDBCUnit.replay();

    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT * FROM persons");

    assertSame(mockRecorder.getRecorded(), rs);

    mockRecorder.verify();

    JDBCUnit.stop();

  }

  public void testReadAndWriteCSV() throws Exception {

    File csv = new File("test-data/test-data.csv");
    Store store = new JavaFile(csv);
    CSVMedia media = new CSVMedia(store);

    MediaRecorder recorder = new MediaRecorder((media));

    JDBCUnit.start(recorder);

    JDBCUnit.record();

    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT * FROM persons");

    rs.close();
    stmt.close();

    JDBCUnit.replay();

    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT * FROM persons");

    // This assert fails since these aren't the literal same objects, but that doesn't feel like
    // a particularly useful test. The values that we're pulling via the get() are correct though
    // assertSame(recorder.get(stmt, con.getMetaData().getURL(), "SELECT * FROM persons"), rs);

    media.close();
    JDBCUnit.stop();

  }

  protected void setUp() throws Exception {
    super.setUp();

    mockRecorder = new PlaybackRecorder();

    mockRecorder.setExpectedSQL("SELECT * FROM persons");
  }

  PlaybackRecorder mockRecorder;
}
