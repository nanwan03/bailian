import java.util.*;

class Heap {
	private static List<Integer> input;
	Heap() {
		input = new ArrayList<Integer>();
	}
	public void shiftUp(int index) {
		int num = input.get(index);
        while(index > 0){
            int pindex = (index - 1)/2;
            int parent = input.get(pindex);
            if(num < parent){
                input.set(index, parent);
                index = pindex;
            }else {
            	break;
            }
        }
        input.set(index, num);
	}
	public void shiftDown(int index) {
		int num = input.get(index);
        int leftIndex = 2 * index + 1;
        while(leftIndex < input.size()){
            int minChild = input.get(leftIndex);
            int minIndex = leftIndex;
             
            int rightIndex = leftIndex + 1;
            if(rightIndex < input.size()){
                int rightChild = input.get(rightIndex);
                if(rightChild < minChild){
                    minChild = rightChild;
                    minIndex = rightIndex;
                }
            }
             
            if(minChild < num){
                input.set(index, minChild);
                index = minIndex;
                leftIndex = index * 2 + 1 ;
            }else {
            	break;
            }
        }
        input.set(index, num);
	}
	public void offer(int i) {
		input.add(i);
		shiftUp(input.size() - 1);
	}
	public int poll() {
		if(input.isEmpty()){
            return -1;
        }
        int minItem = input.get(0);
        int lastItem = input.remove(input.size() -1 );
        if(input.isEmpty()){
            return lastItem;
        }
        input.set(0, lastItem);
        shiftDown(0);
        return minItem;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int operations = in.nextInt();
		Heap heap = new Heap();
		while (operations-- > 0) {
			int type = in.nextInt();
			if (type == 2) {
				System.out.println(heap.poll());
			} else {
				heap.offer(in.nextInt());
			}
		}
	}
}