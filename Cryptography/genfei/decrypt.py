from struct import pack, unpack

def F(w):
    return ((w * 31337) ^ (w * 1337 >> 16)) % 2**32

def decrypt(block):
    a, b, c, d = unpack("<4I", block)# 32-bit integers
    for i in range(32):
        # Decrypting the second step (1337) in encrypt
        tmp = a
        d = d ^ 1337
        a = c ^ (F(d | F(d) ^ d))
        b = b ^ (F(d ^ F(a) ^ (d | a)))
        c = tmp ^ (F(d | F(b ^ F(a)) ^ F(d | b) ^ a))
        
        # Decrypting the first step (31337) in encrypt
        tmp = a
        a = d ^ 31337
        d = c ^ (F(a | F(a) ^ a))
        c = b ^ (F(a ^ F(d) ^ (a | d)))
        b = tmp ^ (F(a | F(c ^ F(d)) ^ F(a | c) ^ d))
    return pack("<4I", a, b, c, d)

# Read the ciphertext from the file in binary mode
with open("./challenge/flag.enc", "rb") as f:
    ciphertext = f.read()

# Decrypt the ciphertext in 16-byte blocks
pt = b"".join(decrypt(ciphertext[i:i+16]) for i in range(0, len(ciphertext), 16))

print(pt.decode("utf-8", errors="ignore").rstrip("#"))