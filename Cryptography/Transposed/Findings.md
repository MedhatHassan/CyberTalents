# Solve Transposed
### https://cybertalents.com/challenges/cryptography/transposed
#### Challenge Description
sseemga si dsenarotps?

### Understand the Encryption
Each round (100 times):
1. Rotate left by 1: `msg = msg[1:] + msg[:1]`
2. Even–odd split: `msg = msg[0::2] + msg[1::2]`
3. Rotate left again by 1
4. Block permutation: For **each 7-char block**, characters are rearranged using `perm`.

### Brute-force Permutation with Chosen Plaintext
We use a **known plaintext attack** to discover `perm`
If we encrypt a known plaintext (e.g. "`FLAG{test}..`") using every possible permutation of **0–6**, we can find the one that gives the exact ciphertext.
*You can find the script in [BruteForce.py](BruteForce.py)*
```python
Recovered permutation: [3, 2, 5, 6, 0, 4, 1]
```

### Reverse the Encryption Logic

1. Reverse block permutation
2. Right-rotate by 1
3. Undo even–odd split
4. Right-rotate by 1

*You can find the script in [Reverse.py](Reverse.py)*

### Flag
`FLAG{##CL4SS1CAL_CRYPTO_TRANSPOS1T1ON##}`

>Find More on ==> github.com/MedhatHassan