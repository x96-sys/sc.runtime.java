package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.text;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.ir.synthetic.Text;

public class EmitText extends Emit<Text> {
    public EmitText(Text t) {
        super(t);
    }
    @Override
    public String toSC() {
        return String.format("'%s'", new String(t.raw()));
    }
}
