package org.x96.sys.sc.buzz.sanctuary;

import org.x96.sys.buzz.Buzz;

public class BuzzUnknownInstance extends Buzz {
    public static final int CODE = 0xE9;

    public BuzzUnknownInstance() {
        super(
                CODE,
                BuzzUnknownInstance.class.getSimpleName(),
                "vc esta tentando incluir predicados em instancias que n existem");
    }
}
