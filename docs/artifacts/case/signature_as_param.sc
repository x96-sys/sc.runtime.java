## anatomic mode

:bug Bee
  :gene health Hex;
  :gene stamina Hex;
  :gene mana Hex;
  :gene xp Hex;
  :gene level Hex;
  :gene dexterity Hex;
  :gene empathy Hex;
;

## bake mode

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

kernel.bake(:bug, @bug_name, @bug_attr);

## Usage is independent of build

@bee = Bee {
  health: 0xFF;
  stamina: 0xFF;
  mana: 0xFF;

  xp: 0x1;
  level: 0x0;
  dexterity: 0x10;
  empathy: 0x80;
};

kernel.printf('Bee health [%s]%n', bee.health);
kernel.printf('Bee stamina [%s]%n', bee.stamina);
kernel.printf('Bee mana [%s]%n', bee.mana);
kernel.printf('Bee xp [%s]%n', bee.xp);
kernel.printf('Bee level [%s]%n', bee.level);
kernel.printf('Bee dexterity [%s]%n', bee.dexterity);
kernel.printf('Bee empathy [%s]%n', bee.empathy);

@distance = 0x5A;

kernel.printf('Bee fly around garden found flowers [%d] %n', @distance)

bee.stamina.sub(distance)
bee.xp.add(distance.div(0x64))
bee.dexterity.add(0x1)

kernel.printf('Bee health [%s]%n', bee.health);
kernel.printf('Bee stamina [%s]%n', bee.stamina);
kernel.printf('Bee mana [%s]%n', bee.mana);
kernel.printf('Bee xp [%s]%n', bee.xp);
kernel.printf('Bee level [%s]%n', bee.level);
kernel.printf('Bee dexterity [%s]%n', bee.dexterity);
kernel.printf('Bee empathy [%s]%n', bee.empathy);
