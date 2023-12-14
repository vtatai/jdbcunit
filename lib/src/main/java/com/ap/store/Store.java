/*
 * @author: Jean Lazarou
 * @date: February 24, 04
 */
package com.ap.store;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * <p>
 * An interface for objects that are modeling the usual OS files. Here we extend
 * the file definition by giving children and content to all of them.
 * </p>
 * 
 * <p>
 * Store can be actual file on hard drives, but can be ZIP files, file stored on
 * a remote FTP server, memory data, a database...
 * </p>
 * 
 * <p>
 * Conformance tests are available to validate the store implementations.
 * </p>
 * 
 * <p>
 * The main reason for this interface is to be able to write tests that need files
 * without having to actually write data on disk (and clean up). The interface is
 * simple so that writing mock objects is very easy.
 * </p>
 * 
 * @author Jean Lazarou
 */
public interface Store {
	
	/**
	 * @return the name of the store 
	 */
	String getName();
	
	/**
	 * @return the type of the content
	 */
	String getType();

	/**
	 * Flushes, writes, on persistent storage data that need to be saved
	 * (if applicable)
	 */
	void sync();
	
	/**
	 * Creates the store regarding to the persistent storage (if applicable)
	 *
	 */
	void create();	
	
	/**
	 * @return true if the store exists
	 */
	boolean exists();
	
	/**
	 * Deletes the store and its content
	 * 
	 * @return true if deletion was sucessful
	 */
	boolean delete();
	
	/**
	 * @return an InputStream representing the store's content
	 */
	InputStream input();
	
	/**
	 * @return an OutputStream to write to the store's content
	 */
	OutputStream output();
	
	/**
	 * @return an Reader representing the store's content
	 */
	Reader reader();
	
	/**
	 * @return an Writer to write to the store's content
	 */
	Writer writer();

	/**
	 * @return an PrintWriter to write to the store's content
	 */
	PrintWriter printWriter();

	/**
	 * @return the parent of this store
	 */
	Store getParent();

	void setParent(Store store);
	
	/**
	 * reserved not yet defined
	 */
	void attach(Store store);

	/**
	 * reserved not yet defined
	 */
	void detach(Store store);

	/**
	 * @return all the children of this store, a Collection of 
	 * Store obejcts
	 */	
	Collection children();
	
	/**
	 * Returns the child store with the given name
	 * 
	 * @param name of the child to retrieve
	 * @return the this store's child or null if no child was found
	 */
	Store child(String name);
	
	/**
	 * Creates a new store and adds it as children
	 * 
	 * @param name of the new child
	 * @return the new created store object
	 */
	Store add(String name);
	
	/**
	 * Removes the child with the given name from the children list
	 * 
	 * @param name the name of the child to remove
	 * @return true if the children was removed
	 */
	boolean remove(String name);
	
}
