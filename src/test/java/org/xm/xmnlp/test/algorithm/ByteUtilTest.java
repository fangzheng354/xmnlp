package org.xm.xmnlp.test.algorithm;


import junit.framework.TestCase;
import org.xm.xmnlp.corpus.io.ByteArray;
import org.xm.xmnlp.util.ByteUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class ByteUtilTest extends TestCase {

    public static final String DATA_TEST_OUT_BIN = "data/test/out.bin";

    public void testReadDouble() throws Exception {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(DATA_TEST_OUT_BIN));
        out.writeDouble(0.123456789);
        out.writeInt(3389);
        ByteArray byteArray = ByteArray.createByteArray(DATA_TEST_OUT_BIN);
        System.out.println(byteArray.nextDouble());
        System.out.println(byteArray.nextInt());
    }

    public void testReadUTF() throws Exception {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(DATA_TEST_OUT_BIN));
        out.writeUTF("nlp你好123");
        ByteArray byteArray = ByteArray.createByteArray(DATA_TEST_OUT_BIN);
        System.out.println(byteArray.nextUTF());
    }

    public void testReadUnsignedShort() throws Exception {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(DATA_TEST_OUT_BIN));
        int utflen = 123;
        out.writeByte((byte) ((utflen >>> 8) & 0xFF));
        out.writeByte((byte) ((utflen >>> 0) & 0xFF));
        ByteArray byteArray = ByteArray.createByteArray(DATA_TEST_OUT_BIN);
        System.out.println(byteArray.nextUnsignedShort());
    }

    public void testConvertCharToInt() throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            int n = i;
            char[] twoChar = ByteUtil.convertIntToTwoChar(n);
            assertEquals(n, ByteUtil.convertTwoCharToInt(twoChar[0], twoChar[1]));
        }
    }
}