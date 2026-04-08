package org.x96.sys.buzz;

public class BuzzHappensMismatchSpore extends Buzz {
    public static final int CODE = 0xE7;

    public BuzzHappensMismatchSpore(String msg) {
        super(CODE, BuzzHappensMismatchSpore.class.getSimpleName(), msg);
    }
}
