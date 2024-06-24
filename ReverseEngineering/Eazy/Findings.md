# Solve Eazy.exe
#### https://cybertalents.com/challenges/malware/Eazy.exe

### Try to run
![alt text](image.png)
Get the file info via `exiftool Eazy.exe`
*You can find the output in [Info](Info.txt) file* 
Dump file strings with `strings Eazy.exe`
*You can find the output in [strings](Strings.txt) file* 
Via analyzing strings file we found interesting keywords.
```
GCC: (MinGW.org GCC Build-2) 9.2.0
fclose
fopen
fputc
fwrite
malloc
/home/keith/builds/mingw/gcc-9.2.0-mingw32-cross-native/mingw32/libgcc
```

The program is developed in C/C++

### Analyze with ghidra
#### Main
```c
int __cdecl _main(int _Argc,char **_Argv,char **_Env)

{
  undefined4 local_3d;
  undefined4 local_39;
  undefined4 local_35;
  undefined4 local_31;
  undefined4 local_2d;
  undefined4 local_29;
  undefined4 local_25;
  undefined4 local_21;
  undefined4 local_1d;
  undefined local_19;
  FILE *local_18;
  int local_14;
  
  ___main();
  local_18 = _fopen("Dont_Check_Me.txt","w");
  local_3d = 0x6000d07;
  local_39 = 0x2d2d003a;
  local_35 = 0x342e181e;
  local_31 = 0x72720f1e;
  local_2d = 0x32081e25;
  local_29 = 0x32340b1e;
  local_25 = 0x39041e35;
  local_21 = 0x35342224;
  local_1d = 0x240c1e24;
  local_19 = 0x3c;
  for (local_14 = 0; local_14 < 0x25; local_14 = local_14 + 1) {
    _fputc((int)(char)(*(byte *)((int)&local_3d + local_14) ^ 0x41),local_18);
  }
  _fclose(local_18);
  return 0;
}

```

The code opens file `Dont_Check_Me.txt` then loop with the defiend variables and xor them with `0x41`

Try to run the code again.
*You can find the code in [Rev.c](Rev.c)*

>Find More on ==> github.com/MedhatHassan 
