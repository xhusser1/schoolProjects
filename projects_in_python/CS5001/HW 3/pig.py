'''
Xavier Husser
10/2/19
CS5001
Fall 2019
'''
import random
MAXSCORE = 20

def roll_dice():
    #producing a randomized dice roll
    dice_roll = random.randint(1,6)
    return dice_roll


def takeTurn(player):
    player_score = 0
    keep_rolling = 1
    
    while keep_rolling == 1:
        #game loop to prompt input, roll dice, and give score
        choice = input('It is your turn, '+ str(player) + '\n' + 'R - Roll\n' +
                'H - Hold\n' + '\n'+ 'Enter your choice\n').upper()
        if choice == 'R':
            dice_value = roll_dice()
            if dice_value > 1:
                #assign player score from dice roll and keep tally
                player_score += dice_value
                print('You rolled a ', dice_value)
                print('You got ' + str(player_score) + ' that round!')
                continue
                
            elif dice_value == 1:
                player_score = 0
                print('You rolled a ', dice_value)
                print('Oink Oink you pigged out')
                keep_rolling == 0 
                break
                
        elif choice == 'H':
            #print score then break to end player's round
            print('Your score is', player_score)
            break
        
        elif choice == 'Q':
            player_score = MAXSCORE + 1
            print('Oink Thanks for playing')
            return player_score
             
        else:
            keep_rolling = 0
            print('Invalid response, please choose again')
    return player_score
            

def main():
    #main loop where players take turns choosing options in game loop above
    player_1 = 0
    player_2 = 0
    while player_1 < MAXSCORE and player_2 < MAXSCORE:
        #start player_1's round
        dice_roll = takeTurn('Human One')
        if dice_roll:
            player_1 += dice_roll
            print('Human One points are: ' + str(player_1))
        if player_1 >= MAXSCORE:
            print('Human One wins')
            return
        #start player_2's round
        dice_roll = takeTurn('Human Two')
        if dice_roll:
            player_2 += dice_roll
            print('Human Two points are: ' + str(player_2))
        if player_2 >= MAXSCORE:
            print('Human Two wins')
            return

              
main()

            
        
                 

           
                
                
                
                        
