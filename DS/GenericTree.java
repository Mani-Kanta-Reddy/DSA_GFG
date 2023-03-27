package DS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
	
	private class Node {
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

	public void traversal(Node root) {
		//Node Pre
		System.out.println("Node Pre " + root.data);
		for(Node child : root.children) {
			//Pre Edge 
			System.out.println("Pre Edge " + root.data + ", " + child.data);
			traversal(child);
			//Post Edge
			System.out.println("Post Edge" + root.data + ", " + child.data);
		}

		//Node Post
		System.out.println("Node Post " + root.data);
	}

	public void preOrder(Node root) {
		//print self 
		System.out.print(root.data + ", ");
		//call for chldren
		for(Node child : root.children) {
			preOrder(child);
		}
	}

	public void postOrder(Node root) {
		for(Node child : root.children) {
			postOrder(child);
		}
		System.out.print(root.data + ", ");
	}

	public void lvlOrderTraversal(Node root) {
		//BFS -> r m* w a* -> r w a 
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			// remove
			Node removed = queue.remove();
			//work
			System.out.print(removed.data + ", ");

			//add
			for(Node child : removed.children) {
				queue.add(child);
			}
		}
	}

	public void lvlOrderLinewise(Node root) {
		//BFS -> r w a
		int level = 1;
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(root, level));
		while(!queue.isEmpty()) {
			//remove
			Pair removed = queue.remove();
			if(removed.level > level) {
				System.out.println();
				level = removed.level;
			}
			//print
			System.out.print(removed.node.data + ", ");
			//add
			for(Node child : removed.node.children) {
				queue.add(new Pair(child, level + 1));
			}
		}
		System.out.println();
	}

	public void lvlOrderLinewiseUsingQueues(Node root) {
		Queue<Node> mainQueue = new ArrayDeque<>();
		Queue<Node> childQueue = new ArrayDeque<>();
		mainQueue.add(root);
		while(!mainQueue.isEmpty()) {
			//remove
			Node removed = mainQueue.remove();
			System.out.print(removed.data + ", ");
			for(Node child : removed.children) {
				childQueue.add(child);
			}
			if(mainQueue.isEmpty()) {
				mainQueue = childQueue;
				childQueue = new ArrayDeque<>();
				System.out.println();
			}
		}
	}

	public void lvlOrderLinewiseUsingMarkerNode(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		Node marker = new Node();
		marker.data = -1;
		queue.add(marker);
		while(!queue.isEmpty()) {
			//remove
			Node removed = queue.remove();
			if(removed.data != -1) {
				System.out.print(removed.data + ", ");
				for(Node child: removed.children) {
					queue.add(child);
				}
			} else {
				System.out.println();
				if(!queue.isEmpty()) {
					Node marker1 = new Node();
					marker1.data = -1;
					queue.add(marker1);
				}
			}
		}
	}

	public void lvlOrderLinewiseUsingCount(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int count = queue.size();
			for(int i = 0; i < count; i++) {
				//remove
				Node removed = queue.remove();
				//print (in the same line)
				System.out.print(removed.data + ", ");
				//add
				for(Node child : removed.children) {
					queue.add(child);
				}
			}
			System.out.println();
		}
	}

	public void lvlOrderLinewiseZigzag(Node root) {
		Stack<Node> mainStack = new Stack<>();
		Stack<Node> childStack = new Stack<>();
		mainStack.push(root);
		boolean isLeftToRight = true;
		while(!mainStack.isEmpty()) {
			//BFS -> RPA
			Node removed = mainStack.pop();
			System.out.print(removed.data + ", ");
			//add intelligently
			if(isLeftToRight) {
				for(Node child : removed.children) {
					childStack.push(child);
				}
			} else {
				for(int i = removed.children.size() - 1; i >= 0; i--) {
					childStack.push(removed.children.get(i));
				}
			}
			if(mainStack.isEmpty()) {
				System.out.println();
				mainStack = childStack;
				childStack = new Stack<>();
				isLeftToRight = !isLeftToRight;
			}
		}
	}

	public void linearize(Node root) {
		for(Node child : root.children) {
			linearize(child);
		}
		//recurisive-case:
		while(root.children.size() > 1) {
			//Remove and store the right most child
			Node rmc = root.children.remove(root.children.size() - 1);
			//Get the tail of SecondRightMost Child
			Node secondLastsTail = giveMeTail(root.children.get(root.children.size() - 1));
			//Build the links
			secondLastsTail.children.add(rmc);
		}
	}

	public Node giveMeTail(Node root) {
		while(root.children.size() != 0) {
			root = root.children.get(0);
		}
		return root;
	}

	public Node linearizeEfficient(Node root) {
		//base-case:
		if(root.children.size() == 0) {
			return root;
		}
		//recursive-case:
		for(int i = root.children.size() - 1; i >= 1; i--) {
			//Remove and Store RightMost child
			Node rmc = root.children.remove(root.children.size() - 1);
			//Get the tail of SecondRightMost child
			Node tailOfSecondLastChild = linearizeEfficient(root.children.get(root.children.size() - 1));
			//Build the link
			tailOfSecondLastChild.children.add(rmc);
		}
		return root;
	}

	public void removeLeaves(Node root) {
		//pre area
		/*
		 * For each loop can't support list modification while traversing
		 * Normal for loop, while traversing from left to right produce wrong result as the list shift the elements to left after delete
		 * Hence prefer using ListIterator or use Normal for loop but in reverse direction (right to left)
		 */
		for(int i = root.children.size() - 1; i >= 0; i--) {
			Node node = root.children.get(i);
			if(node.children.isEmpty()) {
				root.children.remove(node);
			}
		}
		for(Node child : root.children) {
			removeLeaves(child);
		}
	}

	public boolean findElement(Node root, int target) {
		if(root.data == target) {
			return true;
		}
		for(Node child : root.children) {
			boolean isFoundInSubtree = findElement(child, target);
			if(isFoundInSubtree) {
				return true;
			}
		}
		return false;
	}

	public List<Integer> nodeToRootPath(Node root, int target) {
		if(root.data == target) {
			return new ArrayList<>(List.of(root.data));
		}
		for(Node child : root.children) {
			List<Integer> pathTillMe = nodeToRootPath(child, target);
			if(!pathTillMe.isEmpty()) {
				pathTillMe.add(root.data);
				return pathTillMe;
			}
		}
		return new ArrayList<>();
	}

	public int lowestCommonAncestor(Node root, int n1, int n2) {
		List<Integer> path1 = nodeToRootPath(root, n1);
		List<Integer> path2 = nodeToRootPath(root, n2);

		int i = path1.size() - 1;
		int j = path2.size() - 1;

		while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
			i--;
			j--;
		}
		i++;
		return path1.get(i);
	}

	public int distBWTwoNodes(Node root, int n1, int n2) {
		List<Integer> path1 = nodeToRootPath(root, n1);
		List<Integer> path2 = nodeToRootPath(root, n2);

		int i = path1.size() - 1;
		int j = path2.size() - 1;

		while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;
		return i + j;
	}
	

	public boolean areSimilarShape(Node r1, Node r2) {
		//check the no.of children
		if(r1.children.size() != r2.children.size()) {
			return false;
		}

		for(int i = 0; i < r1.children.size(); i++) {
			//get a1
			Node a1 = r1.children.get(i);
			//get correspoding b1
			Node b1 = r2.children.get(i);
			boolean areStillSame = areSimilarShape(a1, b1);
			if(!areStillSame) {
				return false;
			}
		}

		return true;
	}

	public boolean areMirror(Node root1, Node root2) {
		//check if the no.of children are same
		if(root1.children.size() != root2.children.size()) {
			return false;
		}
		//call recursively for the children for tree1 left to right but for tree2 right to left
		for(int i = 0; i < root1.children.size(); i++) {
			//child of left tree
			Node leftTreeChild = root1.children.get(i);
			Node rightTreeChild = root2.children.get(root1.children.size() - i - 1);
			boolean areStillSame = areMirror(leftTreeChild, rightTreeChild);
			if(!areStillSame) {
				return false;
			}
		}
		return true;
	}

	private class Pair {
		Node node;
		int level;
		Pair(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}


	
	
	public static void main(String[] args) {
		//construction of a Generic Tree:
		int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		int[] arr2 = {1, 2, 3, -1, -1, 4, 5, -1, 6, 7, -1, 8, -1, -1, 9, -1, -1, 10, 11, -1, 12, -1, -1, -1};
		GenericTree tree = new GenericTree();
		tree.construct(arr);
		GenericTree tree2 = new GenericTree();
		tree2.construct(arr2);
		// tree.display(tree.root);
		// System.out.println(tree.size(tree.root));
		// System.out.println(tree.height(tree.root));
		// System.out.println(tree.max(tree.root));	
		// tree.traversal(tree.root);
		// tree.preOrder(tree.root);
		// tree.postOrder(tree.root);
		// tree.lvlOrderTraversal(tree.root);
		// tree.lvlOrderLinewise(tree.root);
		// tree.lvlOrderLinewiseUsingQueues(tree.root);
		// tree.lvlOrderLinewiseUsingMarkerNode(tree.root);
		// tree.lvlOrderLinewiseUsingCount(tree.root);
		// tree.lvlOrderLinewiseZigzag(tree.root);
		// tree.linearize(tree.root);
		// tree.linearizeEfficient(tree.root);
		// tree.removeLeaves(tree.root);
		// tree.lvlOrderLinewise(tree.root);
		// System.out.println(tree.findElement(tree.root, 110));
		// System.out.println(tree.findElement(tree.root, -1));
		// System.out.println(tree.nodeToRootPath(tree.root, 110));
		// System.out.println(tree.lowestCommonAncestor(tree.root, 110, 90));
		// System.out.println(tree.distBWTwoNodes(tree.root, 70, 110));
		// System.out.println(tree.areSimilarShape(tree.root, tree2.root));
		System.out.println(tree.areMirror(tree.root, tree2.root));

		
		
		
		
		
		
		
	}
}