l = []
for i in range(1000):
    l.append(input())

hor = 0
depth = 0

for line in l:
    spl = line.split(" ")
    if(spl[0]=="forward"):
        hor+=int(spl[1])
    elif(spl[0]=="down"):
        depth+=int(spl[1])
    else:
        depth-=int(spl[1])

print(hor*depth)
