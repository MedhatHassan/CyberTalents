def get_int_value(index):
    # Simulate the function that returns an integer value based on the index
    # In this case, we'll just return a constant value as a placeholder
    return index

def is_lower_case(char):
    return 'a' <= char <= 'z'

def is_upper_case(char):
    return 'A' <= char <= 'Z'

def is_special_char(char):
    return not char.isalnum() and char not in '{}'

def process_string(input_str):
    result = []
    local_index = 0

    for char in input_str:
        int_value = get_int_value(local_index)
        local_sum = int_value + ord(char)

        if is_lower_case(char):
            max_val = ord('z')
        elif is_upper_case(char):
            max_val = ord('Z')
        else:
            max_val = ord(char)

        while max_val < local_sum:
            local_sum -= 26

        if char == '{':
            local_sum = ord('}')
        elif char == '}':
            local_sum = ord('{')
        elif is_special_char(char):
            local_sum = ord(char)

        result.append(chr(local_sum))
        local_index += 1

    return ''.join(result)

# Input string
input_str = "IQHR}nxio_vtvk_aapbijsr_vnxwbbmm{}"
output_str = process_string(input_str)
print(output_str)
