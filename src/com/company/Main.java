//Lan Vu - 2336.004

package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
Main:   - ask user for input
        - check input
        - display parking lot
 */


public class Main {

    public static void main(String arg[]) { // parameter is not used
        Scanner input = new Scanner(System.in);

        System.out.print("Enter # spots per level (recommend >= 30): ");
        while (!input.hasNextInt()) input.next();   // do nothing if not int
        int spots = input.nextInt();

        System.out.print("Enter # levels: ");
        while (!input.hasNextInt()) input.next();
        int total = input.nextInt();

        Level[] levels = new Level[total];      // create an array of Level objects


        for (int i = 0; i < total; i++) {
            levels[i] = new Level(spots);       // call level constructor
            System.out.print("Level " + Integer.toString(i) + ": ");
            levels[i].printLevel();
        }

        boolean full = false;

        while(!full) {      // loop until all parking spaces are full
            System.out.print("\nTo park, enter 1 for Bus, 2 for Car, 3 for Motorcycle.\n"); // display instructions
            System.out.print("To remove a vehicle, enter its number 2 times (e.g 11 for Bus):\n");
            Scanner choice = new Scanner(System.in);
            while (!choice.hasNextInt()) choice.next();
            int num = choice.nextInt();

            boolean noSpace = true;
            for (int i = 0; i < total; i++) {
                boolean parked = levels[i].park(num);
                if (parked) {
                    noSpace = false;    // check if no space left for that vehicle type
                    break;
                }
            }

            if (noSpace) System.out.print("Parking/Removing Failed. Final state:\n");

            for (int i = 0; i < total; i++) {
                System.out.print("Level " + Integer.toString(i) + ": ");
                levels[i].printLevel();
            }

            boolean allFull = true;
            for (int i = 0; i < total; i++) {
                allFull = levels[i].isFull();
                if(!allFull) break;     // check if all parking spaces are full
            }

            full = allFull;

        }

        System.out.print("\nThe parking lot is now full\n");



    }


}
