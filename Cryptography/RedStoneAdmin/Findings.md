# Red Stone Admin
### https://cybertalents.com/challenges/cryptography/red-stone-admin
#### Challenge Description
his code was run on a megacomputer but we lost our secret. Can you find it?

The challenge is to find the forgotten secret value that produces the output `35979253760252124533044326983738660434153` when running the provided Haskell program.

The Haskell code computes:

```c
secret^31337 mod n = 35979253760252124533044326983738660434153
```

where `n = 0x10000000000000000000000000000000055 = 2^136 + 85`.

After verification, we found that **n is a prime number**. This allows us to solve the problem efficiently using **modular arithmetic**.

Since n is prime:
1. The multiplicative order of any number modulo `n` is `n-1`
2. We can compute the **modular inverse** of `31337` modulo `n-1`
3. The solution is: `secret = target^d mod n`, where d is the **modular inverse** of `31337` modulo `n-1`
*You can find the script in [script](script.py)*

### Flag
The secret is: `3133333333333333333337`

>Find More on ==> github.com/MedhatHassan