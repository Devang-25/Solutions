/**
 * 
 */
package recursion.gen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author makkg
 *
 */
public class RecursionTrackerGenerator extends ClassToClassGenerator {
	private UQueue cmdLineImports;

	protected String generateFlags() {
		return "[-notpublic] [-final] [-abstract] "
				+ "[[-import name]...] [-package name] [-output name]";
	}

	protected String generateClassNamePrefix() {
		return "";
	}

	private Class<?> clazz;

	public RecursionTrackerGenerator(Class<?> clazz) {
		this.inputClassObject = clazz;
		this.classNamePrefix = "Recursive";
		inputClassName = clazz.getSimpleName();
		packageName = clazz.getPackage().getName();
		outputClassName = this.classNamePrefix + inputClassName;
		qualifiedOutputClassName = packageName + "." + outputClassName;
		outputClassName = classNamePrefix + inputClassName;
		isNotPublic = false;
		isFinal = true;
		isInterface = false;
		isAbstract = false;
		this.clazz = clazz;
	}

	protected UQueue generateImports() {
		return cmdLineImports;
	}

	protected String getClassLevelJavadoc() {
		return "";
	}

	protected String getSuperclass() {
		return this.clazz.getSimpleName();
	}

	protected UQueue generateInterfaces() {
		return new UQueue(String.class);
	}

	protected String generateFields() {
		return "private int tab=0;";
	}

	protected String generateConstructors() {
		String result = "";
		Constructor<?>[] cArray = inputClassObject.getDeclaredConstructors();
		for (int i = 0; i < cArray.length; i++)
			result += "public "
					+ createRenamedConstructor(cArray[i], outputClassName, "");
		return result;
	}

	protected String generateMethods() {
		Method[] methods = this.clazz.getDeclaredMethods();
		StringBuilder b = new StringBuilder();
		for (Method m : methods) {
			if (!(Modifier.isStatic(m.getModifiers()))) {
				String name = m.getName();
				String parameters = formalParametersToString(m
						.getParameterTypes());
				String exceptions = exceptionsToString(m.getExceptionTypes());
				String body = generateMethodBody(m);
				String methodSignature = "public "
						+ m.getReturnType().getName() + " " + name + "("
						+ parameters + ")" + exceptions + body;
				b.append(methodSignature);
				b.append("\n");
			}
		}
		b.append("private void display(int tab){\n"
				+ "for(int i=1;i<=tab;i++){\n" + "System.out.print(\"   \");"
				+ "\n}" + "\n}");
		return b.toString();
	}

	/**
	 * @param m
	 * @return
	 */
	private String generateMethodBody(Method m) {
		String body = "{\n " + "display(++tab);" + msg(m) + "super."
				+ m.getName() + "("
				+ actualParametersToString(m.getParameterTypes()) + ");\n"
				+ "display(--tab);\n}";
		return body;
	}

	/**
	 * @param m
	 * @return
	 */
	private String msg(Method m) {
		StringBuilder b = new StringBuilder();
		b.append("\nSystem.out.println(\"" + m.getName() + "(\"");
		int i = 0;
		for (; i < m.getParameterTypes().length - 1; i++) {
			b.append("+p" + i + "+\",\"");
		}
		b.append("+p" + i);
		b.append("+\")\");\n");
		return b.toString();
	}

	/**
	 * @param exceptionTypes
	 * @return
	 */
	private String exceptionsToString(Class<?>[] exceptionTypes) {
		if (exceptionTypes == null || exceptionTypes.length == 0) {
			return "";
		}
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < exceptionTypes.length - 1; i++) {
			b.append(exceptionTypes[i].getName() + " ,");

		}
		b.append(exceptionTypes[exceptionTypes.length - 1]);
		return "throws " + b.toString();
	}

	public static String getTypeName(Class cls) {
		if (!cls.isArray()) {
			return cls.getName();
		} else {
			return getTypeName(cls.getComponentType()) + "[]";
		}
	}

	protected String generateNestedClasses() {
		return "";
	}

	private String formalParametersToString(Class[] pts) {
		String result = "";
		for (int i = 0; i < pts.length; i++) {
			result += getTypeName(pts[i]) + " p" + i;
			if (i < pts.length - 1)
				result += ",";
		}
		return result;
	}

	private String actualParametersToString(Class<?>[] pts) {
		String result = "";
		for (int i = 0; i < pts.length; i++) {
			result += "p" + i;
			if (i < pts.length - 1)
				result += ",";
		}
		return result;
	}

	private String classArrayToString(Class<?>[] pts) {
		String result = "";
		for (int i = 0; i < pts.length; i++) {
			result += getTypeName(pts[i]);
			if (i < pts.length - 1)
				result += ",";
		}
		return result;
	}

	private String createRenamedConstructor(Constructor<?> c, String name,
			String code) {
		Class<?>[] pta = c.getParameterTypes();
		String fpl = formalParametersToString(pta);
		String apl = actualParametersToString(pta);
		Class<?>[] eTypes = c.getExceptionTypes();
		String result = name + "(" + fpl + ")\n";
		if (eTypes.length != 0)
			result += " throws " + classArrayToString(eTypes) + "\n";
		result += "{\n super(" + apl + ");\n" + code + "}\n";
		return result;
	}

	protected void checkPostconditions() {
	}
}
