/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

import java.text.ParseException;
import java.util.Collection;
import java.util.LinkedList;

import datastructures.redBlackTrees.Pair;

/**
 *
 * @author gopimac
 */
public class RegexEngine {
//we can use the concept of Algorithm classes bt requires careful planning...

    StateFactory factory = null;
    private State initialState = null;
    private State finalState = null;
    private State curState = null, prevState = null;
    private char prevChar;
    private char[] rex;
    private final String regularExpression;
    State engine = null;

    public boolean validateRegex(String regex) {
        if (!regex.startsWith("(") | !regex.endsWith(")")) {
            regex = "(" + regex + ")";
        }
        this.rex = regex.toCharArray();
        try {
            int i = this.parseRegularExpression(1);

            if (i != rex.length - 1) {
                throw new ParseException(regex, i);
            }
        } catch (ParseException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

    private int parseRegularExpression(int index) throws ParseException {
        boolean entity = false;
        boolean r = false;
        while (rex[index] != ')') {
            System.out.println(rex[index]);
            if (this.rex[index] == '(') {
                System.out.println("Recursive call");
                index = this.parseRegularExpression(index + 1);
                System.out.println(rex[index] + "is returned");
                entity = true;
                r = true;
            } else if (Character.isLetter(rex[index])) {
                entity = true;
                r = true;
            } else if (rex[index] == '+' || rex[index] == '*' || rex[index] == '?') {
                if (!entity) {
                    throw new ParseException(regularExpression, index);
                }
                entity = false;
            } else if (rex[index] == '|') {
                if (!r) {
                    throw new ParseException(regularExpression, index);
                }
                r = false;
            }
            if (index == rex.length - 1) {
                System.out.println("Reached end");
                throw new ParseException(regularExpression, index);
            }
            index++;
        }
        if (rex[index - 1] == '|') {
            System.out.println("Some rex must follow |");
            throw new ParseException(regularExpression, index);
        }
        System.out.println("Returning from recursive call");
        return index;
    }

    public RegexEngine(String regex) {
        this.factory = Singleton.getFactoryInstance();
        this.regularExpression = regex;
        engine = this.getStateEngine(regex);
        if (this.engine != null) {
            GroupState groupState = (GroupState) this.engine;
            this.initialState = groupState.getStartState();
            this.finalState = groupState.getFinalState();
            factory.setFinalState(finalState);
            System.out.println("Final state is " + this.finalState);
        }
        Collection<State> c = factory.getStates();
        System.out.println("Transition chart");
        for (Object s : c) {
            System.out.println(s);
        }
        System.out.println("");
        System.out.println(engine);
    }

    final State getStateEngine(String rex) {
        LinkedList<Pair<State, State>> stack = new LinkedList<>();
        GroupState gState = null;
        if (validateRegex(rex)) {
            System.out.println(rex);
            gState = new GroupState();
            State startState = factory.getNewStateInstance();
            gState.setStartState(startState);
            curState = startState;
            LinkedList<Character> cStack = new LinkedList<>();
            if (!rex.startsWith("(")) {
                rex = "(" + rex + ")";
                State st = factory.getNewStateInstance();
                startState.addOption(st);
                stack.push(new Pair<State, State>(startState, st));
                curState = st;
            }
            char regexA[] = rex.toCharArray();
            Pair<State, State> cP = null;
            State orState = null;
            LinkedList<State> orStack = new LinkedList<>();
            for (int i = 0; i < regexA.length; i++) {
                char currentCharacter = regexA[i];
                System.out.println("processing :" + currentCharacter);
                switch (regexA[i]) {
                    case '(': {
                        cStack.push('(');
                        System.out.println("( is pushed onto stack");
                        System.out.println(orStack + "\n" + cStack);
                        State s = factory.getNewStateInstance();
                        curState.addOption(s);
                        cP = new Pair<>(curState, s);
                        curState = s;
                        stack.push(cP);
                        break;
                    }
                    case ')': {
                        if (!stack.isEmpty()) {
                            Pair<State, State> stackTop = stack.pop();
                            GroupState state = new GroupState();
                            State gS = stackTop.getFirst();
                            state.setStartState(stackTop.getSecond());
                            if (!orStack.isEmpty()) {
                                if (cStack.peek().equals('|')) {
                                    orState = orStack.peek();
                                    curState.addOption(orState);
                                    System.out.println(curState + " is epsilon connected to " + orState);
                                    orStack.pop();
                                    curState = orState;
                                }
                            }
                            while (!cStack.peek().equals('(')) {
                                System.out.println(cStack.pop());
                            }
                            cStack.pop();
                            System.out.println(orStack);
                            System.out.println(cStack);
                            state.setFinalState(curState);
                            prevState = gS;
                            if (i != regexA.length - 1) {
                                System.out.println("not at last");
                                curState = state;
                                System.out.println(curState);
                            }
                        } else {
                            throw new IllegalStateException("group brackets are not balanced.");
                        }
                        break;
                    }
                    case '*': {
                        if (regexA[i - 1] != '*') {
                            State kleenState = curState.applyPLUSClosure(prevChar);
                            prevState.addOption(kleenState);
                            prevState = curState;
                            curState = kleenState;
                            break;
                        } else {
                            System.out.println("* earlier");
                            break;
                        }
                    }
                    case '+': {
                        State kleenState = curState.applyPLUSClosure(prevChar);
                        prevState = curState;
                        curState = kleenState;
                        break;
                    }
                    case '?': {
                        State newState = factory.getNewStateInstance();
                        curState.addOption(newState);
                        prevState.addOption(newState);
                        prevState = curState;
                        curState = newState;
                        break;
                    }
                    case '|': {
                        System.out.println(orStack);
                        System.out.println(cStack);
                        if (cStack.peek().equals('(')) {
                            orState = factory.getNewStateInstance();
                            System.out.println(orState + "is pushed to stack");
                            orStack.push(orState);
                        }
                        cStack.push('|');
                        curState.addOption(orStack.peek());
                        State gS = null;
                        if (!stack.isEmpty()) {
                            Pair<State, State> stackTop = stack.peek();
                            gS = stackTop.getSecond();
                        }
                        curState = gS;
                        prevState = gS;
                        break;
                    }
                    case '/': {
                        break;
                    }
                    case '\\': {
                        System.out.println("\\character used");
                        switch (regexA[i + 1]) {
                            case 's': {
                                State s = factory.getNewStateInstance();
                                curState.addTransition(s, ' ');
                                prevState = curState;
                                curState = s;
                                break;
                            }
                            case 'w': {
                                //[a-zA-Z0-9] and _
                                State newState = this.factory.getNewStateInstance();
                                for (int k = 'a'; k <= 'z'; k++) {
                                    curState.addTransition(newState, (char) k);
                                }
                                for (int k = 'A'; k <= 'Z'; k++) {
                                    curState.addTransition(newState, (char) k);
                                }
                                curState.addTransition(newState, '_');
                                prevState = curState;
                                curState = newState;
                                break;
                            }
                            case 'd': {
                                State newState = this.factory.getNewStateInstance();
                                for (int k = '0'; k <= '9'; k++) {
                                    curState.addTransition(newState, (char) k);
                                }
                                prevState = curState;
                                curState = newState;
                                break;
                            }
                            default:
                        }
                        i++;
                        break;
                    }
                    default: {
                        State state = factory.getNewStateInstance();
                        curState.addTransition(state, currentCharacter);
                        System.out.println("current State is " + curState);
                        if (prevState != curState) {
                            prevState = curState;
                        }
                        curState = state;
                    }
                    prevChar = currentCharacter;
                }
            }
            System.out.println("Current state when ending is" + curState);
            gState.setFinalState(curState);
        }
        return gState;
    }

    public void match(String candidate) {
        int index = 0;
        Store.setCandidate(candidate);
        System.out.println("Searching shuru");
        State s = this.engine.getTransition(index);
        if (s == this.finalState) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }
}
