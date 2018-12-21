
package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;


public class AirportSecuritySystem
{
    private AirportStateI lowRisk;
    private AirportStateI modRisk;
    private AirportStateI highRisk;
    private AirportStateI currState;
    private int custCount=0,probItems,totaldays=0;
    public Results result;

    public AirportSecuritySystem(Results r)
    {
        lowRisk=new LowRisk(this);
        modRisk=new ModerateRisk(this);
        highRisk=new HighRisk(this);
        currState=lowRisk;
        result=r;
        MyLogger.writeMessage("AirportSecuritySystem class",MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public int getTotalDays() { return totaldays; }
    public int getCountCustomers() { return custCount; }
    public int getProhibitedItems() { return probItems; }

    public void setTotalDays(int count) { totaldays=count; }
    public void setCountCustomers(int count) { custCount=count; }
    public void setProhibitedItems(int count) { probItems=count; }

    public AirportStateI getStateLowRisk() { return lowRisk; }
    public AirportStateI getStateModerateRisk() { return modRisk; }
    public AirportStateI getStateHighRisk() { return highRisk; }
    public AirportStateI getCurrentState() { return currState; }
}
