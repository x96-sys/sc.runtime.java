package org.x96.sys.sc.emit.self.hive.egg.network.organelle.rune;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.EmitPulse;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.ir.synthetic.Rune;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EmitRune extends Emit<Rune> {
    public EmitRune(Rune t) {
        super(t);
    }

    @Override
    public String toSC() {
        String totem = new EmitId(t.id()).toSC();

        if (t.insignias() == null || t.insignias().length == 0) {
            return String.format(":totem %s;%n", totem);
        }

        String insignias = Arrays.stream(t.insignias())
                .map(id -> " ".repeat(4) + new EmitId(id).toSC())
                .collect(Collectors.joining(System.lineSeparator(), System.lineSeparator(), System.lineSeparator()));

        String pulses = Arrays.stream(t.pulses())
                .map(p -> " ".repeat(4) + new EmitPulse(p).toSC())
                .collect(Collectors.joining(System.lineSeparator(), System.lineSeparator(), System.lineSeparator()));

        return String.format(":totem %s%s%s;%n", totem, insignias, pulses);
    }
}
