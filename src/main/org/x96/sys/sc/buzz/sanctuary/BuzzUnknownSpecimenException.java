package org.x96.sys.sc.buzz.sanctuary;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ecology.biosphere.biome.sanctuary.Specimen;

public class BuzzUnknownSpecimenException extends Buzz {
    public static final int CODE = 0xE8;

    public BuzzUnknownSpecimenException(Specimen specimen) {
        super(
                CODE,
                BuzzUnknownSpecimenException.class.getSimpleName(),
                explainUnknownSpecimenException(specimen));
    }

    public static String explainUnknownSpecimenException(Specimen specimen) {
        return String.format(
                "Can't keep on var [%s] unknown specimen [%s]",
                new String(specimen.id().raw()), new String(specimen.neuron().bug().raw()));
    }
}
