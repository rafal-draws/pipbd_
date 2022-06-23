import random as r
import datetime

i = 0
while i <= 20:
    pesel = r.randint(10000000000, 99999999999)
    print("INSERT INTO clients (firstName, lastName, PESEL) VALUES ('first" + str(i) + "','last"  + str(i) + "', " + str(pesel) +');')
    i+=1

o = 1
while o <=20:
    print(f"INSERT INTO accounts (clientId, balance, percentage, percentageSpan, percentageDate) VALUES ({o}, {r.randint(1000,25000)}, {r.randint(1,5)}, {datetime.datetime.now().strftime('%x')});")
    o+=1
