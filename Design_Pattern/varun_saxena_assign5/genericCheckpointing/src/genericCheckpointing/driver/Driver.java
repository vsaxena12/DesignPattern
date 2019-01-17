package genericCheckpointing.driver;

import java.lang.Object;
import java.util.Vector;
import java.util.Random;
import genericCheckpointing.util.*;
import genericCheckpointing.xmlStoreRestore.*;
import genericCheckpointing.server.*;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.visitor.PalindromVisitorImpl;
import genericCheckpointing.visitor.PrimeVisitorImpl;
import genericCheckpointing.util.VectorVerify;

import java.io.IOException;


public class Driver {
	public static String mode = null;
    //public static int NUM_OF_OBJECTS = 0;
    public static FileProcessor fp = null;

    public static void main(String[] args)throws IOException
	{
	try 
	{		
	    if(args.length!=3 && args[0].equals("${arg0}") && args[1].equals("${arg1}") && args[2].equals("${arg2}"))
        {
      		System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
		    System.exit(1);
        }

	    else
	    	{
	    		Vector<SerializableObject> oldVector = new Vector<>();
    			Vector<SerializableObject> newVector = new Vector<>();
	    		VectorVerify verifyVect = new VectorVerify();
	    		VectorVerify.verifyVectors(oldVector, newVector);

	    		Vector<Integer> allTypesFirstInt = new Vector<>();
				Vector<Integer> allTypesSecondInt = new Vector<>();

				Vector<String> allTypesFirstStr = new Vector<>();

	    		mode = args[0]; // mode
	    		int NUM_OF_OBJECTS = Integer.parseInt(args[1]); // number of instances	  
	    		fp = new FileProcessor(args[2]); // file to open

    			//Code by Professor
    			ProxyCreator pc = new ProxyCreator();
    			StoreRestoreHandler handler =  new StoreRestoreHandler(fp);
    			StoreRestoreI cpointRef = pc.createProxy(new Class[]{StoreI.class, RestoreI.class},handler);

    			MyAllTypesFirst myFirst;
    			MyAllTypesSecond  mySecond;
    			
    			Random rand = new Random();

				if (!mode.equals("serdeser"))
				{
					System.out.println("Select Serialization ");
				}

				else
				{
					fp.createWriter();
					int i=0;
					while (i < NUM_OF_OBJECTS)
					{
						int myInt = (rand.nextInt(1000));
						Long myLong = rand.nextLong();

						//String myString = i +"-Design Pattern";
						String myString =
								"a" + (char) (rand.nextInt(26) + 'a') + "cba";
						boolean myBool = true;
						int myOtherInt = (int) (rand.nextInt(1000)*Math.pow(i,2));
						Long myOtherLong = (rand.nextLong()*rand.nextInt(1000));

						if(Math.random() > 0.5)
							myBool = false;

						if(myInt < 10)
							myInt = 0;

						if(myOtherInt < 10)
							myOtherInt = 0;

						if(myLong < 10.0)
						{
							//int cannot convert into long
							String s = "0";
							myLong = Long.parseLong(s);
						}

						if(myOtherLong < 10.0)
						{
							String s = "0";
							myOtherLong = Long.parseLong(s);
						}

						myFirst = new MyAllTypesFirst(myInt,myLong,myString,myBool,myOtherInt,myOtherLong);
						allTypesFirstInt.add(myInt);
						allTypesFirstInt.add(myOtherInt);
						//allTypesFirstInt.add(Math.toIntExact(myLong));
						//allTypesFirstInt.add(Math.toIntExact(myOtherLong));

						allTypesFirstStr.add(myString);

						double myDoubleT = rand.nextDouble() * 1234;
						double myOtherDoubleT = rand.nextDouble()* 4562;//Math.pow(i,2);
						float myFloatT = rand.nextFloat();
						short myShortT = (short) (rand.nextInt(Short.MAX_VALUE + 1)*i);
						short myOtherShortT = (short) (rand.nextInt(Short.MAX_VALUE + 1)*Math.pow(i,2.5));
						char myCharT = (char) (rand.nextInt(26)+'A');

						if(myDoubleT < 10.0)
							myDoubleT = 0.0;

						if(myOtherDoubleT < 10.0)
							myOtherDoubleT = 0.0;

						mySecond = new MyAllTypesSecond(myDoubleT,myOtherDoubleT,myFloatT,myShortT,myOtherShortT,myCharT);
						allTypesSecondInt.add((int) myShortT);
						allTypesSecondInt.add((int) myOtherShortT);

						((StoreI) cpointRef).writeObj(myFirst,13,"XML");
						((StoreI) cpointRef).writeObj(mySecond,17, "XML");
						oldVector.add(myFirst);
						oldVector.add(mySecond);
						i++;
					}
					fp.closeWriter();
					PrimeVisitorImpl pvi = new PrimeVisitorImpl(allTypesFirstInt);
					int numberOfPrimes = pvi.checkVisitorPattern();

					PrimeVisitorImpl pvi2 =
							new PrimeVisitorImpl(allTypesSecondInt);
					int numberOfPrimes2 = pvi2.checkVisitorPattern();

					System.out.println("The number list in myFirst is " + allTypesFirstInt);
					System.out.println("The number of primes in myFirst is " + numberOfPrimes);

					System.out.println("The number list in mySecond is " + allTypesSecondInt);
					System.out.println("The number of primes in mySecond is " + numberOfPrimes2);

					PalindromVisitorImpl palinvis =
							new PalindromVisitorImpl(allTypesFirstStr);
					Vector<String> palindromeStrings =
							palinvis.checkVisitorPattern();

					System.out.println("The String array in myFirst is " + allTypesFirstStr);
					System.out.println("The palindrome stings ([] for null) " +
							"are " + palindromeStrings);
				}

				fp.createReader();
				SerializableObject myRecordRet;
				int j=0;
				while (j<2*NUM_OF_OBJECTS)
				{
					myRecordRet =  ((RestoreI) cpointRef).readObj("XML");
					if (myRecordRet != null)
					{
						newVector.add(myRecordRet);
						j++;
					}

					else
					{
						break;
					}
				}

				if (!mode.equals("serdeser"))
				{
					if (!mode.equals("deser"))
					{
						System.out.println("Invalid mode");
					}
					else
					{
				 		for(SerializableObject tempObj: newVector)
							System.out.println(tempObj.toString());
					}
				}
				else
				{
					if (!VectorVerify.verifyVectors(oldVector, newVector))
					{
						System.out.println("Mismatch found");
					}
					else
					{
						System.out.println("0 mismatched objects");
					}
				}

			fp.closeReader();
   			}

		}

		catch(RuntimeException e)
		{
	    	System.out.println("Error Run time Exception");
	    	System.exit(0);
		}
  	}

}