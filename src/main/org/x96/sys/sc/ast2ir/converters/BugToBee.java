package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Bug;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Bee;
import org.x96.sys.sc.ir.synthetic.Pulse;

public class BugToBee implements ToIr<Bug, Bee> {
    @Override
    public Bee convert(Bug bug) {
        Pulse[] pulses = new Pulse[bug.ethics().length];
        for (int i = 0; i < bug.ethics().length; i++) {
            pulses[i] = new EthicsToPulse().convert(bug.ethics()[i]);
        }
        return new Bee(new PrimorToId().convert(bug.primor()), pulses);
    }
}
