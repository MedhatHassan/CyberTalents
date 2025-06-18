# Solve Feed Me Seed
#### https://cybertalents.com/challenges/cryptography/feed-me-seed

### Breakdown of the encryption Code
1. A fixed random seed (`123456`) is used, **making the key reproducible**.
2. The key is **16 bytes**, generated via `random.randbytes(16)`.
3. The flag is padded using `PKCS#7` to match *AES block size (16 bytes)*.
4. **ECB mode** is used (no IV, deterministic encryption).

### Decryption Approach:
1. Regenerate the same key using the same seed (`123456`).
2. Decrypt the flag using **AES-ECB**.
3. Remove `PKCS#7` padding to get the original flag.

*you can find the script in [AESDycryptor](AESDycryptor.py)*

### Flag
Flag: `flag{3xp0s3d_s33d_1s_n0t_g00d_s33d}`

>Find More on ==> github.com/MedhatHassan