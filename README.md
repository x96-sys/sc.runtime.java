# SC

`SC` é uma **meta** linguagem, multi paradigmal capaz de definir a si e
transpilar o próprio estado

O `kernel` oferece o `bake`, capaz de especificar tudo o que pode ser declarado

O `kernel` oferece o `eco`, capaz de imprimir a declaração do estado
especificado

O lexer trata espaços em branco como opcionais entre tokens, exceto em três
casos: `.`, `(` e `{`. Esses símbolos devem vir imediatamente após o
identificador que os precede (`kernel.`, `bake(`, `Echo{`). Espaços entre o
identificador e esses delimitadores invalidam o token, pois eles formam uma
unidade léxica obrigatória.

palavras chaves

    if
    elif
    else
    fi

    do
    while

portas lógicas e extruturas de repetição são funções

o código inicial pode ser interpretado como anatômico ou comportamental

o anatômico/declaritivo é semelhante a ddl; define uma estrutura;

```sc
:totem bool
  true
  false
;
```

o comportamental/imperativo é um dml + dql..; define uma ação; a ação é capaz de
definir aquilo que pode ser declarado

```sc
kernel.bake(:totem, :bool, &p[true false])
```

Os dois scripts acima são equivalentes, afetam, transformam, levam o kernel ao
mesmo estado;

Tratando sistemas como dados, e dados como sistemas;

Inspirado na obra de [Gödel](https://en.wikipedia.org/wiki/Kurt_Gödel),
[Neumann](https://en.wikipedia.org/wiki/John_von_Neumann),
[Turing](https://en.wikipedia.org/wiki/Alan_Turing),
[Nystrom](https://github.com/munificent)

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
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc0.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc1.sc"
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
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc5.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc6.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc7.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc8.sc"
```

```bash
m sc ARGS="parse /Users/fera/dev/pd/eng/sc/docs/artifacts/sc/sc9.sc"
```

# REPL

```bash
m sc ARGS="repl /Users/fera/dev/pd/eng/sc/docs/artifacts/repl/sc0.sc"
```

Arrays Literais

Um array de literal é uma forma menos verbosa de declarar um conhecido array

O array literal começa com `&` indicando dado literal a ser ingerido

o próximo byte/token reflete o tipo de dado no array

| id | tipo   |
| -- | ------ |
| p  | primor |
| n  | norte  |
| e  | echo   |

a seguir os delimitadores `[` e `]` com seu conteúdo literal, separado por
espaços

Um array literal com 3 Primores

```sc
&p[bug totem logos]
```

Um array literal com 3 Echos

```sc
&e['%s, %s' 'hello' 'word']
```

Um array de nortes literais

```sc
&n[m3{:Hex} l{:Hex}]
```

## Roadmap

os primeiros módulos a serem implementados serão os necessários para compilar a
si
