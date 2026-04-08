package org.x96.sys.sc.buzz;

import org.x96.sys.buzz.Buzz;

public class BuzzHappensUnknowSpore extends Buzz {
    public static final int CODE = 0xE6;

    public BuzzHappensUnknowSpore(String msg) {
        super(CODE, BuzzHappensUnknowSpore.class.getSimpleName(), msg);
    }
}
