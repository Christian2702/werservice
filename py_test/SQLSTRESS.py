import pymysql

conn = pymysql.connect(host='localhost', port=3306, user='root', passwd='', db='hotel')

cur = conn.cursor()

cur.execute("Select * from hotel")

for row in cur:
    print row


cur.close()
conn.close()