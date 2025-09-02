package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter.aminoAcid;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.ir.synthetic.AminoAcid;

public class EmitAminoAcid extends Emit<AminoAcid> {
    public EmitAminoAcid(AminoAcid t) {
        super(t);
    }

    @Override
    public String toSC() {
        String splat = t.splat() ? "*" : "";
        String id = t.id().map(i -> new EmitId(i).toSC()).orElse("");
        return String.format("%s%s", splat, id);
    }
}
