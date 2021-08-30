'''
Xavier Husser
CS5001
Fall 2019
9/29/19
This is the test file of part 1. Part 2 is called Morse_code.py
where I refine this code and convert from morse back to alpha
Test Plan:
Test Case 1 (hello world!):
Output will be .... . .-.. .-.. --- / .-- --- .-. .-.. -.. -.-.--
Test Case 2 (Apple):
Output will be .- .--. .--. .-.. .
Test Case 3(^_^):
Output will be Your message had unknown characters Could not convert it.
'''
CODE_LIST = [[' ', '/'], ['A', '.-'], ['B', '-...'],
 ['C', '-.-.'], ['D', '-..'], ['E', '.'],
['F', '..-.'], ['G', '--.'], ['H', '....'], ['I', '..'], ['J', '.---'],
['K', '-.-'], ['L', '.-..'], ['M', '--'], ['N', '-.'], ['O', '---'],
['P', '.--.'], ['Q', '--.-'], ['R', '.-.'], ['S', '...'], ['T', '-'],
['U', '..-'], ['V', '...-'], ['W', '.--'], ['X', '-..-'], ['Y', '-.--'],
['Z', '--..'], ['0', '-----'], ['1', '.----'], ['2', '..---'], ['3', '...--'],
['4:', '....-'], ['5', '.....'], ['6', '-....'], ['7', '--...'],
['8', '---..'], ['9', '----.'], ['?', '..--..'], ['!', '-.-.--'],
['\'', '.----.'], ['"', '.-..-.'], [',', '--..--']]

STOP = ":q:"
def text_to_morse():
    print("Welcome to the Morse Code Application. We love dots n dashes!\n" +
          "Enter your alphanumeric messages & I'll convert them to Morse\n" +
          "Enter :q: to stop and return to the main menu")
    
    while True:
        #empty string that will be used to store morse characters. 
        encode = " "
        message = input("Your message: ")
        if message == STOP:
            print("Thanks for using our app")
            break
        else:
            #flag everything as false and change to uppercase
            #traverse lookup table to find capital letters in CL[0][0]
            #swap the alpha-numeric character for morse code character
            #separate with space, assign to empty string, and flag true
            for letter in message:
                flag = False
                letter = letter.upper()
                
                for i in range(len(CODE_LIST)):
                    if letter == CODE_LIST[i][0]:
                        encode += CODE_LIST[i][1] + " "
                        flag = True

                if flag == False:
                    print("Your message had unknown characters " +
                          "Could not convert it.")
                    break
        print("Original message: ", message)
        print("Translated message:", encode)

text_to_morse()
                

    

    
