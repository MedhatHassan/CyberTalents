#include <stdio.h>

int main() {
    // Encoded data
    unsigned int data[] = {
        0x6000d07, 0x2d2d003a, 0x342e181e, 0x72720f1e, 0x32081e25,
        0x32340b1e, 0x39041e35, 0x35342224, 0x240c1e24, 0x3c
    };

    
    int total_bytes = 37; // 0x25 in hexadecimal
    char decoded_message[total_bytes + 1]; 
    int i, j;
    unsigned char *byte_ptr;

    
    for (i = 0; i < total_bytes; i++) {
        byte_ptr = (unsigned char *)data + i;
        decoded_message[i] = *byte_ptr ^ 0x41; // XOR each byte with 0x41
    }
    
    // Null-terminate the string
    decoded_message[total_bytes] = '\0';

    printf("Decoded message: %s\n", decoded_message);

    return 0;
}
