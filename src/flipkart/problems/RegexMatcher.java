/**
 * 
 */
package flipkart.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author makkg
 *
 */
public class RegexMatcher {
	public static void main(String[] args) {
		char[] regex = "a*b".toCharArray();
		State init = new State();
		int i = 0;
		State currentState = init;
		State previousState = init;
		while (i < regex.length) {
			char c = regex[i];
			if (Character.isAlphabetic(c)) {
				State s = new State();
				currentState.addTransition(regex[i], s);
				previousState = currentState;
				currentState = s;
			} else if (c == '*') {
				currentState.addTransition(regex[i - 1], currentState);
				previousState.eplisonTransition(currentState);
				previousState = currentState;
			} else if (c == '&') {
				State s = new State();
				currentState.addTransition('&', s);
			}
		}
	}
}

class State {
	private Map<Character, State> transition = new HashMap<Character, State>();
	private Set<State> eplisonStates = new HashSet<State>();

	State() {

	}

	public void addTransition(char c, State toState) {
		this.transition.put(c, toState);
	}

	public void addAlphabet() {

	}

	public State transition(char c) {
		if (transition.containsKey(c)) {
			return transition.get(c);
		}
		return null;
	}

	public void eplisonTransition(State s) {
		eplisonStates.add(s);
	}
}
