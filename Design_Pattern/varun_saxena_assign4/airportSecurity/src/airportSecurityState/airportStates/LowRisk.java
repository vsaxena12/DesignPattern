
package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class LowRisk implements AirportStateI {

    AirportSecuritySystem airportSystem;
    RiskStates riskState;
    
    
    public LowRisk(AirportSecuritySystem newPortCheck )
    {
        airportSystem =newPortCheck;
        riskState = new RiskStates(airportSystem);
        MyLogger.writeMessage("Low Risk class",MyLogger.DebugLevel.CONSTRUCTOR);

    }

    @Override
    public AirportStateI SecurityState(Helper cal)
    {
        AirportStateI state= airportSystem.getCurrentState();

        float avgTraffPDay=cal.avgTrafficPerDay(airportSystem.getCountCustomers(),
                airportSystem.getTotalDays());
        float probItemsPDay=cal.avgProhibitedItemsPerDay(airportSystem.getProhibitedItems(),
                airportSystem.getTotalDays());

        if(state instanceof LowRisk)
        {
            state = riskState.getRiskState(avgTraffPDay, probItemsPDay, riskState.highOperationID,
                    airportSystem,
                    riskState.moderateOperationID, riskState.lowOperationID);
        }
     
        return state;
    }
}
