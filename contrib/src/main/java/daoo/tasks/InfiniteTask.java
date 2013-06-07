package daoo.tasks;

import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 07/06/13
 * Time: 19:43
 * To change this template use File | Settings | File Templates.
 */
public class InfiniteTask extends EchoTask
    {
        public InfiniteTask(Socket socket) { super(socket); }

        @Override public void task() throws IOException {
            super.task();
            print("endless...");
            endless();
        }

        private void endless() {
            //noinspection InfiniteLoopStatement,StatementWithEmptyBody
            for (;;) {}
        }
    }