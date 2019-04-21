//Lan Vu - 2336.004

package com.company;

/*
Bus:    - contain bus parking/removing method
 */

public class Bus extends Vehicle{

    public boolean park(){  // return false if park failed
        boolean available = false;
        for (int i = 0; i < spots; i++) {
            if (level[i] == "l") available = true;
        }

        if (available) {
            for (int i = 0; i < spots; i++) {
                if (level[i] == "l") {
                    boolean enough = true;

                    for (int k = i; k < i + 5; k++) {   // check if 5 consecutive spots are large
                        if (level[k] != "l") {
                            enough = false;
                        }
                    }
                    if (enough) {
                        for (int j = i; j < i + 5; j++) {
                            level[j] = "B";
                        }
                        System.out.print("Parking a Bus\n");
                        return true;
                    } else return false;
                }
            }
        }
        return false;
    }

    public boolean remove() {   // return false if remove failed
        for (int i = 0; i < spots; i++) {
            if (level[i] == "B") {
                for (int j = i; j < i + 5; j++) {
                    level[j] = "l";
                }
                return true;
            }
        }
        return false;
    }
}
