package org.x96.sys.sc.ecology.biosphere;

import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.ir.Hippocampus;
import org.x96.sys.sc.ir.Id;

import java.util.HashMap;

// PACKAGE
public class Biosphere {
    public Id dawning;
    public HashMap<Id, Biome> biomes;

    public Biosphere() {
        this.biomes = new HashMap<>();
        this.dawning = null;
    }

    public boolean contains(Id biome) {
        return biomes.containsKey(biome);
    }

    public void dawn(Id dawn) {
        if (biomes.isEmpty() || !contains(dawn)) {
            dawning = dawn;
            biomes.put(dawning, new Biome(dawning));
            return;
        }
        if (dawning.equals(dawn)) {
            return;
        }
        dawning = dawn;
        if (!contains(dawning)) {
            biomes.put(dawning, new Biome(dawning));
        }
    }

    public Biome biome() {
        guardBiome(dawning);
        return biomes.get(dawning);
    }

    public Biome biome(Id id) {
        guardBiome(id);
        return biomes.get(id);
    }

    public void guardBiome(Id biome) {
        if (biome == null) {
            throw new RuntimeException("Biome is ready");
        }
        if (!contains(biome)) {
            String explain =
                    String.format("Can't read unknown biome [%s]", new String(biome.raw()));
            throw new RuntimeException(explain);
        }
    }

    public void imortalize(Hippocampus hippocampus) {
        biome().imortalize(hippocampus);
    }
}
