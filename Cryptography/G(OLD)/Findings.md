# Solve G(OLD)
### https://cybertalents.com/challenges/cryptography/gold

#### Challenge Description

Back to the Basics! 
ciphertext = "1e03130e2800130119041b07141d190b0a100500070a0e110c10190c0a1d0817070c1d061f1d6039" 
NOTE : - flag format is : FLAG{} - All chars are in uppercase - key length is 8

## Analyze the ciphertext & Challenge Description
Due to `ciphertext` is in hex format and it has a key *(so it is encryption not hashing)* we can derive that the ciphertext was encrypted using a simple XOR cipher.

The flag format is `FLAG{...}` so The partial key can be found by:
```python
known_plaintext = b"FLAG{"
ciphertext_hex = "1e03130e2800130119041b07141d190b0a100500070a0e110c10190c0a1d0817070c1d061f1d6039"
# Step 1: Convert hex to bytes
ciphertext_bytes = bytes.fromhex(ciphertext_hex)
# Step 2 : Extract the first 5 bytes of the ciphertext (same length as known plaintext)
ciphertext_start = ciphertext_bytes[:5]
# XOR each byte of the known plaintext with the ciphertext to get the key
partial_key = bytes([c ^ p for c, p in zip(ciphertext_start, known_plaintext)])
print(partial_key)
```

```bash
└─$ python3
Python 3.11.8 (main, Feb  7 2024, 21:52:08) [GCC 13.2.0] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> known_plaintext = b"FLAG{"
>>> ciphertext_hex = "1e03130e2800130119041b07141d190b0a100500070a0e110c10190c0a1d0817070c1d061f1d6039"
>>> ciphertext_bytes = bytes.fromhex(ciphertext_hex)
>>> ciphertext_start = ciphertext_bytes[:5]
>>> partial_key = bytes([c ^ p for c, p in zip(ciphertext_start, known_plaintext)])
>>> print(partial_key)
b'XORIS'
>>> exit()
```
#### The partial key is `XORIS`

### Brute Force
*the script is in [sol.py](sol.py)*
Since The partial key is XORIS (5 characters ) and the **key length is 8** we need to Brute-Force the Key, and find the remaining **3 bytes** of the key. Since the key is composed of uppercase letters (A-Z) `All chars are in uppercase`, we can brute-force all possible combinations for the remaining 3 bytes. We also filtered out the flags ssing regex to filter valid flags ensures that only meaningful results are considered with the correct flag fromat `FLAG{}`.

### Flag
Key: `XORISBAD`
Plaintext: `FLAG{BREAKING_XOR_WITHOUT_KEY_IS_COOL_!}`

>Find More on ==> github.com/MedhatHassan

