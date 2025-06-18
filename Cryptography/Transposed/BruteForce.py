import itertools

W = 7
known_plain = "FLAG{lets_find_a_kind_of_reverse_logic_}.."
target_cipher = "L{NTP#AGLCSF.#OAR4A#STOL11__}PYCCTO1N#RS.S"

def encrypt(msg, perm):
    while len(msg) % (2 * W):
        msg += "."
    for _ in range(100):
        msg = msg[1:] + msg[:1]
        msg = msg[0::2] + msg[1::2]
        msg = msg[1:] + msg[:1]
        res = ""
        for j in range(0, len(msg), W):
            block = msg[j:j+W]
            for k in range(W):
                res += block[perm[k]]
        msg = res
    return msg

def recover_perm():
    for perm in itertools.permutations(range(W)):
        result = encrypt(known_plain, perm)
        if (result[0:2] == "L{" and result[12] == "." and 
            result[28] == "}" and result[40] == "."):
            print("Recovered permutation:", perm)
            return list(perm)
    return None

perm = recover_perm()