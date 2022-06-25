import random as r
import datetime

i = 1
while i <= 20:
    pesel = r.randint(10000000000, 99999999999)
    print("INSERT INTO CLIENTS (ID, FIRSTNAME, LASTNAME, PESEL) VALUES ("+str(i)+", 'first" + str(i) + "','last"  + str(i) + "', " + str(pesel) +");")
    i+=1

o = 1
while o <=20:
    print(f"INSERT INTO accounts (ID, CLIENTID, BALANCE, PERCENTAGE, PERCENTAGESPAN, PERCENTAGEDATE) VALUES ({o}, '{o}', '{r.randint(1000,25000)}', '{r.randint(1,5)}', '{r.randint(1,3)}', '{datetime.datetime.now().strftime('%x')}');")
    o+=1
