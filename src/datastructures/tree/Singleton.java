package datastructures.tree;

public class Singleton {
	private volatile static Singleton uniqueInstance = null;

	private Singleton() {

	}

	public Singleton newInstance(boolean reInstantiate) {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				//double check state.
				if (uniqueInstance == null) {
					//with some params
					uniqueInstance = new Singleton();
				}
			}
		}else{
			System.out.println("Object already instantiated");
			if(reInstantiate){
				synchronized (Singleton.class) {
					//with new params
					uniqueInstance = new Singleton();
					return uniqueInstance;
				}
			}
		}
		return uniqueInstance;
	}
}
