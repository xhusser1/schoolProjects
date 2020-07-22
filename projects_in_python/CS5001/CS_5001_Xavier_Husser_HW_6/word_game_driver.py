'''
Xavier Husser
CS5001
Fall 2019
11/19/2019
'''
from wordlist import get_wordlist
from scrabble_points import*


def get_input():
    inp = input('Please enter a word to play ').upper()
    return inp
def menu(inp, options = '1234'):
    answer = input(inp)
    answer = answer.upper()
    if(answer[0] in options.upper()):
        return answer, True
    return answer, False
    
def main():
    my_word_list = get_wordlist()
    used_words = {}
    while True:
        score = 0
        my_bag = bag_of_letters(FREQ_LETTER)
        question  = ("Choose:\n" + "D: Draw\n" + "W: Make word\n"
                     + "P: Print\n" + "Q: Quit\n")
        answer, success = menu(question, "DWPQ")
        print("You selected: ", answer)

        if answer == 'D':
            draw = draw_letters(my_bag)
            print(draw)

        elif answer == 'W':
            user_int = get_input()
            validity = is_valid_word(user_int, my_word_list, used_words, draw)
            if validity:
                word_points = get_word_value(user_int, LETTER_POINT_VALUE)
                score += word_points
                used_words[user_int] = score
                redraw = draw_letters(my_bag)
                print(user_int + ' is a valid word ' + str(word_points) +
                      ' points')

        elif answer == 'P':
            for key, value in used_words.items():
                print('You have a total of', value, 'so far.' + '\n' +
                      key, ' -- ', value, ' points')
        elif answer == 'Q':
            print ("Thanks for playing")
            break
        else:
            print("Sorry not a valid response,  make another selection.")
    
    
main()
