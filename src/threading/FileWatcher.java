/**
 * 
 */
package threading;

import java.io.File;
import java.util.TimerTask;

/**
 * @author makkg
 *
 */
public abstract class FileWatcher extends TimerTask {
	private final File file;
	private long timeStamp;

	public FileWatcher(File f) {
		this.file = f;
		this.timeStamp=f.lastModified();
	}

	@Override
	public void run() {
		long timeStamp=file.lastModified();
		if(timeStamp!=this.timeStamp){
			onChange(file);
			this.timeStamp=timeStamp;
		}
	}

	/**
	 * @param file
	 */
	protected  abstract void onChange(File file) ;

}
