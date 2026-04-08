package org.x96.sys.sc.ecology.biosphere.biome.sanctuary;

import org.x96.sys.sc.buzz.sanctuary.BuzzHeapUnknownReference;
import org.x96.sys.sc.buzz.sanctuary.BuzzTypeMismatchException;
import org.x96.sys.sc.buzz.sanctuary.BuzzUnknownInstance;
import org.x96.sys.sc.buzz.sanctuary.BuzzUnknownSpecimenException;
import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.emit.EmitterVisitor;
import org.x96.sys.sc.ir.*;

import java.util.*;

// HEAP
public class Sanctuary {
    public final Biome habitat;
    public List<Specimen> specimens; // instancias
    public List<Specimen> immortals; // constantes
    public List<Phenotype> phenotypes; // pares de atributo e valor de cada instância

    public Sanctuary(Biome habitat) {
        this.habitat = habitat;
        this.specimens = new ArrayList<>();
        this.immortals = new ArrayList<>();
        this.phenotypes = new ArrayList<>();
    }

    // armazena uma instância
    public void keep(Specimen specimen) {
        if (!habitat.integrated(specimen.neuron().bug())) {
            throw new BuzzUnknownSpecimenException(specimen);
        }
        specimens.add(specimen);
    }

    public void imortalize(Specimen specimen) {
        if (!habitat.integrated(specimen.neuron().bug())) {
            throw new BuzzUnknownSpecimenException(specimen);
        }
        immortals.add(specimen);
    }

    public boolean inZoo(Id specimenId) {
        return specimens.stream().anyMatch(s -> Arrays.equals(specimenId.raw(), s.id().raw()));
    }

    public Specimen requireSpecimen(Id specimenId) {
        return specimens.stream()
                .filter(s -> Arrays.equals(specimenId.raw(), s.id().raw()))
                .findFirst()
                .orElseThrow(
                        () ->
                                new NoSuchElementException(
                                        "Specimen not found: " + new String(specimenId.raw())));
    }

    // subject predicate object
    // abstração realização evidência
    // classe atributo valor
    public void predicate(Specimen from, Dendrite w, Neuron value) {
        if (!inZoo(from.id())) {
            throw new BuzzUnknownInstance();
        }
        Specimen specimen = requireSpecimen(from.id());

        // Pegar o tipo do specimen (Bee) para verificar se o dendrite existe
        Organelle organelle = habitat.attention(specimen.neuron().bug());
        Bee bee = (Bee) organelle;
        // Verificar se o dendrite 'w' existe no Bee
        boolean dendriteExists =
                Arrays.stream(bee.dendrites())
                        .anyMatch(
                                d ->
                                        Arrays.equals(
                                                d.neurotransmitter().aminoAcidName().getBytes(),
                                                w.neurotransmitter().aminoAcidName().getBytes()));

        if (!dendriteExists) {
            throw new RuntimeException(
                    String.format(
                            "Dendrite [%s] não existe no Bee [%s]",
                            w.neurotransmitter().aminoAcidName(), new String(bee.id().raw())));
        }

        // Validar tipo antes de armazenar o valor
        String expectedType = new String(w.neurotransmitter().isoform().id().raw());
        Object validatedValue = validateAndConvertValue(value, expectedType);

        // Criar o Phenotype e armazenar o valor
        phenotypes.add(new Phenotype(from, w, validatedValue));
    }

    private Object validateAndConvertValue(Neuron value, String expectedType) {
        return switch (expectedType.toLowerCase()) {
            case "int", "hex" -> {
                if (!(value instanceof Nb16)) {
                    throw new BuzzTypeMismatchException(
                            String.format(
                                    "Tipo incorreto: esperado Nb16 para tipo '%s', mas recebido %s",
                                    expectedType, value.getClass().getSimpleName()));
                }
                yield value;
            }
            case "text", "echo" -> {
                if (!(value instanceof Text)) {
                    throw new BuzzTypeMismatchException(
                            String.format(
                                    "Tipo incorreto: esperado Text para tipo '%s', mas recebido %s",
                                    expectedType, value.getClass().getSimpleName()));
                }
                yield value;
            }
            default -> {
                // Para tipos customizados (outras classes/bugs), esperamos um Id como referência
                if (!(value instanceof Id)) {
                    throw new BuzzTypeMismatchException(
                            String.format(
                                    "Tipo incorreto: esperado Id (referência) para tipo '%s', mas"
                                            + " recebido %s",
                                    expectedType, value.getClass().getSimpleName()));
                }

                // Validar se a referência existe no heap
                Id reference = (Id) value;
                if (!inZoo(reference)) {
                    throw new BuzzHeapUnknownReference(reference);
                }

                yield value; // Manter o Id como referência
            }
        };
    }

    public void eco(String indent) {
        System.out.printf(
                "%s🦄 [folklore] (%d) {%d} [%d]%n",
                indent, specimens.size(), immortals.size(), phenotypes.size());
        String child = indent + " ".repeat(4);
        ecoImmortals(child);
        ecoSpecimens(child);
        ecoPhenotypes(child);
    }

    private void ecoPhenotypes(String indent) {
        for (Phenotype phenotype : phenotypes) {
            throw new RuntimeException("n estou pronto para isso");
        }
    }

    private void ecoSpecimens(String indent) {
        for (Specimen specimen : specimens) {
            throw new RuntimeException("n estou pronto para isso");
        }
    }

    private void ecoImmortals(String indent) {
        for (Specimen immortal : immortals) {
            System.out.printf(
                    "%s🐦‍🔥 [%s] [%s] [%s]%n",
                    indent,
                    new String(immortal.neuron().bug().raw()),
                    new String(immortal.id().raw()),
                    resolve(immortal.neuron()));
        }
    }

    private String resolve(Neuron neuron) {
        if (!neuron.isPrimitive()) {
            throw new RuntimeException("oxe");
        }
        switch (neuron) {
            case Endo endo -> {
                throw new RuntimeException("oxe");
            }
            case Id id -> {
                throw new RuntimeException("oxe");
            }
            case Nb16 nb16 -> {
                throw new RuntimeException("oxe");
            }
            case Text text -> {
                return String.format("'%s'", new String(text.raw()));
            }
        }
    }

    public String accept(EmitterVisitor visitor, String indent) {
        StringBuilder sb = new StringBuilder();
        for (Specimen specimen : immortals) {
            Hippocampus hippocampus =
                    new Hippocampus(
                            Nature.FIXED,
                            specimen.id(),
                            Optional.of(new Impulse(specimen.neuron(), Optional.empty())));
            sb.append(hippocampus.accept(visitor, indent));
        }
        return sb.toString();
    }
}
