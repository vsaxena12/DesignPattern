package genericCheckpointing.xmlStoreRestore;

import java.io.IOException;

import java.lang.reflect.Field;
import genericCheckpointing.util.SerStrategyI;
import genericCheckpointing.util.FileProcessor;

public class XMLSerialization implements SerStrategyI
{
    private FileProcessor fileProcessor;
    SerializeTypes serializeT;

    public XMLSerialization(FileProcessor fpIn){
		this.fileProcessor = fpIn;
		serializeT = null;
		this.serializeT = new SerializeTypes();
    }


    @Override
	public void processInput(Object obj)throws IllegalArgumentException,
			IllegalAccessException, IOException
	{
	    Class className = obj.getClass();
	    fileProcessor.writeLine("<DPSerialization>");
	    fileProcessor.writeLine(serializeT.serializeClass(className.getSimpleName()));
	    Field[] fields = className.getDeclaredFields();
		int i=0;
		while (true)
		{
			if (i >= fields.length) break;
			String type = fields[i].getName();
			fields[i].setAccessible(true);
			Object val = fields[i].get(obj);
			fileProcessor.writeLine(serializeT.convertToString(type,val));
			i++;
		}
		fileProcessor.writeLine("</complexType>");
	    fileProcessor.writeLine("</DPSerialization>");

    }
}
