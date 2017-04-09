/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

/**
 *
 * @author gopimac
 */
public class Singleton {

    private static StateFactory factory = new StateFactory();

    private Singleton() {
    }

    public static StateFactory getFactoryInstance() {
        return factory;
    }
}
