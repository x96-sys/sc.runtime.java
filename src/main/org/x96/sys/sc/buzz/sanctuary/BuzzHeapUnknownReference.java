package org.x96.sys.sc.buzz.sanctuary;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ir.Id;

public class BuzzHeapUnknownReference extends Buzz {
    public static final int CODE = 0xEB;

    public BuzzHeapUnknownReference(Id reference) {
        super(
                CODE,
                BuzzHeapUnknownReference.class.getSimpleName(),
                explainHeapUnknownReference(reference));
    }

    public static String explainHeapUnknownReference(Id reference) {
        return String.format(
                "Referência [%s] não existe no sanctuary", new String(reference.raw()));
    }
}
