"""
    CS5001
    Fall 2019
    HW 4 
    Starter code -- This is a driver for getting
    directions out of the mbta module.

    This program makes several calls to functions you"ll define
    in a module named mbta.py. Names, parameters, and return types
    can be inferred from the code below and are also described
    in the HW spec.

    Simplifications compared to actual T directions:
      * red line only, ashmont branch only
      * unforgiving station-name matches (case must match,
        and abbreviations too, as in Park St)
      
    Test cases for the whole program (you"ll still need to test your
    individual functions as well):
      * Input: Shawmut to Fields Corner. Output: 1 stop, towards Alewife
      * Input: Kendall to Savin Hill. Output: 8 stops, towards Ashmont
      * Input: Alewife to Davis. Output: 1 stop, towards Ashmont
      * Input: Broadway to Charles/MGH. Output: 4 stops, towards Alewife
      * Input: Ashmont to Alewife. Output: 16 stops, towards Alewife
      * Input: Porter to Porter. Output: I can't help you

"""

import mbta

def main():
    
    # Gather and validate input (user provides names of start/end stations)
    # Assumption: User is not transferring
    start_station = input("Enter a starting T station\n")
    while not mbta.is_valid_station(start_station):
        start_station = input("I've never heard of that station, "
                              "please enter again\n")
        
    end_station = input("Enter your destination T station\n")
    while not mbta.is_valid_station(end_station):
        end_station = input("I've never heard of that station, "
                            "please enter again\n")
    
    # Figure out the direction to go on that line (final station
    # in the direction from start to end)
    direction = mbta.get_direction(start_station, end_station)
    num_stops = mbta.get_num_stops(start_station, end_station)

    # Report the result, assuming we"re actually going somewhere
    if num_stops == 0:
        print(start_station, " to ", end_station, "? "
              "I can't help you with that one!", sep = "")
    else:
        print("Get on at ", start_station, " toward ", direction, ".\n"
              "Take the train for ", num_stops, " stops and arrive at ",
              end_station, ".", sep = "")
        
main()
