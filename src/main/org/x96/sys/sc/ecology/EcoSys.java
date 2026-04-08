package org.x96.sys.sc.ecology;

import org.x96.sys.lexer.Lexer;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Sc;
import org.x96.sys.sc.ast2ir.converters.ScToTree;
import org.x96.sys.sc.ecology.biosphere.Biosphere;
import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.emit.*;
import org.x96.sys.sc.emit.targets.*;
import org.x96.sys.sc.ir.*;
import org.x96.sys.sc.parser.ParserSC;

// SANDBOX
public class EcoSys {
    public Biosphere biosphere;
    public Tree buffTree;

    public EcoSys() {
        this.biosphere = new Biosphere();
        this.buffTree = null;
    }

    public void rise(Id sunshine) {
        biosphere.dawn(sunshine);
    }

    public void bioIntegrate(byte[] payload) {
        bioBuff(payload);
        for (Network network : buffTree.hive().egg().network()) {
            web(network);
        }
    }

    public void bioBuff(byte[] payload) {
        this.buffTree = frontEnd(payload);
    }

    public static Tree frontEnd(byte[] payload) {
        Sc x =
                new ParserSC(
                                new Tape(
                                        new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Sc.class)
                                                .lexWrapped(payload)))
                        .parse();
        x.prettyPrint("");
        return new ScToTree().convert(x);
    }

    public void eco(String indent) {
        System.out.printf("%s☀️ [x96] [EcoSys] [SC]%n", indent);
        System.out.printf("%s🪐 [biomes] [%s]%n", indent, biosphere.biomes.size());
        String child = indent + " ".repeat(4);
        for (Biome b : biosphere.biomes.values()) {
            b.eco(child);
        }
    }

    public String emit(EcoTarget target) {
        EmitterVisitor visitor =
                switch (target) {
                    case SC -> new SC();
                    case LLVM -> new LLVM();
                    case JAVA -> new Java();
                    case TS -> new TS();
                    case ZIG -> new Zig();
                    case PUML -> new PUML();
                    case RUST -> new Rust();
                    case RUBY -> new Ruby();
                    case HASKELL -> new Haskell();
                    case GO -> new Go();
                    case SWIFT -> new Swift();
                    default ->
                            throw new UnsupportedOperationException(
                                    "Target not supported: " + target);
                };

        StringBuilder sb = new StringBuilder();
        for (Biome b : biosphere.biomes.values()) {
            sb.append(b.accept(visitor, ""));
        }

        return sb.toString();
    }

    // -------------------------------------

    private void web(Network network) {
        switch (network) {
            case Organelle organelle -> {
                orgIntegrate(organelle);
            }
            case Stimulus stimulus -> {
                stimulusIntegrate(stimulus);
            }
        }
    }

    private void stimulusIntegrate(Stimulus stimulus) {
        switch (stimulus) {
            case Hippocampus hippocampus -> {
                hippocampusIntegrate(hippocampus);
            }
            case Impulse impulse -> {
                impulseIntegrate(impulse);
            }
        }
    }

    private void hippocampusIntegrate(Hippocampus hippocampus) {
        switch (hippocampus.nature()) {
            case MUTABLE -> {
                throw new RuntimeException("me implemente");
            }
            case FIXED -> {
                biosphere.imortalize(hippocampus);
            }
        }
    }

    private void impulseIntegrate(Impulse impulse) {
        throw new RuntimeException("me implemente");
    }

    private void orgIntegrate(Organelle organelle) {
        switch (organelle) {
            case Rune rune -> {
                runeIntegrate(rune);
            }
            case Bee bee -> {
                beeIntegrate(bee);
            }
            case Connect connect -> {
                connectIntegrate(connect);
            }
            case Habit habit -> {
                throw new RuntimeException("me implemente");
            }
            case Pulse pulse -> {
                throw new RuntimeException("me implemente");
            }
            case Swarm swarm -> {
                rise(swarm.id());
            }
        }
    }

    private void beeIntegrate(Bee bee) {
        biosphere.biome().integrates(bee.id(), bee);
    }

    private void connectIntegrate(Connect connect) {
        throw new RuntimeException("me implemente");
        // biosphere.biome().integrates(connect.id(), connect);
    }

    private void runeIntegrate(Rune rune) {
        biosphere.biome().integrates(rune.id(), rune);
    }
}
