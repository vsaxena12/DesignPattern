/**
 * @author Varun Saxena
 *
 */
package findPrime.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileProcessor{

	static String inputFile;
	FileInputStream fileStream;
	BufferedReader buffReadr;

	public FileProcessor(String strIn)throws IOException
	{
		inputFile = strIn;

		fileStream = new FileInputStream(strIn);
		MyLogger.writeMessage("In File Processor Constructor",
				MyLogger.DebugLevel.CONSTRUCTOR);
		buffReadr = new BufferedReader(new InputStreamReader(fileStream));
	}

	public String readLineFromFile() throws IOException
	{
		return buffReadr.readLine();
	}


	public void closeFileBuffer() throws IOException
	{
		buffReadr.close();
	}

}