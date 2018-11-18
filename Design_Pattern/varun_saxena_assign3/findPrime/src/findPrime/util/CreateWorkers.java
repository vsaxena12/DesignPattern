package findPrime.util;

import findPrime.primeValues.IsPrime;

public class CreateWorkers
{
	FileProcessor fileProcessor;
	Results results;
	IsPrime isPrime;

	public CreateWorkers(FileProcessor fp, Results r, IsPrime ip)
	{
		this.fileProcessor = fp;
		this.results = r;
		this.isPrime = ip;

		MyLogger.writeMessage("In CreateWorker Constructor!",
				MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void startWorkers(int numThreads) throws InterruptedException
	{
		Thread [] thread = new Thread[numThreads];

		for (int i = 0; i < numThreads; i++)
		{
			thread[i] = new Thread(new WorkerThread(fileProcessor, results,
					isPrime));
			thread[i].setName("Thread"+i);
			thread[i].start();
			MyLogger.writeMessage("Created "  + i + " Thread:",
					MyLogger.DebugLevel.THREAD);


		}

		for(int i = 0; i < thread.length; i++)
		{
			thread[i].join();
		}
	}
}
