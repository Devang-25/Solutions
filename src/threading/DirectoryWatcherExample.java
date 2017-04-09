/**
 * 
 */
package threading;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author makkg
 *
 */
public class DirectoryWatcherExample  {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Path directory = Paths.get("D:\\Deepak\\WebSite\\DeepakGaikwadNet\\Resources\\");
 
        try{
            WatchService fileSystemWatchService = FileSystems.getDefault().newWatchService();
            WatchKey watchKey = directory.register(fileSystemWatchService,
                    StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            while(true){
                WatchKey watchKeyActual = fileSystemWatchService.take();
                for(WatchEvent<?> event: watchKeyActual.pollEvents()){
                    WatchEvent.Kind<?> eventKind = event.kind();
 
                    if(eventKind == StandardWatchEventKinds.OVERFLOW){
                        continue;
                    }
 
                    WatchEvent<Path> eventPath = (WatchEvent<Path>)event;
                    Path fileName = eventPath.context();
                    System.out.println("Event " + eventKind + " occurred on " + fileName);
                }
                boolean isReset = watchKeyActual.reset();
                if(!isReset){
                    break;
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
 
    }
 
}
