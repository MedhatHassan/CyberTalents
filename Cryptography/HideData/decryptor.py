def decrypt_caesar(ciphertext, shift):
    plaintext = ""
    for char in ciphertext:
        if char.isalpha():
            if char.islower():
                plaintext += chr(((ord(char) - ord('a') - shift) % 26) + ord('a'))
            else:
                plaintext += chr(((ord(char) - ord('A') - shift) % 26) + ord('A'))
        else:
            plaintext += char
    return plaintext

def decrypt_caesar_all_shifts(ciphertext, output_file):
    with open(output_file, "w") as file:
        for shift in range(26):
            decrypted_text = decrypt_caesar(ciphertext, shift)
            file.write(f"Shift: {shift}\n")
            file.write(f"{decrypted_text}\n\n")

def main():
    ciphertext = "gur synt vf 2w68lsudym Vg vf cerggl rnfl gb frr gur synt ohg pna lbh frr vg v gbbx arneyl 1 zvahgr gb rapbqr guvf jvgu EBG13 tbbq yhpx va fbyivat gung"
    output_file = "HideData/output.txt"
    decrypt_caesar_all_shifts(ciphertext, output_file)
    print("Decryption completed. Check the output file.")

if __name__ == "__main__":
    main()
