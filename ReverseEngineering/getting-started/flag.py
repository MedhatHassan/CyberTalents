def reverse(original):
    # Convert the input string to a list of characters
    char_list = list(original)

    # Reverse the list
    char_list.reverse()

    # Convert the reversed list back to a string
    reversed_string = ''.join(char_list)

    return reversed_string


flag = "j}j1j_jljejvjejlj_jojtj_jejmjojcjljejwj{jgjajljf"
#remove all j (rubbish data) 
flag = flag.replace('j','')
print(reverse(flag))