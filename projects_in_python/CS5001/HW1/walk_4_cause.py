import math
'''
CS5001
HW1
Xavier Husser
9/16/19
Walk for a Cause
CS 5001 01
Fall 2019
Homework 1
Goals: Experiential learning with variables, calculations, calling
external functions and problem decomposition.
Test Plan:
Test Case #1
 2 km walk, 1 hr, $1/mile
 1.24 miles, 1.24mph, pace - 48min & 16 sec, earn $1.24
Test Case #2
 12 km walk, 1 hr, $1.3/mile
 7.45 miles, 7.45 mph, pace - 8min & 02sec, earn $9.69
Test Case #3
 13 km walk, 2.5 hr, $1.5/mile
 8.07 miles, 3.29 mph, pace - 18min & 33sec, earn $12.11
Test Case #4
 0.9 km walk, 0.5 hr, $0.75/mile
 0.56 miles, 1.12 mph, pace - 53min & 38sec, earn $0.42
Test Case #5
 17 km walk, 2 hr, $3/mile
 10.56 miles, 5.28 mph, pace - 11min & 21sec, earn $31.68
'''
MILE_PER_KILOMETER = 0.621371

def main():
    #prompt user to give distance walked, time, and sponsor pay per mile

    user_answer_1 = input('How many kilometers did you walk? ')
    kilometers_walked = float(user_answer_1)

    user_answer_2 = input('How many hours was your walk? ')
    hours_walked = float(user_answer_2)

    user_answer_3 = input('How much is your sponsor paying per mile? ')
    sponsor_money = float(user_answer_3)

    #convert kilometers to miles by multiplying input by conversion fact 
    #ppm - math.floor(ppm) * 60 converts the fraction of a second in minutes   
    #into seconds as a non repeating floating number 

    miles = (kilometers_walked * MILE_PER_KILOMETER)
    mph = miles / hours_walked

    minutes = hours_walked * 60
    
    pace_per_mile = minutes / miles

    ppm_sec = (pace_per_mile - math.floor(pace_per_mile)) * 60

    money_earned = sponsor_money * miles

    #math.floor(ppm) in the print out will strip off fraction from minutes
    #math.floor(ppm_sec) will round the non repeating float to the tenths place
    print('Your miles walked is {:.2f} '.format(miles))
    print('Your miles per hour is {:.2f}'.format(mph))
    print('Your pace per mile is ' +(str(math.floor(pace_per_mile))) + ' minutes' + (str(math.floor(ppm_sec))) + ' seconds')
    print('You earned $ {:.2f} dollars '.format(money_earned) +'for the orphange! Thanks!')

main()

     
    
    
