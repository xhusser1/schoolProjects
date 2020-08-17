'''
    CS 5001 HW 2 part 1: Using Functions
    Haversine function for "air miles" distance (nautical miles)
    Calculates distance over large area when given a spherical element
    (like the earth)
    Python implementation obtained from:
    https://stackoverflow.com/questions/
             4913349/haversine-formula-in-python-bearing-and-distance-between-
             two-gps-points/4913653#4913653
    Note: this is open-source code. it does not conform to ALIGN style
    but it's representative of some of the stuff you'll see in the "real world"
'''

from math import radians, cos, sin, asin, sqrt

def haversine(lat1, lon1, lat2, lon2):
    '''
    Function: haversine
    Parameters: two latitude/longitude pairs representing locations
                on a sphere
    Returns: The haversine distance between the two points
    '''

    R = 3959.87433 # this is in miles.  For Earth radius in kilometers use 6372.8 km

    dLat = radians(lat2 - lat1)
    dLon = radians(lon2 - lon1)
    lat1 = radians(lat1)
    lat2 = radians(lat2)

    a = sin(dLat/2)**2 + cos(lat1)*cos(lat2)*sin(dLon/2)**2
    c = 2*asin(sqrt(a))

    return R * c
