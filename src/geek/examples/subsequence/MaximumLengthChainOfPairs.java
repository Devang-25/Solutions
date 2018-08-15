package geek.examples.subsequence;

public class MaximumLengthChainOfPairs {

    public static void main(String[] args) {
        new LongestChainSubSequence<Pair>((current, that) -> current.a > that.b).longestChainSequence(null, 10);
    }

    static class Pair {
        int a, b;
    }
}
