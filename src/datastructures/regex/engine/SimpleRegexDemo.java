/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gopimac
 */
public class SimpleRegexDemo {

    public void demo1() {
        String statement = "I will not compromise. I will not "
                + "cooperate. There will be no concession, no conciliation, no "
                + "finding the middle group, and no give and take.";

        String tokens[] = null;

        String splitPattern = "compromise|cooperate|concession|"
                + "conciliation|(finding the middle group)|(give and take)";

        tokens = statement.split(splitPattern);

        System.out.println("REGEX PATTERN:\n" + splitPattern + "\n");

        System.out.println("STATEMENT:\n" + statement + "\n");
        System.out.println("\nTOKENS");
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }

    }
    /*
    once the pattern //d is compiled, don't expect its string representation to change..
     * it remains //d and not /d on a call to pattern.pattern()
     */

    public void reUsePatternMethodDemo() {
        //match a single digit
        Pattern p = Pattern.compile("\\d");
        Matcher matcher = p.matcher("5");
        boolean isOk = matcher.matches();
        System.out.println("original pattern matches " + isOk);
        //recycle the pattern
        String tmp = p.pattern();
        Pattern p2 = Pattern.compile(tmp);
        matcher = p.matcher("5");
        isOk = matcher.matches();
        System.out.println("second pattern matches " + isOk);
    }

    public void matcherResetDemo() {
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher("12345");
        while (m.find()) {
            System.out.println("\t\t" + m.group());
        }
        m.reset();
        System.out.println("Matcher has been reset");
        while (m.find()) {
            System.out.println("\t\t" + m.group());
        }
    }

    public void matcherStart() {
        String candidate = "my name is Bond. James Bond.";
        Pattern p = Pattern.compile("Bond");
        Matcher m = p.matcher(candidate);
        try {
            m.find();
            int startIndex = m.start();
            System.out.println(startIndex);
            m.find();
            int startIndex_ = m.start();
            System.out.println(startIndex_);
            m.find();
            m.start();
        } catch (IllegalStateException ex) {
            System.out.println("In illegal state..");
        }
    }

    public void appendReplacementDemo() {
        Pattern p = Pattern.compile("Bond");
        StringBuffer buffer = new StringBuffer();
        String candidate = "My name is Bond. James Bond. I would like a martini.";
        Matcher m = p.matcher("My name is Bond. James Bond. I would like a martini.");
        System.out.println("My name is Bond. James Bond. I would like a martini.");
        String replacement = "Smith";
        m.find();
        m.appendReplacement(buffer, replacement);
        m.find();
        m.appendReplacement(buffer, replacement);
        String msg = buffer.toString() + candidate.substring(m.end());
        System.out.println(msg);
    }

    public void appendReplacementDemo_() {
        Pattern p = Pattern.compile("Bond");
        String candidate = "My name is Bond. James Bond. I would like a martini.";
        StringBuffer buffer = new StringBuffer();
        Matcher m = p.matcher(candidate);
        System.out.println(candidate);
        String replacement = "Smith";
        m.find();
        m.appendReplacement(buffer, replacement);
        m = p.matcher(candidate);
        m.find();
        m.appendReplacement(buffer, replacement);
        String msg = buffer.toString();
        System.out.println(msg);
    }

    public void appendReplacementGroupDemo() {
        Pattern p = Pattern.compile("(James) (Bond)");
        String candidate = "my name is Bond. James Bond.";
        StringBuffer buffer = new StringBuffer();
        String replacement = "$1 waldo $2";
        Matcher m = p.matcher(candidate);
        if (m.find()) {
            m.appendReplacement(buffer, replacement);
        }
        m.appendTail(buffer);
        String output = buffer.toString();
        System.out.println(output);
    }
    /*
     *you have the String I love ice. Ice is my favorite. Ice Ice Ice.,
     *and you want to replace every occurrence of ice or Ice with the word Java.
     *Your first step is to describe the word you want to look for.
     *In this case, because you want to match both uppercase Ice and
     *lowercase ice you'll use the regex pattern (i|I)ce
     */

    public void fixIceCream() {
        String p = "(i|I)ce";
        String x = "\\b" + p;
        String y = p + "\\b";
        String pat = "\\b(i|I)ce\\b";
        Pattern pattern = Pattern.compile(pat);
        Pattern pattern2 = Pattern.compile(x);
        Pattern pattern3 = Pattern.compile(y);
        String candidate = "I love ice. Ice is my favorite. Ice Ice Ice.Its nice icecream";
        Matcher m = pattern.matcher(candidate);
        Matcher m1 = pattern2.matcher(candidate);
        Matcher m2 = pattern3.matcher(candidate);
        String tmp = m.replaceAll("Java");
        String tmp1 = m1.replaceAll("Java");
        String tmp2 = m2.replaceAll("Java");
        System.out.println("For regex:" + pat);
        System.out.println(tmp);
        System.out.println("For regex:" + x);
        System.out.println(tmp1);
        System.out.println("For regex:" + y);
        System.out.println(tmp2);
        System.out.println(this.replaceAll(m, "Java"));

    }

    private String replaceAll(Matcher m, String replacement) {
        m.reset();
        StringBuffer buffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(buffer, replacement);
        }
        m.appendTail(buffer);
        return buffer.toString();
    }

    public void simpleGroupDemo() {
        //the original pattern is always group 0
        //remember that \\w\\d is itself a group.
        Pattern p = Pattern.compile("\\w\\d");
        String candidate = "A9 is my favorite";
        Matcher m = p.matcher(candidate);
        if (m.find()) {
            System.out.println(m.group(0));
        }
    }
    //what if we want to access the subgroup...

    public void simpelSubGroupDemo() {
        Pattern p = Pattern.compile("\\w(\\d)");
        String candidate = "A9 is my favorite";
        Matcher m = p.matcher(candidate);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }
    //non capturing groups.
    /*There may be times when you need to define a group, but you don't want that group to be captured—
    you simply want to treat it like a single logical entity.*/

    public void replaceDemo() {
        Pattern p = Pattern.compile("(\\w+)(\\d)(\\w+)");
        String candidate = "X99SuperJava";
        String msg = "noMatchFound";
        Matcher m = p.matcher(candidate);
        if (m.find()) {
            msg = "matchFound";
            System.out.println(m.group());
        }
        //with a (\\w++), no match can be expected. 
        String output = m.replaceAll("$33");
        System.out.println(msg);
        System.out.println(output);
        /*When group(1) runs, (\w+) examines every character in the candidate String X99SuperJava.
        That is, X is explicitly considered, passes inspection, and is put into the matching bag for this group.
        Because this pattern is greedy and has + after \w, it continues. Next, 9 is explicitly considered and passes inspection.
        Then, the next 9 is considered. This continues until the entire String X99SuperJava is consumed.
        After group(1) is satisfied, group(2), namely (\d\d), gets an opportunity.
        Because group(2) is unable to match anything at all, group(1) releases the a character at the end of X99SuperJava.
        The a character is considered by group(2), found not be a digit, and considered not to be sufficient.
        Thus, group(1) releases the v character. group(2) inspects it, finds it lacking, and rejects it.
        Thus, group(1) releases the a character immediately before the v character in X99SuperJava.
        This continues until group(1) has released every character except X.
        Finally, the release of the two 9 characters allow group(2) to match.
        Now group(1) has X and group(2) has 99.
        Finally, group(3) gets an opportunity to run.
        It starts examining the candidate String X99SuperJava at the point immediately following the second 9 character.
        And because it's greedy, it matches the entire String SuperJava.
        Thus, the two patterns (\w)(\d\d)(\w+) and (\w+)(\d\d)(\w+) produce exactly the same result when applied
        to the String X99SuperJava but at vastly different efficiency costs.
        Although this may be insignificant when you're dealing with a small String,
        it's very significant when you're parsing a directory full of files;
        it could mean the difference between your application working and it running out of memory.
         */
    }

    public void reluctantDemo() {
        String regex = "(\\d+?)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("1234");
        while (m.find()) {
            System.out.println(m.group());
            /*Every time find() is run, it matches as little as possible, because it's reluctant to match.
             *The Pattern matches exactly four times: once for each digit.
             *If you weren't using a reluctant qualifier in the Pattern,
             *there would have been a single match for the entire candidate string, namely 1234,
             *because the Pattern would have been greedy and matched as much as possible
             */
        }
    }

    public void positiveLookAheadDemo() {
        String regex = "(?=^255).*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("255.1.1.1");
        if (m.find()) {
            System.out.println(m.group());
        }
        /*the regex engine first confirms that the candidate string starts with 255 before attempting
         *to execute the rest of the pattern. If the candidate String doesn't do so,
         *then the rest of the pattern can't possibly match and no resources are wasted in attempting to do so.
         */
    }
    //Find and capture occurrences of John followed by some capitalized word, unless that word is Smith.

    public void negativeLookAhead() {
        String regex = "John (?!Smith)[A-Z]\\w+";
        Pattern p = Pattern.compile(regex);
        String candidate = "I think that John Smith ";
        candidate += "is a fictional character. His real name ";
        candidate += "might be John Jackson, John Westling, ";
        candidate += "or John Holmes for all we know.";
        Matcher m = p.matcher(candidate);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
//well, it has been done here, but it's not pretty legible..

    public void xmlPersistenceDemo() {
        Regex rex = new Regex();
        rex.setRegex("<((?i)TITLE>)(.*?)</\\1");
        String description = "extract the title from the html page.";
        rex.setDescription(description);
        this.saveXML(rex, "rex.xml");
    }

    private void saveXML(Serializable si, String fileName) {
        try {
            XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            e.writeObject(si);
            System.out.println("Objectwritten");
            e.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SimpleRegexDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Serializable getXML(String fileName) {
        try {
            XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
            Serializable s = (Serializable) d.readObject();
            d.close();
            return s;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
    //useing fileChannels and byteBuffers to store Patterns..

    public void channellPersistenceDemo() {
        String rex = "<((?i)TITLE>)(.*?)</\\1";
        try {
            DataOutputStream dout = new DataOutputStream(new FileOutputStream("rexex.rex"));
            dout.writeUTF(rex);
            dout.flush();
            dout.close();
            //lets confirm our rex
            this.channelBasedRegexHelper("rexex.rex");
            /*Remember that the doubling of the \ character is a requirement of the String object's constructor—
            it has nothing to do with the regex pattern that the String represents.
            Thus, once the String is created, the conflict disintegrates.
             */
        } catch (IOException ex) {
            Logger.getLogger(SimpleRegexDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void channelBasedRegexHelper(String fileName) {
        try {
            FileInputStream sin = new FileInputStream(fileName);
            FileChannel fileChannel = sin.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            if (byteBuffer.hasArray()) {
                String rex = new String(byteBuffer.array());
                System.out.println(rex);
            }
        } catch (IOException ex) {
            Logger.getLogger(SimpleRegexDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void channelBasedRegexhelper(String fileName, String key) {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            FileChannel fc = fin.getChannel();
            ByteBuffer bb = ByteBuffer.allocate((int) fc.size());
            fc.read(bb);
            String data = new String(bb.array());
            String searchRex = "^" + key.trim() + "=(.*)$";
            Pattern p = Pattern.compile(searchRex, Pattern.MULTILINE);
            Matcher m = p.matcher(data);
            if (m.find()) {
                String regularExpression = m.group(1);
                System.out.println(regularExpression);
            }
        } catch (IOException ex) {
            Logger.getLogger(SimpleRegexDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void titleDemoTester() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter here");
        String lineRead = s.nextLine();
        while (true) {
            this.casePatternDemo(lineRead);
            System.out.println("Enter here");
            lineRead = s.nextLine();
        }
    }

    public void titleDemo(String candidate) {
        String regex1 = "<([a-z]+?)( [a-z]+=(\"[a-zA-Z0-9]+\"|[0-9]+?))*>(.*)</\\1>";
        Pattern p = Pattern.compile(regex1);
        Matcher m = p.matcher(candidate);
        if (m.find()) {
            System.out.println(m.group(4));
            if (m.group(4).indexOf('<') == -1 && m.group(4).indexOf('>') == -1) {
                return;
            }
            this.titleDemo(m.group(4).trim());
        } else {
            System.out.println("failed");
        }
    }
    //if it's small then all be small or else

    public void casePatternDemo(String candidate) {
        String regex = "<(\\p{Upper}+|\\p{Lower}+)>.*<\\1>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(candidate);
        if (m.find()) {
            System.out.println(m.group());
        }
    }

    private void roughWork(String regex, String candidate) {
        //if the search pattern doesn't contain any punctuation it means it is simply a word and simply return the line..
        Pattern p = Pattern.compile("\\p{Punct}");
        Matcher m = p.matcher(regex);
        String reqPattern = "";
        if (m.find()) {
            reqPattern = regex;
        } else {
            reqPattern = "^.*" + regex + ".*$";
        }
        Pattern actualPattern = Pattern.compile(reqPattern);
        Matcher m2 = p.matcher(candidate);
        while (m2.find()) {
            System.out.println(m2.start() + ":" + m.group());
        }
    }

    public void setFileContent(String newContent, FileChannel fc) {
        try {
            ByteBuffer buffer = ByteBuffer.wrap(newContent.getBytes());
            fc.truncate(newContent.length());
            fc.position(0);
            fc.write(buffer);
            fc.close();
            fc = null;
        } catch (IOException ex) {
            Logger.getLogger(SimpleRegexDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
