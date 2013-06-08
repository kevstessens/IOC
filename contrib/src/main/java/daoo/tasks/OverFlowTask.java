package daoo.tasks;

import daoo.server.Task;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 07/06/13
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */
public class OverFlowTask extends Task {

    public OverFlowTask(Socket socket) { super(socket); }

    @Override protected void task() throws IOException {
        print("Overflow!");
        overFlow();
    }

    private void overFlow() throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        final StringBuilder header = new StringBuilder();

        while (true) {
            final String s = in.readLine();
            if(s == null || s.isEmpty()) break;
            header.append(s);
        }

        out.write("HTTP/1.1 200 OK\r\n");
        out.write("Content-Type: text/plain\r\n");

        // Echo path
        out.write("\r\n");
        out.write("The queue is full" + "\r\n");

        out.close();
        in.close();
    }

    private String getHeaderPath(String header) {
        final int method = header.indexOf("GET /");
        if(method == -1) throw unsupported("Unsupported HTTP Method! GET only!");
        final int protocol = header.indexOf("HTTP/1.");
        if(protocol == -1) throw unsupported("Unsupported HTTP Protocol! HTTP/1.* only!");
        return header.substring(method + 4, protocol);
    }

    private UnsupportedOperationException unsupported(String s) {
        return new UnsupportedOperationException(s);
    }
}
