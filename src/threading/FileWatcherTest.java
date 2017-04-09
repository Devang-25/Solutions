/**
 * 
 */
package threading;

import java.io.File;
import java.util.Date;
import java.util.Timer;

/**
 * @author makkg
 *
 */
public class FileWatcherTest {
public static void main(String[] args) {
	FileWatcher w=new FileWatcher(new File("D:\\CSVTreatment.java")) {

		@Override
		protected void onChange(File file) {
				System.out.println(file.getName()+" was changed");
		}
		
		
	};
	Timer t=new Timer();
	t.schedule(w, new Date(), 1000);
}
}
