package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerStrategyI;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class StoreRestoreHandler implements InvocationHandler
{
    FileProcessor fProcessor;
    DeserializeTypes deserializeT;

    public StoreRestoreHandler(FileProcessor fpIn)
	{
		this.fProcessor = fpIn;
		deserializeT = new genericCheckpointing.xmlStoreRestore.DeserializeTypes(fpIn);
    }

    public void serializeData(Object sObj,
							  SerStrategyI strategy)throws IllegalAccessException, IOException
	{
	    strategy.processInput(sObj);
	}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		Object tempObj = null;
		if (!method.getName().equals("writeObj"))
		{
			if (!method.getName().equals("readObj"))
			{
				return tempObj;
			}
			tempObj = deserializeT.createObject();
		}
		else
		{
			if (!args[2].equals("XML"))
			{
				return tempObj;
			}
			serializeData(args[0],new XMLSerialization(fProcessor));
		}
		return tempObj;
    }
}
