package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.synaptic;

import org.x96.sys.sc.emit.arch.DoubleEmit;
import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission.EmitTransmission;
import org.x96.sys.sc.ir.synthetic.Neuron;
import org.x96.sys.sc.ir.synthetic.Synaptic;
import org.x96.sys.sc.ir.synthetic.Transmission;
import org.x96.sys.util.S;

public class EmitSynaptic extends DoubleEmit<Synaptic, Neuron> {


    public EmitSynaptic(Synaptic p, Neuron q) {
        super(p, q);
    }

    @Override
    public String toSC() {
        String nerve = "";
        if (p.nerve().isPresent()){
            switch (p.nerve().get()) {
                case Synaptic synaptic -> {
                    nerve = "." + new EmitSynaptic(synaptic, q).toSC();
                }
                case Transmission transmission -> {
                    nerve = new EmitTransmission(transmission, q).toSC();
                }
            }
        }
        return String.format("%s%s", new EmitId(p.id()).toSC(), nerve);
    }
}
