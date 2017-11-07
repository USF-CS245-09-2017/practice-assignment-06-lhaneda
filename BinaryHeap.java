public class BinaryHeap {
	private int[] data;
	private int size;
	
	//Constructor
	public BinaryHeap(){
		data = new int[10];
		size = 0;
	}
	
	//multiply array size by 2
	private void growArray() {
		int[] temp = new int[data.length * 2];
		System.arraycopy(data, 0, temp, 0, data.length);
		data = temp;
	}
	
	//add to end of list and compare to parent
	public void add(int priority) {
		if(size >= data.length)
			growArray();
		int index = size;
		data[size++] = priority;
		while(data[index] < data[parent(index)]){
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	//remove calls shiftDown
	public int remove() {
		int temp = data[0];
		if(size != 0){
			shiftDown(0);
			size--;
		}
		return temp;
	}
	
	//shift down in array till it is in the right spot
	private void shiftDown(int pos) {
		if (left_child(pos) >= size)
			return;
		int child = left_child(pos);
		if (right_child(pos) < size &&
				data[right_child(pos)] < data[child])
			child = right_child(pos);
		if (data[child] < data[pos]) {
			swap(child, pos);
			shiftDown(child);
		}
	}
	
	//return parent index
	private int parent(int index) {
		if(index == 0)
			return 0;
		return ((index-1)/2);
	}
	
	//return left child index
	private int left_child(int pos) {
		return (2 * pos) + 1;
	}
	
	//return right child index
	private int right_child(int pos) {
		return (2 * pos) + 2;
	}
	
	//swap
	private void swap(int index, int parent) {
		int temp = data[index];
		data[index] = data[parent];
		data[parent] = temp;	
	}
}
