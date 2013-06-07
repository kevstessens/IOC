package daoo.server;

import java.io.*;
import java.net.Socket;

public abstract class Task implements Runnable {

    protected final Socket socket;

    public Task(Socket socket) { this.socket = socket; }



    @Override public void run() {
        try {
            task();
            close();
        } catch (IOException e) {
            throw new RuntimeException("Task socket io exception!", e);
        }
    }

    protected abstract void task() throws IOException;

    /** To be called before finishing run execution. */
    protected void close() throws IOException {
        socket.close();
    }

    protected void print(String msg) {
        System.out.println("Task with " + socket + " at " + System.currentTimeMillis() + " " + msg);
    }


}
