package findPrime.driver;

import findPrime.primeValues.IsPrime;
import findPrime.util.CreateWorkers;
import findPrime.util.FileProcessor;
import findPrime.util.MyLogger;
import findPrime.util.Results;

/**
 * @author Varun Saxena
 */
public class Driver {
	static int numThreads;
	static int debugValue;
	static String inputFile;

	public static void main(String[] args)throws Exception
	{
		try
		{

			if (args.length != 3 && args[0].equals("${arg0}") && args[1].equals("${arg1}") && args[2].equals("${arg2}")) {

				System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
				System.exit(1);
			}

			if(args.length == 3)
			{
				if(args[0].endsWith(".txt"))
				{
					inputFile = args[0];

					numThreads = Integer.parseInt(args[1]);

					if (numThreads < 1 || numThreads > 5)
					{
						System.out.println("The Number of threads should be " +
								"between 1 and 5!");
						System.exit(1);
					}
					debugValue = Integer.parseInt(args[2]);
					if (debugValue < 0 || debugValue > 4)
					{
						System.out.println("The debug value should be " +
								"between 0 and 4!");
						System.exit(1);
					}

					MyLogger.setDebugValue(debugValue);

					FileProcessor fileProcessor = new FileProcessor(inputFile);
					Results results = new Results();
					IsPrime isPrime = new IsPrime();

					CreateWorkers createWorkers =
							new CreateWorkers(fileProcessor, results, isPrime);
					createWorkers.startWorkers(numThreads);

					results.displayData();
					results.writeSumToScreen();
					fileProcessor.closeFileBuffer();

				}
				else
				{
					System.out.println("Wrong file type!");
					System.exit(1);
				}
			}

		}

		catch(RuntimeException e){
			System.out.println("Error: "+e.toString());
			System.exit(1);
		}
	}
}
