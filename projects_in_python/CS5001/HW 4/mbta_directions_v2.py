'''
    Xavier Husser
    10/14/19
    CS5001
    Fall 2019

    This program serves as the mbta function that will be imported for testing
    mbta directions. The names, parameters, and return types are described
    in the HW spec. Once the stations have been verified as valid in the first
    iteration of RED_LINE, we check what direction the user is going towards in
    second iteration of RED_LINE, finally we iterate once more to get indices
    of both points and return absolute value of end point - start point.    
'''
import sys
import mbta

def main():
    
    commands = sys.argv
    if len(commands) > 1:
        end_station = sys.argv[2]
        start_station = sys.argv[1]
        

    else:
          
        start_station = input("Enter a starting T station\n")
        while not mbta.is_valid_station(start_station):
            start_station = input("Never heard of that station, "
                                  "please enter again\n")

        end_station = input("Enter your destination T station\n")
        while not mbta.is_valid_station(end_station):
            end_station = input("I've never heard of that station, "
                                "please enter again\n")

    direction = mbta.get_direction(start_station, end_station)
    num_stops = mbta.get_num_stops(start_station, end_station)

    if num_stops == 0:
        print(start_station, " to ", end_station, "?"
              "I can't help you with that one!",  sep = "")
    else:
        print("Get on at ", start_station, " toward ", direction, ".\n"
              "Take the train for ", num_stops, " stops and arrive at ",
              end_station, ".", sep = "")


main()
