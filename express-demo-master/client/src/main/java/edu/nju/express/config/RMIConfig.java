package edu.nju.express.config;

/**
 * @author 
 * @version 
 */
public class RMIConfig {


	public static String HOST = null;


	static {
		ParseXML parse = new ParseXML("RMI.xml", "RMI");

		HOST = parse.getValue("host");

	}
}
