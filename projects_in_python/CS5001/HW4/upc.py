'''
    Xavier Husser
    Fall 2019
    CS5001
    10/12/19

    This program serves as the upc function that is imported in test_upc.py
    to check upc test cases. Function is_valid_upc will take input of possible
    UPC numbers and return Boolean to state if input was valid or invalid.

    First the function will check any UPCs less than 2 digits long
    and return them as invalid then move on to UPCs with length greater than 2.
    Next step will be to store individual digits in a list called digits.
    Once stored in digits, the list is reversed so to be read from right
    to left. Afterwards we iterate the length of digit list to
    1. check number of zeros to mark ones with all zeros invalid
    2. if i is even so not alter it or odd to multiply by 3
    3. check if the sum of digits is a multiple of 10 
'''

def is_valid_upc(UPC):
    digits = []
    if len(UPC) < 2:
        return False

    for char in UPC:
        digits.append(int(char))

    check_sum = 0
    #tracker for number of zeros in possible UPC
    num_of_zero = 0
    digits.reverse()

    for i in range(len(digits)):
                    
        if digits[i] == 0:
            num_of_zero += 1


        elif i % 2 == 0:
            check_sum += digits[i]
            
        elif i % 2 != 0:
            check_sum += (3*digits[i])
            
    
    if sum(digits) == 0:
        return False
    
    elif check_sum % 10 == 0:
        return True
    
    else:
        return False

