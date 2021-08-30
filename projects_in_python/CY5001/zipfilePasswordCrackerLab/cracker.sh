#!/usr/local/bin/python3
import zipfile  # Library to extract zip files
import time  # Library to control the time spent in the cracking process
import sys  # Library to control the arguments of the script


def main():
    found = 1
    if len(sys.argv) != 3:
        print ("\n Please provide zipped file and dictionary file.\n\n ex) crack.sh zippedfile.zip dictionary.txt")
    else:
        dFile = sys.argv[1]
        pFile = sys.argv[2]
        dictionaryFile = open(dfile)  # We open the dictionary file.
        passwordFile = open(pfile)  # We open the password file.
        count = 0
        stime = time.time()

        for line in passwordFile.readlines():
            password = line.strip("\n")
            # removing the end of the line
            codepass = bytes(password, 'utf-8')
            # password coded in binary
            count = count + 1
            try:
                # trying the password with zipfile library
                dictionaryFile.extractall(pwd=codepass)
            except:
                print (" ** trying ** " + password)
            else:
                print (" Password Found " + str(password))
                found = 0
                break

        etime = (time.time()) - stime
        rate = count / etime
        if (found):
            print ("[-] Password not found")
        print ("Time consumed: " + str(etime) + "seconds")
        print ("Passwords attempted: " + str(count) + ". At" + str(rate) + "tries per second")



main()
