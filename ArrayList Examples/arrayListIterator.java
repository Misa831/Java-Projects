import java.util.ArrayList;
import java.util.Iterator;

public class arrayListIterator {
	
	
	public static void main(String[] args) {
	
		ArrayList<Character> list = new ArrayList<>();
    
		list.add('a'); 
    list.add('b'); 
    list.add('c'); 
    list.add('d');
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
			}
		
		
	}
}
