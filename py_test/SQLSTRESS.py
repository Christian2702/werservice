import pymysql

conn = pymysql.connect(host='localhost', port=3306, user='root', passwd='', db='hotel')
cur = conn.cursor()
cur.execute("")  # INSERT INTO Statement here


""" Use for Printing
for row in cur:
    print row
"""
cur.close()
conn.close()
