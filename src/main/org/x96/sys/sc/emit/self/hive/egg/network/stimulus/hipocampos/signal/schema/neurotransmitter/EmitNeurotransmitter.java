package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter.aminoAcid.EmitAminoAcid;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter.isoform.EmitIsoform;
import org.x96.sys.sc.ir.synthetic.Neurotransmitter;

public class EmitNeurotransmitter extends Emit<Neurotransmitter> {
    public EmitNeurotransmitter(Neurotransmitter t) {
        super(t);
    }

    @Override
    public String toSC() {
        String k = t.aminoAcid().map(a -> new EmitAminoAcid(a).toSC()).orElse("");
        String v = new EmitIsoform(t.isoform()).toSC();
        return String.format("%s: %s", k, v);
    }
}
