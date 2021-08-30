import random
from bulls_n_cows import*

''' Xavier Husser
    CS5001
    Fall 2019
    10/31/19
'''
def generate_code():
    ''' function generate secret code
        parameters: none
        returns: secret code for main
        does: generates 4 unique single digit integers to be used
              as the secret code for game
    '''
    code = random.sample(range(9), 4)
    return code


def generate_guess():
    ''' function generate guess
        parameters: none
        returns: A list of integers generated by user input
        does: generates a guess from user that satisfies the conditions
              that input is 4 non-repeating single digit elements
              by converting guess to a list of strings checking the
              length, if there are repeating numbers, single digits,
              then converts the guess into integers and append to list
              of integers.
    '''
    inp = input("Enter a unique guess: ").split(" ")
    flag = False
    while flag == False: 
        #check 1: is input less than or more than 4 characters
        if len(inp) < 4 or len(inp)> 4:
                print("Sorry, digit has to be EXACTLY 4 elements")
        #check 2: does input contain repeating elements
        if len(inp) != len(set(inp)):
             print("Sorry, input has to be unique")
        flag = True
        int_list = []
        for each in inp:
            #check 3: is input a number 
            if not each.isdigit():
                flag = False
                print("Sorry, input has to be 4 digits")
            # check 4: is input a single digit    
            elif each.isdigit() and int(each) > 9:
                flag = False
                print("Sorry, input has to be single digit")
    if flag:     
        for character in inp:
            character = int(character)
            int_list.append(character)
    return int_list
        
    
        
        
def main():
    ''' function: main
        parameters: none
        returns: none
        does: uses the secret_code and guess generated in above functions
              to pass into bulls and cows function. Guessbook calls the
              guessbook dictionary created in bulls and cows function
              which prints out the items in the guess history.
        Test Case 1:
        Secret code = [4, 6, 7, 9]
        Guess = [6, 6, 7, 9]
        Output: Sorry, input has to be unique
        
        Test Case 2:
        Secret code = [1, 2, 3, 4]
        Guess = [1, 2, 3, 4]
        Output: You won, you got the secret code
    '''
    count = 0
    secret_code = generate_code()
    while count < 7:
        count += 1
        print("Guess: " + str(count))
        guess = generate_guess()
        num_bulls, num_cows = count_bulls_and_cows(secret_code, guess)
        guess_book = create_dictionary(num_bulls, num_cows, guess, count)
        for key, value in guess_book.items():
            print("Your guess history:\n", key,'is', value)
        if num_bulls == len(guess):
            print("You won, you got the secret code")
            break
        elif num_bulls != len(guess) and count == 'Guess: 7':
            print("Sorry, you lost. The code was: " + str(secret_code))
    


main()