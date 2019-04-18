/*
 * Creation : 15 avr. 2019
 */
package Methodes;

public class Wait {

    public static void Wait(int Dur) {
        try {
            Thread.sleep(Dur);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

}
