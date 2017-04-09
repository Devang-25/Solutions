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
public interface State extends Cloneable {

    public void addOption(State state);

    public void addTransition(State state, char c);

    public State getTransition(int index);

    public int getStateCode();

    public State applyPLUSClosure(char c);

    public Set<Entry<Character, LinkedList<State>>> getTransitionTable();

    public List<State> getEpsilonList();

    public State epsilonPathTo(State destState);
}
