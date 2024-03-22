def map_to_flag(input_str):
    mapped_result = ""
    skipped_count = 0
    for i, char in enumerate(input_str):
        if char.isalpha():
            mapped_char = chr(((ord(char) - ord('a') + i + 1 - skipped_count) % 26) + ord('a')) if char.islower() else chr(((ord(char) - ord('A') + i + 1 - skipped_count) % 26) + ord('A'))
        else:
            mapped_char = char
            skipped_count += 1
        mapped_result += mapped_char
    return mapped_result

input_str = "ejxc{T0nY0J_BsUMS4}"
mapped_result = map_to_flag(input_str)
print("Mapped Result:", mapped_result)