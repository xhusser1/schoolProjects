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

RED_LINE = ["Ashmont", "Shawmut", "Fields Corner", "Savin Hill", "JFK/UMass",
 "Andrew", "Broadway", "South Station", "Downtown Crossing",
 "Park St", "Charles/MGH", "Kendall", "Central", "Harvard",
 "Porter", "Davis", "Alewife"]

#To do:Red_LINE [i].upper in all function
#To do: string slices
def is_valid_station(station):
    for i in RED_LINE:
        if station.upper() == i.upper():
            return True
    return False

def get_direction(start, end):
    valid_start_station = is_valid_station(start) 
    valid_end_station = is_valid_station(end)
    if valid_start_station and valid_end_station:
        #run loop to find direction
        for i in RED_LINE:
            if start.upper() == i.upper():
                return "Alewife"
            
            if end.upper() == i.upper():
                return "Ashmont"
    
    elif start == end:
        return "no destination found"
        
    else: 
        return "no destination found"
        
def get_num_stops(start, end):
    valid_start_station = is_valid_station(start) 
    valid_end_station = is_valid_station(end)
    if valid_start_station and valid_end_station:
        #run loop to find direction
        for i in range(len(RED_LINE)):
            if start.upper() == RED_LINE[i].upper():
                start_point = i 
            
            if end.upper() == RED_LINE[i].upper():
                end_point = i
        return abs(end_point - start_point)
            
    
    elif start == end:
        return 0 
        
    else: 
        return 0
     
     
         
         
