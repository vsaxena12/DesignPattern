package findPrime.util;

import findPrime.primeValues.IsPrime;

public class WorkerThread implements Runnable
{

	FileProcessor fileProcessor;
	Results results;
	IsPrime isPrime;

	private Thread thread;
	public WorkerThread(FileProcessor fp, Results r, IsPrime ip)
	{
		fileProcessor = fp;
		results = r;
		isPrime = ip;

		MyLogger.writeMessage("In WorkerThread Constructor!",
				MyLogger.DebugLevel.CONSTRUCTOR);
	}

	@Override
	public void run()
	{
		thread = Thread.currentThread();

		try {

			String s = fileProcessor.readLineFromFile();

			while (s != null) {

				MyLogger.writeMessage("Running Thread:" + Thread.currentThread().getName(), MyLogger.DebugLevel.THREAD);
				int number = Integer.parseInt(s);
				boolean i = isPrime.isPrime(number);

				if (i)
				{

					MyLogger.writeMessage("Value Inserted:" + number + " by " + Thread.currentThread().getName(), MyLogger.DebugLevel.RESULT);
					results.insertNumber(number);
				}

				s = fileProcessor.readLineFromFile();
			}

		} catch (Exception e) {
			e.printStackTrace();
			MyLogger.writeMessage("Thread " + Thread.currentThread().getName() + " interrupted.", MyLogger.DebugLevel.THREAD);
		}
		MyLogger.writeMessage("Thread " + Thread.currentThread().getName() + " exiting.", MyLogger.DebugLevel.THREAD);
	}
}
