import java.util.Comparator;


public class VertexComparator implements Comparator<Vertex> {

	public int compare(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		if(v1.dist > v2.dist){return 1;}
		else if(v1.dist < v2.dist){return -1;}
		else{return 0;}
	}

}