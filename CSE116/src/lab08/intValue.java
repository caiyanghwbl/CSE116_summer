package lab08;

import java.util.ArrayList;

public class intValue {
	private ArrayList<Integer> numbers;
	private int flag;

	public intValue(String str) {
		numbers = new ArrayList<Integer>();
		str = str.trim();
		if (str.length() == 0) {
			flag = 0;
			return;
		}
		flag = 1;
		if (str.charAt(0) == '-') {
			flag = -1;
			str = str.substring(1);
		}
		if (str.charAt(0) == '+') {
			str = str.substring(1);
		}

		for (int i = 0; i < str.length(); ++i) {
			numbers.add(str.charAt(str.length() - 1 - i) - '0');
		}
	}

	public intValue() {
		flag = 0;
		numbers = new ArrayList<Integer>();
	}

	public intValue multiply(intValue n) {
		intValue iv = new intValue();
		iv.flag = this.flag * n.flag;
		if (iv.flag == 0) {
			return iv;
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < numbers.size() + n.numbers.size() + 1; ++i) {
			result.add(0);
		}
		for (int i = 0; i < n.numbers.size(); ++i) {
			for (int j = 0; j < numbers.size(); ++j) {
				result.set(i + j, result.get(i + j) + numbers.get(j) * n.numbers.get(i));
			}
		}

		int f = 0;

		for (int i = 0; i < result.size(); ++i) {
			int k = result.get(i) + f;
			f = k / 10;
			result.set(i, k % 10);
		}
		iv.numbers = result;
		iv.checkZero();
		return iv;
	}

	public intValue exponentiation(intValue n) {
		intValue Minusone = new intValue("-1");
		intValue base = new intValue(this.toString());
		intValue result = new intValue("1");
		while (n.flag != 0) {
			result = result.multiply(base);
			n = n.add(Minusone);
			n.checkZero();
		}
		result.checkZero();
		return result;
	}

	public intValue add(intValue n) {
		intValue iv = new intValue();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < numbers.size() + n.numbers.size() + 1; ++i) {
			result.add(0);
		}
		while (numbers.size() < n.numbers.size()) {
			numbers.add(0);
		}
		while (n.numbers.size() < numbers.size()) {
			n.numbers.add(0);
		}

		numbers.add(0);
		n.numbers.add(0);
		if (flag == n.flag) {
			iv.flag = flag;

			int f = 0;
			for (int i = 0; i < n.numbers.size(); ++i) {
				f = n.numbers.get(i) + numbers.get(i) + f;
				result.set(i, f % 10);
				f = f / 10;
			}
		} else {
			if (isSmallerThan(n)) {
				return n.add(this);
			} else {
				iv.flag = flag;
				int f = 0;
				for (int i = 0; i < n.numbers.size(); ++i) {
					f = numbers.get(i) - n.numbers.get(i) - f;
					if (f < 0) {
						result.set(i, f + 10);
						f = 1;
					} else {
						result.set(i, f);
						f = 0;

					}
				}

			}

		}

		iv.numbers = result;

		iv.checkZero();
		return iv;

	}

	@Override
	public String toString() {
		if (flag == 0) {
			return "0";
		}
		StringBuilder stringBuilder = new StringBuilder();
		if (flag == -1) {
			stringBuilder.append('-');
		}
		int i;
		for (i = numbers.size() - 1; i >= 0; --i) {
			if (numbers.get(i) != 0) {
				break;
			}
		}
		for (; i >= 0; --i) {
			stringBuilder.append(numbers.get(i));
		}
		return stringBuilder.toString();
	}

	private void checkZero() {
		if (flag == 0) {
			return;
		}
		boolean allZero = true;
		for (int i = 0; i < numbers.size(); ++i) {
			if (numbers.get(i) != 0) {
				allZero = false;
				break;
			}
		}
		if (allZero) {
			flag = 0;
		}
	}

	private boolean isSmallerThan(intValue other) {
		for (int i = numbers.size() - 1; i >= 0; --i) {
			if (numbers.get(i) < other.numbers.get(i)) {
				return true;
			} else if (numbers.get(i) > other.numbers.get(i)) {
				return false;
			}
		}
		return false;

	}

}
