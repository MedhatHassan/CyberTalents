def reverse_shuffling(s):
    str_list = list(s)
    n = len(str_list)
    
    # Perform the reverse of the shuffling logic
    for i in range(n - 1, -1, -1):  # Iterate from the end to the beginning
        for j in range(n - 2, i - 1, -1):  # Iterate from the second-to-last character to i
            # Swap characters at positions j and j + 1
            str_list[j], str_list[j + 1] = str_list[j + 1], str_list[j]
    
    return ''.join(str_list)

shuffled_string = ''.join(['l', 'g', 'c', 'n', 'y', 'u', 'r', 'V', 'r', '3', '4', 'd', '0', 'D', 'f', '{', '_', '_', '3', '_', 'R', '}', '4', '3', 'n', 'a', '5', '0', '1'])
original_string = reverse_shuffling(shuffled_string)
print(f"Flag: {original_string}")
