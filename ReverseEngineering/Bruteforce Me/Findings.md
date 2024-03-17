# Solve bruteforce me
#### https://cybertalents.com/challenges/malware/bruteforce-me
#### flag format flag{xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx},only a-z,0-9,_ are allowed

```
ll =[51, 54, 48, 51, 61, 57, 50, 54, 48, 52, 55, 50, 50, 57, 47, 52, 57, 47, 54, 24, 57, 58, 62]

i = raw_input()
ss= 0 
try:
    for ii in range(0,46 , 2):
        temp = i[ii:ii+2]
        temp = int(temp,0x10)
        ss+=temp
        temp >>=1
        if temp != ll[ii/2]:
            print "Something is wrong"
    if ss !=2406:
            print ss/0
    print "This flag may or may not work, can you find more ?"
        
except:
    print "NO"
```

### code logic 
ll is a list of integers.
User input is taken and stored in the variable i.
A loop iterates over the input starting from 0 to 46 with step of 2, extracting pairs of characters and converting them to integers in `base 16` (0x10).
The converted integers are added to the variable `ss`.
Each converted integer is `right-shifted` by 1, and if it doesn't match the corresponding value in the list ll, it prints "Something is wrong."
If the sum `ss` is not equal to 2406, it attempts to divide ss by 0 (which would result in a runtime error).
Finally, it prints "This flag may or may not work, can you find more?" or "NO" depending on the execution flow.

Based on the code logic and the length of `ll` array is 23 elements,So the flag must be `23` characters.
We have `flag{}` is fixed as the description.

If we convert ASCII -> decimal we will find:
```
f -> 102  | 51*2 = 102
l -> 108  | 54*2 = 108
a -> 97   | 48*2 = 96
g -> 103  | 51*2 = 102
{ -> 123  | 61*2 = 122
} -> 125  | 62*2 = 124
```
We can find that each char in the flag is `2*ll` or `2*ll+1`.
This is result to right shifting.

write a recursive code find all the possible flags with:
1- 23 characters
2- total sum of 2406
3- on the form flag{xxxxxxx}

*the code is in rev.py file*
We found near 19500 flag!!

So we have to filter it with `only a-z,0-9,_`
*the code is in filter.py file*
we are down to 800 flags with more spelling check we found the flag.
`flag{remainder_is_l0st}`


>Find More on ==> github.com/MedhatHassan 