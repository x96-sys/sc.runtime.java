# SC

`SC` é uma meta linguagem capaz de definir a si e ecoar o próprio estado

Sintaxe atende o paradigma imperativo e declarativo

O `kernel` oferece o `bake`, capaz de especificar tudo o que pode ser declarado

O `kernel` oferece o `eco`, capaz de imprimir a declaração do estado
especificado

#### Tokenize Grammar

Defining SC Grammar on CS DSL

```bash
m cs ARGS="tokenize docs/grammar/sc.cs org.x96.sys.cs.lexer.visitors.Book"
```

#### Build lexer visitors

```bash
m cs ARGS="build docs/grammar/sc.cs org.x96.sys.cs.lexer.visitors.Book org.x96.sys.sc.lexer.visitors.synthetic"
```

#### compile visitors

```bash
m build
```

#### tokenize artifact with visitor synthetic

```bash
m sc ARGS="tokenize docs/artifacts/sc/sc0.sc org.x96.sys.sc.lexer.visitors.synthetic.Sc"
```

```bash
m sc ARGS="tokenize docs/artifacts/sc/sc1.sc org.x96.sys.sc.lexer.visitors.synthetic.Sc"
```

```bash
m sc ARGS="tokenize docs/artifacts/sc/sc2.sc org.x96.sys.sc.lexer.visitors.synthetic.Sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc2.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc3.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc4.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc9.sc"
```
