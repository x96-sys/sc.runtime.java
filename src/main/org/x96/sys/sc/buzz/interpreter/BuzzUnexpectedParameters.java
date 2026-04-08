package org.x96.sys.sc.buzz.interpreter;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ir.Id;

public class BuzzUnexpectedParameters extends Buzz {
    public static final int CODE = 0xE5;

    public BuzzUnexpectedParameters(Id id) {
        super(
                CODE,
                BuzzUnexpectedParameters.class.getSimpleName(),
                explainUnexpectedParameters(id));
    }

    private static String explainUnexpectedParameters(Id id) {
        return String.format("course [%s] does not wait for parameters", new String(id.raw()));
    }
}
