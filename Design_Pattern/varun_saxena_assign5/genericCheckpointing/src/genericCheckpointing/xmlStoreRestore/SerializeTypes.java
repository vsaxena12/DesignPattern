package genericCheckpointing.xmlStoreRestore;



public class SerializeTypes
{
    public SerializeTypes(){}

	protected String serializeClass()
	{
		return serializeClass();
	}

	protected String serializeClass(String strIn)
	{
		return "<complexType xsi:type=\"genericCheckpointing.util."+strIn+"\">";
    }


    public String convertToString(String type,
								  Object value)throws RuntimeException
	{
		String output = "";
	    if(type.equals("myInt"))
	    {
			output = serializeMyInt(value);
	    }
	    else if(type.equals("myLong"))
	    {
			output = serializeMyLong(value);
	    }
	    else if(type.equals("myString"))
	    {
			output = serializeMyString(value);
	    }
	    else if(type.equals("myBool"))
	    {
	       output = serializeMyBool(value);
	    }
	    else if(type.equals("myOtherInt"))
	    {
			output = serializeMyOtherInt(value);
	    }
	    else if(type.equals("myOtherLong"))
	    {
			output = serializeMyOtherLong(value);
	    }
	    else if(type.equals("myDoubleT"))
	    {
			output = serializeMyDouble(value);
	    }
	    else if(type.equals("myOtherDoubleT"))
	    {
			output = serializeMyOtherDouble(value);
	    }
	    else if(type.equals("myFloatT"))
	    {
			output = serializeMyFloat(value);
	    }
	    else if(type.equals("myShortT"))
	    {
			output = serializeMyShort(value);
	    }
	    else if(type.equals("myOtherShortT"))
	    {
			output = serializeMyOtherShort(value);
	    }
	    else if(type.equals("myCharT"))
	    {
			output = serializeMyChar(value);
	    }
	    else
	    {
	        throw new RuntimeException("error: unknown type");
	    }
	return output;
    }


    private String serializeMyInt(Object value)
	{
		String s = String.valueOf(value);
		Integer temp = Integer.parseInt(s);
		if (temp >= 10)
			return " <myInt xsi:type=\"xsd:int\">" + (int) value + "</myInt>";
		return "";
	}
    
    private String serializeMyOtherInt(Object value)
	{
		String s = String.valueOf(value);
		Integer temp = Integer.parseInt(s);
		if (temp >= 10)
			return "  <myOtherInt xsi:type=\"xsd:int\">" + (int) value + "</myOtherInt>";
		return "";
	}
    
    private String serializeMyLong(Object value){
		String s = String.valueOf(value);
		Long temp = Long.parseLong(s);
		if (!(temp < 10.0))
			return " <myLong xsi:type=\"xsd:long\">" + temp + "</myLong>";
		return "";
	}

    private String serializeMyOtherLong(Object value){
		String s = String.valueOf(value);
		Long temp = Long.parseLong(s);
		if (!(temp < 10.0))
			return "  <myOtherLong xsi:type=\"xsd:long\">" + temp + "</myOtherLong>";
		return "";
	}
    
    private String serializeMyString(Object value){
		return " <myString xsi:type=\"xsd:string\">"+(String)value+"</myString>";
    }

    private String serializeMyBool(Object value){
		return " <myBool xsi:type=\"xsd:boolean\">"+(Boolean)value+"</myBool>";
    }

    private String serializeMyDouble(Object value){
		String s = String.valueOf(value);
		Double temp = Double.parseDouble(s);
		if (!(temp < 10.0))
			return " <myDoubleT xsi:type=\"xsd:double\">" + temp + "</myDoubleT>";
		return "";
	}

    private String serializeMyOtherDouble(Object value)
	{
		String s = String.valueOf(value);
		Double temp = Double.parseDouble(s);
		if (!(temp < 10.0))
			return "  <myOtherDoubleT xsi:type=\"xsd:double\">" + temp + "</myOtherDoubleT>";
		return "";
	}

    private String serializeMyFloat(Object value){
		return " <myFloatT xsi:type=\"xsd:float\">"+(float)value+"</myFloatT>";
    }

    private String serializeMyShort(Object value){
		return " <myShortT xsi:type=\"xsd:short\">"+value+"</myShortT>";
    }

    private String serializeMyOtherShort(Object value){
		return "  <myOtherShortT xsi:type=\"xsd:short\">"+value+"</myOtherShortT>";
    }

    private String serializeMyChar(Object value){
		return " <myCharT xsi:type=\"xsd:char\">"+value+"</myCharT>";
    }
}