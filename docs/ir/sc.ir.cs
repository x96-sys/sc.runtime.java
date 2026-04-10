id    = byte[]:raw;
text  = byte[]:raw;
nb16  = int:raw;

habit    = id pulse[];
bee      = id dendrite[] pulse[] able[] be[] bundle?;
rune     = id bundle?;
swarm    = id;
connect  = id;
able     = id;
be       = id;

bond   = (able | be);
packet = id bond?;
bundle = packet[];

dendrite  = neurotransmitter;

pulse     = id schema? flow? chemical?;

direction = id schema?;

chemical  = stimulus[];

wave      = schema flow?;

schema  = neurotransmitter[]:neurotransmitters;
flow    = (id | life);
life    = bool:state;

formula          = {array | optional | splat};
neurotransmitter = formula[]:formulas aminoacid? isoform;

spore   = id impulse;
genesis = spore[]:spores;

aminoacid = id?;

isoform = id;

organelle = (bee | rune | swarm | connect | pulse | habit);

nature = { mutable | static };

hipocampos = nature id signal?;

axoneme = { text | id | direction }
serie = axoneme serial[];

serial = (text | id | direction)

endo = ;

neuron = ( id | endo | text | nb16);

signal = (serie | impulse | wave | activity);

activity = signal[];

synaptic     = id nerve?;
transmission = activity? nerve?;

nerve   = (synaptic | transmission | genesis);
impulse = neuron nerve?;

stimulus = (hipocampos | impulse);

network = (organelle | stimulus);

egg    = network[];
hive   = egg;
tree   = hive;

main  = sc_ir;
