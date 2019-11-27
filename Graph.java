import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


public class Graph {
	private int vertexCount, edgeCount;
	 boolean directed; // false for undirected graphs, true for directed
	 private ArrayList<Vertex> adj;
	 
	 ArrayList<Edge> edgeList = new ArrayList<Edge>();

	 
	 public Graph(ArrayList<Vertex> list, boolean isDirected) { 
		 directed = isDirected;
		 vertexCount = list.size();
		 adj = list;		 

	 }
	 
	 public int searchVertex(Vertex v, Vertex w ){
		 
		 for (int i = 0; i<v.vertexList.size();i++){ //find index in list of searched for node / 
			 if (v.vertexList.get(i).equals(w)){return i;} // Checks if it exists
		 }
		 return -1;
	 }
	 
	 public boolean isDirected() { // your code here
		 return directed;
	 }
	 
	 public int vertices() { // return the number of vertices 
		return vertexCount;
	 }
	 

	 public int edges() { // return number of edges 
		 return edgeCount;
	 }
	 
	 
	 public void insert(Edge e) { // your code here
		 if (directed){
			 if (searchVertex(e.v,e.w) == -1){
				 Vertex toInsert1 = adj.get(e.v.number);
				 toInsert1.vertexList.add(e.w);
				 toInsert1.edgeList.add(e);
				 edgeCount++;				 
			 }
		 }
		 else{
			 if (searchVertex(e.v,e.w)==-1){
				 Vertex toInsert1 = adj.get(e.v.number);
				 toInsert1.vertexList.add(e.w);
				 toInsert1.edgeList.add(e);
				 
				 Vertex toInsert2 = adj.get(e.w.number);
				 toInsert2.vertexList.add(e.v);
				 toInsert2.edgeList.add(e);
				 
				 edgeCount++;				 
			 }
			 
		 }
		 
	}

	 
	 
	 public boolean connected(int node1, int node2) { //are they connected?
		Vertex vertex1 = adj.get(node1);
		Vertex vertex2 = adj.get(node2);
		return searchVertex(vertex1,vertex2) != -1;
			 
	 }
	 
	 
	
	 public AdjList getAdjList(int vertex) {
		return new AdjArray(vertex); // your code here
		
	 }
	 
	 
	 private class AdjArray implements AdjList {

			private int v; // what vertex we are interested in
			private int i; // so we can keep track of where we are

			public AdjArray(int v) {
				this.v = v;
				i = -1;
			}
			
			
		
			
			public boolean end() {
				if(i<vertices())
					return false;
				return true;
			}




			@Override
			public int begin() {
				// TODO Auto-generated method stub
				return 0;
			}




			@Override
			public int next() {
				// TODO Auto-generated method stub
				return 0;
			}

		}
	 
	 
	 public void show(){
		 for (int s = 0; s<vertices(); s++){
			 Vertex v = adj.get(s);
			 System.out.print(v.id + ": ");
			 AdjList A = getAdjList(s);
			 for (int t = 0; t<v.edgeList.size(); t++)
				 System.out.print(v.vertexList.get(t).id + " ");
			 System.out.println();
			 }
		 }
	 
	 
	 
	 public ArrayList<Edge> kruskal (ArrayList<Edge> edges, int numVertices){
		 		 
		 DisjSets ds = new DisjSets();

		 PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new EdgeComparator());
		 pq.addAll(edges);
		 ArrayList<Edge> mst = new ArrayList<Edge>();
		 
		 while(mst.size() != numVertices-1 && !pq.isEmpty()){
			 Edge e = pq.poll();

		 Vertex uset = ds.find(e.v);
		 Vertex vset = ds.find(e.w);
			 
			 if(uset != vset)
			 {
				 mst.add(e);
				 ds.union(uset,vset);
			 }
		 }
		 return mst;
	 }
	 
	 
	 
	 public ArrayList<Vertex> dijkstra (int s, int find){
		
		 PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(new VertexComparator()); 
		 for (int i = 0; i<adj.size();i++){
			 adj.get(i).dist = Double.POSITIVE_INFINITY;
			 adj.get(i).known = false;
		 }
		 
		 adj.get(s).dist = 0.0;
		 
		 
		 Vertex v = adj.get(s);
		 int checked = adj.size();
		 while(!adj.get(find).known && checked>0){
			 adj.get(v.number).known = true;
			
			 for (int k = 0; k<adj.get(v.number).vertexList.size();k++){
				 if(!adj.get(v.vertexList.get(k).number).known){
					 double cvw = adj.get(v.number).edgeList.get(k).weight;
					 
					 if(v.dist + cvw < adj.get(v.number).vertexList.get(k).dist){
						 adj.get(v.vertexList.get(k).number).dist  = v.dist + cvw;
						 adj.get(v.vertexList.get(k).number).path = v;
					 }
				 }
			 }
			 
			 for(int j = 0; j<adj.get(v.number).vertexList.size();j++){
				 if(!adj.get(v.vertexList.get(j).number).known){
					 queue.add(adj.get(v.vertexList.get(j).number));
				 }
			 }
			 v = queue.poll();
			 checked--;
			
		 }
		 
		 if(checked==0){
			 System.out.println("The two places you entered wasn't weren't connected to each other");
			 System.exit(1);
		 }
		 
		 ArrayList<Vertex> finished = new ArrayList<Vertex>();
		 Vertex current = adj.get(find);

		 while (!current.equals(adj.get(s))){
			 finished.add(current);
			 current = current.path;
			 
		 }
		 finished.add(current);
		 finished.add(new Vertex(" | Distance Travelled : " + Math.round(adj.get(find).dist)+"ft",0.0,0.0,++vertexCount));

		 
		 return finished;

		 }
		
	 	 
	
}
