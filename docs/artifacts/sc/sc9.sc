@template = '%s, %s!';
@hello    = 'hello';
@world    = 'world';

:skill imprint
  :ethics printf{template: Echo, *args: []Echo} !Hex;
  :ethics print{ech: Echo} !Hex;
;

:skill exec
  :ethics exit{code: Hex} !0;
;

:bug kernel
    :as sys;
;

:totem bool
    true
    false
;

:totem volume
    empty
    full
    l{:Hex}
    m3{:Hex}
    g{:Hex}
;

:bug buzz
    :gene code Hex;
    :gene buzz Hex;
    :gene explain Echo;
    :gene cause ?buzz;
;



:totem flow<G>
    ok{:G}
    err{:buzz}
;



:bug math
    :ethics div{dividend:Hex, divisor:Hex} !Hex;
;

:bug sys
  :can imprint;
  :can exec;

  :ethics echo{template: Echo, *args?: []Echo} !Hex
      if args.ready
          flow($.print(template))
      else
          flow($.printf(template, args))
      fi
  ;

  :ethics fly{:Hex} !Hex
      $.exit(hex)
  ;
;

# kernel.echo(template, [hello, world])
