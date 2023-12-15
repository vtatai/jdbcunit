/*
 * @author: Jean Lazarou
 * @date: 22 fevr. 04
 */
package com.ap.jdbcunit.csv;

import com.ap.util.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CSVFileIterator implements Iterator<List<String>> {

  BufferedReader in;
  String nextLine;

  public CSVFileIterator(Reader in) {
    this.in = new BufferedReader(in);
    moveToNext();
  }

  public boolean hasNext() {
    return nextLine != null;
  }

  public List<String> next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    List<String> res = Lists.csvSplit(nextLine, true);
    moveToNext();
    return res;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }

  private void moveToNext() {
    try {
      nextLine = this.in.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      nextLine = null;
    }
  }
}
