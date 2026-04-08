package org.x96.sys.sc.buzz.interpreter;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ir.Endo;
import org.x96.sys.sc.ir.Id;
import org.x96.sys.sc.ir.Nb16;
import org.x96.sys.sc.ir.Neuron;
import org.x96.sys.sc.ir.Text;

public class BuzzUnknownForager extends Buzz {

    public static final int CODE = 0xE3;

    public BuzzUnknownForager(Neuron neuron) {
        super(CODE, BuzzUnknownForager.class.getSimpleName(), explainUnknownNeuron(neuron));
    }

    private static String explainUnknownNeuron(Neuron neuron) {
        String neuronStr =
                switch (neuron) {
                    case Id id -> new String(id.raw());
                    case Text text -> new String(text.raw());
                    case Nb16 nb16 -> String.valueOf(nb16.raw());
                    case Endo ignored -> "$";
                };
        return String.format("can't fly with forager [%s] not found", neuronStr);
    }
}
