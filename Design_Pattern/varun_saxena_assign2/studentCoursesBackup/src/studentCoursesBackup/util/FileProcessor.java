/**
 * @author Varun Saxena
 *
 */
package studentCoursesBackup.util;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class FileProcessor{

	protected BufferedReader buffRead;

	public FileProcessor(String strIn)throws IOException{
		buffRead = new BufferedReader(new FileReader(new File(strIn)));
	}

	public String readLine()throws IOException {
		return this.getBuffRead().readLine();
	}

	protected BufferedReader getBuffRead()throws IOException {
		return this.buffRead;
	}
}