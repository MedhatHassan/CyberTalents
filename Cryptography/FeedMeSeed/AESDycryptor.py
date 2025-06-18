from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
import random

# Regenerate the same key using the fixed seed
random.seed(123456)
key = random.randbytes(16)

ciphertext = b'=\x05\xf6zR\xc0\xd5\xb0\xd1\xa1<%\xce:<\xa1h\xd6>!$\xe3\x95\xf9f\x1bj|\x0c\xd7\x19\xe4I\xa6\x8b.\xba\x88|<\xc95(\x08\xf8\x18\x96\x0b'

cipher = AES.new(key, AES.MODE_ECB)
decrypted_padded = cipher.decrypt(ciphertext)

flag = unpad(decrypted_padded, AES.block_size)
print("Flag:", flag.decode())