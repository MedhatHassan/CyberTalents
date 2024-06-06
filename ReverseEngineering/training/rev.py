key = [0x03,0x05,0x07,0x0b,0x0d,0x11,0x13,0x17,0x1D,0x1F,0x25,0x29,0x2B,0x2F,0x35,0x3B,0x3D,0x43,0x47,0x49,0x4F,0x53,0x59,0x61,0x65,0x67,0x6B,0x6D,0x71,0x7F,0x83,0x89,0x8B,0x95,0x97,0x9D,0x0A3,0xA7,0xAD,0xB3,0xB5,0xbf,0xc1,0xc5,0xc7,0xd3,0xdf,0xe3,0xe5,0xe9,0xef,0xf1,0xfb]
def enc(inp):
    inp = list(inp)
    for i in range(len(inp)):
        current_char = ord(inp[i])
        v17 = ord(inp[i]) + key[i]
        if current_char > 96 and current_char <= 122:
            v6 = 122
        else:
            if (current_char > 96 and current_char <= 122 or current_char > 64 and current_char <= 90) and not (current_char > 96 and current_char <= 122):
                v6 = 90
            else:
                v6 = current_char
        while v17 > v6: v17 -= 26
        if current_char == 123:
            v12 = 125
        else:
            if current_char == 125:
                v12 = 123
            else:
                if current_char > 96 and current_char <= 122 or current_char > 64 and current_char <= 90:
                    v12 = v17
                else:
                    v12 = current_char
        inp[i] = chr(v12)
    return ''.join(inp)


flag="IQHR}nxio_vtvk_aapbijsr_vnxwbbmm{"
while True:
    if "FLAG" in flag:
        print(flag)
        break
    flag = enc(flag)