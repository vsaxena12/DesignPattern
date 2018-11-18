/**
 * @author Varun Saxena
 */
package findPrime.util;

import java.util.Vector;

public class Results implements StdoutDisplayInterface
{
	Vector<Integer> primeNumbers;

	public Results()
	{
		MyLogger.writeMessage("In Result's Constructor! Data Structure " +
						"initialized!", MyLogger.DebugLevel.CONSTRUCTOR);
		primeNumbers = new Vector<>();
	}


	public void insertNumber(int num)
	{
		primeNumbers.add(num);
	}

	public int computeSum()
	{
		int sum=0;

		for (int i = 0; i < primeNumbers.size(); i++)
		{
			sum = sum + primeNumbers.get(i);
		}
		return sum;
	}


	@Override
	public void writeSumToScreen()
	{
		int primeSum = computeSum();
		MyLogger.writeMessage("The sum of all the prime numbers is: "+primeSum,
				MyLogger.DebugLevel.OUTPUT);
	}

	public void displayData(){
		for (int i = 0; i < primeNumbers.size(); i++)
		{
			MyLogger.writeMessage("Data Values in DataStructure:"+ primeNumbers.get(i),
					MyLogger.DebugLevel.DATASTRUCTURE);
		}

	}
}