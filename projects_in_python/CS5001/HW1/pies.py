'''
CS5001
HW1
Xavier Husser
9/16/19
Test Plan:
Test 1
5 pie crust, 5 packs of meat, 40 packs of corn, 13 potatoes
Test 2
8 pie crust, 6 packs of meat, 25 packs of corn, 12 potatoes
Test 3
6 pie crust, 14 packs of meat, 30 packs of corn, 9 potatoes
Test 4
1 pie crust, 3 packs of meat, 5 packs of corn, 7 potatoes
Test 5
0 pie crust, 15 packs of meat, 10 packs of corn, 3 potatoes
'''
#
def main():
    #gather user information
    crust_num = int(input('How many crust do you have? '))
    meat = int(input('How many packs of meat do you have? '))
    corn = int(input('How many packs of corn do you have? '))
    potatoes = int(input('How many packs of potatoes do you have? '))

    #calculating required ingredients for a pie
    crust_baked = crust_num // 1
    meat_baked = meat // 2
    corn_baked = corn // 1
    potatoes_baked = potatoes // 6

    #calculating number of pies made with the mininum ingredients available  
    pies_made = min(crust_baked, meat_baked, corn_baked, potatoes_baked)
    print('Kiki made ' + str(pies_made), 'shepherds pies for the NSKS')
    print('You and your friends donate the leftover ingredients to the student program.')
    print('Leftover: ')
    print(str(crust_num - pies_made), 'crust(s)')
    #pies_made multiplied by packs of meat required 
    print(str(meat - (pies_made * 2)), 'meat pack(s)')
    print(str(corn - pies_made), 'corn pack(s)')
    #pies_made multiplied by packs of potatoes required 
    print(str(potatoes - (pies_made * 6)), 'potato(es)')     
main()
            
    
