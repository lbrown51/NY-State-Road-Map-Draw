NY State Road Map Draw

Contact Info : Lenny
Class : Project 4

Description:
Ah yes, the final project. How time has flown, am I right?! This wasn't easy, mind you. I'm sure you and I both know that I've had trouble with projects in the past. This one is different though. I PUT THE TIME IN. Ok, down to business. When I first started, like many of my naive brethren, I attempted to use the adjecency matrix we had been led to use for earlier labs. For the New York State file, this would create an array of roughly 7.6 billion items. Naturally my computer was unable to render those items sufficiently and as such a different methodology for storing the information was required after attempting multiple different structural setups I found the following to be the best for my requirments. First I held each vertex in a single arraylist. Then each vertex had a copy of all intersecting vertexs. For dijkstra's algorithm, I at first attempted to create my own from scratch, but I ended up using a modded version of the books. For Kruskal's, which I used to find the MWST, I used the books and first, but changed to my own version of it after mistakenly believing that it didn't work. This version more closely resembles the building of tree. It even has references to the head node as nodes....I'm not sure that made sense. blargh. With this setup the larger maps become usable. The New  York one does take slightly longer than 10 seconds to load, but implements the MWST super quickly making up for the starting slowness. As for the runtime, probably 30 seconds tops.....joking. Displaying / generating the graph is done in O(n). There are a lot of functions that take place as setup happens but I only touch each node once (it's all done inside a single for loop that doesn't require going through every node more than one time). Djikstra's could possibly be O(n^2) in something like a complete graph, but actual performance will stray closer to O(n). Kruskal's algorithm is probably around O(n log n). It has to go through the entire list each time, but what it has to go through decreases with time. Thanks for reading!

Lenny.

Zip includes: 8 .java file, readme, OUTPUT
