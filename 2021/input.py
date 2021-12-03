import requests
import time
from dotenv import load_dotenv
import os


while(True):
    t = time.localtime(time.time())
    hour = t.tm_hour
    minute = t.tm_min
    if(hour>=21):
        break
    else:
        time.sleep(1)

load_dotenv()

cookie = os.getenv("COOKIE")

s = requests.session()
s.cookies.set("session", cookie)

url = "https://adventofcode.com/2021/day/"
url += str(t.tm_mday+1)
url += "/input"


response = s.get(url)

data = response.text
print(data)

f = open("input"+str(t.tm_mday+1)+".txt", "w")
f.write(data)
f.close()

