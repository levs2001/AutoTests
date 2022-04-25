package utils;

import java.util.concurrent.ThreadLocalRandom;

public class MyRandom {
    private static final String PREFIX = "Гарри Поттер ";

    public static String getString() {
        int n = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
        return PREFIX + n;
    }
}
