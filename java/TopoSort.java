import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/*Complete the function below*/
class GfG
{
	public static void main(String[] args) {
		// topoSort
	}
    static void dfs(int v,ArrayList<Integer>[] alist,boolean[] visited,Stack<Integer> s){
        visited[v]=true;
        Iterator<Integer> i=alist[v].listIterator();
        while(i.hasNext()){
            int ele=i.next();
            if(visited[ele]==false)
                dfs(ele,alist,visited,s);
        }
        //System.out.println(v);
        s.push(v);
    }
         public static int[] topoSort(ArrayList<Integer> graph[],int N)
         {
         //add code here.
         boolean[] vis=new boolean[N];
         int[] a=new int[N];
         Stack<Integer> s=new Stack<Integer>();
         for(int i=0;i<N;i++){
             if(vis[i]==false)
                dfs(i,graph,vis,s);
            }
            int i=0;
            while(!s.isEmpty()){
                a[i]=s.pop();
                //System.out.println(a[i]);
                i++;
            }
            return a;
         }
}