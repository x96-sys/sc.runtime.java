```sc
kernel.bake(:totem, :bool, :true)
kernel.bake(:totem, :bool, :false)
```

isso cria análogo declarativo

```sc
:totem bool
    true
    false
;
```

que pode ser impresso chamando `kernel.eco` que impreme todo o atual estado do programa

agora vamos pensar em uma estrutura mais complexa
```sc
@bug_name = :Bee;

@health  = { health: Hex };
@stamina = { stamina: Hex };
@mana    = { mana: Hex };

@npc_attrs =  {:health, :stamina, :mana};

@xp        = {xp: Hex};
@level     = {level: Hex};
@dexterity = {dexterity: Hex};
@empathy   = {empathy: Hex};

@player_attrs = {:xp, :level, :dexterity, :empathy};

@bug_attr = {:npc_attrs, :player_attrs};

kernel.bake(:bug, bug_name, bug_attr)
```

iso é a mesma coisa que declarar

```sc
:bug bee
    :gene health Hex;
    :gene stamina Hex;
    :gene mana Hex;
    :gene xp Hex;
    :gene level Hex;
    :gene dexterity Hex;
    :gene empathy Hex;
;
```

e para ver isso basta `kernel.eco`
e para ver isso em java basta `kernel.eco(:java)` que imprime análogo
qual linguagem pode fazer isso mais facilmente?
