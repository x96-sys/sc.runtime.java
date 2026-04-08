package org.x96.sys.sc.buzz.interpreter.receptor;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ir.Schema;

public class BuzzNenhumArgumentoPassadoQuandoAlgumEhEsperado extends Buzz {
    public BuzzNenhumArgumentoPassadoQuandoAlgumEhEsperado(Schema schema) {
        super(
                0xE6,
                BuzzNenhumArgumentoPassadoQuandoAlgumEhEsperado.class.getSimpleName(),
                explainArgumentoEsperado(schema));
    }

    private static String explainArgumentoEsperado(Schema schema) {
        // Extrai informações do schema para criar uma mensagem mais informativa
        StringBuilder expected = new StringBuilder();
        expected.append("Argumentos esperados:\n");

        for (int i = 0; i < schema.neurotransmitters().length; i++) {
            var nt = schema.neurotransmitters()[i];
            expected.append("  - ");

            String k = new String(nt.isoform().id().raw());

            // Se tem aminoacid, mostra o nome do parâmetro
            if (nt.aminoAcid().isPresent() && nt.aminoAcid().get().id().isPresent()) {
                expected.append(new String(nt.aminoAcid().get().id().get().raw())).append(": ");
            } else {
                expected.append(k.toLowerCase()).append(": ");
            }

            // Mostra o tipo do isoform
            expected.append(k);

            // Indica se é splat (array)
            if (nt.isSplat()) {
                expected.append("[]");
            }

            expected.append("\n");
        }

        return expected.toString();
    }
}
