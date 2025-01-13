from scapy.all import rdpcap, IP, TCP, Raw

packets = rdpcap("Arson.pcapng")

http_get_requests = []

for packet in packets:
    # Check if the packet has IP, TCP, and Raw layers
    if IP in packet and TCP in packet and Raw in packet:
        # Get the source and destination IP addresses
        src_ip = packet[IP].src
        dst_ip = packet[IP].dst

        # Get the TCP payload (HTTP data)
        tcp_payload = bytes(packet[Raw]).decode("utf-8", errors="ignore")

        if "GET" in tcp_payload.splitlines()[0]:  
            http_get_requests.append({
                "src_ip": src_ip,
                "dst_ip": dst_ip,
                "payload": tcp_payload
            })

with open("http_get_requests.txt", "w") as file:
    for request in http_get_requests:
        file.write(f"Source IP: {request['src_ip']}\n")
        file.write(f"Destination IP: {request['dst_ip']}\n")
        file.write(f"HTTP GET Request:\n{request['payload']}\n")
        file.write("-" * 40 + "\n")

print("HTTP GET request data extracted and saved to 'http_get_requests.txt'.")