#### FUN_0010159d function
```c

undefined8 FUN_0010159d(void)

{
  bool bVar1;
  char cVar2;
  long *plVar3;
  basic_ostream *this;
  long in_FS_OFFSET;
  allocator<char> local_a9;
  basic_string local_a8 [32];
  basic_string local_88 [32];
  basic_string<> local_68 [32];
  basic_string local_48 [40];
  long local_20;
  
  local_20 = *(long *)(in_FS_OFFSET + 0x28);
  std::__cxx11::basic_string<>::basic_string();
                    /* try { // try from 001015c9 to 00101616 has its CatchHandler @ 00101760 */
  FUN_0010130a();
  while( true ) {
    plVar3 = (long *)std::operator>>((basic_istream *)std::cin,local_a8);
    bVar1 = std::basic_ios::operator.cast.to.bool
                      ((basic_ios *)((long)plVar3 + *(long *)(*plVar3 + -0x18)));
    if (!bVar1) break;
    std::__cxx11::basic_string<>::basic_string(local_88);
                    /* try { // try from 00101625 to 00101629 has its CatchHandler @ 0010174f */
    FUN_001013db(local_68,local_88);
    cVar2 = FUN_00101a6c(local_68,&DAT_003046a0);
    if (cVar2 == '\0') {
      std::__cxx11::basic_string<>::basic_string(local_48);
    }
    else {
      std::allocator<char>::allocator();
                    /* try { // try from 0010166f to 0010168b has its CatchHandler @ 00101728 */
      std::__cxx11::basic_string<>::basic_string((char *)local_48,(allocator *)"correct");
    }
                    /* try { // try from 0010169a to 001016b3 has its CatchHandler @ 00101717 */
    this = std::operator<<((basic_ostream *)std::cout,local_48);
    std::basic_ostream<>::operator<<((basic_ostream<> *)this,std::endl<>);
    std::__cxx11::basic_string<>::~basic_string((basic_string<> *)local_48);
    if (cVar2 != '\0') {
      std::allocator<char>::~allocator(&local_a9);
    }
    std::__cxx11::basic_string<>::~basic_string(local_68);
    std::__cxx11::basic_string<>::~basic_string((basic_string<> *)local_88);
  }
  std::__cxx11::basic_string<>::~basic_string((basic_string<> *)local_a8);
  if (local_20 != *(long *)(in_FS_OFFSET + 0x28)) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return 0;
}
```

#### FUN_001013db Function

```c
basic_string * FUN_001013db(basic_string *param_1,ulong param_2)

{
  char cVar1;
  int iVar2;
  char *pcVar3;
  int *piVar4;
  byte *pbVar5;
  undefined *puVar6;
  int local_24;
  uint local_20;
  
  local_24 = 0;
  while (pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2), *pcVar3 != '\0') {
    pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
    cVar1 = *pcVar3;
    piVar4 = (int *)FUN_00101a4c(&DAT_00304260,(long)local_24);
    local_20 = *piVar4 + (int)cVar1;
    pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
    cVar1 = FUN_00101929((int)*pcVar3);
    if (cVar1 == '\0') {
      pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
      cVar1 = FUN_0010194c((int)*pcVar3);
      if (cVar1 == '\0') {
        pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
        iVar2 = (int)*pcVar3;
      }
      else {
        iVar2 = 0x5a;
      }
    }
    else {
      iVar2 = 0x7a;
    }
    for (; iVar2 < (int)local_20; local_20 = local_20 - 0x1a) {
    }
    pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
    if (*pcVar3 == '{') {
      local_20 = 0x7d;
    }
    else {
      pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
      if (*pcVar3 == '}') {
        local_20 = 0x7b;
      }
      else {
        pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
        cVar1 = FUN_001018fa((int)*pcVar3);
        if (cVar1 == '\0') {
          pbVar5 = (byte *)std::__cxx11::basic_string<>::operator[](param_2);
          local_20 = (uint)*pbVar5;
        }
      }
    }
    puVar6 = (undefined *)std::__cxx11::basic_string<>::operator[](param_2);
    *puVar6 = (char)local_20;
    local_24 = local_24 + 1;
  }
  std::__cxx11::basic_string<>::basic_string(param_1);
  return param_1;
}
```
####  FUN_00101a6c function
```c
undefined8 FUN_00101a6c(void)

{
  int iVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  
  lVar2 = std::__cxx11::basic_string<>::size();
  lVar3 = std::__cxx11::basic_string<>::size();
  if (lVar2 == lVar3) {
    uVar4 = std::__cxx11::basic_string<>::size();
    uVar5 = std::__cxx11::basic_string<>::data();
    uVar6 = std::__cxx11::basic_string<>::data();
    iVar1 = FUN_001018bf(uVar6,uVar5,uVar4);
    if (iVar1 == 0) {
      return 1;
    }
  }
  return 0;
}

```

#### FUN_00101929 function

```c
undefined8 FUN_00101929(char param_1)

{
  undefined8 uVar1;
  
  if ((param_1 < 'a') || ('z' < param_1)) {
    uVar1 = 0;
  }
  else {
    uVar1 = 1;
  }
  return uVar1;
}
```


#### FUN_00101a4c function
```c
long FUN_00101a4c(long *param_1,long param_2)

{
  return *param_1 + param_2 * 4;
}
```

#### FUN_0010130a Function
```c
void FUN_0010130a(void)

{
  long in_FS_OFFSET;
  int local_1c;
  uint local_18;
  int local_14;
  long local_10;
  
  local_10 = *(long *)(in_FS_OFFSET + 0x28);
  for (local_18 = 2; (int)local_18 < 0x400; local_18 = local_18 + 1) {
    (&DAT_00304280)[(int)local_18] = (local_18 & 1) != 0;
  }
  for (local_1c = 3; local_1c < 0x400; local_1c = local_1c + 2) {
    if ((&DAT_00304280)[local_1c] != '\0') {
      FUN_001019d0(&DAT_00304260,&local_1c);
      for (local_14 = local_1c * local_1c; local_14 < 0x400; local_14 = local_14 + local_1c) {
        (&DAT_00304280)[local_14] = 0;
      }
    }
  }
  if (local_10 != *(long *)(in_FS_OFFSET + 0x28)) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}
```
### FUN_001019d0 function
```c
void FUN_001019d0(long param_1,undefined8 param_2)

{
  undefined8 uVar1;
  
  if (*(long *)(param_1 + 8) == *(long *)(param_1 + 0x10)) {
    uVar1 = FUN_00101bc0(param_1);
    FUN_00101c0c(param_1,uVar1,param_2);
  }
  else {
    FUN_00101b86(param_1,*(undefined8 *)(param_1 + 8),param_2);
    *(long *)(param_1 + 8) = *(long *)(param_1 + 8) + 4;
  }
  return;
}
```

### FUN_00102066 function
```c
undefined8 FUN_00102066(undefined8 param_1)

{
  long in_FS_OFFSET;
  undefined8 local_18;
  long local_10;
  
  local_10 = *(long *)(in_FS_OFFSET + 40);
  checkEquality(&local_18,param_1);//didn't return
  if (local_10 != *(long *)(in_FS_OFFSET + 40)) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return local_18;
}
```

### FUN_001013db Function
```c

basic_string * FUN_001013db(basic_string *param_1,ulong param_2)

{
  char cVar1;
  int iVar2;
  char *pcVar3;
  int *piVar4;
  byte *pbVar5;
  undefined *puVar6;
  int local_24;
  uint local_20;
  
  local_24 = 0;
  while (pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2), *pcVar3 != '\0') {
    pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
    cVar1 = *pcVar3;
    piVar4 = (int *)FUN_00101a4c(&DAT_00304260,(long)local_24);
    local_20 = *piVar4 + (int)cVar1;
    pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
    cVar1 = FUN_00101929((int)*pcVar3);
    if (cVar1 == '\0') {
      pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
      cVar1 = FUN_0010194c((int)*pcVar3);
      if (cVar1 == '\0') {
        pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
        iVar2 = (int)*pcVar3;
      }
      else {
        iVar2 = 0x5a;
      }
    }
    else {
      iVar2 = 0x7a;
    }
    for (; iVar2 < (int)local_20; local_20 = local_20 - 0x1a) {
    }
    pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
    if (*pcVar3 == '{') {
      local_20 = 0x7d;
    }
    else {
      pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
      if (*pcVar3 == '}') {
        local_20 = 0x7b;
      }
      else {
        pcVar3 = (char *)std::__cxx11::basic_string<>::operator[](param_2);
        cVar1 = FUN_001018fa((int)*pcVar3);
        if (cVar1 == '\0') {
          pbVar5 = (byte *)std::__cxx11::basic_string<>::operator[](param_2);
          local_20 = (uint)*pbVar5;
        }
      }
    }
    puVar6 = (undefined *)std::__cxx11::basic_string<>::operator[](param_2);
    *puVar6 = (char)local_20;
    local_24 = local_24 + 1;
  }
  std::__cxx11::basic_string<>::basic_string(param_1);
  return param_1;
}
```



#### FUN_00101a6c function
```c
int FUN_001018bf(void *param_1,void *param_2,size_t param_3)

{
  int iVar1;
  
  if (param_3 == 0) {
    iVar1 = 0;
  }
  else {
    iVar1 = memcmp(param_1,param_2,param_3);
  }
  return iVar1;
}
```
**memcmp**
`int memcmp ( const void * ptr1, const void * ptr2, size_t num );`
Compare two blocks of memory
Compares the first num bytes of the block of memory pointed by ptr1 to the first num bytes pointed by ptr2, returning zero if they all match or a value different from zero representing which is greater if they do not.
*Notice that*: unlike **strcmp**, the function does not stop comparing after finding a **null character**.


### processString (FUN_001013db) Function

```c
basic_string * processString(basic_string *compareString,ulong processedString)

{
  char cVar1;
  int iVar2;
  char *charPointer;
  int *piVar4;
  byte *pbVar5;
  undefined *puVar6;
  int counter;
  uint local_20;
  
  counter = 0;
  while (charPointer = (char *)(processedString), *charPointer != '\0') {
    charPointer = (char *)(processedString);
    cVar1 = *charPointer;
    piVar4 = (int *)FUN_00101a4c(&DAT_00304260,(long)counter);
    local_20 = *piVar4 + (int)cVar1;
    charPointer = (char *)(processedString);
    cVar1 = CheckAlphabetic((int)*charPointer);
    if (cVar1 == '\0') {
      charPointer = (char *)(processedString);
      cVar1 = FUN_0010194c((int)*charPointer);
      if (cVar1 == '\0') {
        charPointer = (char *)(processedString);
        iVar2 = (int)*charPointer;
      }
      else {
        iVar2 = 0x5a;
      }
    }
    else {
      iVar2 = 0x7a;
    }
    for (; iVar2 < (int)local_20; local_20 = local_20 - 0x1a) {
    }
    charPointer = (char *)(processedString);
    if (*charPointer == '{') {
      local_20 = 0x7d;
    }
    else {
      charPointer = (char *)(processedString);
      if (*charPointer == '}') {
        local_20 = 0x7b;
      }
      else {
        charPointer = (char *)(processedString);
        cVar1 = FUN_001018fa((int)*charPointer);
        if (cVar1 == '\0') {
          pbVar5 = (byte *)(processedString);
          local_20 = (uint)*pbVar5;
        }
      }
    }
    puVar6 = (undefined *)basic_string<>::operator[](processedString);
    *puVar6 = (char)local_20;
    counter = counter + 1;
  }
  basic_string<>::basic_string(compareString);
  return compareString;
}
```

#### CheckAlphabetic (FUN_00101929) function

```c
undefined8 FUN_00101929(char passedChar)

{
  undefined8 Result;
  
  if ((passedChar < 'a') || ('z' < passedChar)) {
    Result = 0;
  }
  else {
    Result = 1;
  }
  return Result;
}
```

#### FUN_00101a4c function
```c
long FUN_00101a4c(long *param_1,long param_2)

{
  return *param_1 + param_2 * 4;
}
```

#### FUN_00102670 function
```c
void FUN_00102670(undefined4 param_1,undefined8 param_2,undefined8 param_3)

{
  long lVar1;
  
  _DT_INIT();
  lVar1 = 0;
  do {
    (*(code *)(&__DT_INIT_ARRAY)[lVar1])(param_1,param_2,param_3);
    lVar1 = lVar1 + 1;
  } while (lVar1 != 2);
  r
```

#### FUN_0010178e function
```c

void FUN_0010178e(int param_1,int param_2)

{
  long in_FS_OFFSET;
  allocator<char> local_21;
  long local_20;
  
  local_20 = *(long *)(in_FS_OFFSET + 0x28);
  if ((param_1 == 1) && (param_2 == 0xffff)) {
    std::ios_base::Init::Init((Init *)&DAT_00304680);
    __cxa_atexit(std::ios_base::Init::~Init,&DAT_00304680,&PTR_LOOP_00304008);
    std::allocator<char>::allocator();
                    /* try { // try from 0010180d to 00101811 has its CatchHandler @ 00101863 */
    std::__cxx11::basic_string<>::basic_string
              (&DAT_003046a0,(allocator *)"IQHR}nxio_vtvk_aapbijsr_vnxwbbmm{");
    std::allocator<char>::~allocator(&local_21);
    __cxa_atexit(std::__cxx11::basic_string<>::~basic_string,&DAT_003046a0,&PTR_LOOP_00304008);
    FUN_001019b4(&DAT_00304260);
    __cxa_atexit(FUN_0010261e,&DAT_00304260,&PTR_LOOP_00304008);
  }
  if (local_20 != *(long *)(in_FS_OFFSET + 0x28)) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}

```