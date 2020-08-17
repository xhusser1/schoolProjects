'''
    Xavier Husser
    CS5001
    Fall 2019
    HW2 Starter Code
    This is testing code to make sure the absolute
    function works as expected. We start with an EPSILON value,
    which helps us approximate that two floats are equal.

    The absolute function must be defined and working for this test code to
    work correctly.

    We test a few different inputs and compare the actual output
    to an expected output for each one. We count the number of failed
    tests and report the details of each one.
'''
from distance import absolute

EPSILON = .0001

def test_absolute():
    ''' function test_absolute
        Input: none
        Returns: int, # of tests that failed
        Does: tests a few different inputs on the absolute function,
        makes sure each value is as-expected.
    '''

    num_failed = 0
    #Test 1: -5
    #Absolute value should be 5
    actual = absolute(-5)
    expected = 5
    print('Input (-5).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1
        
    #Test 2: 3.95
    #Absolute value should be 3.95
    actual = absolute(3.95)
    expected = 3.95
    print('Input (3.95).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1
        
    #Test 3: 0
    #Absolute value should be 0
    actual = absolute(0)
    expected = 0
    print('Input (0).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1
        
    #Test 4: -45.45
    #Absolute value should be -45.45
    actual = absolute(-45.45)
    expected = 45.45
    print('Input (-45.45).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1

    return num_failed

def main():
    num_fail = test_absolute()
    if num_fail == 0:
        print('ALL TESTS PASSED!')
    else:
        print('Sorry', num_fail, 'tests failed. Please go back and fix.')

main()
        
