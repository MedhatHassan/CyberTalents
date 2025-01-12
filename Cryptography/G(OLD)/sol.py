import re

# Ciphertext in bytes
ciphertext_bytes = bytes.fromhex("1e03130e2800130119041b07141d190b0a100500070a0e110c10190c0a1d0817070c1d061f1d6039")

# Partial key
partial_key = b'XORIS'  # FLAG{

# Function to decrypt using a given key
def decrypt(cipher_bytes, key):
    plaintext = bytearray()
    for i, byte in enumerate(cipher_bytes):
        plaintext.append(byte ^ key[i % len(key)])
    return plaintext.decode(errors="ignore")

# Regular expression to match valid flags and exclude those containing '^' or '\'
flag_pattern = re.compile(r"FLAG\{(?!.*[\^\\])[A-Za-z0-9_!@#\$%\^&\*\(\)\-=\+\[\]\{\};:'\",.<>\/?\\\|`~]+\}")

# Open a file to save all outputs
with open("flags.txt", "w") as f:
    # Iterate through all possible combinations for the remaining 3 bytes
    for c1 in range(ord('A'), ord('Z') + 1):
        for c2 in range(ord('A'), ord('Z') + 1):
            for c3 in range(ord('A'), ord('Z') + 1):
                # Construct the full key
                key = partial_key + bytes([c1, c2, c3])
                # Decrypt the ciphertext
                plaintext = decrypt(ciphertext_bytes, key)
                # Check if the plaintext matches the flag pattern and does not contain '^' or '\'
                if flag_pattern.match(plaintext):
                    # Write the key and plaintext to the file
                    f.write(f"Key: {key.decode()} | Plaintext: {plaintext}\n")
                    # Print the key and plaintext
                    print(f"Key: {key.decode()} | Plaintext: {plaintext}")

print("Flags saved to flags.txt")