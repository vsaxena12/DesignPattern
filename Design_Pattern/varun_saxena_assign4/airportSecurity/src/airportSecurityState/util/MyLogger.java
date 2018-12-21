/**
 * @author Varun Saxena
 *
 */
package airportSecurityState.util;

public class MyLogger 
{
    private static DebugLevel debugLevel;
   
    public static enum DebugLevel {OUTPUT, DATASTRUCTURE, RESULT, CONSOLE, CONSTRUCTOR, IN_RUN};
        
    public static void setDebugValue (int levelIn) 
    {
	   switch (levelIn) 
      {
        case 0:
          debugLevel = DebugLevel.OUTPUT;
          break;
        case 1:
          debugLevel = DebugLevel.DATASTRUCTURE;
          break;
        case 2:
          debugLevel = DebugLevel.RESULT;
          break;
        case 3:
          debugLevel = DebugLevel.CONSOLE;
          break;
        case 4:
          debugLevel = DebugLevel.CONSTRUCTOR;
          break;
        case 5:
          debugLevel = DebugLevel.IN_RUN;
	    }
    }
      
    public static void setDebugValue (DebugLevel levelIn) {
	     debugLevel = levelIn;
    }
      
    public static void writeMessage (String  message, DebugLevel levelIn ) 
    {
	    if (levelIn == debugLevel)
      {
	     System.out.println(message);
      }
    }

    public static void writeOutput(){
      System.out.println(debugLevel);
    }

    public String toString() {
      return "The debug level has been set to the following " + debugLevel;
    }     
}