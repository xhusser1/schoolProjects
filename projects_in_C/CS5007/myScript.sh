#!/bin/bash
# The line above makes your script executable.
# You should write your tutorial in here.
# Purpose of the script: "To sort a particular column of data and print out the last ten vales and print out 
#		          the average of that column of data."
  
# Problem Statement: "Often if I'm looking at an excel spreadsheet of a stock I have to ignore the 
#		      other columns and focus on the one I need. If I want to see the highest stock price of 
# 		      Netflix over the last ten market days and get the average of those ten entries I need to 
# 		      use several different commands in order to do that. Luckily there are three helpful commands
# 		      that could do just that. 'Awk' allows me to manipulate the text pattern of data to show when  
# 		      used with a field separator which in this instance is a ','. Following the delimiter I can call
# 		      print $1, $3 which will show the dates from the first column and price from the third column   	 
# 		      I'm looking for (the highest price for Netflix during trading over the past ten days) and only 
# 		      present that data to me instead of a huge spreadsheet of irrelevant data."
#Name of commnad: awk
#Example of its usage:
#awk -F ',' '{print $1, $3}'
# Problem Statement: "Now that I have my columns of dates and highest prices I need to find a way to only see the last ten days
#		     instead of every price within the last year. In order to do that I'll have to connect my results from printing
#		     only column 1 and 3 from the spreadsheet to a new command called 'tail' which would allows me to print the 
#		     last N values of a file. Lucilky for me 'tail' by default already prints the last ten values, so the only thing 
#		     I need to do is pipe the results of my previous awk command into my tail command with '|' and instead of getting
# 		     all of the highest market prices for Netflix's stock within the past year I'll only output ten dates and prices 
# 		     from February 26th to March 10th."
#Name of command: tail
#Example of its usage:
#tail NFLX.csv | awk -F ',' '{print $1, $3}'
# Problem Statement: "We've gotten the correct data and now how output them which is really useful for looking at a snapshot of 
#	     	      Netflix's highest stock prices over the past ten days. Now how will I get the average of those ten entries.
#		      I can call awk and set a variable total equal to the first value in column 3 then have a count variable 
#		      which increments the rows within the column and adds up a total value. Since the average is our value to outpup
#		      we use 'END' to output once and print the string 'the average is:' before we calculate the average by 
#		      dividing the total and the count."
#Name of command: END
#Example of its usage: 
#END {print "the average is:", total/count}             
tail NFLX.csv | awk -F ',' '{print $1, $3}' 
tail NFLX.csv | awk -F ',' '{total += $3; count++} END {print "the average is:",  total/count}' 
# Include comments inline with your script explaining what is going on.

# You might start out by first saying the purpose of the script and
# demonstrating its usage.
