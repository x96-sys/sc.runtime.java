package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.synaptic;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission.EmitTransmission;
import org.x96.sys.sc.ir.synthetic.Synaptic;
import org.x96.sys.sc.ir.synthetic.Transmission;
import org.x96.sys.util.S;

public class EmitSynaptic extends Emit<Synaptic> {
    public EmitSynaptic(Synaptic t) {
        super(t);
    }

    @Override
    public String toSC() {
        String nerve = "";
        if (t.nerve().isPresent()){
            switch (t.nerve().get()) {
                case Synaptic synaptic -> {
                    nerve = "." + new EmitSynaptic(synaptic).toSC();
                }
                case Transmission transmission -> {
                    nerve = new EmitTransmission(transmission).toSC();
                }
            }
        }
        return String.format("%s%s", new EmitId(t.id()).toSC(), nerve);
    }
}
