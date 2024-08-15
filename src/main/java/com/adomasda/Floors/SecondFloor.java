package com.adomasda.Floors;
import com.adomasda.Configuration;
import com.adomasda.Floor;

public class SecondFloor extends Floor {
    public SecondFloor(Configuration configuration) {
        super(configuration.setNumber(2));
    }
}
