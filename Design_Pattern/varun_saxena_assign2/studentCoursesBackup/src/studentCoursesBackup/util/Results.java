/**
 * @author Varun Saxena
 */
package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	protected String text="";
    protected String outputFile = null;
    protected BufferedWriter buffWriter = null;

	public Results(String outFile){
		this.outputFile = outFile;
	}

	@Override
	public void stdOutDisplayInterface(String s)throws Exception
	{
		System.out.println(s);
	}

	@Override
	public void fileDisplayInterface()throws Exception{
	    buffWriter = new BufferedWriter(new FileWriter(outputFile));
	    buffWriter.write(this.getResults());
		buffWriter.close();
	}

	public String getResults()throws Exception{
		return this.text;
	}

	public void storeResult(String s)throws Exception{
		this.text = text + s;
    }
}