package practice3_adv;

/*Бінарна Купа
Реалізуйте структуру даних  - Бінарна Купа (Binary Heap).
Конструктор проймає один параметр size.
Методи insert(int) що працює за O(logN) і poll(),
який видаляє і повертає максимальне число з купи і також працює за O(logN).
*/

public class BinaryHeap {
    private int[] binaryHeap;
    private int currentSize;

    public BinaryHeap(int size) {
        binaryHeap = new int[size];
    }

    public void insert(int val) {
        if ((currentSize + 1) > binaryHeap.length) {
            increaseHeapCapacity();
        }
        binaryHeap[currentSize++] = val;
        upShiftRecovery();
    }

    private void increaseHeapCapacity() {
        int[] newArray = new int[binaryHeap.length * 2];
        System.arraycopy(binaryHeap, 0, newArray, 0, binaryHeap.length);
        binaryHeap = newArray;
    }

    private void upShiftRecovery() {
        int childIndex = currentSize - 1;
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            int child = binaryHeap[childIndex];
            int parent = binaryHeap[parentIndex];
            if (child > parent) {
                binaryHeap[childIndex] = parent;
                binaryHeap[parentIndex] = child;
                childIndex = parentIndex;
            } else break;
        }
    }

    public int poll() {
        if (currentSize == 1) {
            int max = binaryHeap[0];
            binaryHeap[0] = 0;
            currentSize--;
            return max;
        }
        int max = binaryHeap[0];
        binaryHeap[0] = binaryHeap[currentSize - 1];
        binaryHeap[currentSize - 1] = 0;
        currentSize--;

        downShiftRecovery();

        return max;
    }

    private void downShiftRecovery() {
        int currentPosition = 0;
        int leftChild = 2*currentPosition + 1;
        while (leftChild < currentSize) {
            int maxElementPosition = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize) {
                if (binaryHeap[rightChild] > binaryHeap[leftChild]) {
                    ++maxElementPosition;
                }
            }
            if (binaryHeap[currentPosition] < binaryHeap[maxElementPosition]) {
                int temp = binaryHeap[currentPosition];
                binaryHeap[currentPosition] = binaryHeap[maxElementPosition];
                binaryHeap[maxElementPosition] = temp;
                currentPosition = maxElementPosition;
                leftChild = 2*currentPosition + 1;
            } else break;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < currentSize; i++ ) {
            result.append(binaryHeap[i]).append(' ');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(2);
        heap.insert(0);
        heap.insert(1);
        heap.insert(2);
        heap.insert(7);
        heap.insert(9);
        heap.insert(4);

        for (int i = 0; i < 6; i++) {
            System.out.println(heap.toString());
            System.out.println(heap.poll());
        }
    }
}