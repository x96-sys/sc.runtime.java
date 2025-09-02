package org.x96.sys.sc.emit.self.hive.egg;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.EmitNetwork;
import org.x96.sys.sc.ir.synthetic.Egg;
import org.x96.sys.sc.ir.synthetic.Network;

public class EmitEgg extends Emit<Egg> {
    public EmitEgg(Egg egg) {
        super(egg);
    }

    @Override
    public String toSC() {
        StringBuilder sb = new StringBuilder();
        for (Network n: t.network()) {
            sb.append(new EmitNetwork(n).toSC());
        }
        return sb.toString();
    }
}
