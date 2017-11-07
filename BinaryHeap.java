public class BinaryHeap {
	private int[] heap;
	private int size;
	
	public BinaryHeap() {
		heap = new int[10];
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getHeapIndex(int i) {
		if(i < 0 || i > size)
			return -1;
		return heap[i];
	}
	
	public void growHeap() {
		int[] temp = heap;
		heap = new int[heap.length * 2];
		System.arraycopy(temp, 0, heap, 0, temp.length);
	}
	
	public void add(int index) {
		if(heap.length <= size + 1)
			growHeap();
		heap[size] = index;
		//System.out.print(heap[size++]);
		while(index > 0 && heap[index] < heap[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}
		size++;
	}
	
	public int remove() {
		int priority = heap[0];
		swap(0, --size);
		if (size != 0) {
			shiftDown(0);
		}
		return priority;
	}
	
	public void shiftDown(int index) {
		if (leftChild(index) >= size)
			return;
		int child = leftChild(index);
		if (rightChild(index) < size &&
			heap[rightChild(index)] < heap[child])
			child = rightChild(index);
		if (heap[child] < heap[index]) {
			swap(child, index);
			shiftDown(child);
		}
    }
	
	public int parent(int index) {
        return (index - 1) / 2;
	}
	
	public int leftChild(int index) {
		return (index * 2) + 1;
	}
	
	public int rightChild(int index) {
		return (index * 2) + 2;
	}
	
	protected void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;        
    }
}
