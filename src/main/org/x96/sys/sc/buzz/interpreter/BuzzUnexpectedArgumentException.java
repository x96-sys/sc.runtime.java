package org.x96.sys.sc.buzz.interpreter;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ir.Neuron;
import org.x96.sys.sc.ir.Synaptic;

public class BuzzUnexpectedArgumentException extends Buzz {
    public static final int CODE = 0xEC;

    public BuzzUnexpectedArgumentException(Neuron neuron, Synaptic synaptic) {
        super(
                CODE,
                BuzzUnexpectedArgumentException.class.getSimpleName(),
                explainUnexpectedArgumentException(neuron, synaptic));
    }

    public static String explainUnexpectedArgumentException(Neuron neuron, Synaptic synaptic) {
        return String.format(
                "nenhum argumento eh esperado em [%s] do [%s]",
                new String(synaptic.id().raw()), new String(neuron.bug().raw()));
    }
}
