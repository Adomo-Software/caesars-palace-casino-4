package com.adomasda.Floors;
import com.adomasda.Configuration;
import com.adomasda.Floor;

public class FirstFloor extends Floor {
    public FirstFloor(Configuration configuration) {
        super(configuration.setNumber(1));
    }
}
