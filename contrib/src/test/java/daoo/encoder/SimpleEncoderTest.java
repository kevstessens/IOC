package daoo.encoder;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 08/06/13
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
public class SimpleEncoderTest  extends TestCase {

    SimpleEncoder encoder = new SimpleEncoder();


    public void testEncoder()
    {
        String s = "StringForTesting ";
        String s2 = new String(encoder.encode(s));
        String s3 = "U3RyaW5nRm9yVGVzdGluZyA=";
        assertEquals(s3, s2.replaceAll("\\s",""));
    }

    public void testDecoder()
    {
        byte[] s = "U3RyaW5nRm9yVGVzdGluZyA=".getBytes();
        String s2 = encoder.decode(s);
        assertEquals(s2, "StringForTesting ");
    }

    public void testEncodeDecode()
    {
        String s = "StringForTesting";
        String s2 = encoder.decode(encoder.encode(s));
        assertEquals(s2,s);
    }

}
