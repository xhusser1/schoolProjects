'''
    Xavier Husser
    CS5001
    Fall 2019
    10/26/19
'''
import hanoi_viz

TOWERS = ['Naruto', 'Sasuke', 'Sakura']


def move_tower(disk_num, source, target, aux, TOWERS):
    '''function move towers
       parameters: number of disks, names of source, target, temp towers,
                   along  with list of Simpsons characters
       returns: nothing

       does: checks if the number of disks is greater than or equal to one
             and moves n - 1 disks from source tower Homer to temp home Bart.
             We call move_disk from hanoi_viz to move disks from source to
             target using dictionary key towers. The final move towers is to 
             move the n - 1 disks from the temp tower of Bart to our target
             tower of Marge 
    '''
    if disk_num >= 1:
        move_tower(disk_num - 1, source, aux, target, TOWERS)
        hanoi_viz.move_disk(source, target, TOWERS)
        move_tower(disk_num - 1, aux, target, source, TOWERS)

def main():
    '''function main
       parameter: none
       returns: nothing
       does: asks user to enter number of disks and checks conditionals
             of if they enter anything other than 1-8 to print again.
             Once they enter a correct value we use initialize tower
             function to return towers dictionary so we can utilize the
             global variable TOWERS
             move towers uses the value of towers dictionary to create and
             print towers then breaks
    '''
    while True:
        #try except to accept when user doesn't enter integer and reprompts them 
        try:
            user_input = int(input("Enter a number between 1-8 for disks? "))
            if user_input < 1:
                print("Ay Caramba!can't move disk from empty tower")
                continue
            elif user_input > 8:
                print("Ay Caramba!Please enter a number between 1-8")
                continue
        except ValueError:
            print("Ay Caramba!, please try again")
            continue           
        else:
            initialize = hanoi_viz.initialize_towers(user_input, TOWERS[0], TOWERS[1], TOWERS[2])
            movement = move_tower(user_input, TOWERS[0], TOWERS[1], TOWERS[2],
                                                                   initialize)
            break




main()



