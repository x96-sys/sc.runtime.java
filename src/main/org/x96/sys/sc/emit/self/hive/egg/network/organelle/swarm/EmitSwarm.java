package org.x96.sys.sc.emit.self.hive.egg.network.organelle.swarm;

import org.x96.sys.lexer.visitor.entry.terminals.c1.Em;
import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.ir.synthetic.Swarm;

public class EmitSwarm extends Emit<Swarm> {
    public EmitSwarm(Swarm t) {
        super(t);
    }

    @Override
    public String toSC() {
        return String.format(":logos %s%n", new EmitId(t.id()).toSC());
    }
}
