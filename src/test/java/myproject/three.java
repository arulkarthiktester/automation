package myproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;;

public class three {
	
	@Test
	public void logs()
	{
Logger log =LogManager.getLogger(three.class.getName());

		log.debug("debug message");
	
	}
	

}
