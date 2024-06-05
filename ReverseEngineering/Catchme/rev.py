def decrypt_string():
    encryptedString = bytearray(b"Catch Me If You Can")
    
    # XOR key values
    xorKeys = [0x25, 0xd, 0x15, 0x4, 0x13, 0x74, 0x1, 0x36, 0x7f, 0x78, 0x35, 0x7f, 0x1e, 0x5f, 0x45, 0x64, 0x79, 0x48, 0x13]
    
    # Decrypt the string
    decryptedString = bytearray(len(encryptedString))
    for i in range(19):
        decryptedString[i] = encryptedString[i] ^ xorKeys[i]
    
    return decryptedString.decode()

print(decrypt_string())
