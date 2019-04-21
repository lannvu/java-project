//Lan Vu - 2336.004

package com.company;

/*
Car:    - contain car parking/removing method
 */

public class Car extends Vehicle {

    public boolean park() { // return false if park failed

        boolean available = false;
        for (int i = 0; i < spots; i++) {
            if (level[i] == "c" || level[i] == "l") available = true;
        }

        if (available) {
            for (int i = 0; i < spots; i++) {
                if (level[i] == "c" || level[i] == "l") {
                    level[i] = "C";
                    System.out.print("Parking a Car\n");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean remove(int numL) {   // return false if remove failed, numL is used as index to find type of vehicle
        for (int i = 0; i < spots; i++) {
            if (level[i] == "C") {
                if (i > numL - 1) level[i] = "c";
                else level[i] = "l";

                return true;
            }
        }
        return false;
    }
}