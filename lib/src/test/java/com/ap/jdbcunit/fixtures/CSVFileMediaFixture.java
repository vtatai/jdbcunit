/*
 * @author Jean Lazarou
 * Date: April 13, 2004
 */
package com.ap.jdbcunit.fixtures;

import com.ap.jdbcunit.Media;
import com.ap.jdbcunit.conformance.MediaFixture;
import com.ap.jdbcunit.csv.CSVMedia;
import com.ap.store.JavaFile;
import com.ap.store.MemoryStore;

public class CSVFileMediaFixture implements MediaFixture {

	public CSVFileMediaFixture() {
		super();
	}

	public String getName() {
		return "CSVMedia";
	}

	public void setUp() throws Exception {
	}

	public void tearDown() throws Exception {
	}

	public Media newMedia() {
		JavaFile rep = new JavaFile("/usr/local/google/home/vtatai/tmp/jdbcunit");
		return new CSVMedia(rep.add("toc.csv"));
	}
}
