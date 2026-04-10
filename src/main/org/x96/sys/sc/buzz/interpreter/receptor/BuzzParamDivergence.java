package org.x96.sys.sc.buzz.interpreter.receptor;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ir.*;

public class BuzzParamDivergence extends Buzz {
    public BuzzParamDivergence(Neurotransmitter expected, Signal provided, int paramIndex) {
        super(
                0xE7,
                BuzzParamDivergence.class.getSimpleName(),
                explainParamDivergence(expected, provided, paramIndex));
    }

    private static String explainParamDivergence(
            Neurotransmitter expected, Signal provided, int paramIndex) {
        String expectedType = new String(expected.isoform().id().raw());
        String providedType = getSignalTypeName(provided);

        return "Tipo incompatível no parâmetro "
                + (paramIndex + 1)
                + ":\n"
                + "  Esperado: "
                + expectedType
                + "\n"
                + "  Recebido: "
                + providedType;
    }

    private static String getSignalTypeName(Signal signal) {
        return switch (signal) {
            case Activity _ -> "Activity";
            case Serie _ -> "Filament";
            case Impulse _ -> "Fly";
            case Wave _ -> "Aura";
        };
    }
}
