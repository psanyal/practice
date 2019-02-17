
import java.util.Scanner;

class CountSubStrings {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    sc.nextLine();
		    char c[]= sc.next().toCharArray();
		    int count = 0;
		    for(int i=0;i<c.length;i++)
		    {
		        if(c[i] == '1'){
		            for(int j=i;j<c.length;j++)
		            {
		                if(c[j] == '1'){
		                	count++;
		                }
		            }
		        }
		        
		    }
		    System.out.print(count);
		    System.out.println();
		}
	}
}
