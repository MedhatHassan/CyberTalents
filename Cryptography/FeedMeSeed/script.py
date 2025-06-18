from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
import random


random.seed(123456)
key = random.randbytes(16)

message = b'flag{redacted}'
message = pad(message, AES.block_size)


cipher = AES.new(key, AES.MODE_ECB)
encrypted_message = cipher.encrypt(message)


print(encrypted_message)
# =\x05\xf6zR\xc0\xd5\xb0\xd1\xa1<%\xce:<\xa1h\xd6>!$\xe3\x95\xf9f\x1bj|\x0c\xd7\x19\xe4I\xa6\x8b.\xba\x88|<\xc95(\x08\xf8\x18\x96\x0b