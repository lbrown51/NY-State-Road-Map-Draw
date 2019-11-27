import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Project4 {
    static JPanel panel = new JPanel();
	static JFrame frame = new JFrame();
	static Hashtable<String,Vertex> hash = new Hashtable<String,Vertex>();
	static double minLat = 0.0;
	static double maxLat = 0.0;
	static double minLong = 0.0;
	static double maxLong = 0.0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = createFromFile(args[0]);
		double[] scale = {minLong,maxLong, minLat, maxLat};


		
		if (args.length == 1){
			

		}
		
		
		
		else if(args.length == 2){
			if (args[1].equals("-show")){
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(panel);
				frame.setResizable(false);
			    frame.setSize(700, 700);
			    frame.setVisible(true);

				frame.setVisible(true);

			    Graphics2D g2d = (Graphics2D) panel.getGraphics();
			    panel.setBackground(Color.gray);
			    
			
				g2d.setColor(Color.black);

			    for (int i = 0; i<graph.edgeList.size();i++){
					double[] coor = findCoordinates(graph.edgeList.get(i), scale);
					g2d.drawLine((int) coor[0], (int)coor[1], (int)coor[2], (int)coor[3]);
				}

			}
			
			else if(args[1].equals("-meridianmap")){
						ArrayList<Edge> edges  = graph.kruskal(graph.edgeList, graph.vertices());
						
						for (int i =0; i<edges.size();i++){
							System.out.println(edges.get(i));
						}
					    System.out.println("With a total of " + edges.size() + " roads out of " +graph.edgeList.size());

			}

		}
		
		
		
		
		else if(args.length == 3){
			
			
			if(args[1].equals("-show")){
				
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(panel);
			frame.setResizable(false);
		    frame.setSize(700, 700);
		    frame.setVisible(true);

			frame.setVisible(true);

		    Graphics2D g2d = (Graphics2D) panel.getGraphics();
		    panel.setBackground(Color.gray);
		    
		
			g2d.setColor(Color.black);

		    for (int i = 0; i<graph.edgeList.size();i++){
				double[] coor = findCoordinates(graph.edgeList.get(i), scale);
				g2d.drawLine((int) coor[0], (int)coor[1], (int)coor[2], (int)coor[3]);
			}

			
			if (args[2].equals("-meridianmap")){
			    g2d.setColor(Color.red);
				ArrayList<Edge> edges  = graph.kruskal(graph.edgeList, graph.vertices());
				
				for (int i =0; i<edges.size();i++){
					double[] coor = findCoordinates(edges.get(i), scale);
					System.out.println(edges.get(i));
					g2d.drawLine((int) coor[0], (int)coor[1], (int)coor[2], (int)coor[3]);
				}
			    System.out.println("With a total of " + edges.size() + " roads out of " +graph.edgeList.size());

			}
			else {
				System.out.println("Your third argument was incorrect");
				}

			}
			
			else{
				System.out.println("Your second argument was incorrect");
				
			}
		}
	


	        
		  
		else if (args.length == 4){
			
			if(args[1].equals("-directions")){
			try {
				ArrayList<Vertex> finished = graph.dijkstra(hash.get(args[2]).number,hash.get(args[3]).number);
			
				for(int i =0;i<finished.size()-1;i++){
					Vertex next  = finished.get(i);
					
					System.out.print(next + " -> ");


			}
				System.out.print(finished.get(finished.size()-1) + "");
				
			}	catch (NullPointerException e){
				System.out.println("Something about the places that you gave wasn't quite right");
				e.printStackTrace();
				System.exit(1);
			} 
			}
			else{
				System.out.println("Your second argument was incorrect");
			}
			
		}
		
		
		
		if (args.length == 5){
			
			if(args[1].equals("-show")){
				
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(panel);
				frame.setResizable(false);
			    frame.setSize(700, 700);
			    frame.setVisible(true);

				frame.setVisible(true);

			    Graphics2D g2d = (Graphics2D) panel.getGraphics();
			    panel.setBackground(Color.gray);
			    
			
				g2d.setColor(Color.black);

			    for (int i = 0; i<graph.edgeList.size();i++){
					double[] coor = findCoordinates(graph.edgeList.get(i), scale);
					g2d.drawLine((int) coor[0], (int)coor[1], (int)coor[2], (int)coor[3]);
				}
			if(args[2].equals("-directions")){
				try{
		
				ArrayList<Vertex> finished = graph.dijkstra(hash.get(args[3]).number,hash.get(args[4]).number);
				
				for(int i =0;i<finished.size();i++){
					Vertex next  = finished.get(i);
					
					if(i<finished.size()-2 ){
						Vertex toMatch = finished.get(i+1);
					
					Edge toGraph = null;

					for (int j =0; j<next.vertexList.size()-1;j++)
						if(next.vertexList.get(j).number == (toMatch).number){
							toGraph = graph.edgeList.get(next.edgeList.get(j).id);
					

					double[] coor= findCoordinates(toGraph, scale);
					g2d.drawLine((int) coor[0], (int)coor[1], (int)coor[2], (int)coor[3]);}
					}

					System.out.print(next + " -> ");
			}
				System.out.print(finished.get(finished.size()-1) + "");
				

			}	catch (NullPointerException e){
				System.out.println("Something about the places that you gave wasn't quite right");
				e.printStackTrace();
				System.exit(1);
			} 
			}
			
			else{
				System.out.println("Your second argument was incorrect");
			}
		}
			else{
				System.out.println("The second argument that you entered was not correct");
			}
		
		}
		
		
	}
				
		
		
	

	
	
		
		

	
	
	

	public static Graph createFromFile(String filename) {
		 
			try {
				Scanner scan = new Scanner(new File(filename));
				Graph g = null;
				ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
				
				String CurrentLine = scan.nextLine();
				int vertexCount = 0;
				int edgeCount = 0;
				boolean graphCreated = false;
				
				 minLat  = Double.parseDouble(CurrentLine.split("\t")[2]);
				 maxLat = Double.parseDouble(CurrentLine.split("\t")[2]);
				 minLong = Double.parseDouble(CurrentLine.split("\t")[3]);
				 maxLong = Double.parseDouble(CurrentLine.split("\t")[3]);
				
				
				while ( CurrentLine  != null ){

					String[] in = CurrentLine.split("\t");
					String type = in[0];
					
					if(type.equals("i")){
						String ID = in[1];
						Double x = Double.parseDouble(in[2]);
						if(x>(maxLat)){maxLat = x;}
						if(x<(minLat)){minLat = x;}
						
						
						Double y = Double.parseDouble(in[3]);
						if (y>maxLong){maxLong = y;}
						if(y<(minLong)){minLong = y;}
						
						
						Vertex temp = new Vertex(ID,x,y,vertexCount);
						hash.put(ID, temp);
						vertexCount++;
						
						vertexList.add(temp);
					}
					else if(type.equals("r")){
						double[] scale = {minLong,maxLong, minLat, maxLat};
						if(!graphCreated)
						{g = new Graph(vertexList,false); 
						graphCreated = true;
				        
						}
//						Graphics2D g2d = (Graphics2D) panel.getGraphics();
//				        g2d.setColor(Color.blue);
				        
						Vertex vertex1 =  hash.get(in[2]);
						Vertex vertex2 = hash.get(in[3]);	 
						
						//Source http://andrew.hedges.name/experiments/haversine/
						double dlong = toRadians(vertex2.y - vertex1.y);
						double dlat = toRadians(vertex2.x - vertex1.x);
						double lat1 = toRadians(vertex1.x);
						double lat2 = toRadians(vertex2.x);
						double a = Math.pow((Math.sin(dlat/2)),2) +
								Math.cos(lat1)*Math.cos(lat2)*
								Math.pow((Math.sin(dlong/2)),2);
						
						double c = 2 * (Math.atan2(Math.sqrt(a),Math.sqrt(1-a)));
						double weight = c*6371000;
						double weightFeet = weight*3.28084;
						Edge e = new Edge(vertex1,vertex2,weightFeet,edgeCount++,in[1]);
						g.insert(e);
						g.edgeList.add(e);

						
						//double[] coor = findCoordinates(e, scale);
						//g2d.drawLine((int) coor[0], (int)coor[1], (int)coor[2], (int)coor[3]);
						

					}
					try{
					CurrentLine = scan.nextLine();} catch (NoSuchElementException e){
						CurrentLine = null;
					}
					
				}
				return g;

				
	 
			} catch (IOException e) {
				e.printStackTrace();
			} 
			return null;
			
			
		}
	

	public static double[] findCoordinates(Edge e, double[] scale){
		double minLong  = scale[0];
		double maxLong = scale[1];
		double minLat = scale[2];
		double maxLat = scale[3];

		double dlon = maxLong - minLong;
		double dlat = maxLat - minLat;
		double scaleVert = frame.getWidth() / dlon;
		double scaleHor = frame.getHeight() / dlat;
	

		double x1 = (e.v.y - minLong)*scaleVert;
		double y1 = frame.getHeight() - (e.v.x - minLat)*scaleHor;

		double x2 = (e.w.y - minLong)*scaleVert;
		double y2 =  frame.getHeight() - (e.w.x - minLat)*scaleHor;

		double[] scale1 = {x1,y1,x2,y2};
		
		return scale1;
		
		
		
	}
	
	
	
	public static double toRadians(double x){
	    return x * Math.PI / 180; 

	}
	
	
	
		
	
}

