/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author gopimac
 */
public class SimpleState implements State {

    private Map<Character, LinkedList<State>> transitionTable;
    private LinkedList<State> optionList;
    private int stateCode = 0;
    boolean cycle = false;
    int savedIndex = Integer.MAX_VALUE;

    private SimpleState() {
    }
//yet to find where the match occurs...

    public SimpleState(int stateVode) {
        this.stateCode = stateVode;
        this.transitionTable = new HashMap<>();
        this.optionList = new LinkedList<>();
        System.out.println("State with id " + this.stateCode + " created.");
    }

    @Override
    public void addOption(State state) {
        this.optionList.add(state);
    }

    @Override
    public void addTransition(State state, char c) {
        List<State> list = this.transitionTable.get(c);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(state);
        this.transitionTable.put(c, (LinkedList<State>) list);
    }

    @Override
    public State getTransition(int index) {
        System.out.print(this);
        if (index < Store.getCandidate().length) {
            if (savedIndex != index) {
                savedIndex = index;
                char ch = Store.getCandidate()[index];
                System.out.println(" is given " + ch);
                List<State> nextState = this.transitionTable.get(ch);
                if (nextState == null) {
                    //continue here..
                    System.out.println("Transition not found:");
                    for (State c : this.optionList) {
                        System.out.println("Trying epsilon:" + c);
                        State s = c.getTransition(index);
                        if (s != null) {
                            return s;
                        }
                    }
                    return null;
                } else {
                    for (State nxtSt : nextState) {
                        System.out.println("going to " + nxtSt);
                        State dest = nxtSt.getTransition(index + 1);
                        System.out.println(this + " Destination returned is " + dest);
                        if (dest != null) {
                            System.out.println("dest is not null is " + dest);
                            if (dest == Singleton.getFactoryInstance().getFinalState()) {
                                return dest;
                            }
                            System.out.println("going the epsilon path...");
                            State s = dest.epsilonPathTo(Singleton.getFactoryInstance().getFinalState());
                            if (s == Singleton.getFactoryInstance().getFinalState()) {
                                return s;
                            }
                        } else {
                            for (State st : this.optionList) {
                                State temp = st.getTransition(index);
                                if (temp != null) {
                                    if (temp == Singleton.getFactoryInstance().getFinalState()) {
                                        return temp;
                                    }
                                }
                                //risk here
                            }
                        }
                    }
                    return null;
                }
            } else {
                return null;
            }
        }
        return this.epsilonPathTo(Singleton.getFactoryInstance().getFinalState());
    }

    @Override
    public int getStateCode() {
        return this.stateCode;
    }

    @Override
    public String toString() {
        String ret = "" + this.stateCode + ": ";
        Set<Entry<Character, LinkedList<State>>> entrySet = this.transitionTable.entrySet();
        for (Entry<Character, LinkedList<State>> entry : entrySet) {
            ret += "{" + entry.getKey() + ":";
            for (State t : entry.getValue()) {
                ret += t.getStateCode() + ",";
            }
            ret += "}";
        }
        for (State s : this.optionList) {
            ret += "{$ ," + s.getStateCode() + "}";
        }
        return ret;
    }

    @Override
    public State applyPLUSClosure(char c) {
        State newState = Singleton.getFactoryInstance().getNewStateInstance();
        this.addOption(newState);
        newState.addTransition(this, c);
        return newState;
    }

    @Override
    public Set<Entry<Character, LinkedList<State>>> getTransitionTable() {
        return this.transitionTable.entrySet();
    }

    @Override
    public State epsilonPathTo(State destState) {
        System.out.println("cur " + this);
        System.out.println((cycle) ? true : "");
        if (!cycle) {
            cycle = true;
            if (this == destState) {
                return destState;
            }
            for (State i : this.optionList) {
                System.out.println("Trying path :" + i);
                if (i.epsilonPathTo(destState) == destState) {
                    return destState;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public List<State> getEpsilonList() {
        //check for consistency of cycle..
        return this.optionList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Object();
    }
}
