stx = 0x2;
etx = 0x3;

q         = 0x27;
ghost     = 0x5F;

any       = [0x20-0x7E];
digit     = [0x30-0x39];
alpha_up  = [0x41-0x5A];
alpha_low = [0x61-0x7A];

init_anatomy = ':';
fini_anatomy = ';';

init_signature = '{';
fini_signature = '}';

space = 0x20;

i = @ ( space | 0x9 | 0xD | 0xA );

alpha = (alpha_up | alpha_low);

primor_follow  = ( alpha | digit | ghost );
primor         = @ alpha primor_follow*;
primor_literal = ':' primor;

bug_content = bcf+;
bcf         = bug_anatomy i*;

bug    = 'b' 'ug' i* primor i* bug_content?;
totem  = 't' 'otem' i* primor i* norte_follow*;
logos  = 'l' 'ogos' i* primor;
know   = 'k' 'now' i* primor;
ethics = 'e' 'thics' i* primor i* signature i* manifest?;

manifest = behavior i*;

signature = sigin i* resonance?;
sigin     = init_signature pairs? fini_signature;
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
bug_anatomy = ':' i* ethics i* ';';

flower = @ ('@' | '%') i*;

pollinate = flower primor i* '=' i* (filament | fly | echo | primor_literal | ps) i*;
ps = signature i* ';';

norte = primor;
norte_follow = i* norte?;

filament = '&' 'p' '[' norte_follow+ ']';

forager = primor;

word = !q any;
echo = @ q word+ q;

nectar        = (filament | fly | echo | primor_literal | signature);
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
