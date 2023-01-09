package examplesArrayList;

import java.util.List;
import java.util.ArrayList;

public class ArrayStringList {

    private String[] data;
    private int size; 
   
    private void resizeData(int newSize) {  
    	  String [] dataResized = new String[newSize];
    	  for(int i = 0; i<data.length; i++) {
    		  dataResized[i] = data[i];
    		}
    	  data = dataResized;
    }
    
    public ArrayStringList(int initialCapacity) { 			
    	data = new String [initialCapacity];
    	size = 0;
    }

    
    public void add(String str) {
    	if(size == data.length) {
			resizeData(data.length*2);
			}
    	
    	data[size++] = str;
    }

    public void add(int index, String str) {
    	if(index>0 && index<data.length-1) {
    		size++;
    	  System.arraycopy(data, index, data, index+ 1, data.length);
    	  data[index] = str;
    	}
    	if(size == data.length) {
    		resizeData(data.length*2);
    	}
    }

    public String get(int index) {
    if(index<0 || index>=data.length) {
    	return null;
    }
    else {
    	return data[index];
    }
    }

    
    public void remove(int index) { 
    	String [] array1 = new String[data.length];
    	
    	for(int i = index; i<data.length-1; i++) {
    		data[i] = data[i+1];
    		data[data.length-1] = "";
    	}
    	size--;
    	
    	
    }

    
    public int size() { 
        return size;
    }

    public boolean contains(String str) {
    	for(int i = 0; i<data.length;i++) {
    		if(data[i].equals(str)) {
    			return true;
    		}
    	}
    	
    	return false;
    }

    public static void main(String[] args) {
        ArrayStringList list = new ArrayStringList(2);
        ArrayList<String> referenceList = new ArrayList<>();

        list.add("alpha");
        referenceList.add("alpha");
        list.add("beta");
        referenceList.add("beta");
        list.add("gamma");
        referenceList.add("gamma");

     

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("Your size method produced "
                + "the wrong results. It should be been %d, but it was %d.",
                referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("The item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "add or get methods may be wrong.", i,
                    referenceList.get(i), list.get(i)));
            }
        }

        list.remove(1);
        referenceList.remove(1);

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("After removing an item, "
            + "the size of your list should be %d, but it was %d. Your "
            + "remove method may not properly be updating the list's size.",
            referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("After removing an "
                    + "item, the item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "remove method may be wrong.",
                    referenceList.get(i), list.get(i)));
            }
        }

        if (!list.contains("alpha")) {
            throw new AssertionError(String.format("Your contains method "
                + "reported a string doesn't exist in the List, even though "
                + "it should."));
        }

        if (list.contains("beta")) {
            throw new AssertionError(String.format("Your contains method "
                + "reported a string DID exist in the List, even though it "
                + "should have been removed."));
        }

 

        list.add("delta");
        referenceList.add("delta");
        list.add("epsilon");
        referenceList.add("epsilon");
        list.add("zeta");
        referenceList.add("zeta");
        list.add("eta");
        referenceList.add("eta");
        list.add("theta");
        referenceList.add("theta");
        list.add("iota");
        referenceList.add("iota");
        list.add("kappa");
        referenceList.add("kappa");
        list.add("lambda");
        referenceList.add("lambda");
        list.add("mu");
        referenceList.add("mu");

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("After adding a bunch of "
                + "new elements, the size of your list should have been %d "
                + "but it was %d", referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("After removing an "
                    + "item, the item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "remove method may be wrong.",
                    referenceList.get(i), list.get(i)));
            }
        }

        System.out.println("If you're reading this, everything worked!");
    }
}
