# Solve arithmetic
### https://cybertalents.com/challenges/cryptography/arithmetic
#### Challenge Description
SHA256 is safe, the cipher is not?

### Encryption Process
1. A random **32-byte** key is generated.
2. The key is hashed using `SHA-256` to initialize the internal state.
3. For each character in the plaintext:
   - Perform **32 rounds** of transformations
   - Each round uses **2 state updates** to determine operation and value
   - Operations: `add`, `XOR`, `subtract`, or `multiply`
   - Final state update: `XOR` with encrypted character
   - The state is updated after each operation.
4. The transformed characters are combined to form the ciphertext.
5. The ciphertext is output as a hexadecimal string.

The critical weakness we can exploit is in the STEP function's behavior:

```python
def STEP(v):
    return (31338 * v**3 + 17 * v**2 + 2017 * v + 10) % 2**256
```
Last Byte Determinism:
- `STEP(v) % 256 ` depends **ONLY** on `v % 256`
- This means the last byte of the state completely determines the sequence of operations

### Decrypt Strategy:
1. Brute-force Initial State:
  - Assume flag starts with `"FLAG{"` (common format)
  - Try all **256** possible last bytes for initial state
  - Find which one produces the ciphertext's **first 5 bytes** when encrypting `"FLAG{"`

2. Recover Full Flag:
   - With initial state known, decrypt remaining characters one-by-one
   - For each position, try all printable ASCII characters
   - Check which one extends the matching ciphertext

*you can find the script in [decrypt](decrypt.py)*

### Flag
Flag: `FLAG{SM4LL_57473_HAHA}`

>Find More on ==> github.com/MedhatHassan