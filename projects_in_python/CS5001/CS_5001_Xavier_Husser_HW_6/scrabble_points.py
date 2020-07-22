'''
Xavier Husser
CS 5001
11/18/19
Fall 2019
'''
from wordlist import get_wordlist
import random

LETTER_POINT_VALUE = {"A": 1, "B": 3, "C": 3, "D": 2, "E": 1, "F": 4,
                      "G": 2, "H": 4, "I": 1, "J": 8, "K": 5, "L": 1,
                      "M": 3, "N": 1, "O": 1, "P": 3, "Q": 10, "R": 1,
                      "S": 1, "T": 1, "U": 1, "V": 4, "W": 4, "X": 8,
                      "Y": 4, "Z": 10 }

FREQ_LETTER = {"A": 9, "B": 2, "C": 2, "D": 4, "E": 12, "F": 2, "G": 3,
               "H": 2, "I": 9, "J": 1, "K": 1, "L": 4, "M": 2, "N": 6,
               "O": 8, "P": 2, "Q": 1, "R": 6, "S": 4, "T": 6, "U": 4,
               "V": 2, "W": 2, "X": 1, "Y": 2, "Z": 1, "_": 2}
def scrabble_menu(message, options = '1234'):
    '''Function: scrabble menu
       Input: user input with the options in menu
       returns: Boolean expression
       Does: convert input to uppercase and compare it to options
    '''
    answer = input(message)
    answer = answer.upper()
    if(answer[0] in options.upper()):
        return answer, True
    return answer, False

def bag_of_letters(FREQ_LETTER):
    '''Function: bag of letters
       Input: Frequency letter dictionary
       returns: a list of letters
       Does: iterate through the dictionary to append key in list
    '''
    lst_of_letters = []
    for key, value in FREQ_LETTER.items():
        b = [key, value]
        for i in range(value):
            lst_of_letters.append(key)
    lst_of_letters
    return lst_of_letters

def draw_letters(lst_of_letters):
    '''Function: draw letters
       Input: list of letters
       returns: a list of random letters for user to play
    '''
    random_letters = random.sample(lst_of_letters, 7)
    for i in range(len(random_letters)):
        lst_of_letters.remove(random_letters[i])
    return random_letters

def is_valid_word(word, wordlist, used_words, hand):
    '''Function: is valid word
       Input: user input, list of words, used word dictionary, draw 
       returns: Boolean expression
       Does: check if word is in the text file, been played, and is valid
    '''
    if word.upper() in wordlist:
        if word.upper() not in used_words:
            for each in word.upper():
                if each not in hand:
                    if '_' not in hand:
                        return False
            return True

    return False
                    
                

def get_word_value(word, LETTER_POINT_VALUE):
    '''Function: get word value
       Input: user input word, letter point constant
       returns: the point value of generated word
       Does: iterate each element of the word and check value in dictionary
    '''
    word_value = 0
    for each in word:
        if each.upper() in LETTER_POINT_VALUE:
            word_value += LETTER_POINT_VALUE[each.upper()]
    return word_value
            

