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

init_happens = '{';
fini_happens = '}';

init_generalization = '<';
fini_generalization = '>';

init_array = '[';
fini_array = ']';

init_carrier = '(';
fini_carrier = ')';

space = 0x20;
nl    = 0xA;

fini_doc   = @ nl;
init_doc   = hash;
doc_follow = !fini_doc any;
doc        = @ init_doc doc_follow* fini_doc;

i          = @ ( space | 0x9 | 0xD | nl | doc );

hex_follow = ( digit | af_low | af_up );
hex        = @ zero ( x_up | x_low ) hex_follow+;

alpha = (alpha_up | alpha_low);

primor_follow  = ( alpha | digit | ghost );
primor         = @ alpha primor_follow*;
primor_literal = ':' primor;

bug_follow     = bug_anatomy i*;
totem_follow   = (norte | bug_anatomy) i*;

tie                = (can | as);
abstraction        = primor i* tie?;
abstraction_follow = ',' i* abstraction i*;

generalization_follow = abstraction i* abstraction_follow*;
generalization        = init_generalization i* generalization_follow fini_generalization;

bug    = 'b' 'ug'    i* primor i* generalization? i* bug_follow*;
totem  = 't' 'otem'  i* primor i* generalization? i* totem_follow*;
logos  = 'l' 'ogos'  i* web;
know   = 'k' 'now'   i* web;
ethics = 'e' 'thics' i* primor i* signature? i* resonance? i* manifest*;

web        = primor web_follow*;
web_follow = '.' primor;

skill_follow = skill_anatomy i*;
skill        = 's' 'kill' i* primor i* skill_follow*;

gene = 'g' 'ene' i* smf* i* primor i* smf* i* primor i* smf*;

can  = 'c' 'an' i* primor;

as   = 'a' 's' i* primor;

manifest = behavior i*;

aura = signature i* resonance?;

signature = init_signature i* pairs? i* fini_signature;
resonance = '!' i* (primor | void | generalization);
void      = @ zero ;

pairs       = pair pair_follow*;
pair        = attribute? i* typo;
pair_follow = ',' i* pair i*;

nucleotides_follow = ',' i* nucleotide i*;
nucleotide         = primor i* ':' i* fly i*;
helix              = nucleotide nucleotides_follow*;

optional = '?';
array    = init_array i* fini_array;
splat    = '*';
mod_sig  = (splat | array | optional);
smf      = mod_sig i*;

attribute  = smf* i* primor? i* smf*;
typo       = ':' i* smf* i* primor i* smf*;

anatomy       = init_anatomy i* (bug | totem | logos | know | ethics | skill) i* fini_anatomy;
bug_anatomy   = init_anatomy i* (ethics | can | as | gene) i* fini_anatomy;
totem_anatomy = init_anatomy i* (ethics | can ) i* fini_anatomy;
skill_anatomy = init_anatomy i* ethics i* fini_anatomy;

flower = @ ('@' | '%') i*;

pollinate      = flower primor i* '=' i* nectar i* fini_pollinate;
fini_pollinate = ';';

norte = primor signature?;
norte_follow = norte i*;

lpf = primor i*;
lp  = 'p' i* init_array i* lpf*;

lef = echo i*;
le  = 'e' i* init_array i* lpf*;

ln  =  'n' i* init_array i*  norte_follow*;
axon     = (lp | le | ln);
filament = '&' i* axon fini_array;

ipse = '$';
forager = (primor | ipse | hex | echo);

word = !q any;
echo = @ q word+ q;

nectar_array  = init_array i* brood fini_array;

nectar        = (filament | fly | primor_literal | aura  | nectar_array);
nectar_follow = ',' i* nectar i*;

brood = nectar i* nectar_follow*;

catalysis = '.' i* primor course?;
carrier   = init_carrier i* brood? fini_carrier course?;
happens   = init_happens i* helix? fini_happens course?;

course  = (catalysis | carrier | happens);
fly     = forager course?;

behavior = (pollinate | fly);

genome_follow = genome i*;
genome        = (anatomy | behavior);

pupa  = genome_follow+;
nymph = pupa;
sc    = stx i* nymph etx;
