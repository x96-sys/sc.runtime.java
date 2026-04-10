package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Bug;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.*;

import java.util.Optional;

public class BugToBee implements ToIr<Bug, Bee> {
    @Override
    public Bee convert(Bug bug) {
        Id id = new PrimorToId().convert(bug.primor());

        Pulse[] pulses = new Pulse[bug.ethics().length];
        for (int i = 0; i < bug.ethics().length; i++) {
            pulses[i] = new EthicsToPulse().convert(bug.ethics()[i]);
        }

        Dendrite[] dendrites = new Dendrite[bug.genes().length];
        for (int i = 0; i < bug.genes().length; i++) {
            dendrites[i] = new GeneToDendrite().convert(bug.genes()[i]);
        }

        Able[] ables = new Able[bug.cans().length];
        for (int i = 0; i < bug.cans().length; i++) {
            ables[i] = new CanToAble().convert(bug.cans()[i]);
        }

        Be[] bes = new Be[bug.as().length];
        for (int i = 0; i < bug.as().length; i++) {
            bes[i] = new AsToBe().convert(bug.as()[i]);
        }

        Optional<Bundle> bundle = Optional.empty();
        if (bug.generalization().isPresent()) {
            bundle = Optional.of(new GeneralizationToBundle().convert(bug.generalization().get()));
        }

        return new Bee(id, dendrites, pulses, ables, bes, bundle);
    }
}
