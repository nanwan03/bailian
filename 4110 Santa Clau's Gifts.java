import java.util.*;

class Box {
	int value;
	int weight;
	double density;
	Box(int value, int weight) {
		this.value = value;
		this.weight = weight;
		this.density = 1.0 * this.value / this.weight;
	}
}

class BoxComparator implements Comparator<Box> {
	public int compare(Box a, Box b) {
		return a.density < b.density ? -1 : 1;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numBox = in.nextInt();
		int maxWeight = in.nextInt();
		List<Box> boxes = new ArrayList<Box>();
		for (int i = 0; i < numBox; ++i) {
			boxes.add(new Box(in.nextInt(), in.nextInt()));
		}
		Collections.sort(boxes, new BoxComparator());
		double totalWeight = 0;
		double totalValue = 0;
		for (int i = boxes.size() - 1; i >= 0; --i) {
			if (totalWeight + boxes.get(i).weight <= maxWeight) {
				totalWeight += boxes.get(i).weight;
				totalValue += boxes.get(i).value;
			} else {
				totalValue += boxes.get(i).density * (maxWeight - totalWeight);
				break;
			}
		}
		System.out.println(String.format("%.1f\n", totalValue));
	}
}