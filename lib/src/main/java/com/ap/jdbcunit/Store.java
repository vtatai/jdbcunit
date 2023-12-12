package com.ap.jdbcunit;

import java.io.PrintWriter;
import java.io.Reader;

public interface Store {

  Store getParent();

  boolean exists();

  void create();

  Reader reader();

  PrintWriter printWriter();

  String getName();

  void sync();

  Store add(String trackName);

  Store child(String s);

  void delete();

  String getType();
}
