package genericCheckpointing.util;

import java.util.Random;

public class MyAllTypesSecond extends SerializableObject
{
    private double myDoubleT;
    private double myOtherDoubleT;
    private float myFloatT;
    private short myShortT;
    private short myOtherShortT;
    private char myCharT;

    public MyAllTypesSecond(){}

    public MyAllTypesSecond(double myDoubleT, double myOtherDoubleT, float myFloatT, short myShortT, short myOtherShortT, char myCharT){
		this.myDoubleT = myDoubleT;
		this.myOtherDoubleT = myOtherDoubleT;
		this.myFloatT = myFloatT;
		this.myShortT = myShortT;
		this.myOtherShortT = myOtherShortT;
		this.myCharT = myCharT;
    }

    public double getMyDoubleT(){
		return myDoubleT;
    }

    public double getMyOtherDoubleT(){
		return myOtherDoubleT;
    }
    
    public float getMyFloatT(){
		return myFloatT;
    }

    public short getMyShortT(){
		return myShortT;
    }

    public short getMyOtherShortT(){
		return myOtherShortT;
    }
    
    public char getMyCharT(){
		return myCharT;
    }

    public void setMyDoubleT(double myDoubleTIn){
		this. myDoubleT = myDoubleTIn;
    }

    public void setMyOtherDoubleT(double myOtherDoubleTIn){
		this. myOtherDoubleT = myOtherDoubleTIn;
    }
    
    public void setMyFloatT(float myFloatTIn){
		this. myFloatT = myFloatTIn;
    }

    public void setMyShortT(short myShortTIn){
		this. myShortT = myShortTIn;
    }
    
    public void setMyOtherShortT(short myOtherShortTIn){
        this.myOtherShortT = myOtherShortTIn;
    }
    
    public void setMyCharT(char myCharTIn){
		this.myCharT = myCharTIn;
    }

    @Override
    public String toString(){
		String temp = "myDoubleT: "+myDoubleT+" | myOtherDoubleT: "+myOtherDoubleT+" | myFloatT: "+myFloatT+" | myShortT: "+myShortT+" | myOtherShortT: "+myOtherShortT+" | myCharT: "+myCharT+"\n";
		return temp;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MyAllTypesSecond temp = (MyAllTypesSecond) obj;
	if (myCharT != temp.getMyCharT())
	    return false;
	if (Double.doubleToLongBits(myDoubleT) != Double
	    .doubleToLongBits(temp.getMyDoubleT()))
	    return false;
	if (Double.doubleToLongBits(myOtherDoubleT) != Double
	    .doubleToLongBits(temp.getMyOtherDoubleT()))
	    return false;
	if (Float.floatToIntBits(myFloatT) != Float
	    .floatToIntBits(temp.getMyFloatT()))
	    return false;
	if (myShortT != temp.getMyShortT())
	    return false;
	if (myOtherShortT != temp.getMyOtherShortT())
	    return false;
	return true;
    }

    @Override
    public int hashCode(){
		final int pcode = 107;
		int entry = 1;
		entry = (int) (entry + pcode * myDoubleT);
		entry = (int) (entry + pcode * myOtherDoubleT / 1000);
		entry = (int) (entry + (myFloatT + pcode * myShortT));
		entry = pcode * entry + myOtherShortT;
		entry = pcode * myCharT + entry;
		return entry;	
    }   
}