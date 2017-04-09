/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author gopimac
 */
public class GroupState implements State {

    private State startState, finalState;

    public GroupState() {
        System.out.println("New group State created");
        startState = finalState = null;
    }

    public State getFinalState() {
        return finalState;
    }

    public void setFinalState(State finalState) {
        if (finalState instanceof GroupState) {
            this.finalState = ((GroupState) finalState).getFinalState();
        } else {
            this.finalState = finalState;
        }
    }

    public State getStartState() {
        return startState;
    }

    public void setStartState(State startState) {
        this.startState = startState;
    }

    @Override
    public void addOption(State state) {
        this.finalState.addOption(state);
    }

    @Override
    public void addTransition(State state, char c) {
        this.finalState.addTransition(state, c);
    }

    @Override
    public State getTransition(int c) {
        return this.startState.getTransition(c);
    }

    @Override
    public int getStateCode() {
        return this.startState.getStateCode();
    }

    @Override
    public String toString() {
        return this.startState + ";" + this.finalState;
    }

    @Override
    public State applyPLUSClosure(char c) {
        System.out.println(this);
        State newState = Singleton.getFactoryInstance().getNewStateInstance();
        System.out.println("f-----" + this.finalState);
        this.finalState.addOption(newState);
        for (Entry<Character, LinkedList<State>> e : this.startState.getTransitionTable()) {
            for (State state : e.getValue()) {
                newState.addTransition(state, e.getKey());
            }
        }
        List<State> epsilonList = this.startState.getEpsilonList();
        for (State s : epsilonList) {
            newState.addOption(s);
        }
        return newState;
    }

    @Override
    public State epsilonPathTo(State destState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<State> getEpsilonList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<Character, LinkedList<State>>> getTransitionTable() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
