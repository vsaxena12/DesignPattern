package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportSecuritySystem;
import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.Helper;
import airportSecurityState.airportStates.LowRisk;
import airportSecurityState.airportStates.ModerateRisk;
import airportSecurityState.airportStates.HighRisk;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.Results;

/**
 *
 * @author Varun Saxena
 */
public class Driver 
{
	  public static int debugValue=0;
    public static String outputFile=null;
    public static String inputFile=null;
    static Results result;
    static FileProcessor fProcessor;
    static AirportSecuritySystem airportSecSys;
    //static AirportSecuritySystem airportSecSys;
    static Helper cal;

    public static void main(String[] args)
    {
        int check = Integer.parseInt(args[2]);
        try
        {
         	if(args.length!=3 && args[0].equals("${arg0}") && args[1].equals("${arg1}") && args[2].equals("${arg2}"))
         	{
        	  System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
				    System.exit(1);
         	}
         	
          else
          {
              if(args.length == 3)
              {
                if(args[0].endsWith(".txt") && args[1].endsWith(".txt"))
                {
                  inputFile=args[0];
                  outputFile=args[1];
                
                  if((check > 4)) //Fix the code
                  {
                    System.err.print("Error: Debug level value between 0 and 4");
                    System.exit(1);
                  }
                  
                  else
                  {
                    debugValue=Integer.parseInt(args[2]);
                    MyLogger.setDebugValue(debugValue);
                    result=new Results();
                    fProcessor = new FileProcessor(inputFile);
                    airportSecSys=new AirportSecuritySystem(result);
                    cal=new Helper(airportSecSys);
                    result.setFilename(outputFile);

                    String line = " ";
                    while((line = fProcessor.readLine())!=null)
                    {
                      cal.processData(line);  
                      AirportStateI state =airportSecSys.getCurrentState();
                      if(state instanceof LowRisk)
                      {
                        state=state.SecurityState(cal);
                      }
                      else if(state instanceof ModerateRisk)
                      {
                        state=state.SecurityState(cal);
                      }
                      else if(state instanceof HighRisk)
                      {
                        state=state.SecurityState(cal);
                      }   
                      else
                      {
                        System.exit(1);
                      }
                    }
                    airportSecSys.result.writeToFile(" ");


                  }
                }

                else
                {
                  System.out.println("Error: Wrong file type!");
                  System.exit(1);
                }
         			}     	 	
         	}
       	}
       	catch(Exception ex)
       	{
           System.out.println("Error: "+ex.toString());
		       System.exit(1);
       	} 
    }
}