'''
    Xavier Husser
    CS5001
    Fall 2019
    10/12/19

    
    This program serves as the function driver for kmeans from the
    kmeans_viz file and imports functions to assign and draw clusters
    of centroids. The distance formula calculates the Euclidean distance
    between two points and returns the distance. To find the shortest distance
    between centroidss the distance function is called and the value is
    appended to a distance list. If the shortest distance is the same as the
    mininum of the distance list then the value of the index is appended to
    the closest centroid list and the index list appends that value.

    The main function assigns values to the four centroids then iterates
    the DATA list to assign centroids and append indices to a centroid list.
    Once the draw functions are called the turtle goes to drawing the
    assigned centroids.
    
'''

import random
import math
from kmeans_viz import draw_centroids
from kmeans_viz import draw_assignment

DATA = [ [-32.97, -21.06], [9.01, -31.63], [-20.35, 28.73], [-0.18, 26.73],
 [-25.05, -9.56], [-0.13, 23.83], [19.88, -18.32], [17.49, -14.09],
 [17.85, 27.17], [-30.94, -8.85], [4.81, 42.22], [-4.59, 11.18],
 [9.96, -35.64], [24.72, -11.39], [14.44, -43.31], [-10.49, 33.55],
 [4.24, 31.54], [-27.12, -17.34], [25.24, -12.61], [20.26, -4.7],
 [-16.4, -19.22], [-15.31, -7.65], [-26.61, -20.31], [15.22, -30.33],
 [-29.3, -12.42], [-50.24, -21.18], [-32.67, -13.11], [-30.47, -17.6],
 [-23.25, -6.72], [23.08, -9.34], [-25.44, -6.09], [-37.91, -4.55],
 [0.14, 34.76], [7.93, 49.21], [-6.76, 12.14], [-19.13, -2.24],
 [12.65, -7.23], [11.25, 25.98], [-9.03, 22.77], [9.29, -26.2],
 [15.83, -1.45], [-22.98, -27.37], [-25.12, -23.35], [21.12, -26.68],
 [20.39, -24.66], [26.69, -28.45], [-45.42, -25.22], [-8.37, -21.09],
 [11.52, -16.15], [7.43, -32.89], [-31.94, -11.86], [14.48, -10.08],
 [0.63, -20.52], [9.86, 13.79], [-28.87, -17.15], [-29.67, -22.44],
 [-20.94, -22.59], [11.85, -9.23], [30.86, -21.06], [-3.8, 22.54],
 [-5.84, 21.71], [-7.01, 23.65], [22.5, -11.17], [-25.71, -14.13],
 [-32.62, -15.93], [-7.27, 12.77], [26.57, -13.77], [9.94, 26.95],
 [-22.45, -23.18], [-34.7, -5.62], [29.53, -22.88], [0.7, 31.02],
 [-22.52, -10.02], [-23.36, -14.54], [-19.44, -12.94], [-0.5, 23.36],
 [-45.27, -19.8], [8.95, 13.63], [47.16, -14.46], [5.57, 4.85],
 [-19.03, -25.41], [28.16, -13.86], [-15.42, -14.68], [10.19, -25.08],
 [0.44, 23.65], [-20.71, -20.94], [35.91, -20.07], [42.81, -21.88],
 [5.1, 9.33], [-15.8, -18.47], [5.39, -26.82], [-40.53, -17.16],
 [-29.54, 23.72], [7.8, 23.4], [-22.19, -27.76], [-23.48, -25.01],
 [-21.2, -21.74], [23.14, -24.14], [-28.13, -13.04], [-24.38, -6.79] ]

COLORS = ['green', 'blue', 'red', 'orange']

def distance(point1, point2):
    #calculate distance of two points
    centroids = []
    x1 = point1[0]
    y1 = point1[1]
    x2 = point2[0]
    y2 = point2[1]
    

    dist = math.sqrt((x2 -x1)**2 + (y2 - y1)**2)
    return dist
    

    
    

def assigning_centroids(point,centroids):
    #create lists for distance, closests centroids, and indices
    #assign centroid value to index from DATA list
    closest_centroid = -1
    distance_list = []
    for i in centroids:
        index_list = []
        shortest = distance(point, i)
        distance_list.append(shortest)
        if shortest == min(distance_list):
            closest_centroid = centroids.index(i)
        index_list.append(DATA.index(point))
        index_list.append(closest_centroid)
    return index_list
        

            


def main():
    centroid_list =[]
    #len(DATA) has to be subtracted by 1 to stay within range
    #random 2 - random 4 need to be differiated from random 1's value
    random1 = random.randint(0, (len(DATA)-1)//4)
    random2 = random.randint((len(DATA)-1)//4 + 1, (len(DATA)-1)//2)
    random3 = random.randint((len(DATA)-1)//2 + 1, (3*(len(DATA)-1))//4)
    random4 = random.randint((3*(len(DATA)-1))//4 + 1, (len(DATA)-1))

    centroid1 = DATA[random1]
    centroid2 = DATA[random2]
    centroid3 = DATA[random3]
    centroid4 = DATA[random4]

    centroids =[centroid1, centroid2, centroid3, centroid4] 
    
    
    for i in DATA:
        index = assigning_centroids(i,centroids)
        centroid_list.append(index)

    draw_centroids(centroids, COLORS)
    draw_assignment(centroids, DATA, centroid_list, COLORS)


main()
        
    
    
    
