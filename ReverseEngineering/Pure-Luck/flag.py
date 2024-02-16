local_1 = 0x66
local_2 = 0x6c
local_3 = 0x61
local_4 = 0x67
local_5 = 0x7b
local_6 = 0x55
local_7 = 0x50
local_8 = 0x58
local_9 = 0x5f
local_10 = 0x69
local_11 = 0x73
local_12 = 0x5f
local_13 = 0x73
local_14 = 0x6f
local_15 = 0x5f
local_16 = 0x65
local_17 = 0x61
local_18 = 0x61
local_19 = 0x61
local_20 = 0x61
local_21 = 0x73
local_22 = 0x79
local_23 = 0x79
local_24 = 0x7d

variables = [
    local_1, local_2, local_3, local_4, local_5, local_6, local_7, local_8, local_9,
    local_10, local_11, local_12, local_13, local_14, local_15, local_16, local_17, 
    local_18, local_19, local_20, local_21, local_22, local_23, local_24
]
# Convert the variables to strings and join them into a single string
flag = ''.join([chr(variable) for variable in variables])

print(flag)