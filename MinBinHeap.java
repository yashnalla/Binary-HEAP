package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size = 0;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.

  public EntryPair[] getHeap() { 
    return this.array;
  }


public void insert(EntryPair entry) {
	array[size + 1] = entry;
	size++;
	int test = size;
	while(array[test].getPriority() < array[test/2].getPriority()){
		swap(test/2, test);
		test = test/2;
	}
}


public void delMin() {
	if(size ==0){
		return;
	}
	swap(1, size);
	array[size] = null;
	size--;
	bubbleDown(1);
	
}
public void bubbleDown(int fuckme){
	while(array[(2*fuckme)]!= null){ 
		int fuckchild = fuckme*2;
		if(array[(2*fuckme)+1]!= null &&	(getLefty(fuckme) > getRighty(fuckme)) ){ // and if the left child priority is lower than the right child
			fuckchild = (fuckme*2) + 1;		
			
		}
		if(array[fuckme].getPriority() > array[fuckchild].getPriority()){
					swap(fuckme, fuckchild);
		}else{
			break;
		} fuckme = fuckchild;
	}
}

public int getLefty(int a){
	return array[a*2].getPriority();
}

public int getRighty(int b){
	return array[(b*2)+1].getPriority();
}

public EntryPair getMin() {
	
	if(size == 0){
		return null;
	}
	return array[1];
}


public int size() {

	return size;
}


public void build(EntryPair[] entries) {
	for(int i = 0; i< entries.length; i++){
		array[i+1] = entries[i];
		
	}size = entries.length;
	
	/*for(int i = (size/2); i > 0; i--){
		bubbleDown(i);
	}
	*/
	int temp = size/2;
	
	while(array[temp].getValue() != null){
		
		
		bubbleDown(temp);
		
		//System.out.println("runs: " + temp);
		temp--;
		
	}
	
}

public void swap(int bigger, int smaller){
	EntryPair goingdown  = new EntryPair(array[bigger].getValue(), array[bigger].getPriority());
	EntryPair goingup = new EntryPair(array[smaller].getValue(), array[smaller].getPriority());
	array[smaller] = goingdown;
	array[bigger] = goingup;
}
}