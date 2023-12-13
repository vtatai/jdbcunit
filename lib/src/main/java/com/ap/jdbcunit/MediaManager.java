/*
 * @author: Jean Lazarou
 * @date: March 9, 2004
 */
package com.ap.jdbcunit;

import com.ap.jdbcunit.csv.CSVMedia;
import com.ap.store.Store;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MediaManager {
	static Map<String, MediaFactory> mediaFactories = new HashMap<>();

	private MediaManager() {}

	public static synchronized Media createMedia(Store store) {
		Iterator<MediaFactory> it = getMediaFactories();
		
		while (it.hasNext()) {
			MediaFactory factory = it.next();
			if (factory.accepts(store)) {
				return factory.create(store);
			}
		}
		
		return null;
	}
	
	public static synchronized void registerMediaFactory(MediaFactory factory) {
		mediaFactories.put(factory.getClass().getName(), factory);
	}
	
	public static synchronized void deregisterMediaFactory(MediaFactory factory) {
		mediaFactories.remove(factory.getClass().getName());
	}
	
	public static synchronized Iterator<MediaFactory> getMediaFactories() {
		return mediaFactories.values().iterator();
	}	
	
	static {
		registerMediaFactory(new MediaFactory() {

			public Media create(Store store) {
				return new CSVMedia(store);
			}

			public boolean accepts(Store store) {
				return "csv".equals(store.getType());
			}
		});
	}
}
