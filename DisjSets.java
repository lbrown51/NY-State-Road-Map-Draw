

public class DisjSets {
		
	
	public void union(Vertex root1, Vertex root2)
	{
		if(root1.height<root2.height && !(find(root1)!=find(root2)) )
			{
			root1.head = root2;
			root2.height++;
			}
		
		else{
			if(root1.height == root2.height)
				root1.height--;
			root1.head = root2;
			root2.height++;
		}
		
	}
	
	
	public Vertex find(Vertex x){
		if (x.head == null)
			return x;
		else
			return x = find(x.head);
	}
	
	
	
}
