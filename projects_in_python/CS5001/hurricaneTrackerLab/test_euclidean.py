'''
    CS5001
    Fall 2019
    HW2 Starter Code
    This is testing code to make sure the Euclidean distance
    function works as expected. We start with an EPSILON value,
    which helps us approximate that two floats are equal. (Fun fact:
    x == y doesn't work if x and y are floats, because of how they
    get stored in memory. Be careful not to use it!)

    The absolute function must be defined and working for this test code to
    work correctly.

    We test a few different inputs and compare the actual output
    to an expected output for each one. We count the number of failed
    tests and report the details of each one.
'''

from distance import absolute
from distance import euclidean

EPSILON = .0001

def test_euclidean():
    ''' function test_euclidean
        Input: none
        Returns: int, # of tests that failed
        Does: tests a few different inputs on the euclidean
              distance function, makes sure each distance value
              is as-expected.
    '''
        
    num_failed = 0

    # Test 1: (0, 0), (0, 0)
    # Distance should be 0
    actual = euclidean(0, 0, 0, 0)
    expected = 0.0
    print('Input (0, 0), (0, 0).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1
    
    # Test 2: (2, -1), (-2, 2).
    # Distance is 5.0
    actual = euclidean(2, -1, -2, 2)
    expected = 5.0
    print('Input (2, -1), (-2, 2).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1


    # Test 3: (1, 1), (0, 1)
    # Distance is 1.0
    actual = euclidean(1, 1, 0, 1)
    expected = 1.0
    print('Input (1, 1), (0, 1).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :( \n')
        num_failed += 1

    # Test 4: (-5.2, 3.8), (-13.4, 0.2)
    # Distance is 8.955445
    actual = euclidean(-5.2, 3.8, -13.4, 0.2)
    expected = 8.955445
    print('Input (-5.2, 3.8), (-13.4, 0.2).\n'
          'Expected result', expected,
          'and actual result =', actual)
    if absolute(actual - expected) < EPSILON:
        print('SUCCESS!\n')
    else:
        print('FAIL :(\n')
        num_failed += 1

    return num_failed
    
def main():
    num_fail = test_euclidean()
    if num_fail == 0:
        print('ALL TESTS PASSED!')
    else:
        print('Sorry', num_fail, 'tests failed. Please go back and fix.')

main()
