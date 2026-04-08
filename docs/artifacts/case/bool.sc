
:logos org.x96.sys;

:totem bool
    true
    false
;


:ethics div{dividend:Hex, divisor:Hex} !Flow<Hex>
    if divisor.eq(0x0)
        flow(err{
            code: 0x1
            name: 'BuzzDivByZero'
            msg: 'in math, div by zero doest not be done'
        })
    then
    if
;