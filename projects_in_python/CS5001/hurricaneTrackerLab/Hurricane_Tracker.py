'''
Xavier Husser
CS5001
Fall 2019
9/22/2019
Test Plan:
Test Case 1(Boston):
Output will be 1133.06 nautical miles
Test Case 2 (Miami):
Output will be 144.4 nautical miles
Test Case 3 (Grand Bahamas Island):
Output will be 31.35 nautical miles
'''
from Haversine_Function import haversine

B = "Boston"
M = "Miami"
Boston_Lat = 42.361145
Boston_Lon = -71.057083
Miami_Lat = 25.761681
Miami_Lon = -80.191788
#latitude for Hurricane Dorian
latitude1 = 27.1
#longitude for Hurricane Dorian
longitude1 = -78.4


def main():

    print("Welcome to the hurricane tracker and warning system!")
    
    location = input("Enter the location to appply our radar:\n" +
                     "B for Boston\n" + "M for Miami\n" +
                     "O for another location of your choice\n" +
                     "B, M, or O? ").upper()

    if location == "B":
        latitude2 = Boston_Lat
        longitude2 = Boston_Lon
        #The haversine distance between Boston and Hurricane Dorian
        distance = haversine(latitude1, longitude1, latitude2, longitude2)
        print("Hurricane Dorian was",str(round(distance, 2)), "nautical miles from "
              + str(B), "on 03-Sep-2019")
        print("Boston was not in the hurricane zone.")
        
    elif location == "M":
        latitude2 = Miami_Lat
        longitude2 = Miami_Lon
        #The haversine distance between Miami and Hurricane Dorian
        distance = haversine(latitude1, longitude1, latitude2, longitude2)
        print("Hurricane Dorian was", str(round(distance, 2)), "nautical miles from "
              + str(M), "on 03-Sep-2019")
        print("Miami was in the hurricane zone! Seek shelter now!")

    else:
       #gather the name, latitude, and longitude of other city
       O_city = input("What is the name of the city? ") 
       latitude2 = float(input("latitude (decimal degrees): "))
       longitude2 = float(input("longitude (decimal degrees): "))
       #The haversine distance between O_city and Hurricane Dorian
       distance = haversine(latitude1, longitude1, latitude2, longitude2)
       print("Hurricane Dorian was", str(round(distance, 2)), "nautical miles from "
              + str(O_city), "on 03-Sep-2019")
       #Condition that only applies if O_city is in hurricane zone
       if distance <= 150:
            print(str(O_city) + " was in the hurricane zone! Seek shelter now!") 

main()
