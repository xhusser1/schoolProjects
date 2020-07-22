'''
    Xavier Husser
    CS5001
    Fall 2019
    10/26/19
'''
import random

GUESS_BOOK = {}

def count_bulls_and_cows(secret_code, guess):
    ''' fucntion: count bulls and cows
        parameters: random generated secret code and user guess
        
        returns: number of bulls and number of cows to be used in driver file
        
        does: since the guess in the driver file is a list of integers we
              will iterate through the list to check the value and position
              of i to see if there is a match for a bull or cow in order to
              count the number of bulls or cows in a guess
    '''
    bulls = 0
    cows = 0
    for i in range(0, len(guess)):
        if guess[i] == secret_code[i]:
            bulls += 1
        elif guess[i] in secret_code:
            cows += 1
    print('bulls:' + str(bulls), 'cows:' + str(cows))
    return bulls, cows

def create_dictionary(num_bulls, num_cows, guess, count):
    ''' function create dictionary

        parameters: number of bulls, cows, guesses, and counter
        
        returns: dictionary called guessbook with guess history
        
        does: fills the guessbook dictionary with a dictionary of entries
              that is updated with the values as the bulls and cows game
              runs then returns the game history in the outer dictionary
    '''
    entry = {}
    entry['guess'] = guess
    entry['bulls'] = num_bulls
    entry['cows'] = num_cows
    GUESS_BOOK['guess' + str(count)] = entry
    return GUESS_BOOK

