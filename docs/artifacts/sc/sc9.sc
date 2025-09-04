
@template = '%s, %s!'
@hello    = 'hello'
@world    = 'world'

:bug kernel
  :ethics wf{template: Echo, args: []Echo } 0x0
    sys.wf(template, args)
    flow # void
  ;
  :ethics fly{code: Hex} 0x0
    sys.fly(template, args)
    flow(0x0)
  ;
;

:bug sys
  :ethics wf{template: Echo, *args: []Echo} n32
    flow $.printf(template, args)
  ;
  :ethics fly(Hex code) 0x0
    $.exit(code)
  ;
;


kernel.wf(template, [hello, word])

:totem kind
  unknow,
  soh,
  null,
  stx,
  etx

  :ethics is{:Hex} $
    flow unknow if isUnknow(hex)
    flow null if isNull(hex)
    flow soh if isSoh(hex)
    flow stx if isStx(hex)
    flow etx if isEtx(hex)
  ;

  :ethics isNull{:Hex} bool
    hex.eq(0x0)
  ;
  :ethics isSoh{:Hex} bool
    hex.eq(0x1)
  ;
  :ethics isStx{:Hex} bool
    hex.eq(0x2)
  ;
  :ethics isEtx{:Hex} bool
    hex.eq(0x3)
  ;
  :ethics isUnknow{:Hex} bool
    hex.gt(0x3)
  ;
;
