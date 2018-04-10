package com.ecm.webautomation.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	
	private static final String Test_Directory= "src/test/resources/conf";
	private static final String Main_Directory="src/main/resources/conf";
	private static final String Properties_Extension=".properties";
	private static Properties properties;
	
	public ConfigurationReader() {
		
	}
	
	private static File [] listFiles(String path) {
		File folder=new File(path);
		File[] listOfFiles=folder.listFiles(new FilenameFilter() {
			
			public boolean accept(File directory, String fileName) {
				// TODO Auto-generated method stub
				return fileName.endsWith(Properties_Extension);
			}
		});
		
		if(listOfFiles==null || listOfFiles.length==0){
			return new File[] {};
		}
		return listOfFiles;

	}
	
	private static void readToProperties(File[] listOfFiles) {
		Properties temporaryProperties;
		
		for (File file:listOfFiles) {
			if(file.isFile()) {
				temporaryProperties=new Properties();
				FileInputStream fileInputStream = null;
				
				try {
					fileInputStream=new FileInputStream(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					temporaryProperties.load(fileInputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 properties.putAll(temporaryProperties);
				 
				 try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void read() {
		properties= new Properties();
		File[] confFiles=listFiles(Main_Directory);
		readToProperties(confFiles);
		
		confFiles=listFiles(Test_Directory);
		readToProperties(confFiles);
	}
	
	public static Properties getProperties() {
		if(properties==null) {
			read();
		}
		properties.putAll(System.getProperties());
		return properties;
	}
	
	public static String get(String property) {
		return getProperties().getProperty(property);
	}
}
