package daoo.tasks;

import daoo.encoder.SimpleEncoder;
import daoo.server.Task;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 30/05/13
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */

public class EncoderTask extends Task
{
    public EncoderTask(Socket socket) { super(socket); }

    @Override protected void task() throws IOException {
        print("encoding...");
        encode();
    }

    private void encode() throws IOException {

        final SimpleEncoder simpleEncoder = new SimpleEncoder();


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

        out.write("\r\n");
        final String[] dividedPath = getHeaderPath(header.toString()).split("/");
            if (dividedPath[1].equals("encode")){
                out.write("You asked to encode:" +"\r\n");
                out.write(dividedPath[2]+"\r\n");
                out.write("Your encoded message is:" +"\r\n");
                out.write(new String(simpleEncoder.encode(dividedPath[2]))+"\r\n");
            } else if (dividedPath[1].equals("decode")){
                out.write("You asked to decode:" +"\r\n");
                out.write(dividedPath[2]+"\r\n");
                out.write("Your decoded message is:" +"\r\n");
                out.write(simpleEncoder.decode(dividedPath[2].getBytes())+"\r\n");
            }
            else {
                out.write("Please select an action (ie. encode/YourMessage)" +"\r\n");
            }


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