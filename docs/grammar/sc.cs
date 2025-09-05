stx = 0x2;
etx = 0x3;

hash      = 0x23;
q         = 0x27;
zero      = 0x30;
x_up      = 0x58;
ghost     = 0x5F;
x_low     = 0x78;

any       = [0x20-0x7E];
digit     = [0x30-0x39];
alpha_up  = [0x41-0x5A];
af_up     = [0x41-0x46];
alpha_low = [0x61-0x7A];
af_low    = [0x61-0x66];

init_anatomy = ':';
fini_anatomy = ';';

init_signature = '{';
fini_signature = '}';

space = 0x20;
nl    = 0xA;

i          = @ ( space | 0x9 | 0xD | nl | doc );

hex_follow = ( digit | af_low | af_up );
hex        = @ zero ( x_up | x_low ) hex_follow+;

alpha = (alpha_up | alpha_low);

primor_follow  = ( alpha | digit | ghost );
primor         = @ alpha primor_follow*;
primor_literal = ':' primor;

bug_follow     = bug_anatomy i*;
totem_follow   = (norte | bug_anatomy) i*;

bug    = 'b' 'ug' i* primor i* bug_follow*;
totem  = 't' 'otem' i* primor i* totem_follow*;
logos  = 'l' 'ogos' i* primor;
know   = 'k' 'now' i* primor;
ethics = 'e' 'thics' i* primor i* signature i* manifest*;

manifest = behavior i*;

signature = sigin i* resonance?;
sigin     = init_signature i* pairs? i* fini_signature;
resonance = (primor | void);
void      = @ '0' ('x' | 'X') '0';

pairs       = pair pair_follow*;
pair        = attribute? i* typo;
pair_follow = ',' i* pair i*;

attribute     = mod_attribute? i* primor?;
mod_attribute = splat;
splat         = '*';

typo     = ':' i* mod_typo? i* primor;
mod_typo = (array | optional);
array    = '[' ']';
optional = '?';

anatomy     = init_anatomy i* (bug | totem | logos | know | ethics) i* fini_anatomy;
bug_anatomy = init_anatomy i* ethics i* fini_anatomy;

flower = @ ('@' | '%') i*;

pollinate      = flower primor i* '=' i* nectar i* fini_pollinate;
fini_pollinate = ';';

norte = primor;
norte_follow = i* norte?;

filament = '&' 'p' '[' norte_follow+ ']';

self = '$';
forager = (primor | self);

word = !q any;
echo = @ q word+ q;

fini_doc   = @ nl;
doc        = @ hash doc_follow* fini_doc;
doc_follow = !fini_doc any*;

init_array = '[';
fini_array = ']';

nectar_array  = init_array i* brood fini_array;

nectar        = (filament | fly | echo | primor_literal | signature | hex | nectar_array);
nectar_follow = ',' i* nectar i*;

brood = nectar i* nectar_follow*;

init_carrier = '(';
fini_carrier = ')';

catalysis = '.' i* primor course?;
carrier   = init_carrier i* brood? fini_carrier course?;

course  = (catalysis | carrier);
fly     = forager course?;

behavior = (pollinate | fly);

genome_follow = genome i*;
genome        = (anatomy | behavior);

pupa  = genome_follow+;
nymph = pupa;
sc    = stx i* nymph etx;
