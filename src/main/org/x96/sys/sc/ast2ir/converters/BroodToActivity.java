package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Brood;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Activity;
import org.x96.sys.sc.ir.Signal;

public class BroodToActivity implements ToIr<Brood, Activity> {
    @Override
    public Activity convert(Brood brood) {
        Signal[] signals = new Signal[brood.nectar().length];
        for (int i = 0; i < brood.nectar().length; i++) {
            signals[i] = new NectarToSignal().convert(brood.nectar()[i]);
        }
        return new Activity(signals);
    }
}
