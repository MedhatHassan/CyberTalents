# Solve pe master
#### https://cybertalents.com/challenges/malware/pe-master

### Try to run
![alt text](images/image.png)
Get the file info via `exiftool Challenge.exe`
*You can find the output in [Info](Info.txt) file* 
Dump file strings with `strings Challenge.exe`
*You can find the output in [strings](Strings.txt) file* 
Via analyzing strings file we found interesting keywords.
```
GNU C17 8.1.0 -mtune=core2 -march=nocona -g -g -g -O2 -O2 -O2 -fno-ident -fbuilding-libgcc -fno-stack-protector
../../../../../src/gcc-8.1.0/libgcc/libgcc2.c
C:\mingw810\x86_64-810-posix-seh-rt_v6-rev0\build\gcc-8.1.0\x86_64-w64-mingw32\libgcc
fprintf
free
fwrite
malloc
memcpy
C:/mingw810/src/gcc-8.1.0/gcc/config/i386
C:/mingw810/src/gcc-8.1.0/libgcc
```

The program in C/C++

### Scan with readpe
`readpe --header optional Challenge.exe`
*you can find the output in [readpeOut](readpeOut.txt)*
```
Entrypoint:                      0x14e0
    Address of .text section:        0x1000
    ImageBase:                       0x133337
```

the virtual entrypoint address is image base address + entry point address : 0x134817

flag{0x14e0|0x133337|0x134817}


>Find More on ==> github.com/MedhatHassan 
