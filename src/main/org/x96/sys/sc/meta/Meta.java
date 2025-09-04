package org.x96.sys.sc.meta;

import org.x96.sys.sc.ast.synthetic.*;
import org.x96.sys.sc.ir.synthetic.Tree;

import java.util.ArrayList;
import java.util.List;

public class Meta {
    private final Tree tree;
    private final List<Primor> primors;

    public Meta(Tree tree) {
        this.tree = tree;
        this.primors = new ArrayList<>();
    }

    public void bake(Bake bake, Nectar... args){
        switch (bake) {
            case bug -> {
                bakeBug(args);
            }
            case primor -> {
                bakePrimor(args);
            }
            case totem -> {
                bakeTotem(args);
            }
        }
    }

    private void bakeTotem(Nectar[] args) {
    }

    private void bakePrimor(Nectar[] args) {
        if (args.length != 1) {
            throw new RuntimeException("print bake usage: kernel.bake(:primor, :bee)");
        }
        switch (args[0]) {
            case Echo echo -> {
                throw new RuntimeException("print bake usage: kernel.bake(:primor, :bee)");
            }
            case Filament filament -> {
                throw new RuntimeException("print bake usage: kernel.bake(:primor, :bee)");
            }
            case Fly fly -> {
                throw new RuntimeException("print bake usage: kernel.bake(:primor, :bee)");
            }
            case Primor primor -> {
                primors.add(primor);
            }
            case Signature signature -> {
                throw new RuntimeException("print bake usage: kernel.bake(:primor, :bee)");
            }
        }
    }

    private void bakeBug(Nectar[] args) {
    }
}
