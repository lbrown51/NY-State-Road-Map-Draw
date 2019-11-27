public class Edge {
	public final Vertex v, w; // an edge from v to w
	public final double weight;
	public final int id; 
	public final String name;
	 public Edge(Vertex v, Vertex w, double weight, int id, String name) { // your code here 
		 this.weight = weight;
		 this.v = v;
		 this.w = w;
		 this.id = id;
		 this.name = name;
	 }
	 
	 public String toString(){
		 return name; //v.id + "-->"+ w.id + "        Distance : " + Math.round(weight) + "ft";
	 }
	 
//	 public boolean equals(Edge test){
//		 if(v == test.v && w == test.w && weight == test.weight){return true;}
//		 else{return false;}
//	 }
	 
	 public int compareTo(Edge e1, Edge e2) {
			// TODO Auto-generated method stub
			if(e1.weight > e2.weight){return 1;}
			else if(e1.weight < e2.weight){return -1;}
			else{return 0;}
		}
	
}

