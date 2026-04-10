package org.x96.sys.sc.emit.targets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.ir.Id;

class SCTest {

    @Test
    void happyBiome() {
        new Biome(new Id("".getBytes()));
    }
}
