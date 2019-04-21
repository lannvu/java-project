//Lan Vu - 2336.004

package com.company;

/*
Vehicle:    - contain common values between 3 kinds of vehicle
            - contain a common constructor
            - contain a common method to build a vehicle
 */

public class Vehicle {
    protected int spots;
    protected String[] level;

    public Vehicle(){};

    public void build(int spots, String[] level) {  // spots & level are updated
        this.spots = spots;
        this.level = level;
    }

}
