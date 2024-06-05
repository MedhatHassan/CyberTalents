b *0x08048561
r 0 1 0123456789abcdefghijkl
set $i = 0
while $i < 22
  printf "%c -> %c",$ebx,$eax
  set $ebx=$eax
  set $i = $i + 1
  c
end
q
