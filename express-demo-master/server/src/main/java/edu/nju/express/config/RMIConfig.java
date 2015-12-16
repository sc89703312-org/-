package edu.nju.express.config;

/**
 * @author 
 * @version 
 */
public class RMIConfig {


	public static String PORT = null;


	static {
		ParseXML parse = new ParseXML("RMI.xml", "RMI");

		PORT = parse.getValue("port");

	}
}
