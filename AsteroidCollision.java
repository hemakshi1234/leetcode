import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int asteroid : asteroids) {
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				while (true) {
					if (stack.empty()) {
						stack.push(asteroid);
						break;
					}

					int top = stack.peek();
					if (top < 0) {
						stack.push(asteroid);
						break;
					} else if (top + asteroid == 0) {
						stack.pop();
						break;
					} else if (top + asteroid < 0) {
						stack.pop();
					} else {
						break;
					}
				}
			}
		}

		return stack.stream().mapToInt(x -> x).toArray();
	}
}
