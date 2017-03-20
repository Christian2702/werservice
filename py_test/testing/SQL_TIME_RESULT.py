import pymysql
import timeit

conn = pymysql.connect(host='localhost', port=3306, user='root', passwd='', db='hotel', autocommit=True)

cur = conn.connect()

start = timeit.default_timer()
# cur.execute() statement here

elapsed = timeit.default_timer()-start
print "TIME ELAPSED:", elapsed
