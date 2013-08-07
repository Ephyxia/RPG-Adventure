package me.Gugino.adventure.Levels;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

	public static String[] getRawFile(String filePath) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			String line = "";
			
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			
			while((line = in.readLine()) != null) {
				lines.add(line);
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] data = new String[lines.size()];
		data = lines.toArray(data);
		
		return data;
	}

}
