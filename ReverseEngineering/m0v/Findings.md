# Solve m0v.asm
#### https://cybertalents.com/challenges/malware/m0v.asm

### Try to run
![alt text](images/image.png)
Get the file info via `exiftool m0v.asm`
*You can find the output in [Info](Info.txt) file* 


```asm
mov eax,0
mov ebx,0
mov edx,deadbeefh
mov ax,3337h
mov ebx,31330000h
mov dx,ax
mov bx,dx
```
`mov eax,0`

Sets `eax` to `0`. This also sets the lower **16-bit** ax to 0.
`eax` = 0x00000000

`mov ebx,0`

Sets `ebx` to 0. This also sets the lower **16-bit** bx to 0.
`ebx` = 0x00000000

`mov edx,deadbeefh`

Sets `edx` to 0xDEADBEEF.
`edx` = 0xDEADBEEF

`mov ax,3337h`

Sets the lower **16-bit** `ax` of `eax` to 0x3337.
`eax` = 0x00003337

`mov ebx,31330000h`

Sets `ebx` to 0x31330000.
`ebx` = 0x31330000

`mov dx,ax`

Sets dx to the value of `ax`, which is 0x3337.
`edx` = 0xDEAD3337 (since only the lower **16 bits** are affected, `edx` becomes 0xDEAD3337)

`mov bx,dx`

Sets bx to the value of dx, which is 0x3337.
`ebx` = 0x31333337 (since only the lower **16 bits** are affected, `ebx` becomes 0x31333337)

>Find More on ==> github.com/MedhatHassan 
