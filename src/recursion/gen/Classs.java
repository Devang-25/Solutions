/**
 *
 */
package recursion.gen;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author makkg
 */
public class Classs {
    private Class<?> clazz;
    private String superClass;
    private Set<String> implementz = new TreeSet<>();
    private String packagee;

    Classs(Class clazz) {
        this.clazz = clazz;
    }

    public Classs extendsItself() {
        this.extendz(this.clazz);
        return this;
    }

    public Classs extendz(Class clazz) {
        this.superClass = clazz.getName();
        return this;
    }

    public Classs implementz(Class clazz) {
        this.implementz.add(clazz.getName());
        return this;
    }

    public Classs destination(String d) {
        return null;
    }

    public Classs packagee(String packagee) {
        this.packagee = packagee;
        return null;
    }


}
