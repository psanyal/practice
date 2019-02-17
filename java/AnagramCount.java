import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class AnagramCount {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    HashMap<String,Integer> map=new HashMap<String,Integer>();
		    for(int i=0;i<n;i++)
		    {
		        char c[]= sc.next().toCharArray();
		        Arrays.sort(c);
		        String s =new String(c);
		        if(!map.containsKey(s))
		            map.put(s,1);
		        else
		            map.put(s,map.get(s)+1);
		    }
		    ArrayList<Integer> ans=new ArrayList<Integer>();
		    for(String sp:map.keySet())
		    {
		        ans.add(map.get(sp));
		    }
		    Collections.sort(ans);
		    for(int x:ans)
		        System.out.print(x+" ");
		    System.out.println();
		    
		    
		}
	}
}