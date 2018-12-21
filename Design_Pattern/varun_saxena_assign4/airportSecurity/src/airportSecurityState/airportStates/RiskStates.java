package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class RiskStates
{
	AirportSecuritySystem airportSystem;

	String lowOperationID="1 3 5 7 9";
	String moderateOperationID="2 3 5 8 9";
	String highOperationID="2 4 6 8 10";

	public RiskStates(AirportSecuritySystem ass)
	{
		airportSystem=ass;
		MyLogger.writeMessage("Risk States class",
				MyLogger.DebugLevel.CONSTRUCTOR);
	}

	static AirportStateI getRiskState(float avgTraffPDay, 
									  float probItemsPDay, 
									  String highOperation, 
									  AirportSecuritySystem airpotSystem, 
									  String moderateOperation, 
									  String lowOperation)
	{
		AirportStateI state;
		if((avgTraffPDay>=8)||(probItemsPDay>=4))
		{
			MyLogger.writeMessage(highOperation, MyLogger.DebugLevel.CONSOLE);
			airpotSystem.result.storeNewResult(highOperation);
			state= airpotSystem.getStateHighRisk();

		}
		else if((avgTraffPDay>=4&&avgTraffPDay<8)||(probItemsPDay>=2&&probItemsPDay<4))
		{
			MyLogger.writeMessage(moderateOperation, MyLogger.DebugLevel.CONSOLE);
			airpotSystem.result.storeNewResult(moderateOperation);
			state= airpotSystem.getStateModerateRisk();
		}
		else if((avgTraffPDay>=0&&avgTraffPDay<4)||(probItemsPDay>=0&&probItemsPDay<2))
		{
			MyLogger.writeMessage(lowOperation, MyLogger.DebugLevel.CONSOLE);
			airpotSystem.result.storeNewResult(lowOperation);
			state= airpotSystem.getStateLowRisk();
		}
		else
		{
			throw new UnsupportedOperationException("Unknown value!");
		}
		return state;
	}
}
