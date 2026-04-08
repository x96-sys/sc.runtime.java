package org.x96.sys.sc.ecology.biosphere;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.sc.ecology.EcoSys;
import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.ir.Hippocampus;
import org.x96.sys.sc.ir.Id;
import org.x96.sys.sc.ir.Tree;

class BiosphereTest {
    @Test
    void happy() {
        Biosphere biosphere = new Biosphere();
        assertNotNull(biosphere);
        assertNull(biosphere.dawning);
        assertEquals(0, biosphere.biomes.size());

        Id dawn = new Id("organism".getBytes());
        biosphere.dawn(dawn);
        assertNotNull(biosphere.dawning);
        assertEquals(1, biosphere.biomes.size());
        Biome b = biosphere.biome(dawn);
        assertNotNull(b);
        assertEquals(0, b.organisms.size());
    }

    @Test
    void happyDawning() {
        Biosphere biosphere = new Biosphere();
        Id dawn = new Id("main".getBytes());
        biosphere.dawn(dawn);
        assertNotNull(biosphere.dawning);
        assertEquals(1, biosphere.biomes.size());
        Biome b = biosphere.biome(dawn);
        assertNotNull(b);
        assertEquals(0, b.organisms.size());
        assertNotNull(b.chronicle);
        assertEquals(0, b.chronicle.specimens.size());
        assertEquals(0, b.chronicle.immortals.size());
        assertEquals(0, b.chronicle.phenotypes.size());
        assertSame(b, biosphere.biome());
        assertTrue(biosphere.contains(new Id("main".getBytes())));
        assertFalse(biosphere.contains(new Id("darkness".getBytes())));
    }

    @Test
    void happyConstant() {
        Biosphere biosphere = new Biosphere();
        Id dawn = new Id("earth".getBytes());
        biosphere.dawn(dawn);

        Tree tree = EcoSys.frontEnd("%VERSION = '0.1.2';".getBytes());
        Hippocampus hippocampus = (Hippocampus) tree.hive().egg().network()[0];
        biosphere.imortalize(hippocampus);
    }

    @Test
    void happyUnknownBiome() {
        Biosphere biosphere = new Biosphere();
        var e =
                assertThrows(
                        RuntimeException.class,
                        () -> biosphere.biome(new Id("organism".getBytes())));
        assertEquals("Can't read unknown biome [organism]", e.getMessage());
    }
}
