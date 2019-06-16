package myproject;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class DataDrivenmain {
	@Test
	public void GetDataFromExcelSheet() throws IOException {
		datadriven getdata = new datadriven();
		ArrayList<String> av=getdata.GetDataFromExcelSheet("set a","login");
		
		System.out.println(av.get(0));
		
	}
}
