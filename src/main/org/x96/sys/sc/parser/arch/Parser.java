package org.x96.sys.sc.parser.arch;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.can.ParserAs;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.can.ParserCan;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.ParserEthics;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.typo.modTypo.ParserModSig;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.gene.ParserGene;

import java.util.List;

public abstract class Parser extends org.x96.sys.parser.Parser {
    public Parser(Tape tape) {
        super(tape);
    }

    public void skipSpace() {
        if (hasNext("space")) {
            consume("space");
            skipSpace();
        }
    }

    public void skip(String s) {
        if (hasNext(s)) {
            consume(s);
            skip(s);
        }
    }

    public void skipI() {
        if (hasNext("i")) {
            consume("i");
            skipI();
        }
    }

    public void skipPS() {
        if (hasNext("ps")) {
            consume("ps");
        }
    }

    public boolean hasNextTie() {
        return hasNextCan() || hasNextAs();
    }

    public boolean hasNextAs() {
        return hasNext("as");
    }

    public boolean hasNextCan() {
        return hasNext("can");
    }

    public boolean hasNextSkill() {
        return hasNext("skill");
    }

    public boolean hasNextBug() {
        return hasNext("bug");
    }

    public boolean hasNextTotem() {
        return hasNext("totem");
    }

    public boolean hasNextLogos() {
        return hasNext("logos");
    }

    public boolean hasNextKnow() {
        return hasNext("know");
    }

    public boolean hasNextFilament() {
        return hasNext("filament");
    }

    public boolean hasNextBrood() {
        return hasNextNectar();
    }

    public boolean hasNextPrimorLiteral() {
        return hasNext("primor_literal");
    }

    public boolean hasNextHappens() {
        return hasNext("init_happens");
    }

    public boolean hasNextCatalysis() {
        return hasNext("catalysis");
    }

    public boolean hasNextCarrier() {
        return hasNext("init_carrier");
    }

    public boolean hasNextHex() {
        return hasNext("hex");
    }

    public boolean hasNextCourse() {
        return hasNextCatalysis() || hasNextCarrier() || hasNextHappens();
    }

    public boolean hasNextFly() {
        return hasNextPrimor() || hasNextIpse() || hasNextHex() || hasNextEcho();
    }

    public boolean hasNextIpse() {
        return hasNext("ipse");
    }

    public boolean hasNextResonance() {
        return hasNext("resonance");
    }

    public boolean hasNextVoid() {
        return hasNext("void");
    }

    public boolean hasNextModSig() {
        return hasNextArray() || hasNextOptional() || hasNextSplat();
    }

    public boolean hasNextPairFollow() {
        return hasNext("pair_follow");
    }

    public boolean hasNextPair() {
        return hasNextAttribute() || hasNextTypo();
    }

    private boolean hasNextTypo() {
        return hasNextArray() || hasNextOptional();
    }

    public boolean hasNextOptional() {
        return hasNext("optional");
    }

    public boolean hasNextArray() {
        return hasNext("init_array");
    }

    public boolean hasNextAttribute() {
        return hasNextModSig() || hasNextPrimor();
    }

    public boolean hasNextSplat() {
        return hasNext("splat");
    }

    public boolean hasNextPrimor() {
        return hasNext("primor");
    }

    public boolean hasNextGeneralization() {
        return hasNext("init_generalization");
    }

    public boolean hasNextAura() {
        return hasNextSignature();
    }

    public boolean hasNextNectar() {
        return hasNextFilament()
                || hasNextFly()
                || hasNextPrimorLiteral()
                || hasNextAura()
                || hasNextArray();
    }

    public boolean hasNextSignature() {
        return hasNext("init_signature");
    }

    public boolean hasNextEcho() {
        return hasNext("echo");
    }

    public boolean hasNextGenome() {
        return hasNextAnatomy() || hasNextBehavior();
    }

    public boolean hasNextAnatomy() {
        return hasNext("init_anatomy");
    }

    public boolean hasNextBehavior() {
        return hasNextPollinate() || hasNextFly();
    }

    public boolean hasNextPollinate() {
        return hasNext("flower");
    }

    public void followBugAnatomy(
            List<Ethics> ethics, List<Can> cans, List<As> as, List<Gene> genes) {
        if (hasNext("init_anatomy")) {
            consume("init_anatomy");
            skipI();
            if (hasNext("ethics")) {
                ethics.add(new ParserEthics(tape).parse());
            }
            if (hasNext("can")) {
                cans.add(new ParserCan(tape).parse());
            }
            if (hasNext("as")) {
                as.add(new ParserAs(tape).parse());
            }
            if (hasNext("gene")) {
                genes.add(new ParserGene(tape).parse());
            }
            skipI();
            consume("fini_anatomy");
            skipI();
            followBugAnatomy(ethics, cans, as, genes);
        }
    }

    public void followOptionalModSig(List<ModSig> mods) {
        skipI();
        parserOptionalModSig(mods);
        skipI();
    }

    public void parserOptionalModSig(List<ModSig> m) {
        if (hasNextModSig()) {
            m.add(new ParserModSig(tape).parse());
            skipI();
            parserOptionalModSig(m);
        }
    }
}
