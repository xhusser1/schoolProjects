'''
Xavier Husser
CS5001
Fall 2019
9/22/2019
'''


def absolute(num):
    '''For positive numbers (float or int) the function returns
       the same value. However if the number is negative
       then that number is multiplied by -1 to get a positive
       value which is returned as the absolute value. 
    '''
    if num < 0:
        num =(-1 * num)
    return num


def manhattan(x1, y1, x2, y2):
    #taking the absolute value of the difference between x and y coordinates
    #return stores the actual distance when combining the differecne of x and y
    distance = absolute(x2 - x1) + absolute(y2 - y1)

    return(distance)

#constant variables for def euclidean fucntion    
square_root = 0.5
second_power = 2

def euclidean(x1, y1, x2, y2):
    '''Once the absolute function calculates the difference of x and y,
       those numbers are raised to the second power
       and added together in the manhattan function to get the distance.
       Because the distance is sqaured it is raised to the 1/2 power 
       to take the square root to get the euclidean value.   
    '''

    euclidean_dist = ((((absolute(x2 - x1)**second_power)) + ((absolute(y2 - y1)**second_power)))**square_root)

    return(euclidean_dist)
    
    


