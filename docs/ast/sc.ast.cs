primor = byte[]:raw;
echo   = byte[]:raw;
hex    = int:raw

skill  = primor ethics[];
bug    = primor gene[] ethics[] can[] as[] generalization?;
totem  = primor generalization?;
logos  = primor;
know   = primor;
can    = primor;
as     = primor;

tie            = (can | as);
abstraction    = primor tie?;
generalization = abstraction[];

gene     = pair;

ethics   = primor signature? resonance? manifest?;

norte    = primor signature?;

manifest = behavior[];

aura     = signature resonance?;

signature = pair[]:pairs;
resonance = (primor | ready);
ready     = bool:state;

mod         = {array | optional | splat};
pair        = mod[]:mods attribute? typo;

nucleotide  = primor fly;
happens     = nucleotide[]:nucleotides;

attribute   = primor?;

typo        = primor;

anatomy     = (bug | totem | logos | know | ethics | skill);

flower = {variable | constant};

pollinate = flower primor nectar?;

base = { echo | primor | norte }
filament = base rna;

rna = (echo | primor | norte);

ipse = ;

forager = (primor | ipse | echo | hex);

nectar  = (filament | fly | aura | brood);

brood = nectar[];

catalysis = primor course?;
carrier   = brood? course?;

course  = (catalysis | carrier | happens);
fly     = forager course?;

behavior = (pollinate | fly);

genome   = (anatomy | behavior);

pupa  = genome[];
nymph = pupa;
sc    = nymph;

main = sc_tree;
