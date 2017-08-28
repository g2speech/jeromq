package zmq.util;

import java.util.Arrays;

/**
 * Replacement of Objects from SDK so it can be used in java6 environments.
 */
public class Objects
{
    private Objects()
    {
        throw new AssertionError("No zmq.util.Objects instances for you!");
    }

    public static int hash(Object... values)
    {
        return Arrays.hashCode(values);
    }

    public static boolean equals(Object a, Object b)
    {
        return (a == b) || (a != null && a.equals(b));
    }

    public static String toString(Object o)
    {
        return String.valueOf(o);
    }

    public static int hashCode(Object o)
    {
        return o != null ? o.hashCode() : 0;
    }
}
