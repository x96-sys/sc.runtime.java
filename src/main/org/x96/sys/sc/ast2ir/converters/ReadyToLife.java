package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Ready;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Life;

public class ReadyToLife implements ToIr<Ready, Life> {
    @Override
    public Life convert(Ready ready) {
        return new Life(ready.state());
    }
}
