# Solve RSA101
### https://cybertalents.com/challenges/cryptography/rsa101

#### Decrypt the file using a private key with openssl
```bash
openssl pkeyutl -decrypt -in cipher -out decrypted.txt -inkey key.pem
```

flag `flag{RSA_nice_try}` 

>Find More on ==> github.com/MedhatHassan