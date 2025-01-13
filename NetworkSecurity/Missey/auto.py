from scapy.all import rdpcap, UDP, TCP, ICMP, ARP, DNS

packets = rdpcap("Missey.pcap")

findings = {
    "udp_payloads": [],
    "tcp_payloads": [],
    "icmp_payloads": [],
    "arp_requests": [],
    "dns_queries": []
}

for packet in packets:
    # Extract UDP payloads
    if UDP in packet:
        payload = bytes(packet[UDP].payload)
        if payload:
            findings["udp_payloads"].append(payload.hex())

    # Extract TCP payloads
    if TCP in packet:
        payload = bytes(packet[TCP].payload)
        if payload:
            findings["tcp_payloads"].append(payload.hex())

    # Extract ICMP payloads
    if ICMP in packet:
        payload = bytes(packet[ICMP].payload)
        if payload:
            findings["icmp_payloads"].append(payload.hex())

    # Extract ARP requests
    if ARP in packet:
        arp_request = {
            "sender_ip": packet[ARP].psrc,
            "target_ip": packet[ARP].pdst
        }
        findings["arp_requests"].append(arp_request)

    # Extract DNS queries
    if DNS in packet and packet[DNS].qr == 0:  # DNS query (qr=0)
        dns_query = packet[DNS].qd.qname.decode("utf-8", errors="ignore")
        findings["dns_queries"].append(dns_query)

print("UDP Payloads:", findings["udp_payloads"][:5])  
print("TCP Payloads:", findings["tcp_payloads"][:5])
print("ICMP Payloads:", findings["icmp_payloads"][:5])
print("ARP Requests:", findings["arp_requests"][:5])
print("DNS Queries:", findings["dns_queries"][:5])