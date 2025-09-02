# SC

`SC` é uma meta linguagem capaz de definir a si e transpilar nativamente

Sintaxe atende o paradigma imperativo e declarativo

O `kernel` oferece o `bake`, capaz de especificar tudo o que pode ser declarado

O `kernel` oferece o `eco`, capaz de imprimir a declaração do estado
especificado

#### tokenize for sure

```bash
java -jar cs.jar tokenize docs/grammar/sc.cs org.x96.sys.cs.lexer.visitors.Book
```

#### build lexer visitors

```bash
java -jar cs.jar build docs/grammar/sc.cs org.x96.sys.cs.lexer.visitors.Book org.x96.sys.sc.lexer.visitors.synthetic
```

#### compile visitors

```bash
m build
```

#### tokenize artifact with visitor synthetic

```bash
m run ARGS="tokenize docs/artifacts/sc/sc0.sc org.x96.sys.sc.lexer.visitors.synthetic.Sc"
```

```bash
m run ARGS="tokenize docs/artifacts/sc/sc1.sc org.x96.sys.sc.lexer.visitors.synthetic.Sc"
```

```bash
m run ARGS="tokenize docs/artifacts/sc/sc2.sc org.x96.sys.sc.lexer.visitors.synthetic.Sc"
```

```bash
m run ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc2.sc"
```

```bash
m run ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc3.sc"
```
