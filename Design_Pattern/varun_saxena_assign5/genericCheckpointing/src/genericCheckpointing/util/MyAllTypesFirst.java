package genericCheckpointing.util;

import java.util.Random;

public class MyAllTypesFirst extends SerializableObject
{
    private int myInt;
    private long myLong;
    private String myString;
    private boolean myBool;
    private int myOtherInt;
    private long myOtherLong;


    public MyAllTypesFirst(){}


    public MyAllTypesFirst(int myInt,Long myLong,String myString,boolean myBool,int myOtherInt,Long myOtherLong){
		this.myInt = myInt;
		this.myLong = myLong;
		this.myString = myString;
		this.myBool = myBool;
		this.myOtherInt = myOtherInt;
		this.myOtherLong = myOtherLong;
    }

    public int getMyInt()
	{
		return myInt;
    }

    public long getMyLong()
	{
		return myLong;
    }

    public String getMyString()
	{
		return myString;
    }

    public boolean getMyBool()
	{
		return myBool;
    }

    public int getMyOtherInt()
	{
		return myOtherInt;
    }

    public long getMyOtherLong()
	{
		return myOtherLong;
    }

    public void setMyInt(int myIntIn)
	{
		this.myInt = myIntIn;
    }

    public void setMyLong(long myLongIn)
	{
		this.myLong = myLongIn;
    }

    public void setMyString(String myStringIn) {
	this.myString = myStringIn;
    }


    public void setMyBool(boolean myBoolIn) {
	this.myBool = myBoolIn;
    }


    public void setMyOtherInt(int myOtherIntIn){
	this.myOtherInt = myOtherIntIn;
    }


    public void setMyOtherLong(long myLongOtherIn) {
	this.myOtherLong = myLongOtherIn;
    }


    @Override
    public String toString(){
	String tempEntry =
			"myInt: "+myInt+" -> myLong: "+myLong+" -> myString: "+myString+
					" " +
					"-> myBool: "+myBool+" -> myOtherInt: "+myOtherInt+" -> " +
					"myOtherLong: "+myOtherLong+"\n";
	return tempEntry;
    }

    @Override
    public boolean equals(Object obj){
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;

	MyAllTypesFirst entry = (MyAllTypesFirst) obj;
	if (myBool != entry.getMyBool())
	    return false;
	if (myInt != entry.getMyInt())
	    return false;
	if(myOtherInt != entry.getMyOtherInt())
	    return false;
	if (myLong != entry.getMyLong())
	    return false;
	if(myOtherLong != entry.getMyOtherLong())
	if (myString == null) {
	    if (entry.getMyString() != null)
		return false;
	} else if (!myString.equals(entry.getMyString()))
	    return false;
	return true;
    }


    @Override
    public int hashCode(){
	final int pcode = 107;
	int entry = 1;
		entry = entry + pcode * myInt;
		entry = (pcode * entry) - (myBool ? -10 : 10);
		entry = entry + (myOtherInt + pcode * myString.length());
		entry = (int) (entry + (myLong >> 16));
		entry = (int) (entry + Math.pow(entry, myOtherLong << 2) * pcode);
	return entry;
    }
    
}
