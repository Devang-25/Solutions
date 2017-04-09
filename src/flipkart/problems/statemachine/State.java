package flipkart.problems.statemachine;

import java.util.HashMap;
import java.util.Map;

public class State {
	private final Map<Event, State> transitionT = new HashMap<Event, State>();
	private int events = 0;
	private final String name;
	private boolean isFinal;

	public State(String name) {
		this.name = name;
	}

	public State(String name, boolean isFinal) {
		this.name = name;
		this.isFinal = isFinal;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void addTransition(Event e, State state) {
		transitionT.put(e, state);
	}

	public State transit(Event e) {
		if (transitionT.containsKey(e)) {
			return transitionT.get(e);
		}
		return this;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
