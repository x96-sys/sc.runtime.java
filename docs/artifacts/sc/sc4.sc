# ast gen

# assinaturas
@ba     = { raw: []byte };
@hex    = { raw: int };
@primor = ba;
@echo   = ba;


# build ast node

kernel.bake(:bug, :Hex,    hex)
kernel.bake(:bug, :Primor, primor)
kernel.bake(:bug, :Echo,   echo)

