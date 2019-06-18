package myproject;

import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
public class one {
	
	private static Logger log =LogManager.getLogger(one.class.getName());
	
	@Test
	public void van() {
		
		log.debug("debug message");
	}

	@Test
	public void Auto() {
		System.out.println("two done");
	}

	@Test
	public void rock() {
		System.out.println("three done");
	}
}
