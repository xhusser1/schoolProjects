'''
Xavier Husser
CS5001
Fall 2019
9/29/19
I created my functions to convert text to morse and morse to text first
then I created refractored menu same as from lecture to store options.
Test Plan:
Test Case 1 Alpha to Morse (hello world!):
Output will be .... . .-.. .-.. --- / .-- --- .-. .-.. -.. -.-.--
Test Case 2 Alpha to Morse (^_^):
Output will be Your message had unknown characters Could not convert it.
Test Case 3 Morse to Alpha(... --- ...):
Output will be SOS
Test Case 4 Morse to Alpha(.. / .-- .- -. - / .--. .. --.. --.. .- -.-.-- -.-.--):
Output will be: I WANT PIZZA!!
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

def text_to_morse(message):
    print("Welcome to the Morse Code Application. We love dots n dashes!\n" +
          "Enter your alphanumeric messages & I'll convert them to Morse\n" +
          "Enter :q: to stop and return to the main menu")
    #empty string that will be used to store morse characters. 
    encode = " "
    while True:
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
                    continue
            return encode

def morse_to_alpha(message):
    print("Welcome to the Morse Code Application. We love dots n dashes!\n" +
          "Enter your morse code & I'll convert them to Alpha-numeric\n" +
          "Enter :q: to stop and return to the main menu")
   
    while True:
        #empty string that will be used to store alpha characters.
        decode = ''
        if message == STOP:
            print("Thanks for using our app")
            break
        else:
            #flag everything as false and split up individual morse characters
            #traverse lookup table to find morse character in CL[0][1]
            #swap morse character for alpha-numeric character
            morse_list = message.split()
            for letter in morse_list:
                flag = False
                for i in range(len(CODE_LIST)):
                    if letter == CODE_LIST[i][1]:
                        decode += CODE_LIST[i][0]
                        flag = True

                if flag == False:
                    print("Your message had unknown characters " +
                          "Could not convert it.")
                    break
            return decode
 
def menu(message, options = '123'):
    
    #options = 'ABC'
    answer = input(message)
    answer = answer.upper()#convert to uppercase for comparison
    if(answer[0] in options.upper()):#compare first letter if they enter more
        return answer, True
    return answer, False

def morse_code():
    while True:
        
        print("Welcome to the Morse Code Application. We love dots n dashes!\n")
        question =("Choose:\n" + "A: Alpha to Morse Coverter\n" +
                   "B: Morse to Alpha Converter\n" + "Q: Quit\n")
        
        answer, success = menu(question, "ABQ")
        print("You selected: ", answer)
        
        if answer == 'A':
            text = input("Insert a space between signals and / between words\n"+
              "Enter morse messages & I'll convert them to alpha-numeric\n"+
              "Enter :q: to stop and return to the main menu\n")
            translate = text_to_morse(text)

        elif answer == 'B':
            text = input("Insert a space between signals and / between words\n"+
              "Enter morse messages & I'll convert them to alpha-numeric\n"+
              "Enter :q: to stop and return to the main menu\n")
            translate = morse_to_alpha(text)

        elif answer == 'Q':
            print("--Thanks for using our app--")
            print("- .... .- -. -.- ... / ..-. --- .-. / ..- ... .. -. --.\n" +
                  "/ --- ..- .-. / .- .--. .--.") 
            break
            
        else:
            print("Sorry not valid response, make another selection.")    

morse_code()
