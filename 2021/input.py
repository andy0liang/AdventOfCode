import requests
import time
from dotenv import load_dotenv
import os
import sys
if(len(sys.argv)==1):
    sys.argv.append("normal")
while(True):
    t = time.localtime(time.time())
    hour = t.tm_hour
    minute = t.tm_min
    if(sys.argv[1] == "custom"):
        break;
    if(hour>=21):
        break
    else:
        time.sleep(1)

load_dotenv()

cookie = os.getenv("COOKIE")

s = requests.session()
s.cookies.set("session", cookie)
day = t.tm_mday+1

if(sys.argv[1]=="custom"):
    day = int(sys.argv[2])
url = "https://adventofcode.com/2021/day/"
   
url += str(day)
url += "/input"


response = s.get(url)

data = response.text
print(data)

f = open("input"+str(day)+".txt", "w")
f.write(data)
f.close()

