package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.EmitNerve;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.neuron.EmitNeuron;
import org.x96.sys.sc.ir.synthetic.Impulse;

public class EmitImpulse extends Emit<Impulse> {
    public EmitImpulse(Impulse impulse) {
        super(impulse);
    }

    @Override
    public String toSC() {
        String neuron = new EmitNeuron(t.neuron()).toSC();
        String nerve = t.nerve().map(n -> new EmitNerve(n, t.neuron()).toSC()).orElse("");
        return String.format("%s%s", neuron, nerve);
    }
}
