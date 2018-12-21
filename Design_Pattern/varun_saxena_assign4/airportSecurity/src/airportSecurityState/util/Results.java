/**
 * @author Varun Saxena
 *
 */
package airportSecurityState.util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Results implements FileDisplayInterface
{
    Vector<String> vectorResult =new Vector<String>();;
    private String con1=" ";
    private String con2=" ";
    private String fileName;
    private FileOutputStream fos = null;
   
    public Results()
    {
        MyLogger.writeMessage("Result's Constructor!", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public void setFilename(String fName)
    {
        fileName=fName;    
    }
        
    @Override
    public void writeToFile(String s)
    {
        try
        {
            MyLogger.writeMessage("Print Output To File", MyLogger.DebugLevel.OUTPUT);
            fos=new FileOutputStream(fileName);
            for(String result:vectorResult)
            {
                con1=con1+result+"\n";
            }
            con2=con2+con1;
            byte[] con=(con2).getBytes();  
            fos.write(con);
        }
        
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            }
        }

        public void storeNewResult(String s)
        {
            MyLogger.writeMessage("In Results function",
                    MyLogger.DebugLevel.RESULT);
            vectorResult.add(s);   
        } 
        
    }