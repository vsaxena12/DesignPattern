package genericCheckpointing.util;
import java.util.Vector;

public class VectorVerify
{
    public static boolean verifyVectors(Vector<SerializableObject> oVector, Vector<SerializableObject> nVector){
	boolean flag = false;
	int num = 0;
	int NUM_OF_OBJECTS = 0;
		if (oVector.size() <= nVector.size())
		{
			NUM_OF_OBJECTS = oVector.size();
		}
		else
		{
			NUM_OF_OBJECTS = nVector.size();
		}

		int i=0;
		while (i<NUM_OF_OBJECTS)
		{
			if(!oVector.get(i).equals(nVector.get(i)))
			{
				num++;
			}
			i++;
		}

		if (num == 0)
		{
			flag = true;
		}

		else
		{
	    	System.out.println("Number of mismatches: "+num);
		}

		return flag;
    }
}