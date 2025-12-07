package com.subbu.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class FileUtil {
	
	public String getLatestFileNameFromFolder(String folderPath, ExtentTest rprtMessage) {
		
	    String fileName = null;

	    try {

	      Path path = Paths.get(folderPath);

	      if (Files.isDirectory(path)) {

	        Optional<Path> latestFile = Files.list(path).filter(Files::isRegularFile)

	          .sorted((file1, file2) -> {

	            try {

	              return Files.getLastModifiedTime(file2).compareTo(Files.getLastModifiedTime(file1));

	            }

	            catch (IOException e) {

	              throw new RuntimeException(e);

	            }

	          })

	          .findFirst();

	        return latestFile.map(file -> file.getFileName().toString()).orElse(null);

	      }

	      else {

	    	  rprtMessage.log(Status.FAIL,"The specified path is not a directory.");

	      }

	    }

	    catch (IOException e) {

	      e.printStackTrace();

	    }

	    return fileName;

	  }
}
