/**
 * 
 */
package recursion.gen;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;

/**
 * @author makkg
 *
 */
public abstract class ClassToClassGenerator {

	protected String classNamePrefix;
	protected Class inputClassObject;
	protected String inputClassName = null;
	protected String outputClassName;
	protected Class outputClassObject;
	protected String packageName;
	protected String qualifiedInputClassName = null;
	protected String qualifiedOutputClassName;
	boolean isAbstract;

	protected final void setAbstract() {
		isAbstract = true;
	}

	protected final boolean isAbstract() {
		return isAbstract;
	}

	boolean isFinal;

	protected final void setFinal() {
		isFinal = true;
	}

	protected final boolean isFinal() {
		return isFinal;
	}

	boolean isInterface;

	protected final void setInterface() {
		isInterface = true;
	}

	protected final boolean isInterface() {
		return isInterface;
	}

	boolean isNotPublic;

	protected final void setNotPublic() {
		isNotPublic = true;
	}

	protected final boolean isNotPublic() {
		return isNotPublic;
	}

	public final Class createClass() throws Exception {
		classNamePrefix = generateClassNamePrefix();
		UQueue itQ = generateInterfaces();
		UQueue importQ = generateImports();
		String aClassString = (packageName == null ? "" : "package "
				+ packageName + ";\n")
				/*
				 * + (importQ.isEmpty() ? "" : "import " +
				 * importQ.toString(";\nimport ") + ";\n")
				 */
				+ getClassLevelJavadoc()
				+ (isNotPublic ? "" : "public ")
				+ (isFinal ? "final " : "")
				+ (isAbstract ? "abstract " : "")
				+ (isInterface ? " interface " : " class ")
				+ outputClassName
				+ "\n"
				+ (getSuperclass().equals("") ? "" : " extends "
						+ getSuperclass() + "\n")
				+ (itQ.isEmpty() ? "" : " implements " + itQ.toString(", "))
				+ "{\n//============= F I E L D S ======================\n"
				+ generateFields()
				+ "\n//============= C O N S T R U C T O R S ==========\n"
				+ generateConstructors()
				+ "\n//============= M E T H O D S ====================\n"
				+ generateMethods()
				+ "\n//============= N E S T E D C L A S S E S ======\n"
				+ generateNestedClasses() + "}\n";
		String path = "src\\" + this.packageName.replace(".", "\\") + "\\"
				+ outputClassName + ".java";
		File javaFile = new File(path);
		System.out.println(javaFile.getAbsolutePath());
		FileWriter outputFile = new FileWriter(javaFile);
		outputFile.write(aClassString);
		System.out.println(aClassString);
		outputFile.close();
		compile(javaFile.getAbsolutePath());
		checkPostconditions();
		System.out.println(outputClassName + " compiled and loaded");
		return outputClassObject;
	}

	private void compile(String path) throws Exception {
		try {
			String cp =System.getProperty("java.class.path");
			System.out.println(cp);
			String command = "javac -source 1.7 -classpath \"" + cp + "\" "
					+ path;
			System.out.println(command);
			Process p = Runtime.getRuntime().exec(command);
			// The following section substitutes for p.waitFor( )
			int exitValue = -1; // compilation failure is not –1
			int errStreamAvailable = 0;
			while (exitValue == -1) {
				Thread.sleep(10);
				try {
					exitValue = p.exitValue();
				} catch (IllegalThreadStateException e) {
					InputStream errStream = p.getErrorStream();
					if (errStream.available() > 0
							&& errStream.available() == errStreamAvailable) {
						for (int j = errStream.available(); j > 0; j--)
							System.out.write(errStream.read());
						p.destroy();
						throw new RuntimeException("compile failed");
					}
					errStreamAvailable = errStream.available();
					exitValue = -1;
				}
			}
			if (p.exitValue() == 0) {
				outputClassObject = Class.forName(qualifiedOutputClassName);
			} else {
				InputStream errStream = p.getErrorStream();
				for (int j = errStream.available(); j > 0; j--)
					System.out.write(errStream.read());
				throw new Exception("compile fails " + p.exitValue());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	abstract protected String generateFlags();

	abstract protected String generateClassNamePrefix();

	abstract protected UQueue generateImports();

	abstract protected String getClassLevelJavadoc();

	abstract protected String getSuperclass();

	abstract protected UQueue generateInterfaces();

	abstract protected String generateFields();

	abstract protected String generateConstructors();

	abstract protected String generateMethods();

	abstract protected String generateNestedClasses();

	abstract protected void checkPostconditions();
}