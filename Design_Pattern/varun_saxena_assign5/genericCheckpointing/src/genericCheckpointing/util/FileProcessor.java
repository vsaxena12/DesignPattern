package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor
{
    private String inputFileName=null;
    private File inputFile=null;
    private FileReader fileReader=null;
    private FileWriter fileWriter = null;
    private BufferedReader bufferedReader=null;
    private BufferedWriter bufferedWriter = null;
    private boolean operationType;
	    

    public FileProcessor(String s){
		this.inputFileName = s;
    }

    public void createWriter()throws IOException{
	    bufferedWriter = new BufferedWriter(new FileWriter(inputFileName));
    }

    public void createReader() throws IOException{
	    bufferedReader = new BufferedReader(new FileReader(inputFileName));
    }


    public String readLine()throws IOException {
	    return getBufferedReader().readLine();
    }


    private BufferedReader getBufferedReader(){
		return bufferedReader;
    }


    public void writeLine(String line)throws IOException{
		if (line.equals(""))
		{
			return;
		}
		bufferedWriter.write(line);
		bufferedWriter.newLine();
	}


    public void closeWriter()throws IOException{
	    this.bufferedWriter.close();
    }

    public void closeReader()throws IOException{
	    this.bufferedReader.close();    
	}
}
