from scapy.all import rdpcap, IP, TCP

# Load the PCAP file
packets = rdpcap("Missey.pcap")

# Function to check if an IP address is in the range 192.126.117.0/24
def is_in_subnet(ip):
    return ip.startswith("192.126.117.")

# List to store TCP payloads
tcp_payloads = []

# Iterate through each packet
for packet in packets:
    # Check if the packet has IP and TCP layers
    if IP in packet and TCP in packet:
        # Get the source and destination IP addresses
        src_ip = packet[IP].src
        dst_ip = packet[IP].dst

        # Check if the source IP is 192.168.1.7 and the destination IP is in 192.126.117.0/24
        if src_ip == "192.168.1.7" and is_in_subnet(dst_ip):
            # Get the TCP payload
            if packet[TCP].payload:
                payload = bytes(packet[TCP].payload).hex()  # Convert payload to hex string
                tcp_payloads.append(payload)

# Save the TCP payloads to a text file
with open("tcp_payloads.txt", "w") as file:
    for payload in tcp_payloads:
        file.write(payload + "\n")

print("TCP payloads extracted and saved to 'tcp_payloads.txt'.")