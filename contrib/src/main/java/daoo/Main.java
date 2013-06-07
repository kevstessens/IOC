package daoo;


import daoo.executors.NewThreadTaskExecutor;
import daoo.server.TaskServer;
import daoo.servers.DaooEncoderServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final TaskServer server = new DaooEncoderServer();
        server.start(new NewThreadTaskExecutor(), 3000);
    }
}
