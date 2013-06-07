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


    public void testEncoder()
    {
        InvertEncoder encoder = new InvertEncoder();
        String s = "Mingus RoxZ";
        String s2 = new String(encoder.encode(s));
        assertEquals(s2, ("ZxoR sugniM"));
    }

    public void testDecoder()
    {
        InvertEncoder encoder = new InvertEncoder();
        byte[] s = "OtaG".getBytes();
        String s2 = encoder.decode(s);
        assertEquals(s2, ("GatO"));
    }

    public void testEncodeDecode()
    {
        InvertEncoder encoder = new InvertEncoder();
        String s = "OtaG";
        String s2 = encoder.decode(encoder.encode(s));
        assertEquals(s2,"OtaG");
    }


}
