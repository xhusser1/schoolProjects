#!/usr/local/bin/python3
import zipfile # Library to extract zip files
from  tqdm import tqdm
import time # Library to control the time spent in the cracking process
import sys # Library to control the arguments of the script

def main():
	
	found = 1
	if len(sys.argv) != 3:
		print ("\n Please provide zipped file and dictionary file.\n\n ex) crack.sh zippedfile.zip dictionary.txt")
	else: 
		zfile = sys.argv[1] 
		dfile = sys.argv[2]
		filezip = zipfile.ZipFile(zfile) # We used the zipfile library to open the zipped file.
		passFile = len(list(open(dfile,"rb"))) # We open the dictionary file.
		print("Total passwords to test:", passFile)
		stime = time.time()
		
		with open(dfile, "rb") as dfile:
			for word in tqdm(dfile, total = passFile, unit = "word"):
				try:
				#trying the password with zipfile library
					filezip.extractall(pwd=word.strip())
				except:
					continue
				else:
					print (" Password Found " + str(word))
					exit(0)
		print("[-] Password not found")	
main()
