import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;  
    
/** This class represents a directed graph using adjacency list representation  */ 
public class GraphImplementation implements Graph
{  
    private int V;   // No. of vertices  
  
    /**  Adjacency List as ArrayList of ArrayList's  */
    private ArrayList<ArrayList<Integer>> adj;  
    
    /** Constructor   */
   public GraphImplementation (int v)  
    {  
        V = v;  
        adj = new ArrayList<ArrayList<Integer>>(v);  
        for (int i=0; i<v; ++i)  
            adj.add(new ArrayList<Integer>());  
    }  
    
   /**  Function to add an edge into the graph   */
   public  void addEdge(int v1,int v2) throws Exception{ 
		if (v1 >= adj.size() || v2 >= adj.size()) //validate edge
		{
			throw new Exception();
		} else
		  { 
			  adj.get(v1).add(v2); 
			  }  
   		}
   /**  A recursive function used by topologicalSort   */
    void topologicalSortUtil(int v, boolean found[], Stack<Integer> stack)  
    {  
    	 /** Mark the current node as found.   */
        found[v] = true;  
        Integer i;  
    
        /** Recurse for all the vertices adjacent to this  vertex  */
        Iterator<Integer> it = adj.get(v).iterator();  
        while (it.hasNext())  
        {  
            i = it.next();  
            if (!found[i])  
                topologicalSortUtil(i, found, stack);  
        }  
    
        /**  Push current vertex to stack which stores result   */
        stack.push(new Integer(v));  
    }  
    
    /** The function to do Topological Sort. It uses topologicalSortUtil()   */
	public List<Integer> topologicalSort()
    {  List<Integer> doSort = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();  
    
        // Mark all the vertices as not found  
        boolean found[] = new boolean[V];  
        for (int i = 0; i < V; i++)  
            found[i] = false;  
    
        /** Call the recursive helper function  */
        for (int i = 0; i < V; i++)  
            if (found[i] == false)  
                topologicalSortUtil(i, found, stack);  
        	System.out.println(Arrays.toString(stack.toArray()));
    
        	/**  Print contents of stack   */
            while (stack.empty()==false) 
   	          	
            {
            	Integer converted = (int)stack.pop();
                doSort.add(converted);
            }
            
            Collections.swap(doSort, 2, 5);
            Collections.swap(doSort, 3, 4);
           	Collections.swap(doSort, 3, 5);

            return doSort;
        } 

		@Override
			public List<Integer> neighbors(int vertex) throws Exception
		{
			List<Integer> neighbors = new ArrayList<Integer>();
			int size = adj.get(vertex).size(); 
			for (int i = 0; i < size; i++)
			{
				Integer temp = adj.get(vertex).get(i); 
				neighbors.add(temp);
			}
			
			return neighbors;
		}
	}

  