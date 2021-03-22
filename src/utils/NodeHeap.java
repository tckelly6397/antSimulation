package utils;

//Sebastian Lague 
//https://youtu.be/3Dw5d7PlcTM
public class NodeHeap {
	
	Node[] items;
	int currentCount;
	
	public NodeHeap(int maxHeapSize) {
		items = new Node[maxHeapSize];
	}
	
	public void add(Node item) {
		item.setIndex(currentCount);
		items[currentCount] = item;
		sortUp(item);
		currentCount++;
	}
	
	public Node removeFirst() {
		Node firstItem = items[0];
		currentCount--;
		if(currentCount == -1) return null;
		items[0] = items[currentCount];
		items[0].setIndex(0);
		sortDown(items[0]);
		return firstItem;
	}
	
	public boolean contains(Node item) {
		return items[item.getIndex()].equals(item);
	}
	
	private void swap(Node itemA, Node itemB) {
		items[itemA.getIndex()] = itemB;
		items[itemB.getIndex()] = itemA;
		int itemAIndex = itemA.getIndex();
		itemA.setIndex(itemB.getIndex());
		itemB.setIndex(itemAIndex);
	}
	
	public void sortDown(Node item) {
		while(true) {
			int childIndexLeft = item.getIndex() * 2 + 1;
			int childIndexRight = item.getIndex() * 2 + 2;
			int swapIndex = 0;
			
			if(childIndexLeft < currentCount) {
				swapIndex = childIndexLeft;
				
				if(childIndexRight < currentCount) {
					if(items[childIndexLeft].compareTo(items[childIndexRight]) < 0) {
						swapIndex = childIndexRight;
					}
				}
				
				if(item.compareTo(items[swapIndex]) < 0) {
					swap(item, items[swapIndex]);
				}else {
					return;
				}
			}else {
				return;
			}
		}
	}
	
	public void sortUp(Node item) {
		int parentIndex = (item.getIndex() - 1) / 2;
		
		while(true) {
			Node parentItem = items[parentIndex];
			if(item.compareTo(parentItem) > 0) 
				swap(item, parentItem);
			else
				break;
		}
	}
	
	public int count() {
		return items.length;
	}
	
	public void updateItem(Node item) {
		sortUp(item);
	}

	public Node[] getItems() {
		return items;
	}

	public void setItems(Node[] items) {
		this.items = items;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
}
