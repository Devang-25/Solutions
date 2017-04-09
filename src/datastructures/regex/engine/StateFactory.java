/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author gopimac
 */
public class StateFactory {

    private LinkedList<State> list = new LinkedList<>();
    private int stateCode = 0;
    private State finalState;

    public void setFinalState(State finalState) {
        this.finalState = finalState;
    }

    public State getFinalState() {
        return this.finalState;
    }

    public State getNewStateInstance() {
        State newState = new SimpleState(stateCode++);
        this.list.add(newState);
        return newState;
    }

    public Collection<State> getStates() {
        return this.list;
    }
}
