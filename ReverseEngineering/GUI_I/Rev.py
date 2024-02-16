def decimal_to_ascii(decimal_number):
    try:
        ascii_character = chr(decimal_number)
        return ascii_character
    except ValueError:
        # Handle the case where the decimal number is out of ASCII range
        return None

def print_as_string(output):
    return ''.join(output)

input_list = [92, 98, 87, 93, 113, 95, 105, 85, 106, 94, 95, 105, 85, 89, 87, 91, 105, 87, 104, 85, 89, 95, 102, 94, 91, 104, 53, 115]
output = []

# Adding 10 to each element in the input_list
output = [i + 10 for i in input_list]

# Converting the list of numbers to ASCII characters
output = [decimal_to_ascii(num) for num in output]

# Print the output as a string
result_string = print_as_string(output)
print(result_string)
