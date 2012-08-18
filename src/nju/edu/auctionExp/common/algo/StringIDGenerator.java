package nju.edu.auctionExp.common.algo;

import java.util.UUID;

public class StringIDGenerator implements IDGenerator {
	private static StringIDGenerator theInstance;
	
	private StringIDGenerator() {
		
	}
	
	/**
	 * Generates a random String which can be used as a GUID (Globally Unique IDentifier).
	 */
	public String generate() {
		UUID randomID = UUID.randomUUID();
		return randomID.toString();		
	}
	
	/**
	 * Gets the singleton instance of the generator.
	 * @return
	 */
	public static StringIDGenerator getInstance() {
		if(theInstance == null) {
			theInstance = new StringIDGenerator();
		}		
		return theInstance;
	}
}
