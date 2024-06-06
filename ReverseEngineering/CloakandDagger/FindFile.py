from os import listdir
from os.path import isfile, join

# Define the byte pattern to check
byte_pattern = [
    b'\xFF', b'\x00', b'\x03', b'\x06', b'\x0C', b'\x12', b'\x04', b'\x12',
    b'\x12', b'\x12', b'\x00', b'\x01', b'\x00', b'\xC4', b'\x03', b'\x07'
]


files = [f for f in listdir(".") if isfile(join(".", f))]

for file in files:
    with open(file, 'rb') as f:
        data = f.read()

    match = all(data[i] == byte_pattern[i] for i in range(len(byte_pattern)))

    if match:
        print(file)
