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

i = @ ( 0x20 | 0x9 | 0xD | 0xA );

alpha = (alpha_up | alpha_low);

primor_follow = ( alpha | digit | ghost );
primor        = @ alpha primor_follow*;

bug   = 'b' 'ug';
totem = 't' 'otem';
logos = 'l' 'ogos';
know  = 'k' 'now';

anatomy = init_anatomy i* (bug | totem | logos | know) i* fini_anatomy;

pollinate = '@';

forager = primor;

word = !q any;
echo = @ q word+ q;

nectar        = (fly | echo);
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
