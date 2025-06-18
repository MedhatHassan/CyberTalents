#-*- coding:utf-8 -*-

import os
from hashlib import sha256

def H(v):
    return int(sha256(str(v)).hexdigest(), 16)

def STEP(v):
    return (31338 * v**3 + 17 * v**2 + 2017 * v + 10) % 2**256

def encrypt(pt, key):
    state = H(key)
    ct = ""
    for c in pt:
        c = ord(c)
        for i in xrange(32):
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
        ct += chr(c)
    return ct


print encrypt(open("flag.txt").read().strip(), os.urandom(32)).encode("hex")
