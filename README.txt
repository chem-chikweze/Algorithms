/* 
* Sung Beom Park & Jim Chaffer
* 30602601 & 30642485
* Project 3
* MW 3:25 - 4:40 Hark 114
* Lab TA: Dominick Harasimiuk
*/

Open CSC172_Project_4 -> src -> default package -> Main.java
- Run the program
- Enter the file path. I have included the 3 different map txt files in the file, so simply find the location and path of the file and enter it in.
- Enter the starting location. 
   -> For UR,text: Starting and Ending location will be building names : ex: 	SUEB 
	LECHASE
   -> For Monroe and NYS: Starting and Ending location will be i (something).
	ex: i70000
	    i42000
- The program will let you know all the path it took to get to the destination using Dijkstra's shortest path algorithm.
- It will also let you know the total distance it took from starting and ending location. 

Dijkstra's algorithm came in very handy when finding the shortest path from one node to another. In addition, using StringTokenizer helped a lot when taking in different lines of data that are distinguished by Intersection and Road. 

Haversine's Formula was also used for determining the actual length/distance between the starting and the ending points. Check the comments on the code to see more detail and how it was used and implemented. 

The overall runtime of drawing the actual Graph will be Big O (n), because it does not use nested loops. But, it does use a loop to mark the path in color, so that may add some constants to n, but it will still be O (n).

When using Dijkstra's algorithm, the runtime for the for loop that iterates over the edges would be Big O (E). Priority Queue operations (from Dijkstra) will take Big O (log E).Building the actual table of vertices to the graph will take Big O (V). Combining the above, the total runtime would result in Big O (V+ElogE).

Included with this README are 6 different files: Draw.java, Edge.java, Edge2.java, Graph.java, Main.java, and Node.java
In addition, 3 different txt files of the map are also included: ur.txt, monroe.txt, nys.txt
And, OUTPUT is also included to show the output of the program. 

