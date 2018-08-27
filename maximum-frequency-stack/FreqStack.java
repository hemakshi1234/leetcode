import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class FreqStack {
	private Map<Integer, Element> valueToElement = new HashMap<>();
	private SortedSet<Element> elements = new TreeSet<>(
			(element1, element2) -> (element1.sequences.size() != element2.sequences.size())
					? Integer.compare(element1.sequences.size(), element2.sequences.size())
					: Integer.compare(element1.sequences.peek(), element2.sequences.peek()));
	private int sequence = 0;

	public FreqStack() {
	}

	public void push(int x) {
		Element element;
		if (valueToElement.containsKey(x)) {
			element = valueToElement.get(x);
			elements.remove(element);
		} else {
			element = new Element(x);
			valueToElement.put(x, element);
		}
		element.sequences.add(sequence);
		elements.add(element);
		sequence++;
	}

	public int pop() {
		Element element = elements.last();
		elements.remove(element);

		element.sequences.pop();
		if (element.sequences.empty()) {
			valueToElement.remove(element.value);
		} else {
			elements.add(element);
		}

		return element.value;
	}
}

class Element {
	int value;
	Stack<Integer> sequences = new Stack<>();

	Element(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, sequences);
	}

	@Override
	public boolean equals(Object obj) {
		Element other = (Element) obj;
		return Objects.equals(value, other.value) && Objects.equals(sequences, other.sequences);
	}
}

// Your FreqStack object will be instantiated and called as such:
// FreqStack obj = new FreqStack();
// obj.push(x);
// int param_2 = obj.pop();
