#-*- coding:utf-8 -*-

import os
import hashlib
import random

msg = open("flag.txt").read().strip()

res = ""
for i in xrange(0, len(msg), 2):
    pair = msg[i:i+2]
    a = random.randint(1, 16)
    b = random.randint(1, 16)
    res += os.urandom(random.randint(0, 31)).encode("hex")
    res += hashlib.sha512(pair).hexdigest()[a:-b][::-1]
    res += os.urandom(random.randint(0, 31)).encode("hex")
print(res)
