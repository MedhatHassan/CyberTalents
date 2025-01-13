from scapy.all import rdpcap, ARP, Ether

# Path to the PCAP file
pcap_file = "ARP+Storm.pcap"

# Output file to save extracted data
output_file = "arp_packet_data.txt"

# Read the PCAP file
packets = rdpcap(pcap_file)

# List to store valid packets
valid_packets = []

# Iterate through each packet
for i, packet in enumerate(packets):
    if ARP in packet:
        # Extract ARP layer
        arp_layer = packet[ARP]

        # Extract relevant fields
        opcode = arp_layer.op  # ARP Opcode
        sender_mac = arp_layer.hwsrc  # Sender MAC Address
        sender_ip = arp_layer.psrc  # Sender IP Address
        target_mac = arp_layer.hwdst  # Target MAC Address
        target_ip = arp_layer.pdst  # Target IP Address

        # Store the valid packet data
        valid_packets.append({
            "packet_index": i,
            "opcode": opcode,
            "sender_mac": sender_mac,
            "sender_ip": sender_ip,
            "target_mac": target_mac,
            "target_ip": target_ip
        })

# Sort valid packets by Packet Index to ensure correct order
valid_packets.sort(key=lambda x: x["packet_index"])

# Write the valid data to the output file
with open(output_file, "w") as f:
    for packet in valid_packets:
        f.write(f"Packet Index: {packet['packet_index']}\n")
        f.write(f"Opcode: {packet['opcode']}\n")
        f.write(f"Sender MAC: {packet['sender_mac']}\n")
        f.write(f"Sender IP: {packet['sender_ip']}\n")
        f.write(f"Target MAC: {packet['target_mac']}\n")
        f.write(f"Target IP: {packet['target_ip']}\n")
        f.write("-" * 40 + "\n")

print(f"Valid ARP data extracted and saved to {output_file}")