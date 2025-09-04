primor = byte[]:raw;
echo   = byte[]:raw;
hex    = int:raw

bug    = primor ethics[];
totem  = primor;
logos  = primor;
know   = primor;

ethics = primor signature? manifest?;

manifest = behavior;

signature = pair[]:pairs resonance?;
resonance = (primor | ready);
ready     = bool:state;

pair        = attribute? typo;

attribute     = bool?:splat primor?;

typo     = mod_typo? primor;
mod_typo = {array | optional};

anatomy     = (bug | totem | logos | know | ethics);

flower = {variable | constant};

pollinate = flower primor nectar?;

filament = primor[];

forager = primor;

nectar  = (filament | fly | echo | primor | signature | hex);

brood = nectar[];

catalysis = primor course?;
carrier   = brood? course?;

course  = (catalysis | carrier);
fly     = forager course?;

behavior = (pollinate | fly);

genome   = (anatomy | behavior);

pupa  = genome[];
nymph = pupa;
sc    = nymph;

main = sc_tree;
