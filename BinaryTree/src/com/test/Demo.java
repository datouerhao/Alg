package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Demo {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		/*
		 * System.out.println(getNumRec(t1));//1.1
		 * System.out.println(getNodeNum(t1));//1.2
		 * System.out.println(getDepthRec(t1)); //2 preOrder(t1);//3.1
		 * System.out.println(); preorderTraversal(t1); System.out.println();
		 * inOrder(t1); //3.2 System.out.println(); postOrder(t1);//3.3
		 * System.out.println(); levelTraversal(t1); //4 convert1(t1);
		 * 
		 * TreeNode tmp = convertBST2DLL(t1); while (true) { if (tmp == null) {
		 * break; } System.out.print(tmp.val + " "); if (tmp.right == null) {
		 * break; } tmp = tmp.right; }
		 */
		// System.out.println(getNodeNumLeafRec(t1));//7.1
		// System.out.println(isAVLRec(t1));
		// System.out.println(getLastCommonParentRec(t1, t4, t5).val);//11.1
		// System.out.println(getLastCommonParentRec2(t1, t4, t5).val);// 11.2
		// System.out.println(getMaxDistanceRec(t1).maxDistance);// 12
		// System.out.println(isCompleteBineryTree(t1));//13
	}

	/*
	 * 1.1 ��������еĽڵ�����ݹ�ⷨ�� O(n) ��1�����������Ϊ�գ��ڵ����Ϊ0 ��2�������������Ϊ�գ��������ڵ���� = �������ڵ����
	 * + �������ڵ���� + 1
	 */
	public static int getNumRec(TreeNode root) {
		if (root == null)
			return 0;
		else
			return getNumRec(root.left) + getNumRec(root.right) + 1;
	}

	/**
	 * 1.2 ��������еĽڵ���������ⷨO(n)������˼��ͬLevelOrderTraversal��
	 * ����һ��Queue����Java���������LinkedList��ģ��
	 */
	public static int getNodeNum(TreeNode root) {
		if (root == null)
			return 0;
		int count = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();// �Ӷ�ͷλ���Ƴ�
			if (cur.left != null) {
				queue.add(cur.left);// ��������ӣ��ӵ���β
				count++;
			}
			if (cur.right != null) {
				queue.add(cur.right);// ������Һ��ӣ��ӵ���β
				count++;
			}
		}
		return count;
	}
	/*
	 * 2���������ȣ��ݹ�ⷨO(n) (1)���Ϊ�գ��򷵻�0 ��2�������Ϊ�գ����������Ϊmax����������ȣ���������ȣ�+1
	 */

	public static int getDepthRec(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = getDepthRec(root.left);
		int rightDepth = getDepthRec(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	// 3.1 ǰ������ݹ�ⷨ
	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		else {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	// 3.1ǰ����������ⷨ
	public static void preorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>(); // ����stack
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop(); // ��ջջ��Ԫ��
			System.out.print(cur.val + " ");

			// �ؼ��㣺Ҫ��ѹ���Һ��ӣ���ѹ�����ӣ������ڳ�ջʱ���ȴ�ӡ�����ٴ�ӡ�Һ���
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// 3.2��������ݹ�ⷨ
	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		else {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	// 3.3 ��������ݹ�ⷨ
	public static void postOrder(TreeNode root) {
		if (root == null)
			return;
		else {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val + " ");
		}
	}

	// 4�ֲ�����������������ⷨ��traversal��Ϊ����
	public static void levelTraversal(TreeNode root) {
		if (root == null)
			return;
		else {
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.push(root);// ��������
			while (!queue.isEmpty()) {
				TreeNode cur = queue.removeFirst();// ����ͷ�����Ƴ���ӡ
				System.out.print(cur.val + " ");
				if (cur.left != null)// ����Ƴ����������Ӵ��ڣ����Ƚ���
					queue.add(cur.left);
				if (cur.right != null)// ����Ƴ��������ֺ���Ҳ���ڣ���Ҳ���Ž��ӣ���֤��ÿ���Ǵ����ұ���
					queue.add(cur.right);
			}
		}
	}

	/*
	 * 5.1�������������Ϊ�����˫������ Ҫ���ܴ����½ڵ㣬ֻ����ָ��.root�����������м�λ�ã����Ҫ�ֶ� ��root�Ƶ�����ͷ������β
	 * �ݹ�ⷨ
	 */
	public static TreeNode convert1(TreeNode root) {
		root = convert2(root);
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static TreeNode convert2(TreeNode root) {
		if (root == null || (root.left == null) && (root.right == null))
			return root;
		TreeNode current = null;
		if (root.left != null)// ����������
		{
			current = convert2(root.left);
			while (current.right != null)// Ѱ�����ҽڵ�
			{
				current = current.right;
			}
			current.right = root;// ���������ұ���root����
			root.left = current;
		}
		if (root.right != null) {// ����������
			current = convert2(root.right);
			while (current.left != null) {
				current = current.left;
			}
			current.left = root;// �������������root����
			root.right = current;
		}
		return root;
	}

	// 5.2����������Ϊ�����˫���б��� �����ⷨ
	public static TreeNode convertBST2DLL(TreeNode root) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root; // ָ��ǰ�����ڵ�
		TreeNode old = null; // ָ��ǰһ�������Ľڵ�
		TreeNode head = null; // ����ͷ

		while (true) {
			while (cur != null) { // ������һ���ǿսڵ����е����ӵ�ջ
				stack.push(cur);
				cur = cur.left;
			}

			if (stack.isEmpty()) {
				break;
			}

			// ��Ϊ��ʱ�Ѿ�û�������ˣ��������ջ��Ԫ��
			cur = stack.pop();
			if (old != null) {
				old.right = cur;
			}
			if (head == null) { // /��һ���ڵ�Ϊ˫������ͷ�ڵ�
				head = cur;
			}

			old = cur; // ����old
			cur = cur.right; // ׼������������
		}

		return head;
	}

	/**
	 * 6.1���������K��Ľڵ���� �ݹ�ⷨ�� ��1�����������Ϊ�ջ���k<1����0 ��2�������������Ϊ�ղ���k==1������1
	 * ��3�������������Ϊ����k>1������root��������k-1��Ľڵ������root������k-1��ڵ����֮��
	 * 
	 * ����rootΪ����k��ڵ���Ŀ �ȼ��� ����root����Ϊ����k-1�㣨��Ϊ����root��һ�㣩�ڵ���Ŀ ����
	 * ��root�Һ���Ϊ����k-1�㣨��Ϊ����root��һ�㣩�ڵ���Ŀ
	 * 
	 * �������������Ȱ���������������������������⽵��
	 * 
	 */
	public static int getNodeNumKthLevelRec(TreeNode root, int k) {
		if (root == null || k < 1)
			return 0;
		if (k == 1)
			return 1;
		int numLeft = getNodeNumKthLevelRec(root.left, k - 1);
		int numRight = getNodeNumKthLevelRec(root.right, k - 1);
		return numLeft + numRight;
	}

	/**
	 * 7.1���������Ҷ�ӽڵ�ĸ������ݹ飩
	 */
	public static int getNodeNumLeafRec(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
	}

	/**
	 * 8.1�ж����ö������Ƿ���ͬ������ �ݹ�ⷨ�� ��1��������ö�������Ϊ�գ������� ��2��������ö�����һ��Ϊ�գ���һ�ò�Ϊ�գ����ؼ�
	 * ��3��������ö���������Ϊ�գ������Ӧ������������������ͬ�������棬�������ؼ�
	 */
	public boolean isSameRec(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		else if (t1 == null || t2 == null)
			return false;
		if (t1.val != t2.val)
			return false;
		boolean leftSame = isSameRec(t1.left, t2.left);
		boolean rightSame = isSameRec(t1.right, t2.right);
		return leftSame && rightSame;
	}

	/**
	 * 9.1�ж϶������ǲ���ƽ������� �ݹ�ⷨ�� ��1�����������Ϊ�գ�������
	 * ��2�������������Ϊ�գ����������������������AVL���������������������߶�������1�������棬�������ؼ�
	 */
	public static boolean isAVLRec(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(getDepthRec(root.left) - getDepthRec(root.right)) > 1) {
			return false;
		}
		return isAVLRec(root.left) && isAVLRec(root.right);
	}

	/**
	 * 10��������ľ��� �ݹ�ⷨ�� ��1�����������Ϊ�գ����ؿ� ��2�������������Ϊ�գ������������������ľ���Ȼ�󽻻���������������
	 */
	// �ƻ�ԭ����������ԭ�������ĳ��侵��
	public static TreeNode mirrorRec(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = mirrorRec(root.left);
		TreeNode right = mirrorRec(root.right);
		root.left = right;// �������ɵ�����������������
		root.right = left;// �������ɵ�����������������
		return root;
	}

	// ���ƻ�ԭ���ģ�����һ���¾�����
	public static TreeNode mirrorCopyRec(TreeNode root) {
		if (root == null)
			return null;
		TreeNode newNode = new TreeNode(root.val);
		newNode.left = mirrorCopyRec(root.right);
		newNode.right = mirrorCopyRec(root.left);
		return newNode;
	}

	// �ж��������Ƿ��໥����
	public static boolean isMirrorRec(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		else if (t1 == null || t2 == null)
			return false;
		if (t1.val != t2.val)
			return false;// �����������Ϊ�ǿ������ȱȽϸ��ڵ�
		return isMirrorRec(t1.left, t2.right) && isMirrorRec(t1.right, t2.left);
	}

	/**
	 * 11��������������ڵ����͹������Ƚڵ� �ݹ�ⷨ�� ��1����������ڵ�ֱ��ڸ��ڵ�������������������򷵻ظ��ڵ�
	 * ��2����������ڵ㶼������������ݹ鴦������������������ڵ㶼������������ݹ鴦��������
	 */
	// ����һ11.1��Ҫ��������İ�������findNodeRec����
	public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
		if (findNodeRec(root.left, n1)) {
			if (findNodeRec(root.right, n2)) {
				return root;// ���һ��������������һ�������������֣��򷵻ظ��ڵ�
			} else {
				return getLastCommonParentRec(root.left, n1, n2);// �����������������������ȥ������Ѱ�ҹ������Ƚڵ�
			}

		} else {// ���n1��������
			if (findNodeRec(root.left, n1)) {
				return root;
			} else {
				return getLastCommonParentRec(root.right, n1, n2);
			}
		}
	}

	// �����������ж�һ���ڵ��Ƿ�������
	private static boolean findNodeRec(TreeNode root, TreeNode node) {
		if (root == null || node == null)
			return false;
		if (node == root)
			return true;
		boolean found = findNodeRec(root.left, node);
		if (!found) {
			found = findNodeRec(root.right, node);
		}
		return found;
	}

	// ��������11.2
	public static TreeNode getLastCommonParentRec2(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null)
			return null;
		if (root.equals(n1) || root.equals(n2))
			return root;
		TreeNode commonInLeft = getLastCommonParentRec2(root.left, n1, n2);
		TreeNode commonInRight = getLastCommonParentRec2(root.right, n1, n2);
		if (commonInLeft != null && commonInRight != null)
			return root;
		if (commonInLeft != null) {
			return commonInLeft;
		} else {
			return commonInRight;
		}
	}

	/**
	 * 12��������нڵ�������� ���������������Զ�������ڵ�֮��ľ��롣 (distance / diameter) �ݹ�ⷨ��
	 * ��1�����������Ϊ�գ�����0��ͬʱ��¼������������������ȣ���Ϊ0
	 * ��2�������������Ϊ�գ�������Ҫô���������е������룬Ҫô���������е������룬
	 * Ҫô���������ڵ��е����ڵ��������+�������ڵ��е����ڵ�������룬 ͬʱ��¼���������������ڵ��е����ڵ�������롣
	 * 
	 * http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html
	 * 
	 * ����һ�������������������������:
	 * 
	 * ���A: ·������������������ڵ㣬ͨ�����ڵ㣬�ٵ�������������ڵ㡣 ���B: ·�����������ڵ㣬��������������������������·����ȡ����ߡ�
	 * ֻ��Ҫ���������������·�����룬��ȡ����ߣ����Ǹö�������������
	 */

	public static Result getMaxDistanceRec(TreeNode root) {
		if (root == null) {
			Result empty = new Result(0, -1);// Ŀ�����õ��÷� +1 �󣬰ѵ�ǰ�Ĳ����ڵ� (NULL)
												// ��������������Ϊ 0 ����̫���⣿��������
			return empty;
		}
		Result lmd = getMaxDistanceRec(root.left);// ������������
		Result rmd = getMaxDistanceRec(root.right);// ������������
		Result res = new Result();
		res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;// ��ǰ������
		// A��Ϊ�����������ȼ��������������ȣ�Ȼ���ټ���ͨ�����ڵ�������ߣ���2
		res.maxDistance = Math.max(lmd.maxDepth + rmd.maxDepth + 2, Math.max(lmd.maxDistance, rmd.maxDistance));// ǰ��һ��Ϊ���A,����һ��Ϊ���B
		return res;
	}

	private static class Result {
		int maxDistance;
		int maxDepth;

		public Result() {

		}

		public Result(int maxDistance, int maxDepth) {
			this.maxDistance = maxDistance;
			this.maxDepth = maxDepth;
		}
	}

	/**
	 * 13. �ж϶������ǲ�����ȫ�������������� ��������������Ϊh������ h ���⣬�������� (1��h-1) �Ľ�������ﵽ�������� �� h
	 * �����еĽ�㶼��������������ߣ��������ȫ�������� �������㷨������Σ����ϵ��£������ң�������������������һ���ڵ��������Ϊ��ʱ��
	 * ��ýڵ�����������Ϊ�գ��Һ�������Ľڵ���������������Ϊ�գ���������ȫ��������
	 */
	public static boolean isCompleteBineryTree(TreeNode root) {
		if (root == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean mustHaveNoChild = false;
		boolean result = true;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			if (mustHaveNoChild) {// ����Ҷ�ӽڵ㣬����������������Ϊnull
				if (cur.left != null || cur.right != null) {
					result = false;// ֻҪ������������������Ϊ�գ��򷵻�false
					break;
				}
			} else {
				// ��������������Ϊ�����������
				if (cur.left != null && cur.right != null) {
					queue.add(cur.left);
					queue.add(cur.right);
				}
				// ��������Ϊ��������Ϊ�գ���˵�����ֿսڵ㣬�Ժ����Ϊ�սڵ㣬��������������
				if (cur.left != null && cur.right == null) {
					mustHaveNoChild = true;
					queue.add(cur.left);
				}
				// ������Ϊ�գ���������Ϊ��˵��������ȫ������������false
				if (cur.left == null && cur.right != null) {
					result = false;
					break;
				} // ��������������Ϊ�գ���˵��û���ӽڵ�
				else {
					mustHaveNoChild = true;
				}
			}
		}
		return result;
	}

	/**
	 * 14. ��ǰ��������к�������������ؽ����������ݹ飩 �о���ƪ�ǽ�����Ϊ������:
	 * http://crackinterviewtoday.wordpress.com/2010/03/15/rebuild-a-binary-tree
	 * -from-inorder-and-preorder-traversals/ ���л��ᵽһ�ֱ��⿪����ռ�ķ��������´β���
	 */
	public static TreeNode rebuildBinaryTreeRec(List<Integer> PreOrder, List<Integer> InOrder) {
		TreeNode root = null;
		List<Integer> leftPredOrder;// �������������
		List<Integer> lefInOrder;// �������������
		List<Integer> rightPredOrder;// �������������
		List<Integer> rightInOrder;// �������������
		int inorderPos;
		int preorderPos;
		if (PreOrder.size() != 0 && InOrder.size() != 0) {
			root = new TreeNode(PreOrder.get(0));// ��������и��ڵ�Ϊ��һ��
			inorderPos = InOrder.indexOf(PreOrder.get(0));// �ҳ�������������������ķָ��
			lefInOrder = InOrder.subList(0, inorderPos);
			rightInOrder = InOrder.subList(inorderPos + 1, InOrder.size());
			preorderPos = lefInOrder.size();// ������������������ķָ�㣬��������������������Ĵ�С
			leftPredOrder = PreOrder.subList(1, preorderPos);
			rightPredOrder = PreOrder.subList(preorderPos + 1, PreOrder.size());
			root.left = rebuildBinaryTreeRec(leftPredOrder, lefInOrder);// ���������������������γɵ�
			root.right = rebuildBinaryTreeRec(rightPredOrder, rightInOrder);// ���������������������γɵ�
		}
		return root;
	}
}