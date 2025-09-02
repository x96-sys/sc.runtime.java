package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.EmitSchema;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.serie.EmitSerie;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.text.EmitText;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.EmitImpulse;
import org.x96.sys.sc.ir.synthetic.*;

public class EmitSignal extends Emit<Signal> {
    public EmitSignal(Signal signal) {
        super(signal);
    }

    @Override
    public String toSC() {
        return switch (t){
            case Id id -> new EmitId(id).toSC();
            case Impulse impulse -> new EmitImpulse(impulse).toSC();
            case Schema schema -> new EmitSchema(schema).toSC();
            case Serie serie -> new EmitSerie(serie).toSC();
            case Text text -> new EmitText(text).toSC();
        };
    }
}
