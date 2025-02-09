# Solve mobile app
#### https://cybertalents.com/challenges/mobile-security/mobile-app

Challenge Description:
Reverse engineer the APK to find the flag.

## Reverse engineer the APK with `apktool`
```bash
apktool d mobap.apk
```
### Search for the flag
```bash
grep -ri "flag" mobapp/*
```
*Note: `-r` for "recursive" and `-i` makes the search case-insensitive*

We found it in `mobapp/assets/www/js/index.js`

```
cat assets/www/js/index.js
app.initialize();
function whereIsMyFlag() {
        var flag = "W11bKCFbXStbXSlbK1tdXSsoWyFbXV0rW11bW11dKVsrIStbXStbK1tdXV0rKCFbXStbXSlbIStbXSsh ...
        W10rIStbXSshK1tdKyErW10rIStbXSshK1tdKyErW11dKyhbXVtbXV0rW10pWyErW10rIStbXV0pKSgp";
}
```

Decode base64 then This is a **JSFuck** obfuscation technique.

flag : FLAG{JS_AND_CORDOVA_FTW}

### Resources 
[Decoder JSFuck](https://enkhee-osiris.github.io/Decoder-JSFuck/)

