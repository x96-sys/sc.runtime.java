id    = byte[]:raw;
text  = byte[]:raw;
nb16  = int:raw;

bee      = id pulse[];
rune     = id;
swarm    = id;
connect  = id;

pulse    = id schema? chemical?;

chemical = stimulus[];

schema  = neurotransmitter[]:neurotransmitters flow?;
flow    = (id | life);
life    = bool:state;

neurotransmitter = aminoacid? isoform;

aminoacid = bool?:splat id?;

isoform = formula? id;
formula = {array | optional};

organelle = (bee | rune | swarm | connect | pulse);

nature = { mutable | static };

hipocampos = nature id signal?;

serie = id[];

neuron = id;

signal = (serie | impulse | text | id | schema | nb16);

activity = signal[];

synaptic     = id nerve?;
transmission = activity? nerve?;

nerve   = (synaptic | transmission);
impulse = neuron nerve?;

stimulus = (hipocampos | impulse);

network = (organelle | stimulus);

egg    = network[];
hive   = egg;
tree   = hive;

main  = sc_ir;
