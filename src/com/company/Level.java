/*Lan Vu - 2336.004

User manual:
-   Compile & run
-	Enter # spots per level
-	Enter # levels
-	To park, enter 1 for Bus, 2 for Car, 3 for Motorcycle
-	To remove, enter its number 2 times (e.g 11 for Bus)
-	Program ends only after all spots are parked

*/
package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
Level:  - represent a level in a parking lot
        - create new level
        - display a level
 */

public class Level {

    private int spots;
    private String[] level; // level is a string array, each position is a parking spot
    private int numL;   // # large spots
    private int numM;   // # motorcycle spots

    public boolean isFull() {   // return true if level is full
        boolean allFull = true;
        for (int i = 0; i < spots; i++) {
            if (level[i] == "c" || level[i] == "l" || level[i] == "m") allFull = false;
        }
        return allFull;
    }

    public Level(int spots) {   // instantiate a level, spots = # spots per level

        this.spots = spots;

        String[] level = new String[spots];
        int numL = (spots/10)*2;    // = 20% spots
        int numM = (spots/10)*2;

        this.numM = numM;
        this.numL = numL;

        for (int i = 0; i < numL; i++) {
            level[i] = "l";
        }

        for (int i = numL; i < spots - numM; i++) {
            level[i] = "c";
        }

        for (int i = spots - numM; i < spots; i++) {
            level[i] = "m";
        }

        this.level = level;
    }

    public void printLevel() {  // divide level to 3 rows & display
        for (int i = 0; i < spots/3; i++) {
            System.out.print(level[i]);
        }
        System.out.print(" ");

        for (int i = spots/3; i < (spots*2)/3; i++) {
            System.out.print(level[i]);
        }
        System.out.print(" ");

        for (int i = (spots*2)/3; i < spots; i++) {
            System.out.print(level[i]);
        }
        System.out.print("\n");
    }

    public boolean park(int num){   // create a vehicle and park/remove it, num is user input, return false if park failed

            if (num == 1) {
                Bus bus = new Bus();
                bus.build(spots, level);
                return bus.park();

            } else if (num == 2) {
                Car car = new Car();
                car.build(spots, level);
                return car.park();

            } else if (num == 3) {
                Motorcycle motorcycle = new Motorcycle();
                motorcycle.build(spots, level);
                return motorcycle.park();

            } else if (num == 11) {
                Bus bus = new Bus();
                bus.build(spots, level);
                return bus.remove();

            } else if (num == 22) {
                Car car = new Car();
                car.build(spots, level);
                return car.remove(this.numL);

            } else if (num == 33) {
                Motorcycle motorcycle = new Motorcycle();
                motorcycle.build(spots, level);
                return motorcycle.remove(this.numL, this.numM);
            }
        return false;
    }
}
