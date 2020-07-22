from bulls_n_cows import*
TEST_GUESSES = [[1,2, 3, 4], [5, 2, 3, 4], [7, 6, 5, 4], [0, 9, 8, 5],
                [2, 4, 6, 8], [1, 3, 5, 7], [1, 2, 0, 9] ]

TEST_SECRET = [[1,9,8, 7],[2,4,6, 7], [1,2,0, 9],[7,6,5, 4]]


def test_count_bulls_and_cows():
    ''' Function test_count_bulls_and_cows
        Input: None.
        Returns: Number of failing test conditions for cow/bull sequences
        Do: Test various cow/bull sequences to ensure those counters
            are working as expected. Key cases:0 cows, 0 bulls;
            4 cows, 0 bulls; 4 bulls, 0 cows, 2 cows, 2 bulls
    '''
    num_failed = 0
    test_bulls, test_cows = count_bulls_and_cows([1, 2, 3, 4], [0, 5, 8, 9])
    if test_bulls == 0 and test_cows == 0:
        print('SUCCESS! \n')
    else:
        print('FAIL \n')
        num_failed += 1
    test_bulls, test_cows = count_bulls_and_cows([1, 2, 3, 4], [4, 3, 2, 1])
    if test_bulls == 0 and test_cows == 4:
        print('SUCCESS! \n')
    else:
        print('FAIL \n')
        num_failed += 1
    test_bulls, test_cows = count_bulls_and_cows([1, 2, 3, 4], [1, 2, 3, 4])
    if test_bulls == 4 and test_cows == 0:
        print('SUCCESS! \n')
    else:
        print('FAIL \n')
        num_failed += 1
    test_bulls, test_cows = count_bulls_and_cows([1, 2, 3, 4], [1, 2, 4, 3])
    if test_bulls == 2 and test_cows == 2:
        print('SUCCESS! \n')
    else:
        print('FAIL \n')
        num_failed += 1
    return num_failed
        
def auto_play_game(secret_code, guess_book):
    ''' Function auto_play_game
        Input:  secret_code (list of digits),
                guess_book (dictionary of guess history)
        Returns: True if auto-player a winner; False otherwise
        Do: Automate the playing of Bulls and Cows for regression
        testing. Instead of using interactive input from stdin, this
        function uses test data fed directly to the function to simulate
        an entire "systems test" and complete game flow
        Concept: instead of guess = input(...), now using
        guess = TEST_GUESSES[i]
    '''
    count = 1
    while count < 7:
        print("guess: " + str(count))
        guess = TEST_GUESSES[count]
        num_bulls, num_cows = count_bulls_and_cows(secret_code, guess)
        guess_book = create_dictionary(num_bulls, num_cows, guess, count)
        count += 1
        for key, value in guess_book.items():
            print("Your guess history:\n", key, 'is', value)
        if num_bulls == len(guess):
            print("Auto-player is a winner")
            return True
        elif num_bulls != 4 and count == 7:
            print("Auto-player lost (this time human)")
    return False

def test_regression_bull_cow(secret_code):
    ''' Function test_regression_bull_cow
        Input: secret_code: secret to test with (the one we're "cracking").
        Returns: None
        Do: Automatically exercise and test the entire bulls n cows system
        by calling auto_play_game() multiple times with both "winning" and
        "losing" data. Printed output can then be "diff'd" and examined either
        manually or automatically via tool support

        Example: code is our test data, and autoplay instead of interactive
        secret_code = TEST_SECRET[0]
        guess_book = create_guessbook(7)
        result = auto_play_game(secret_code, guess_book)
    '''
    for i in range(len(TEST_SECRET)):
        secret_code = TEST_SECRET[i]
        guess = TEST_GUESSES[0]
        num_bulls, num_cows = count_bulls_and_cows(secret_code, guess)
        count = 0
        guess_book = create_dictionary(num_bulls, num_cows, guess, count)
        result = auto_play_game(secret_code, guess_book)
    
        
    
def main():
    print('Beginning test suite. Testing count bulls and cows...')
    fails = test_count_bulls_and_cows()
    if fails > 0:
        print('Something went wrong. Pls go back and fix errors')
    else:
        print('Counting Bulls and Cows Passed All Tests')
    print('Beginning Auto Play Regression Tests')
    test_regression_bull_cow(TEST_SECRET[0])

main()
