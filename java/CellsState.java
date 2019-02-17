// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
	import java.util.List;
	import java.util.ArrayList;
	// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
	// DEFINE ANY CLASS AND METHOD NEEDED
	// CLASS BEGINS, THIS CLASS IS REQUIRED
     
public class CellsState {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] states = {1,1,1,0,1,1,1,1};
		int days = 2;
		new CellsState().cellCompete(states, days);
	}
	
	
	  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	    public List<Integer> cellCompete(int[] states, int days)
	    {
	        // check if arguments are valid
	        if(states.length != 8 || days < 0){
	            System.out.println("Invalid Input"); 
	            return null;
	        } else if(days == 0){
	            // print states as-is if num of days is 0
	            return printResults(states);
	        } else{
	            int statesCount = states.length;
	            int[] newStates = new int[statesCount];
	            
	            // loop through num of days
	            while(days > 0){
	                
	                // loop through states
	                for(int i = 0; i < statesCount; i++){
	                    
	                    // check for first state element
	                    if(i == 0){
	                         if(states[i+1] == 0){
	                            newStates[i] = 0;
	                        }else{
	                            newStates[i] = 1;
	                        }
	                    }else if(i == statesCount -1){  // check for last state element
	                        if(states[i-1] == 0){
	                            newStates[i] = 0;
	                        }else{
	                            newStates[i] = 1;
	                        }
	                    }else{
	                        // check for state similary of neighbours
	                        if(states[i-1] == states[i+1]){
	                            newStates[i] = 0;
	                        }else{
	                            newStates[i] = 1;
	                        }
	                    }
	                }
	                
	                // update states array after each day
	                //states = newStates;
	                for (int i = 0; i < statesCount -1; i++) {
	                	states[i] = newStates[i];
	                }
	             
	                days--;
	            }
	            
	            // final result is in states array
	            return printResults(states);
	        }
	    }
	    
	    private List<Integer> printResults(int[] newStates){
	        List<Integer> nStates = new ArrayList<Integer>();
	        for(int s : newStates){
	           System.out.print(s + " "); 
	           nStates.add(s);
	        }
	        return nStates;
	    }
	  // METHOD SIGNATURE ENDS
	}


