'''
    Xavier Husser
    CS5001
    Fall 2019
    HW2 Starter Code
    This is testing code to make sure the manhattan distance
    function works as expected. We start with an EPSILON value,
    which helps us approximate that two floats are equal.

    The absolute function must be defined and working for this test code to
    work correctly.

    We test a few different inputs and compare the actual output
    to an expected output for each one. We count the number of failed
    tests and report the details of each one.
'''
from distance import absolute
from distance import manhattan

EPSILON = .0001

def test_manhattan():
    ''' function: test_manhattan
        Input: none
        Returns: int, # of tests that failed
        Does: tests a few different inputs on the manhattan
              distance function, makes sure each distance value
              is as-expected.
    '''

    num_failed = 0

    # Test 1: (20, 15), (25, 30)
    # Distance should be 20
    actual = manhattan(20, 15, 25, 30)
    expected = 20
    print('Input (20, 15), (25, 30).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1
    
    # Test 2: (20, 15), (25, 32).
    # Distance is 22.32
    actual = manhattan(20.90, 15, 25.25, 32.97)
    expected = 22.32
    print('Input (20.90, 15), (25.25, 32.97).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1


    # Test 3: (-5.3, 4.8), (-14, 0.7)
    # Distance is 12.8
    actual = manhattan(-5.3, 4.8, -14, 0.7)
    expected = 12.8
    print('Input (-5.3, 4.8), (-14, 0.7).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1

    # Test 4: (7.9, 5), (-17.2, 3)
    # Distance is 27.1
    actual = manhattan(7.9, 5, -17.2, 3)
    expected = 27.1
    print('Input (7.9, 5), (-17.2, 3).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :(\n')
        num_failed += 1

    return num_failed
    
def main():
    num_fail = test_manhattan()
    if num_fail == 0:
        print('ALL TESTS PASSED!')
    else:
        print('Sorry', num_fail, 'tests failed. Please go back and fix.')

main()

