#!/usr/bin/python3
import sys
import os
import subprocess

#Admino script
#Author: Xavier Husser
input = sys.argv[1]

if (str(input) == "--help"):
    print("Welcome to the Admino system information script\nPlease follow the following"
          + "instructions to use it\n" + "- admino - h --> provides hostname information.\n"
          + "- admino - i < interface > -->  provides the IP address of provided < interface >\n"
          + "-admino - u --> provides the list of users of the system.\n"
          + "- admino - g < groupname > --> provides the list of users for an specific < group >\n"
          + "-admino - t < user > -->provides the directory list tree for a system < user >\n"
          + "-admino -l --> provides the list of IPs from last remote connections\n"
          + "-admino -p --> provides the top 10 processes which are using more % memory\n"
          + "-admino -s --> provides the list of SUDO invoked commands from log file\n"
          + "-admino -d --> provides a randomly generated strong password")
elif input == "-h":
    #calling hostnamectl command and checking if it is a true shell command
    subprocess.call(["hostnamectl"],shell = True)

elif input == "-i":
    #opening and reading a pipe command to get ip address for interface then stripping new line
    ip = os.popen("hostname -I | awk \"{print $1\"}").read().rstrip("\n")
    print("Your ip for " + str(sys.argv[2]) + " interface is:", ip)

elif input == "-u":
    #opening a pipe command to print list of users
    #then using standard output of file in a for loop which decodes the bytes of the object to a string literal
    output = subprocess.Popen(["awk","-F:", "BEGIN {print \"The list of users of your system are:\"} {print $1}", "/etc/passwd"],stdout=subprocess.PIPE)
    end_of_pipe = output.stdout
    for line in end_of_pipe:
        print(line.decode("utf-8").strip())

elif input == "-g":
    #Breaking up a multi-piped command into smaller pieces
    #first we call the cat command then 
    #use the output of cat variable as standard input of grep
    #then use output of grep as input for awk command and iterate over the byte object created
    #while iterating we also decode it to a string object. 
    cat = subprocess.Popen(["cat", "/etc/group"], stdout=subprocess.PIPE)

    grep = subprocess.Popen(["grep",str(sys.argv[2])],stdin=cat.stdout, stdout=subprocess.PIPE)

    awk = subprocess.Popen(["awk", "-F", ":", "{print $3, $4}"], stdin=grep.stdout, stdout=subprocess.PIPE)

    end_of_pipe = awk.stdout

    for line in end_of_pipe:
        print(line.decode("utf-8").strip())

elif input == "-t":
    print("Directory list for user : " + str(sys.argv[2]))
    subprocess.call(["tree" , "/home" + str(sys.argv[2])], shell=True)

elif input == "-l":
    #Breaking up a multi-piped command into smaller pieces
    #first we call the last command then
    #use the output of last variable as standard input of awk
    #then use output of awk as input for uniq command and iterate over the byte object created
    #while iterating we also decode it to a string object.
    last = subprocess.Popen(["last", "-5", "-i"],stdout=subprocess.PIPE)

    awk = subprocess.Popen(["awk", "BEGIN {print \"IP addresses\"} {print $3}"],stdin=last.stdout, stdout=subprocess.PIPE)

    uniq = subprocess.Popen(["uniq", "-c"],stdin=awk.stdout, stdout=subprocess.PIPE)

    end_of_pipe = uniq.stdout
    for line in end_of_pipe:
        print(line.decode("utf-8"))

elif input == "-p":
    subprocess.call("ps aux --sort=-%mem | head", shell=True)

elif input == "-s":
    sudo_cat = subprocess.Popen(["sudo", "cat", "/var/log/secure"], stdout=subprocess.PIPE)

    grep = subprocess.Popen(["grep", "sudo"], stdin=sudo_cat.stdout, stdout=subprocess.PIPE)

    tail = subprocess.Popen(["tail"], stdin=grep.stdout, stdout=subprocess.PIPE)

    awk = subprocess.Popen(["awk", "{print \"Date:\"$1, $2, $3, $5, $14, $15}"], stdin=tail.stdout, stdout=subprocess.PIPE)

    end_of_pipe = awk.stdout
    for line in end_of_pipe:
        print(line.decode("utf-8"))

elif input == "-d":
    print("Strong suggested password from terminal:")

    date = subprocess.Popen(["date", "+%s"], stdout=subprocess.PIPE)

    shasum = subprocess.Popen(["sha256sum"], stdin=date.stdout, stdout=subprocess.PIPE)

    base64 = subprocess.Popen(["base64"],stdin=shasum.stdout, stdout=subprocess.PIPE)

    reverse = subprocess.Popen(["rev"], stdin=base64.stdout, stdout=subprocess.PIPE)

    head = subprocess.Popen(["head", "-c", "12"], stdin=reverse.stdout, stdout=subprocess.PIPE)

    end_of_pipe = head.stdout
    for line in end_of_pipe:
        print(line.decode("utf-8"))
else: 
    print("Invalid command")
