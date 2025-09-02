package org.x96.sys.sc.emit.self.hive.egg.network.organelle;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.EmitBee;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.EmitPulse;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.connect.EmitConnect;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.rune.EmitRune;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.swarm.EmitSwarm;
import org.x96.sys.sc.ir.synthetic.*;

public class EmitOrganelle extends Emit<Organelle> {
    public EmitOrganelle(Organelle t) {
        super(t);
    }

    @Override
    public String toSC() {
        return switch (t) {
            case Bee bee -> new EmitBee(bee).toSC();
            case Connect connect -> new EmitConnect(connect).toSC();
            case Pulse pulse -> new EmitPulse(pulse).toSC();
            case Rune rune -> new EmitRune(rune).toSC();
            case Swarm swarm -> new EmitSwarm(swarm).toSC();
        };
    }
}
