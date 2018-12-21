package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Method;
import java.util.regex.Pattern;
import java.io.IOException;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;

public class DeserializeTypes
{
    private FileProcessor fileproc;

    public DeserializeTypes(FileProcessor fIn){
		this.fileproc = fIn;
    }

    public SerializableObject createObject() throws IOException
	{
	boolean updateFlag = true;
	Class<?> cls = null;
	SerializableObject obj = null;
	Method method = null;
	String line = "";
	while((line=fileproc.readLine()) != null){
		if (!line.equals("<DPSerialization>") || updateFlag)
		{
			if (line.equals("</DPSerialization>") && updateFlag)
			{
				updateFlag = false;
				break;
			}

			if (updateFlag)
			{
				try
				{
					if (line.contains("complexType") && !line.contains("/"))
					{
						String clsType = getxsiType(line);
						cls = Class.forName(clsType);
						obj = (SerializableObject) cls.newInstance();
					} else if (line.contains("myInt"))
					{
						method = cls.getDeclaredMethod("setMyInt", int.class);
						method.invoke(obj, Integer.parseInt(dataExtract(line)));
					} else if (line.contains("myLong"))
					{
						method = cls.getDeclaredMethod("setMyLong", long.class);
						method.invoke(obj, Long.parseLong(dataExtract(line)));
					} else if (line.contains("myString"))
					{
						method = cls.getDeclaredMethod("setMyString", String.class);
						method.invoke(obj, dataExtract(line));
					} else if (line.contains("myBool"))
					{
						method = cls.getDeclaredMethod("setMyBool", boolean.class);
						method.invoke(obj, Boolean.parseBoolean(dataExtract(line)));
					} else if (line.contains("myOtherInt"))
					{
						method = cls.getDeclaredMethod("setMyOtherInt", int.class);
						method.invoke(obj, Integer.parseInt(dataExtract(line)));
					} else if (line.contains("myOtherLong"))
					{
						method = cls.getDeclaredMethod("setMyOtherLong", long.class);
						method.invoke(obj, Long.parseLong(dataExtract(line)));
					} else if (line.contains("myDoubleT"))
					{
						method = cls.getDeclaredMethod("setMyDoubleT", double.class);
						method.invoke(obj, Double.parseDouble(dataExtract(line)));
					} else if (line.contains("myOtherDoubleT"))
					{
						method = cls.getDeclaredMethod("setMyOtherDoubleT", double.class);
						method.invoke(obj, Double.parseDouble(dataExtract(line)));
					} else if (line.contains("myFloatT"))
					{
						method = cls.getDeclaredMethod("setMyFloatT", float.class);
						method.invoke(obj, Float.parseFloat(dataExtract(line)));
					} else if (line.contains("myShortT"))
					{
						method = cls.getDeclaredMethod("setMyShortT", short.class);
						method.invoke(obj, Short.parseShort(dataExtract(line)));
					} else if (line.contains("myOtherShortT"))
					{
						method = cls.getDeclaredMethod("setMyOtherShortT", short.class);
						method.invoke(obj, Short.parseShort(dataExtract(line)));
					} else if (line.contains("myCharT"))
					{
						method = cls.getDeclaredMethod("setMyCharT", char.class);
						method.invoke(obj, (dataExtract(line)).charAt(0));
					}
				} catch (Exception e)
				{
					System.out.println("Handle Exception MyAllTypesFirst");
					System.exit(0);
				}
			}
		} else
		{
			updateFlag = true;
		}
	}
	return obj;
    }

    //Helper
    private String getxsiType(String strIn)
    {
		String[] temp = strIn.split("=");
		String output = temp[1].replace("\"","");
		return output.replace(">", "");
    }

	private String dataExtract()
	{
		return dataExtract();
	}

	private String dataExtract(String strIn)
    {
		String output = "";
		boolean flag = false;
		int i=0;
		while (true)
		{
			if (i >= strIn.length() - 1) break;
			char temp = strIn.charAt(i);
			if (strIn.charAt(i) == '>' && !flag)
			{
				flag = true;
				i++;
			}
			else
			{
				if (strIn.charAt(i) == '<' && flag)
				{
					flag = false;
					break;
				}
				if (flag)
				{
					output += temp;
				}
				i++;
			}
		}
		return output;
    }
}
