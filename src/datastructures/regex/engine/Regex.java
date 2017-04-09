/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.regex.engine;

import java.io.Serializable;

/**
 *
 * @author gopimac
 */
public class Regex implements Serializable {

    private String regex, description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
