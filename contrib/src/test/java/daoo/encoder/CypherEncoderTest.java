package daoo.encoder;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 08/06/13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class CypherEncoderTest extends TestCase {

    CypherEncoder encoder = new CypherEncoder();


    public void testEncoder()
    {
        String s = "StringForTesting";
        String s2 = new String(encoder.encode(s));
        assertEquals(s2, ("[B@78952527"));
    }

    public void testDecoder()
    {
        byte[] s = "StringForTesting".getBytes();
        String s2 = encoder.decode(s);
        assertEquals(s2, ("[B@79f1d448"));
    }

    public void testEncodeDecode()
    {
        String s = "StringForTesting";
        String s2 = encoder.decode(encoder.encode(s));
        assertEquals(s2,s);
    }
}
