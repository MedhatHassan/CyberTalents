# Solve easywin
#### https://cybertalents.com/challenges/web/easywin

![alt text](images/image.png)
### Run Directory bruteforce
`dirsearch -u http://wcamxwl32pue3e6m873ok97swvy0j6zqdkgxu639-web.cybertalentslabs.com -x 403,404`

No output

### Analyze the source code 

```js
<script>
                        (function(_0x913661,_0x4d120b){const _0x56f777=_0x1854,_0x47f5f7=_0x913661();while(!![]){try{const _0x335d48=parseInt(_0x56f777(0x84))/0x1+-parseInt(_0x56f777(0x8f))/0x2*(parseInt(_0x56f777(0x82))/0x3)+-parseInt(_0x56f777(0x86))/0x4*(parseInt(_0x56f777(0x8a))/0x5)+parseInt(_0x56f777(0x87))/0x6*(parseInt(_0x56f777(0x90))/0x7)+-parseInt(_0x56f777(0x85))/0x8*(-parseInt(_0x56f777(0x8c))/0x9)+parseInt(_0x56f777(0x92))/0xa+parseInt(_0x56f777(0x88))/0xb;if(_0x335d48===_0x4d120b)break;else _0x47f5f7['push'](_0x47f5f7['shift']());}catch(_0x3db4e3){_0x47f5f7['push'](_0x47f5f7['shift']());}}}(_0x58be,0x6bc9e));function _0x1854(_0x375900,_0x1e7699){const _0x58be1f=_0x58be();return _0x1854=function(_0x185496,_0x39c5df){_0x185496=_0x185496-0x81;let _0x5d0d96=_0x58be1f[_0x185496];return _0x5d0d96;},_0x1854(_0x375900,_0x1e7699);}function login(){const _0x590ed8=_0x1854,_0x4fb772=document['getElementById'](_0x590ed8(0x91))[_0x590ed8(0x83)],_0x39e137=document['getElementById'](_0x590ed8(0x81))['value'],_0x2e7bab=_0x590ed8(0x89),_0x220f2d='password';_0x4fb772===_0x2e7bab&&_0x39e137===_0x220f2d?window[_0x590ed8(0x8b)]['replace'](_0x590ed8(0x8d)):alert(_0x590ed8(0x8e));}function _0x58be(){const _0x129aca=['email','5055890brylTr','password','291ADApiL','value','111915TuoPIH','74064qFLpju','4bGPcQf','6PzkuAP','6597877lorJsv','admin@mail.com','3394165HJcJMq','location','306tMZOOY','5up3rs3cr3t.html','Invalid\x20email\x20or\x20password.\x20Please\x20try\x20again.','16842eIDCgi','2835623pvkZea'];_0x58be=function(){return _0x129aca;};return _0x58be();}
                </script>
```

De-obfuscated Code
```js
function _0x58be() {
    const _0x129aca = [
        'email', '5055890brylTr', 'password', '291ADApiL', 'value',
        '111915TuoPIH', '74064qFLpju', '4bGPcQf', '6PzkuAP',
        '6597877lorJsv', 'admin@mail.com', '3394165HJcJMq', 'location',
        '306tMZOOY', '5up3rs3cr3t.html', 'Invalid email or password. Please try again.',
        '16842eIDCgi', '2835623pvkZea'
    ];
    _0x58be = function() {
        return _0x129aca;
    };
    return _0x58be();
}

function _0x1854(_0x375900, _0x1e7699) {
    const _0x58be1f = _0x58be();
    return _0x1854 = function(_0x185496, _0x39c5df) {
        _0x185496 = _0x185496 - 0x81;
        let _0x5d0d96 = _0x58be1f[_0x185496];
        return _0x5d0d96;
    }, _0x1854(_0x375900, _0x1e7699);
}

function login() {
    const _0x590ed8 = _0x1854;
    const email = document.getElementById(_0x590ed8(0x91))[_0x590ed8(0x83)];
    const password = document.getElementById(_0x590ed8(0x81))['value'];
    const validEmail = 'admin@mail.com';
    const validPassword = 'password';
    
    if (email === validEmail && password === validPassword) {
        window.location.replace('5up3rs3cr3t.html');
    } else {
        alert('Invalid email or password. Please try again.');
    }
}

```

We found hardcoded email and password > admin@mail.com:password

Login 

![alt text](images/image-2.png)

>Find More on ==> github.com/MedhatHassan 
