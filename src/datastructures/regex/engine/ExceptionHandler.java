/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gopimac
 */
public class ExceptionHandler extends StreamHandler {

    @Override
    public synchronized void publish(LogRecord record) {
        String ms = record.getMessage();
        if (ms.indexOf("Exception") > -1) {
            String regex = "(.*Exception.*)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(ms);
            if (m != null && m.find()) {
                System.out.println(m.group(1));
            }
        }

    }
}
