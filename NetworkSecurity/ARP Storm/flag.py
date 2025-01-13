input_file = "arp_packet_data.txt"

opcodes = []

with open(input_file, "r") as file:
    for line in file:
        if line.startswith("Opcode:"):
            # Extract the opcode value and convert it to an integer
            opcode = int(line.split(":")[1].strip())
            opcodes.append(opcode)

# Convert opcodes to ASCII characters
ascii_string = "".join([chr(opcode) for opcode in opcodes])

print("Extracted ASCII string:", ascii_string)