def reverse(original):
    # Convert the input string to a list of characters
    char_list = list(original)

    # Reverse the list
    char_list.reverse()

    # Convert the reversed list back to a string
    reversed_string = ''.join(char_list)

    return reversed_string

label2 = "d0248b4e"
label3 = "47996655"
label4 = "83f05689"
label5 = "c154b6ea"

original_string = label2 + label3 + label4 + label5
reversed_result = reverse(original_string)
print("original string: ",original_string)
print("The key: ",reversed_result)
