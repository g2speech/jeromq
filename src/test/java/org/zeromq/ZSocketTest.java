package org.zeromq;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class ZSocketTest
{
    @Test
    public void pushPullTest() throws IOException
    {
        int port = Utils.findOpenPort();

        final ZSocket pull = new ZSocket(ZMQ.PULL);
        final ZSocket push = new ZSocket(ZMQ.PUSH);
        try {
            pull.bind("tcp://*:" + port);
            push.connect("tcp://127.0.0.1:" + port);

            final String expected = "hello";
            push.sendStringUtf8(expected);
            final String actual = pull.receiveStringUtf8();

            assertEquals(expected, actual);
        }
        finally {
            push.close();
            pull.close();
        }
    }
}
