package genericCheckpointing.util;

import java.io.IOException;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategyI
{
    public void processInput(Object obj)throws IllegalArgumentException,
            IllegalAccessException, IOException;
}
