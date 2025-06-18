ciphertext = "L{NTP#AGLCSF.#OAR4A#STOL11__}PYCCTO1N#RS.S"
W = 7
perm = [3, 2, 5, 6, 0, 4, 1]  # Found via chosen plaintext attack

# Compute inverse permutation
inv_perm = [0] * W
for idx, val in enumerate(perm):
    inv_perm[val] = idx

n = len(ciphertext)
msg = ciphertext

for _ in range(100):
    # Reverse permutation on blocks
    blocks = [msg[i:i+W] for i in range(0, n, W)]
    new_blocks = []
    for block in blocks:
        new_block = [''] * W
        for k in range(W):
            new_block[k] = block[inv_perm[k]]
        new_blocks.append(''.join(new_block))
    msg = ''.join(new_blocks)
    
    # Right rotate once
    msg = msg[-1:] + msg[:-1]
    
    # Unshuffle: split into two halves and interleave
    half = n // 2
    first_half = msg[:half]
    second_half = msg[half:]
    unshuffled = [''] * n
    unshuffled[0::2] = first_half
    unshuffled[1::2] = second_half
    msg = ''.join(unshuffled)
    
    # Right rotate once more
    msg = msg[-1:] + msg[:-1]

# Remove padding (trailing '.')
flag = msg.rstrip('.')
print(flag)