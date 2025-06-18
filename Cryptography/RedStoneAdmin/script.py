n = 2**136 + 85  # 0x10000000000000000000000000000000055
target = 35979253760252124533044326983738660434153
exponent = 31337

# Compute Euler's totient (since n is prime, φ(n) = n-1)
phi = n - 1

# Calculate modular inverse of exponent modulo φ(n)
d = pow(exponent, -1, phi)

# Compute the secret
secret = pow(target, d, n)

print("The secret is:", secret)