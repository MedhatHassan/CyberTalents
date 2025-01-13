import urllib.parse
import base64
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

def create_aes_managed_object(key, iv=None):
    """
    Creates an AES object with CBC mode and zero padding.
    """
    if isinstance(key, str):
        key = base64.b64decode(key)  # Decode key from Base64 if it's a string
    if isinstance(iv, str):
        iv = base64.b64decode(iv)  # Decode IV from Base64 if it's a string
    return Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend())

def decrypt_string(key, encrypted_string_with_iv):
    """
    Decrypts a string using AES-CBC with zero padding.
    """
    # Decode the encrypted string from Base64
    encrypted_data = base64.b64decode(encrypted_string_with_iv)
    
    # Extract the IV (first 16 bytes) and the actual encrypted data
    iv = encrypted_data[:16]
    encrypted_bytes = encrypted_data[16:]
    
    # Create the AES object
    aes = create_aes_managed_object(key, iv)
    decryptor = aes.decryptor()
    
    # Decrypt the data
    decrypted_data = decryptor.update(encrypted_bytes) + decryptor.finalize()
    
    # Remove zero padding and return as a UTF-8 string
    return decrypted_data.rstrip(b'\x00').decode('utf-8')

# Define the key for decryption (from host.ps1)
key = "llm0xB8WOfv9Ssq9+f0sIMFK6OyQHOzhdenMzRInqXA="

with open("PostData.txt", "r") as file:
    data = file.read()

results = []
for line in data.splitlines():
    if line.startswith("result="):
        results.append(line.split("result=")[1])

for result in results:
    url_decoded = urllib.parse.unquote(result)
    
    try:
        decrypted_string = decrypt_string(key, url_decoded)
    except Exception as e:
        decrypted_string = f"Error decrypting: {e}"
    
    print(f"Original: {result}")
    print(f"URL Decoded: {url_decoded}")
    print(f"Decrypted: {decrypted_string}")
    print("-" * 40)