import pymysql
import timeit

conn = pymysql.connect(host='localhost', port=3306, user='root', passwd='', db='hotel', autocommit=True)

cur = conn.cursor()

start = timeit.default_timer()  # Measure the time the next statement needs
cur.execute("INSERT INTO hotel (id, name, strasse, ort) "
            "VALUES (NULL, 'Hotel x', 'Strasse x', 'Ort x');")  # INSERT INTO Statement here
elapsed = timeit.default_timer()-start
print "TIME ELAPSED:", elapsed


cur.execute("Select * from hotel")
print cur.rowcount  # output rowcount

cur.close()
conn.close()
