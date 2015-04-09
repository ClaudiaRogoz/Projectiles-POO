import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Opens a file for reading and provides a stream of words resulting from its parsing
 */

public class FileParser {
	
	private String str;

	/*
	 * 
	 * Constructor 
	 * 
	 * @param nameFile the name of the file to be read
	 */
	FileParser(String nameFile){
	
	File file = new File(nameFile);
	
	BufferedInputStream bin = null;
	FileInputStream fin = null;
	setStr("");

	try {
		
		fin = new FileInputStream(file);

		bin = new BufferedInputStream(fin);

		while (bin.available() > 0) {
			setStr(getStr() + (char) bin.read());
		}
		
	}
	catch (FileNotFoundException e) {
		System.out.println("File not found" + e);
	}
	catch (IOException ioe) {
		System.out.println("Exception while reading file " + ioe);
	}
	finally {
		// close the streams using close method
		try {
			if (fin != null) {
				fin.close();
			}
			if (bin != null) {
				bin.close();
			}
		}
		catch (IOException ioe) {
			System.out.println("Error while closing stream : " + ioe);
		}

	}
	
}

	/*
	 * Returns the string
	 * 
	 * @return str string
	 */
	public String getStr() {
		return str;
	}

	
	public void setStr(String str) {
		this.str = str;
	}

}
