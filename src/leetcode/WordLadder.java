package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {


    public static void main(String[] args) {
        List<String> words = Arrays.asList("pick", "lick", "pack", "lack", "luck", "puck", "hack", "huck", "duck");
        final List<String> c = Arrays.asList("cet", "ism", "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob");
        final int result = new WordLadder().ladderLength("cet", "ism", c);
        System.out.println(result);
    }

    public static final int DEAD_END = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Dictionary d = new Dictionary(wordList);
        final int result = process(beginWord, endWord, d, new HashSet<>(), new HashMap<>());
        if (result == DEAD_END) {
            return 0;
        }
        return result;
    }

    private int process(String beginWord, String endWord, Dictionary d, Set<String> visited, Map<String, Integer> cachedResult) {
        if (cachedResult.containsKey(beginWord)) {
            return cachedResult.get(beginWord);
        }
        System.out.println(beginWord + ":" + endWord);
        if (beginWord.equals(endWord)) {
            return 1;
        }
        final Collection<String> matches = d.oneDiffMatch(beginWord);
        System.out.println(matches);
        final int result = matches.stream().filter(x -> !visited.contains(x)).mapToInt(m -> {
            visited.add(m);
            final int r = process(m, endWord, d, visited, cachedResult);
            System.out.println(m + "->" + endWord + ": " + r);
            if (r == DEAD_END) {
                return DEAD_END;
            }
            visited.remove(m);
            return r + 1;
        }).min().orElse(DEAD_END);
        cachedResult.put(beginWord, result);
        return result;
    }

    class Dictionary {
        private final List<String> words;

        public Dictionary(List<String> words) {
            this.words = words;
        }

        public Collection<String> oneDiffMatch(String word) {
            return this.words.stream().filter(w -> diffMatch(w, word)).collect(Collectors.toSet());
        }
    }

    boolean diffMatch(String word1, String word2) {
        int mismatch = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                mismatch++;
                if (mismatch > 1) {
                    return false;
                }
            }
        }
        return mismatch == 1;
    }

}
