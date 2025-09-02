package org.x96.sys.sc.emit.self.hive.egg.network;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.EmitOrganelle;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.EmitStimulus;
import org.x96.sys.sc.ir.synthetic.Network;
import org.x96.sys.sc.ir.synthetic.Organelle;
import org.x96.sys.sc.ir.synthetic.Stimulus;

public class EmitNetwork extends Emit<Network> {
    public EmitNetwork(Network network) {
        super(network);
    }

    @Override
    public String toSC() {
        return switch (t){
            case Organelle organelle -> new EmitOrganelle(organelle).toSC();
            case Stimulus stimulus -> new EmitStimulus(stimulus).toSC();
        };
    }
}
