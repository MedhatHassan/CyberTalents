# Solve Find the Pass
##### https://cybertalents.com/challenges/malware/Find-the-pass
Try to run the exe 
![Run](images/image.png)

The program try to get a password from the user and check if it correct or not.  

Get the file info via `exiftool CybertalentDemo0.exe`
*You can find the output in Info file* 
Dump file strings with `strings CybertalentDemo0.exe`
*You can find the output in strings file*

with Ghidra we found the main code
### Main
```
void FUN_00401180(void)

{
  bool bVar1;
  undefined3 extraout_var;
  byte local_1c [20];
  uint local_8;
  
  local_8 = DAT_00403004 ^ (uint)&stack0xfffffffc;
  FUN_00401050("Enter Your Pass Key : \n",(char)local_1c);
  FUN_004010c0(&DAT_00402118,(char)local_1c);
  bVar1 = FUN_00401100(local_1c);
  if (CONCAT31(extraout_var,bVar1) == 0) {
    FUN_00401050("Correct Password",bVar1);
  }
  else {
    FUN_00401050("Wrong Password",bVar1);
  }
  @__security_check_cookie@4(local_8 ^ (uint)&stack0xfffffffc);
  return;
}
```

the main get string from user **password** and pass it to a function `FUN_00401100` to check on the password.

### function 00401100
```
bool __cdecl FUN_00401100(byte *param_1)

{
  byte bVar1;
  bool bVar2;
  uint local_14;
  char *local_10;
  byte *local_c;
  
  local_10 = "elite";
  local_c = param_1;
  do {
    bVar1 = *local_c;
    bVar2 = bVar1 < (byte)*local_10;
    if (bVar1 != *local_10) {
LAB_00401157:
      local_14 = -(uint)bVar2 | 1;
      goto LAB_0040115f;
    }
    if (bVar1 == 0) break;
    bVar1 = local_c[1];
    bVar2 = bVar1 < (byte)local_10[1];
    if (bVar1 != local_10[1]) goto LAB_00401157;
    local_c = local_c + 2;
    local_10 = local_10 + 2;
  } while (bVar1 != 0);
  local_14 = 0;
LAB_0040115f:
  return local_14 != 0;
}
```

`FUN_00401100` accept on input (password) and check if the input byte array represents the string `"elite`. If it does, the function returns `true` otherwise, it returns `false`.


>Find More on ==> github.com/MedhatHassan