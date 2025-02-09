def t9_decode(ct):
    # Mapping from T9 to corresponding letters
    t9_map = {
        '2': 'A', '22': 'B', '222': 'C',  # 2 maps to ABC
        '3': 'D', '33': 'E', '333': 'F',  # 3 maps to DEF
        '4': 'G', '44': 'H', '444': 'I',  # 4 maps to GHI
        '5': 'J', '55': 'K', '555': 'L',  # 5 maps to JKL
        '6': 'M', '66': 'N', '666': 'O',  # 6 maps to MNO
        '7': 'P', '77': 'Q', '777': 'R', '7777': 'S',  # 7 maps to PQRS
        '8': 'T', '88': 'U', '888': 'V',  # 8 maps to TUV
        '9': 'W', '99': 'X', '999': 'Y', '9999': 'Z'  # 9 maps to WXYZ
    }
    
    ct_list = ct.split(' ')
    
    decoded_message = []
    
    for code in ct_list:
        if code in t9_map:
            decoded_message.append(t9_map[code])
        else:
            decoded_message.append('?')
    
   
    return ''.join(decoded_message)


ciphertext = "7777 2 44 333 444 99 666 3 66 555 33 33 666 3 7 99 444 777 222 33"
decoded_message = t9_decode(ciphertext)

print("Decoded Message:", decoded_message)