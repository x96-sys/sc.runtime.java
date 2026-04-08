package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.gene;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.x96.sys.io.IoTest.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Gene;
import org.x96.sys.sc.ast2ir.converters.GeneToDendrite;
import org.x96.sys.sc.emit.targets.SC;
import org.x96.sys.sc.ir.Dendrite;

class ParserGeneTest {

    public Token[] tokenizer(byte[] payload) {
        return new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Gene.class).lex(payload);
    }

    @Test
    void happyHex() {
        byte[] payload = "gene xp Hex;".getBytes();
        Token[] tokens = tokenizer(payload);
        Gene gene = new ParserGene(new Tape(tokens)).parse();
        assertPrintLn(
                """
                Gene
                    Pair
                        Attribute
                            Primor > xp
                        Typo
                            Primor > Hex\
                """,
                () -> gene.prettyPrint(""));
        SC sc = new SC();
        Dendrite dendrite = new GeneToDendrite().convert(gene);
        assertPrintLn(
                """
                Dendrite
                    Neurotransmitter
                        AminoAcid
                            Id > xp
                        Isoform
                            Id > Hex\
                """,
                () -> dendrite.prettyPrint(""));
        assertEquals(":gene xp Hex;", sc.visit(dendrite, ""));
    }

    @Test
    void happyEcho() {
        byte[] payload = "gene nick Echo;".getBytes();
        Token[] tokens = tokenizer(payload);
        Gene gene = new ParserGene(new Tape(tokens)).parse();
        assertPrintLn(
                """
                Gene
                    Pair
                        Attribute
                            Primor > nick
                        Typo
                            Primor > Echo\
                """,
                () -> gene.prettyPrint(""));
        SC sc = new SC();
        Dendrite dendrite = new GeneToDendrite().convert(gene);
        assertPrintLn(
                """
                Dendrite
                    Neurotransmitter
                        AminoAcid
                            Id > nick
                        Isoform
                            Id > Echo\
                """,
                () -> dendrite.prettyPrint(""));
        assertEquals(":gene nick Echo;", sc.visit(dendrite, ""));
    }

    @Test
    void happyOptionalEcho() {
        byte[] payload = "gene ?nick Echo;".getBytes();
        Token[] tokens = tokenizer(payload);
        Gene gene = new ParserGene(new Tape(tokens)).parse();
        String[] e =
                new String[] {
                    """
                    Gene
                        Pair
                            Attribute
                                Primor > nick
                            Typo
                                Primor > Echo
                            ModSig > ?\
                    """,
                    """
                    Dendrite
                        Neurotransmitter
                            AminoAcid
                                Id > nick
                            Isoform
                                Id > Echo
                            Formula > ?\
                    """
                };

        assertPrintLn(e[0], () -> gene.prettyPrint(""));

        Dendrite dendrite = new GeneToDendrite().convert(gene);

        assertPrintLn(e[1], () -> dendrite.prettyPrint(""));

        SC sc = new SC();

        assertEquals(":gene ?nick Echo;", sc.visit(dendrite, ""));

        payload = "gene nick? Echo;".getBytes();
        tokens = tokenizer(payload);
        Gene g = new ParserGene(new Tape(tokens)).parse();
        assertPrintLn(e[0], () -> g.prettyPrint(""));
        Dendrite d = new GeneToDendrite().convert(g);
        assertPrintLn(e[1], () -> d.prettyPrint(""));
        assertEquals(":gene ?nick Echo;", sc.visit(d, ""));
    }
}
