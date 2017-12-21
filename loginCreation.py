'''
Created on Dec 21, 2017

@author: Alex
'''
import sqlite3
def main():
    createDB()
    insertDummyValues()
    
def createDB():
    db = sqlite3.connect("login.sqlite")
    cursor = db.cursor()
    cursor.execute("DROP TABLE IF EXISTS LoginInfo")
    cursor.execute("CREATE TABLE loginInfo(username VARCHAR(20) PRIMARY KEY, password VARCHAR(20))")
    db.commit()
    cursor.close()
    
def insertDummyValues():
    db = sqlite3.connect("login.sqlite")
    cursor = db.cursor()
    cursor.execute("INSERT INTO loginInfo(username, password) VALUES (?,?)",
                  ("Alex", "Alex1") )
    cursor.execute("INSERT INTO loginInfo(username, password) VALUES (?,?)",
                  ("Ismail", "Ismail1") )
    db.commit()
    cursor.close()
    

if __name__ == '__main__':
    main()