# flag format flag{xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx},only a-z,0-9,_ are allowed

ll =[51, 54, 48, 51, 61, 57, 50, 54, 48, 52, 55, 50, 50, 57, 47, 52, 57, 47, 54, 24, 57, 58, 62]

i = raw_input()
ss= 0 
try:
    for ii in range(0,46 , 2):
        temp = i[ii:ii+2]
        temp = int(temp,0x10)
        ss+=temp
        temp >>=1
        if temp != ll[ii/2]:
            print("Something is wrong")
    if ss !=2406:
            print(ss/0)
    print("This flag may or may not work, can you find more ?")
        
except:
    print ("NO")