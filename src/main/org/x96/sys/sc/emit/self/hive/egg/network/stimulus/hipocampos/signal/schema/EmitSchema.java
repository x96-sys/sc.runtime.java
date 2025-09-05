package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.flow.EmitFlow;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter.EmitNeurotransmitter;
import org.x96.sys.sc.ir.synthetic.Schema;
import org.x96.sys.util.S;

public class EmitSchema extends Emit<Schema> {
    public EmitSchema(Schema t) {
        super(t);
    }

    @Override
    public String toSC() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < t.neurotransmitters().length; i++) {
            sb.append(new EmitNeurotransmitter(t.neurotransmitters()[i]).toSC( ));
            if (i < t.neurotransmitters().length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        if (t.flow().isPresent()){
            sb.append(" ");
            sb.append(new EmitFlow(t.flow().get()).toSC());
        }
        return sb.toString();
    }
}
