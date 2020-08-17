'''
CS5001
Xavier Husser
HW 1
9/16/19
Test Plan:
Test Case #1
 1 book: $14.97 cost, $3.00 shipping, $17.97 total cost
Test Case #2
 5 books: $74.85 cost, $6.00 shipping, $80.85 total cost
Test Case #3
 60 books: $901.20 cost, $47.25 shipping, $945.45 total cost
'''
COST_OF_ONE_BOOK = 24.95
ADDITIONAL_COST = 0.75

def main():
    order_num = int(input('How many copies are you ordering? '))
    #cover cost before wholesale discount and shipping costs
    cover_cost = float(order_num * COST_OF_ONE_BOOK)
    wholesale_cost = float(cover_cost - (cover_cost * 0.40))
    #(order_num * 0.75) calculates additional shipping cost for more than one book
    #subtracting that total  with 0.75 gets rid of the additional $0.75
    shipping_cost = float(3 + ((order_num  * ADDITIONAL_COST)- ADDITIONAL_COST))
    total_cost = wholesale_cost + shipping_cost
    print('The wholesale cost of your books is $' + str(round(wholesale_cost, 2)))
    print('The shipping cost is ${:.2f}'.format(shipping_cost))
    print('Your total cost is $' + str(round(total_cost, 2)))

main()
    
