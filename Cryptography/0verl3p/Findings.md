# Solve 0verl4p
### https://cybertalents.com/challenges/cryptography/0verl4p
#### Challenge Description
my friends are texting me using RSA to encrypt the messages, but some expert told me that there is a bad mistake in the implementation, can you figure out what it is?

### Multi-layer RSA encryption 
#### Key Generation
- Prime Numbers Selection:
  - Two large prime numbers `p` and `q` are generated using `getPrime(1024)`.
  - Their product forms `N = p * q`, which serves as the modulus for RSA encryption.
  - The Euler's totient function is computed: `phi = (p-1) * (q-1)`.
- RSA Key Pair:
  - The public exponent `e = 65537` is chosen (a standard RSA value).
  - The private exponent d is computed using the modular inverse: `d = inverse(e, phi)`.
  - The private key is stored as `(N, d)`.

#### Encryption Process
- Flag Conversion:
  - The flag (plaintext) is converted into a large integer via `bytes_to_long(flag)`.
- Layered Encryption:
  - The script **defines 10 RSA keys**, each consisting of `(N, getPrime(16))`, where the second value is a small encryption exponent **(random 16-bit prime)**.
  - The flag is encrypted iteratively with each of these keys using modular exponentiation `(pow(cipher, key[1], key[0]))`.
  - This approach repeatedly encrypts the ciphertext, making decryption more complex.

#### Final Output
- The script prints:
    -  Private key (N, d).
    -  List of encryption keys used.
    -  Final encrypted data.

### Reverse Approach
#### Factorizing N
We compute:
``k = e ⋅ d − 1``, which is a multiple of ``ϕ(N)``.
By factoring out all powers of 2 from ``k``, we get:
``k = 2^t ⋅ s``.
Using a random base ``a``, we compute:
``x = a^s mod N``.
Repeated squaring helps us find a non-trivial square root of 1 modulo ``N``, leading to the factors ``p`` and ``q``.

#### Compute ϕ(N)
With ``p`` and ``q``, we compute: ``ϕ(N) = (p − 1) ⋅ (q − 1)``.
#### Product of Exponents E
Multiply all the encryption exponents from the provided keys to get: ``E``.
#### Decryption Exponent dE
Compute the modular inverse of ``E`` modulo ``ϕ(N)`` to get:
``dE``.

## Decryption Process
Decrypt the ciphertext by computing: ``flag = cipher^dE mod N``,
then convert the result to a string.

NOTE: This approach efficiently **reverses multi-layer RSA encryption** by leveraging the private key to factorize ``N`` and using the **multiplicative property of RSA** to combine the encryption exponents.

### Flag
`Flag{N0_M1stak3s_W1th_RSA}`

>Find More on ==> github.com/MedhatHassan