package daoo.executors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

public class QueuedTaskExecutor implements TaskExecutor {
    private List<Task> queuedTasks;

    public QueuedTaskExecutor() {
        this.queuedTasks = new ArrayList<Task>();
    }

    @Override public void execute(@NotNull Task task) {
        if(queuedTasks.isEmpty()){
            new Thread(task).start();
        }else if(queuedTasks.size() > 5){
            // me gustaria que se pudiese hacer que te diga que se lleno la cola.
            queuedTasks.add(task);
        } else queuedTasks.add(task);

        while(!queuedTasks.isEmpty()){
            Thread runningThread = new Thread(queuedTasks.remove(0));
            runningThread.start();
            while(runningThread.isAlive()){

            }
        }
    }
}
