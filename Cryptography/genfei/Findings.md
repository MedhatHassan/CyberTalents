# Solve Genfei
### https://cybertalents.com/challenges/cryptography/genfei

#### Challenge Description
We found an encrypted secret and an encrypting machine. It seems to be a complicated cipher, can you break it?

## [encrypt.py](challenge/encrypt.py)
The encryption script `encrypt.py` performs the following operations:

1. Padding: The plaintext is padded with `#` characters to make its length a multiple of **16** bytes.

2. Block Encryption: The plaintext is divided into **16-byte** blocks, and each block is encrypted using the encrypt function.

3. Encryption Function: The encrypt function processes each 16-byte block by splitting it into four **32-bit** integers (a, b, c, d). It then applies a series of transformations over **32 rounds**.

### Analyze the Encryption Function
`function F(w)` defined as:

```
def F(w):
    return ((w * 31337) ^ (w * 1337 >> 16)) % 2**32
```
This function takes a **32-bit** integer w and applies a transformation:
Multiplies `w` by `31337`. Multiplies `w` by `1337`, shifts the result right by **16 bits**, and `XORs` it with the previous result.
The result is `modulo 2**32` to ensure it fits within **32 bits**.

### Write a python script to 
*the script is in [decrypt](decrypt.py)*
run the script to get the flag.
```python
python decrypt.py
```
Flag : `FLAG{G3N3R4L123D_F31573L_EZ!}`

>Find More on ==> github.com/MedhatHassan