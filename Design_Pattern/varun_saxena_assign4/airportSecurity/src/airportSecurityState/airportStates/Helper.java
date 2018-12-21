package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import java.util.Vector;
import java.util.HashMap;

/**
 *
 * @author Varun Saxena
 */
public class Helper {
    
    AirportSecuritySystem airport;
    
    int countCustomer = 0;
    int countitems = 0;
    int daysCount = 1;
    int days = 1;
    Vector<String> prohibitedItems=new Vector<String>();
      
    
    public Helper(AirportSecuritySystem air)
    {
        MyLogger.writeMessage("Helper class", MyLogger.DebugLevel.CONSTRUCTOR);
        airport=air;
        prohibitedItems.clear();
        prohibitedItems.add("Grain");
        prohibitedItems.add("NailCutter");
        prohibitedItems.add("Plants");
        prohibitedItems.add("EndangeredAnimals");
    }
    
    public float avgTrafficPerDay(int noOfCust,int totalDays)
    {
        return ((float)noOfCust/totalDays);
    }

    public float avgProhibitedItemsPerDay(int noOfItems,int totalDays)
    {
        return ((float)noOfItems/totalDays);
    }
    
    public void processData(String data)
    {
        HashMap<String,String> result=new HashMap<String,String>();
        countCustomer++;
        String[] customerDetails=data.split(";");
        for(String datas : customerDetails)
        {
            String[]temp=datas.split(":");
            result.put(temp[0], temp[1]);
        }
                
        if(Integer.parseInt(result.get("Day"))!=days)
        {
          daysCount++;
          days=daysCount;
        }
        if(prohibitedItems.contains(result.get("Item")))
        {
          countitems++;
        }
        airport.setCountCustomers(countCustomer);
        airport.setProhibitedItems(countitems);
        airport.setTotalDays(daysCount);      
    }
}