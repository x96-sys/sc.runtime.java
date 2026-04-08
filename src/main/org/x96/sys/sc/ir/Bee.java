package org.x96.sys.sc.ir;

import org.x96.sys.Sys;
import org.x96.sys.buzz.BuzzHappensMismatchSpore;
import org.x96.sys.sc.buzz.BuzzHappensUnknowSpore;
import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Arrays;
import java.util.Optional;

public record Bee(
        Id id,
        Dendrite[] dendrites,
        Pulse[] pulses,
        Able[] ables,
        Be[] bes,
        Optional<Bundle> bundle)
        implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        id.prettyPrint(child);
        bundle.ifPresent(b -> b.prettyPrint(child));
        for (Dendrite d : dendrites) {
            d.prettyPrint(child);
        }
        for (Pulse p : pulses) {
            p.prettyPrint(child);
        }
    }

    public boolean reply(Id id) {
        return Arrays.stream(pulses).anyMatch(p -> p.id().equals(id));
    }

    @Override
    public Optional<Pulse> pulse(Id id) {
        return Arrays.stream(pulses).filter(p -> p.id().equals(id)).findFirst();
    }

    public boolean happensWith(Spore spore) {
        Optional<Dendrite> optionalDendrite =
                Arrays.stream(dendrites)
                        .filter(
                                d ->
                                        Arrays.equals(
                                                spore.id().raw(),
                                                d.neurotransmitter().aminoAcidName().getBytes()))
                        .findFirst();
        if (optionalDendrite.isEmpty()) {
            String msg =
                    String.format(
                            "Bee [%s] cant happens with [%s]",
                            new String(this.id.raw()), new String(spore.id().raw()));
            throw new BuzzHappensUnknowSpore(msg);
        }
        Dendrite dendrite = optionalDendrite.get();

        String msg =
                String.format(
                        "Bee [%s] wait [%s] on [%s] and receive [%s]",
                        new String(this.id.raw()),
                        new String(dendrite.neurotransmitter().isoform().id().raw()),
                        new String(spore.id().raw()),
                        Sys.kind(spore.impulse()));
        if (matches(spore, dendrite)) {
            return true;
        }
        throw new BuzzHappensMismatchSpore(msg);
    }

    private boolean matches(Spore spore, Dendrite d) {
        Id b = d.neurotransmitter().isoform().id();
        return matcher(spore, b);
    }

    private boolean matcher(Spore spore, Id iso) {
        byte[] expected = iso.raw();
        byte[] provided = Sys.kind(spore.impulse()).getBytes();

        if (literalCast(expected, provided)) {
            return true;
        }

        return Arrays.equals(expected, provided);
        //        System.out.println("iso: " + new String(expected));
        //        System.out.println("spore: " + new String(provided));
    }

    private boolean literalCast(byte[] expected, byte[] provided) {
        return Arrays.equals(expected, "int".getBytes())
                && Arrays.equals(provided, "Hex".getBytes());
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
