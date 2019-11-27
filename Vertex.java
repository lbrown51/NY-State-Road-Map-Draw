import java.util.ArrayList;



public class Vertex {
	public final String id;
	public final int number;
	public final Double x,y;
	public Vertex head = null;
	public int height = 1;

	public Vertex(String id, Double x, Double y,int number){
		this.id = id;
		this.x = x;
		this.y = y;
		this.number = number;
	}
	
	public String toString(){
		String returnString =  id ;
		return returnString;
		
	}
	
	public boolean known;
	public double dist; 
	public Vertex path;
	
	ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	
	ArrayList<Edge> edgeList = new ArrayList<Edge>();
}
