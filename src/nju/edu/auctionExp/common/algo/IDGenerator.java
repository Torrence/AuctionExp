package nju.edu.auctionExp.common.algo;

/**
 * Generates various IDs. Most probably used as database primary key.
 * It can return any data type (String, Integer, etc)
 * depending on the implementation.
 * 
 * @author BYF
 *
 */
public interface IDGenerator {
	public Object generate();	
}
