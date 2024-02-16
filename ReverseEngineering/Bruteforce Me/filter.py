import re

def is_valid_flag(flag):
    # Check if the flag contains only a-z, 0-9, or _
    return bool(re.match("^[a-z0-9_]+$", flag)) and 6 <= len(flag) <= 20

def filter_flags(input_file, output_file):
    with open(input_file, 'r') as infile, open(output_file, 'w') as outfile:
        for line in infile:
            # Extract the string between {}
            match = re.search(r'\{(.+?)\}', line)
            
            if match:
                flag = match.group(1)
                if is_valid_flag(flag) and "_is_" in flag:
                    # Write the valid flag to the output file
                    outfile.write(f'flag{{{flag}}}\n')

# Specify the input and output file names
input_filename = 'flags'  # Change this to your input file name
output_filename = 'filteredflags'

# Call the function
filter_flags(input_filename, output_filename)
