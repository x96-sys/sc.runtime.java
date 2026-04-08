package org.x96.sys.sc.buzz.sanctuary;

import org.x96.sys.buzz.Buzz;

public class BuzzTypeMismatchException extends Buzz {
    public static final int CODE = 0xEA;

    public BuzzTypeMismatchException(String msg) {
        super(CODE, BuzzTypeMismatchException.class.getSimpleName(), msg);
    }
}
