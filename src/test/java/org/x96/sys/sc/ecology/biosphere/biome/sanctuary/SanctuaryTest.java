package org.x96.sys.sc.ecology.biosphere.biome.sanctuary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.sc.buzz.sanctuary.BuzzHeapUnknownReference;
import org.x96.sys.sc.buzz.sanctuary.BuzzTypeMismatchException;
import org.x96.sys.sc.buzz.sanctuary.BuzzUnknownInstance;
import org.x96.sys.sc.buzz.sanctuary.BuzzUnknownSpecimenException;
import org.x96.sys.sc.ecology.EcoSys;
import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.ir.*;

class SanctuaryTest {
    public Sanctuary fromBiome(String biome) {
        return new Sanctuary(new Biome(new Id(biome.getBytes())));
    }

    @Test
    void happy() {
        String biome = "savannah";
        Sanctuary sanctuary = fromBiome(biome);
        assertNotNull(sanctuary);
        assertEquals(0, sanctuary.specimens.size());
        assertEquals(0, sanctuary.immortals.size());
        assertEquals(0, sanctuary.phenotypes.size());
        assertArrayEquals(biome.getBytes(), sanctuary.habitat.bioName.raw());
    }

    @Test
    void happyBuzzUnknownSpecimenException() {
        Sanctuary sanctuary = fromBiome("savannah");
        Specimen s = new Specimen(new Id("var".getBytes()), new Id("Lion".getBytes()));
        var e = assertThrows(BuzzUnknownSpecimenException.class, () -> sanctuary.keep(s));
        assertEquals(
                """
                🦕 [0xE8]
                🐝 [BuzzUnknownSpecimenException]
                🌵 > Can't keep on var [var] unknown specimen [Lion]\
                """,
                e.getMessage());
    }

    @Test
    void happyBuzzUnknownInstance() {
        Sanctuary sanctuary = fromBiome("savannah");
        Specimen s = new Specimen(new Id("vol".getBytes()), new Id("Volume".getBytes()));

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

        assertEquals(0, sanctuary.specimens.size());
        assertEquals(0, sanctuary.immortals.size());
        assertEquals(0, sanctuary.phenotypes.size());

        Dendrite dendrite = ((Bee) organelle).dendrites()[0];

        var f =
                assertThrows(
                        BuzzUnknownInstance.class,
                        () -> sanctuary.predicate(s, dendrite, new Nb16(0x3E8)));
        assertEquals(
                """
                🦕 [0xE9]
                🐝 [BuzzUnknownInstance]
                🌵 > vc esta tentando incluir predicados em instancias que n existem\
                """,
                f.getMessage());
    }

    @Test
    void happyBuzzTypeMismatchException() {
        Sanctuary sanctuary = fromBiome("savannah");
        Specimen s = new Specimen(new Id("name".getBytes()), new Id("Distro".getBytes()));
        EcoSys eco = new EcoSys();
        eco.bioBuff(
                """
                :bug Distro
                    :gene name Echo;
                    :gene year Hex;
                ;
                """
                        .getBytes());
        Network network = eco.buffTree.hive().egg().network()[0];
        Organelle organelle = (Organelle) network;
        Bee bee = (Bee) organelle;

        sanctuary.habitat.integrates(bee.id(), bee);
        assertDoesNotThrow(() -> sanctuary.keep(s));
        assertEquals(1, sanctuary.specimens.size());
        assertEquals(0, sanctuary.immortals.size());
        assertEquals(0, sanctuary.phenotypes.size());

        Dendrite dendriteNameEcho = bee.dendrites()[0]; // :gene name Echo;
        var e =
                assertThrows(
                        BuzzTypeMismatchException.class,
                        () -> sanctuary.predicate(s, dendriteNameEcho, new Nb16(0x7C7)));
        assertEquals(
                """
                🦕 [0xEA]
                🐝 [BuzzTypeMismatchException]
                🌵 > Tipo incorreto: esperado Text para tipo 'Echo', mas recebido Nb16\
                """,
                e.getMessage());

        assertEquals(1, sanctuary.specimens.size());
        assertEquals(0, sanctuary.immortals.size());
        assertEquals(0, sanctuary.phenotypes.size());

        Dendrite dendriteYearHex = bee.dendrites()[1]; // :gene year Hex;
        e =
                assertThrows(
                        BuzzTypeMismatchException.class,
                        () ->
                                sanctuary.predicate(
                                        s, dendriteYearHex, new Text("linux".getBytes())));
        assertEquals(
                """
                🦕 [0xEA]
                🐝 [BuzzTypeMismatchException]
                🌵 > Tipo incorreto: esperado Nb16 para tipo 'Hex', mas recebido Text\
                """,
                e.getMessage());

        assertEquals(1, sanctuary.specimens.size());
        assertEquals(0, sanctuary.immortals.size());
        assertEquals(0, sanctuary.phenotypes.size());
    }

    @Test
    void happyHeapConstant() {
        Sanctuary sanctuary = fromBiome("sys");
    }

    @Test
    void happyHeap() {
        Sanctuary sanctuary = fromBiome("savannah");
        Id bugName = new Id("vol".getBytes());
        Id bugType = new Id("Volume".getBytes());
        Specimen s = new Specimen(bugName, bugType);
        int primitive = 0x3E8;
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

        sanctuary.habitat.integrates(bee.id(), bee); // stack `Volume`
        assertDoesNotThrow(() -> sanctuary.keep(s)); // sanctuary `@vol = Volume{};`
        assertEquals(1, sanctuary.specimens.size()); // instance recorded
        assertEquals(0, sanctuary.immortals.size()); // constantes
        assertEquals(0, sanctuary.phenotypes.size()); // atributos individuais de cada instancia

        Dendrite geneM3Int = bee.dendrites()[0]; // :gene m3 int;
        sanctuary.predicate(s, geneM3Int, new Nb16(primitive)); // `vol.m3 = 0x3E8;`

        assertEquals(1, sanctuary.specimens.size());
        assertEquals(0, sanctuary.immortals.size());
        assertEquals(1, sanctuary.phenotypes.size()); // atributos individuais de cada instancia

        Phenotype phenotype = sanctuary.phenotypes.getFirst();
        assertArrayEquals(phenotype.specimen().id().raw(), bugName.raw());
        assertEquals(phenotype.dendrite(), geneM3Int);
        assertInstanceOf(Nb16.class, phenotype.polymorphic());
        assertEquals(primitive, ((Nb16) phenotype.polymorphic()).raw());
    }

    @Test
    void happyComposite() {
        Sanctuary sanctuary = fromBiome("pokedex");

        EcoSys eco = new EcoSys();
        eco.bioBuff(
                """
                :bug Pokemon
                    :gene name Echo;
                    :gene xp Hex;
                ;
                """
                        .getBytes());
        Network network = eco.buffTree.hive().egg().network()[0];
        Organelle organelle = (Organelle) network;
        Bee pokemon = (Bee) organelle;

        assertEquals(0, sanctuary.habitat.organisms.size());
        sanctuary.habitat.integrates(pokemon.id(), pokemon); // stack `Pokemon`
        assertEquals(1, sanctuary.habitat.organisms.size());

        eco.bioBuff(
                """
                :bug ChallengePokemon
                    :gene challenging Pokemon;
                    :gene challenged Pokemon;
                ;
                """
                        .getBytes());
        network = eco.buffTree.hive().egg().network()[0];
        organelle = (Organelle) network;
        Bee challengePokemon = (Bee) organelle;

        sanctuary.habitat.integrates(
                challengePokemon.id(), challengePokemon); // stack `ChallengePokemon`
        assertEquals(2, sanctuary.habitat.organisms.size());

        Id bugName = new Id("pikachu".getBytes());
        Id bugType = new Id("Pokemon".getBytes());
        Specimen pikachu = new Specimen(bugName, bugType); // @pikachu = Pokemon{};

        bugName = new Id("charizard".getBytes());
        Specimen charizard = new Specimen(bugName, bugType); // @charizard = Pokemon{};

        assertEquals(0, sanctuary.specimens.size());
        assertDoesNotThrow(() -> sanctuary.keep(pikachu)); // sanctuary `@pikachu = Pokemon{};`
        assertEquals(1, sanctuary.specimens.size());

        assertDoesNotThrow(() -> sanctuary.keep(charizard)); // sanctuary `@charizard = Pokemon{};`
        assertEquals(2, sanctuary.specimens.size());

        bugName = new Id("battle".getBytes());
        bugType = new Id("ChallengePokemon".getBytes());
        Specimen battle = new Specimen(bugName, bugType); // @battle = ChallengePokemon{};

        assertDoesNotThrow(
                () -> sanctuary.keep(battle)); // sanctuary `@battle = ChallengePokemon{};`
        assertEquals(3, sanctuary.specimens.size());

        Dendrite dendriteChallenging =
                challengePokemon.dendrites()[0]; // :gene challenging Pokemon;

        // Deve falhar: referência não existe no sanctuary
        // @battle.challenging = charmander;
        var e =
                assertThrows(
                        BuzzHeapUnknownReference.class,
                        () ->
                                sanctuary.predicate(
                                        battle,
                                        dendriteChallenging,
                                        new Id("charmander".getBytes())));
        assertEquals(
                """
                🦕 [0xEB]
                🐝 [BuzzHeapUnknownReference]
                🌵 > Referência [charmander] não existe no sanctuary\
                """,
                e.getMessage());

        assertEquals(0, sanctuary.phenotypes.size()); // atributos individuais de cada instancia

        // Deve funcionar: referência existe no sanctuary
        assertDoesNotThrow(
                () ->
                        sanctuary.predicate(
                                battle,
                                dendriteChallenging,
                                pikachu.id())); // @battle.challenging = pikachu;
        assertEquals(1, sanctuary.phenotypes.size());
    }
}
