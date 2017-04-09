package flipkart.problems.statemachine;

public class StateMachine {

	private final State[] states;

	public StateMachine(State... states) {
		this.states = states;
		init = this.states[0];
	}

	private State init;

	public static void main(String[] args) {
		State start = new State("start", true);
		State wash = new State("wash");
		State rinse = new State("rinse");
		State spin = new State("spin");
		State stop = new State("stop");
		stop.addTransition(Event.SWITCHED_ON, start);
		start.addTransition(Event.WASH_BUTTON_PRESSED, wash);
		start.addTransition(Event.RINSE_BUTTON_PRESSED, rinse);
		start.addTransition(Event.SPIN_BUTTON_PRESSED, spin);
		start.addTransition(Event.POWER_FAILURE, stop);
		wash.addTransition(Event.TIME_OUT, rinse);
		rinse.addTransition(Event.TIME_OUT, spin);
		spin.addTransition(Event.TIME_OUT, start);
		wash.addTransition(Event.POWER_FAILURE, stop);
		rinse.addTransition(Event.POWER_FAILURE, stop);
		spin.addTransition(Event.POWER_FAILURE, stop);
		wash.addTransition(Event.STOP_BUTTON_PRESSED, start);
		rinse.addTransition(Event.STOP_BUTTON_PRESSED, start);
		spin.addTransition(Event.STOP_BUTTON_PRESSED, start);
		wash.addTransition(Event.LID_OPENED, stop);
		rinse.addTransition(Event.LID_OPENED, stop);
		spin.addTransition(Event.LID_OPENED, stop);

		StateMachine machine = new StateMachine(start, stop, rinse, wash, spin);
		machine.getState(Event.SWITCHED_ON, Event.RINSE_BUTTON_PRESSED,
				Event.TIME_OUT, Event.TIME_OUT, Event.WASH_BUTTON_PRESSED);

	}

	private void getState(Event... e) {
		State cur = this.init;
		for (Event ev : e) {
			cur = cur.transit(ev);
			System.out.println(cur);
		}
		if (cur.isFinal()) {
			System.out.println("F:"+ cur);
		}
	}
}
