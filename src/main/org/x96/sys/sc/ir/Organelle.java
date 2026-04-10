package org.x96.sys.sc.ir;

public sealed interface Organelle extends Network permits Bee, Rune, Swarm, Connect, Pulse, Habit {
    public default boolean reply(Synaptic synaptic) {
        throw new RuntimeException("implemente reply na filha " + this.getClass().getSimpleName());
    }
}
