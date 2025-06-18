import os
from hashlib import sha256

def H(v):
    return int(sha256(str(v).encode()).hexdigest(), 16)

def STEP(v):
    return (31338 * v**3 + 17 * v**2 + 2017 * v + 10) % 2**256

def encrypt(pt, state):
    ct = b""
    for c in pt.encode():
        for _ in range(32):
            op = state % 4
            state = STEP(state)
            v = state % 256
            state = STEP(state)
            if op == 0:
                c = (c + v) % 256
            elif op == 1:
                c = (c ^ v) % 256
            elif op == 2:
                c = (c - v) % 256
            elif op == 3:
                c = (c * (v | 1)) % 256
        state ^= c
        ct += bytes([c])
    return ct

def brute_force_initial_state(ciphertext, prefix="flag"):
    # Brute-force the initial state (last byte of H(key))
    target = bytes.fromhex(ciphertext[:len(prefix) * 2])  # Each char -> 2 hex digits
    for last_byte in range(256):
        state = last_byte
        ct = encrypt(prefix, state)
        if ct == target:
            return state
    raise ValueError("Initial state not found. Try a different prefix.")

def recover_flag(ciphertext, initial_state):
    flag = ""
    ciphertext_bytes = bytes.fromhex(ciphertext)
    max_length = len(ciphertext_bytes)
    while len(flag) < max_length:
        for c in range(32, 127):
            candidate = flag + chr(c)
            ct = encrypt(candidate, initial_state)
            if ct == ciphertext_bytes[:len(candidate)]:
                flag += chr(c)
                print(f"Progress: {flag}")
                break
        else:
            raise ValueError(f"Failed to recover next character at position {len(flag)}")
    return flag

# Given ciphertext
ciphertext = "868c017b7bef15e04ccc5f2d6b4c372fdff881080155"

#Try common flag prefixes for cybertalnets 
prefixes = ["flag", "FLAG", "Flag"]
for prefix in prefixes:
    try:
        print(f"Trying prefix: {prefix}")
        initial_state = brute_force_initial_state(ciphertext, prefix)
        print(f"Initial state (last byte of H(key)): {initial_state}")
        flag = recover_flag(ciphertext, initial_state)
        print(f"Flag: {flag}")
        break
    except ValueError as e:
        print(f"Failed with prefix '{prefix}': {e}")
else:
    print("Could not recover flag with common prefixes.")