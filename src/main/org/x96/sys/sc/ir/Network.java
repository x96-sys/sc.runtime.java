package org.x96.sys.sc.ir;

import java.util.Optional;

public sealed interface Network extends ScIr permits Organelle, Stimulus {

    default boolean reply(Id id) {
        throw new RuntimeException("implemente reply na filha " + this.getClass().getSimpleName());
    }

    default Optional<Pulse> pulse(Id id) {
        throw new RuntimeException(
                "Método 'pulse' deve ser implementado na classe filha: "
                        + this.getClass().getSimpleName());
    }
}
