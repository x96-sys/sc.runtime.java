package org.x96.sys.sc.ecology.biosphere.biome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.sc.ecology.EcoSys;
import org.x96.sys.sc.ecology.biosphere.biome.sanctuary.Sanctuary;
import org.x96.sys.sc.emit.targets.PUML;
import org.x96.sys.sc.ir.*;

import java.util.Optional;

class BiomeTest {

    @Test
    void happy() {
        String biomeName = "amazon";
        Id biomeId = new Id(biomeName.getBytes());
        Biome biome = new Biome(biomeId);
        assertArrayEquals(biomeName.getBytes(), biome.bioName.raw());
        assertEquals(0, biome.organisms.size());

        EcoSys eco = new EcoSys();
        eco.bioBuff(
                """
                :bug Volume
                    :gene m3 int;
                ;
                """
                        .getBytes());
        Network network = eco.buffTree.hive().egg().network()[0];
        Organelle organelle = (Organelle) network;
        Bee bee = (Bee) organelle;

        assertFalse(biome.integrated(bee.id()));
        biome.integrates(bee.id(), bee);

        assertEquals(1, biome.organisms.size());
    }

    @Test
    void happyPrimitiveIntegration() {
        Biome biome = new Biome(new Id("any".getBytes()));
        assertTrue(biome.integrated(new Id("Echo".getBytes())));
        assertTrue(biome.integrated(new Id("Hex".getBytes())));
        assertEquals(0, biome.organisms.size());
        assertEquals(0, biome.chronicle.specimens.size());
        assertEquals(0, biome.chronicle.immortals.size());
        assertEquals(0, biome.chronicle.phenotypes.size());
    }

    @Test
    void happyEcho() {
        Biome biome = new Biome(new Id("sys".getBytes()));

        EcoSys eco = new EcoSys();
        eco.bioBuff(
                """
                :bug Echo
                    :gene raw echo;
                ;
                """
                        .getBytes());
        Bee bee = (Bee) eco.buffTree.hive().egg().network()[0];

        assertEquals(0, biome.organisms.size());
        biome.integrates(bee.id(), bee);
        assertEquals(1, biome.organisms.size());

        PUML puml = new PUML();
        String gen = biome.accept(puml, "");
        assertEquals(
                """
                @startuml
                package sys {
                    struct Echo {
                        + raw: echo
                    }
                }
                @enduml
                """,
                gen);
    }

    @Test
    void happyConstant() {
        String biomeName = "sys";
        Id biomeId = new Id(biomeName.getBytes());
        Biome biome = new Biome(biomeId);

        EcoSys eco = new EcoSys();

        // constant echo
        // %VERSION = '0.1.2';
        String constantSignal = "%";
        String constantName = "VERSION";
        String constantValue = "0.1.2";

        eco.bioBuff(
                String.format("%s%s = '%s';", constantSignal, constantName, constantValue)
                        .getBytes());
        Network network = eco.buffTree.hive().egg().network()[0];

        assertInstanceOf(Stimulus.class, network);
        assertInstanceOf(Hippocampus.class, network);
        Hippocampus hippocampus = (Hippocampus) network;
        assertEquals(Nature.FIXED, hippocampus.nature());
        assertArrayEquals(constantName.getBytes(), hippocampus.id().raw());
        assertTrue(hippocampus.signal().isPresent());
        Signal signal = hippocampus.signal().get();
        assertInstanceOf(Impulse.class, signal);

        Impulse impulse = (Impulse) signal;
        Neuron neuron = impulse.neuron();

        assertTrue(neuron.isPrimitive());
        assertFalse(neuron.isId());
        assertInstanceOf(Text.class, neuron);
        assertTrue(impulse.nerve().isEmpty());

        Text text = (Text) neuron;
        assertArrayEquals(constantValue.getBytes(), text.raw());

        Id constantId = new Id(constantName.getBytes());
        assertFalse(biome.integrated(constantId));

        assertEquals(0, biome.chronicle.immortals.size());
        biome.imortalize(new Hippocampus(Nature.FIXED, constantId, Optional.of(impulse)));
        assertEquals(1, biome.chronicle.immortals.size());
    }

    @Test
    void happyConstantOnEcoSys() {
        EcoSys es = new EcoSys();
        byte[] payload = "sys".getBytes();
        Id garden = new Id(payload);
        es.rise(garden);
        assertNotNull(es.biosphere);
        assertNotNull(es.biosphere.dawning);
        assertArrayEquals(payload, es.biosphere.dawning.raw());
        assertEquals(1, es.biosphere.biomes.size());
        assertTrue(es.biosphere.biomes.containsKey(garden));
        Biome biomeOnBiosphereOnSys = es.biosphere.biomes.get(garden);
        assertNotNull(biomeOnBiosphereOnSys.bioName);
        assertEquals(garden, biomeOnBiosphereOnSys.bioName);
        assertEquals(0, biomeOnBiosphereOnSys.organisms.size());
        assertNotNull(biomeOnBiosphereOnSys.chronicle);
        Sanctuary folklore = biomeOnBiosphereOnSys.chronicle;
        assertEquals(0, folklore.specimens.size());
        assertEquals(0, folklore.immortals.size());
        assertEquals(0, folklore.phenotypes.size());
    }
}
