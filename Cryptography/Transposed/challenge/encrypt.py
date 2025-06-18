#-*- coding:utf-8 -*-

import random

W = 7
perm = range(W)
random.shuffle(perm)

msg = open("flag.txt").read().strip()
while len(msg) % (2*W):
    msg += "."

for i in xrange(100):
    msg = msg[1:] + msg[:1]
    msg = msg[0::2] + msg[1::2]
    msg = msg[1:] + msg[:1]
    res = ""
    for j in xrange(0, len(msg), W):
        for k in xrange(W):
            res += msg[j:j+W][perm[k]]
    msg = res
print msg
