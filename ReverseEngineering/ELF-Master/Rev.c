#include <stdio.h>
#include <stdint.h>

void decode_and_print(void) {
    // Encoded data
    uint64_t local_38 = 0xc6a9dde2fef8f5ff;
    uint64_t local_30 = 0xd5c6f2a9a9d5c6a8;
    uint64_t local_28 = 0xaac6f7adc6aaf2a8;
    uint64_t local_20 = 0xaaedeaadd4c6dfd5;
    uint16_t local_18 = 0xe4eb;

    // Buffer to hold all the bytes together
    uint8_t data[34];

    // Copying each segment into the data buffer
    memcpy(data, &local_38, sizeof(local_38));
    memcpy(data + 8, &local_30, sizeof(local_30));
    memcpy(data + 16, &local_28, sizeof(local_28));
    memcpy(data + 24, &local_20, sizeof(local_20));
    memcpy(data + 32, &local_18, sizeof(local_18));

    // Decoding and printing each character
    for (int i = 0; i < 34; i++) {
        putchar(data[i] ^ 0x99); // XOR each byte with 0x99 and print
    }
    putchar('\n'); // Print newline at the end
}

int main() {
    decode_and_print();
    return 0;
}
