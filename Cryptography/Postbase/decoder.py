import base64

encodedString = 'BR3tCNDUzXzYxWDdZXzRSfQ=='

base64Map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

for i in range(64):
    for j in range(64):
        r = 'R' + base64Map[i] + base64Map[j] + encodedString
        decodedString = base64.b64decode(r)
        if b"flag" in decodedString or b"FLAG" in decodedString:
                print(f"Found {decodedString}")