/*
 * @author Jean Lazarou
 * Date: June 21, 2004
 */
package com.ap.straight.condition;

public interface CompositeCondition extends Condition {
	
	/**
	 * Returns the left-most term of the composite condition and
	 * removes it from this composition
	 * 
	 * @return the left-most (last) condition
	 * 
	 * @throws java.util.NoSuchElementException if no any condition is available
	 */
	Condition takeLast();
	
	/**
	 * Add the given Condition to be composited
	 * 
	 * @param condition the Condition object to add 
	 */
	void add(Condition condition);
	
}
