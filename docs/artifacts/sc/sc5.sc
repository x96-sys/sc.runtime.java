@template = '%s, %s!';
@hello    = 'hello';
@world    = 'world';

:bug kernel
  :ethics wf{template: Echo, args: []Echo } !0
    flow(0x0)
  ;

  :ethics wf{template: Echo, args: []Echo } !0
    sys.wf(template, args)
    sys.wf(template, args)
    sys.wf(template, args)
    flow(0x0)
  ;
;

:bug sys
  :ethics wf{template: Echo, *args: []Echo} n32
    flow($.printf(template, args))
  ;
  :ethics fly{code: Hex} !0
    $.exit(code)
  ;
;


:totem kind
  unknow
  soh
  null
  stx
  etx

  :ethics is{:Hex} $
    flow(unknow) if isUnknow(hex)
    flow(null) if isNull(hex)
    flow(soh) if isSoh(hex)
    flow(stx) if isStx(hex)
    flow(etx) if isEtx(hex)
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
