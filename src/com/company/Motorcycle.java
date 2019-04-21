//Lan Vu - 2336.004

package com.company;

/*
Motorcycle:    - contain motorcycle parking/removing method
 */

public class Motorcycle extends Vehicle {

    public boolean park() { // return false if park failed

        for (int i = 0; i < spots; i++) {
            if (level[i] == "m" || level[i] == "c" || level[i] == "l") {
                level[i] = "M";
                System.out.print("Parking a Motorcycle\n");
                return true;
            }
        }
        return false;
    }

    public boolean remove(int numL, int numM) { // return false if remove failed, numL & numM is used as index to find type of vehicle
        for (int i = 0; i < spots; i++) {
            if (level[i] == "M") {
                if (i < numL) level[i] = "l";
                else if (i > spots - numM - 1) level[i] = "m";
                else level[i] = "c";

                return true;
            }
        }
        return false;
    }
}