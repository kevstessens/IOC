package daoo.encoder;

import com.sun.istack.internal.NotNull;
import org.apache.commons.codec.binary.Base64;
import daoo.ioc.MessageEncoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 07/06/13
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
public class SimpleEncoder implements MessageEncoder{

    @Override
    public byte[] encode(@NotNull String message) {
        final String encode = new BASE64Encoder().encodeBuffer(message.getBytes());
        return encode.getBytes();

    }

    @Override
    public String decode(@NotNull byte[] message) {
        try {
            final byte[] bytes = new BASE64Decoder().decodeBuffer(new String(message));
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }


    public static void main(String[] args) {
        SimpleEncoder c = new SimpleEncoder();
        String message = "ThisIsATest";
        byte[] messageEncoded = c.encode(message);
        String messageDecoded = c.decode(messageEncoded);
        System.out.println(message);
        System.out.println(new String(messageEncoded));
        System.out.println(messageDecoded);


    }


}
