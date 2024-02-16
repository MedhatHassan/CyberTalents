ll = [51, 54, 48, 51, 61, 57, 50, 54, 48, 52, 55, 50, 50, 57, 47, 52, 57, 47, 54, 24, 57, 58, 62]
ll = [i*2 for i in ll]

def bruteforce(i=0, flag=[0] * 23):
    if i == 23:
        if sum(flag) == 2406:
            string = ''.join([chr(i) for i in flag])
            if string.startswith('flag{') and string.endswith("}"):
                with open("flags", "a") as file:
                    file.write(string + "\n")
        return
    flag[i] = ll[i]
    bruteforce(i+1, flag)
    flag[i] = ll[i] + 1
    bruteforce(i+1, flag)

bruteforce()