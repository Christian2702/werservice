import pymysql

conn = pymysql.connect(host='localhost', port=3306, user='root', passwd='', db='hotel')

cur = conn.cursor()

cur.execute("INSERT INTO hotel (id, name, strasse, ort) "
            "VALUES (NULL, 'Hotel x', 'Strasse x', 'Ort x');")  # INSERT INTO Statement here
conn.commit()  # Commit changes to Database

cur.execute("Select * from hotel")
print cur.rowcount  # output rowcount

cur.close()
conn.close()
