from Crypto.Util.number import getPrime, bytes_to_long, inverse

flag = b"Flag{XXXXXXXXXXXXXXXXXX}"

p = getPrime(1024)
q = getPrime(1024)
N = p*q
phi = (p-1)*(q-1)
e = 65537
d = inverse(e, phi)

my_key = (N, d)

keys = [(N, getPrime(16)) for i in range(10)]

cipher = bytes_to_long(flag)

for key in keys:
    cipher = pow(cipher, key[1], key[0])

print("- My private key",my_key)
print("- keys",keys)
print("- Encrypted DATA",cipher)
