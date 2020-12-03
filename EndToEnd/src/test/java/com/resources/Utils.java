package com.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {

	public String getQAUrl() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\sachinm\\Music\\APIPRo\\EndToEnd\\src\\test\\java\\com\\resources\\gobal.properties");
		
	prop.load(fis);
	return prop.getProperty("QAURL");
		
	}
}
