package DS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericTree {
	
	static class Node {
		int data;
		List<Node> children = new ArrayList<>();
	}
	
	Node root;
	
	public void construct(int[] arr) {
		Stack<Node> stack = new Stack<>();

		for (int element : arr) {
			if (element == -1)
				stack.pop();
			else
			{
				Node node = new Node();
				node.data = element;
				if (stack.isEmpty())
					root = node;
				else
					stack.peek().children.add(node);
				stack.push(node);
			}
		} 
	}

	public void display(Node root) {
		//print yourself
		StringBuilder sb = new StringBuilder();
		sb.append(root.data).append(" -> ");
		for(Node child: root.children) {
			sb.append(child.data).append(" ");
		}
		System.out.println(sb);
		//call recursively for your children
		for(Node child : root.children) {
			display(child);
		}
	}

	public int size(Node root) {
		int sum = 0;
		for(Node child : root.children) {
			int myfamilySize = size(child);
			sum += myfamilySize;
		}
		//post-order
		return sum + 1;
	}

	public int height(Node root) {
		int height = -1;	//very important :)
		for(Node child : root.children) {
			int myFamilyHeight = height(child);
			height = Math.max(height, myFamilyHeight);
		}
		return height + 1;
	}

	public int max(Node root) {
		int max = Integer.MIN_VALUE;
		for(Node child : root.children) {
			int myFamilyMax = max(child);
			max = Math.max(max, myFamilyMax);
		}
		return Math.max(root.data, max);
	}
	
	public static void main(String[] args) {
		//construction of a Generic Tree:
		int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		GenericTree tree = new GenericTree();
		tree.construct(arr);
		// tree.display(tree.root);
		// System.out.println(tree.size(tree.root));
		// System.out.println(tree.height(tree.root));
		System.out.println(tree.max(tree.root));	
	}
}