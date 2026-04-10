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