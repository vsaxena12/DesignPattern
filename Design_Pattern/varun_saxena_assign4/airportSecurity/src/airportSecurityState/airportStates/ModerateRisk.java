package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
public class ModerateRisk implements AirportStateI
{

	AirportSecuritySystem airportSystem;
	RiskStates riskState;
      
    
    public ModerateRisk(AirportSecuritySystem newPortCheck )
	{
        airportSystem =newPortCheck;
		riskState = new RiskStates(airportSystem);
        MyLogger.writeMessage("Moderate Risk class",MyLogger.DebugLevel.CONSTRUCTOR);
    }
        
    @Override
    public AirportStateI SecurityState(Helper cal)
	{
    	AirportStateI state= airportSystem.getCurrentState();

    	float avgTraffPDay=cal.avgTrafficPerDay(airportSystem.getCountCustomers(),
                airportSystem.getTotalDays());
        float probItemsPDay=cal.avgProhibitedItemsPerDay(airportSystem.getProhibitedItems(),
                airportSystem.getTotalDays());

     	if(state instanceof ModerateRisk)
     	{
			state = riskState.getRiskState(avgTraffPDay, probItemsPDay, riskState.highOperationID,
					airportSystem,
					riskState.moderateOperationID, riskState.lowOperationID);
	 	}
     
    	return state;
    }
}