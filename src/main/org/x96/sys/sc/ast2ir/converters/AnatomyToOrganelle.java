package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.*;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Organelle;

public class AnatomyToOrganelle implements ToIr<Anatomy, Organelle> {
    @Override
    public Organelle convert(Anatomy anatomy) {
        return switch (anatomy) {
            case Bug bug -> new BugToBee().convert(bug);
            case Ethics ethics -> new EthicsToPulse().convert(ethics);
            case Know know -> new KnowToConnect().convert(know);
            case Logos logos -> new LogosToSwarm().convert(logos);
            case Totem totem -> new TotemToRune().convert(totem);
        };
    }
}
