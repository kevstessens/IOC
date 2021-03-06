package daoo.encoder;

import com.sun.istack.internal.NotNull;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 17/05/13
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */

public class InverseEncoderTest extends TestCase {

    InvertEncoder encoder = new InvertEncoder();


    public void testEncoder()
    {
        String s = "StringForTesting";
        String s2 = new String(encoder.encode(s));
        assertEquals(s2, ("gnitseTroFgnirtS"));
    }

    public void testDecoder()
    {
        byte[] s = "StringForTesting".getBytes();
        String s2 = encoder.decode(s);
        assertEquals(s2, ("gnitseTroFgnirtS"));
    }

    public void testEncodeDecode()
    {
        String s = "StringForTesting";
        String s2 = encoder.decode(encoder.encode(s));
        assertEquals(s2,s);
    }


}
