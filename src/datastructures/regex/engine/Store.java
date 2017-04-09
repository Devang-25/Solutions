/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

/**
 *
 * @author gopimac
 */
public class Store {

    private static char[] candidate;

    public static char[] getCandidate() {
        return candidate;
    }

    public static void setCandidate(String candid) {
        candidate = candid.toCharArray();
    }
}
