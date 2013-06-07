package daoo.servers;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;
import daoo.server.TaskServer;
import daoo.tasks.EncoderTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 07/06/13
 * Time: 19:30
 * To change this template use File | Settings | File Templates.
 */
public class DaooEncoderServer implements TaskServer {

    @Override public void start(@NotNull TaskExecutor executor, int port) {

        ServerSocket serverSocket=null;
        try {
            serverSocket =new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        while(true){
            try{
                Socket socket=serverSocket.accept();
                Task task= new EncoderTask(socket);
                executor.execute(task);


            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
