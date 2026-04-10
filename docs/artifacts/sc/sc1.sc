kernel.print('%s, %s!', 'hello', 'world')
kernel.print('%s, %s!', 'hello', 'world')

:bug a;

:ethics b{:Hex};
:ethics b{hex :Hex};
:ethics b{a:Hex};
:ethics b{:Hex, :Hex};
:ethics b{a:Hex, :hex, t: Echo};


:ethics c{a: []Hex, a: []Hex};
:ethics c{:[]Hex};

:ethics c{a: []Hex, *a: []Hex};

:ethics c{*:[]Hex};
:ethics c{*:?Hex, *:?Hex} !0
  kernel.print('%s, %s!', 'hello', 'world')
;


:bug b
  :ethics c{*:[]Hex};
  :ethics c{*:[]Hex};
  :ethics c{*:?Hex, *:?Hex} !0
    kernel.print('%s, %s!', 'hello', 'world')
  ;
;
