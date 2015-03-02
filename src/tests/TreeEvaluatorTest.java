package tests;

import static org.junit.Assert.*;

import org.ParseTree;
import org.TreeEvaluator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TreeEvaluatorTest {

	private ParseTree tree;
	private TreeEvaluator eval;
	
	public TreeEvaluatorTest() {
	}

	@Before
	public void setUp() throws Exception {
		tree = new ParseTree();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_1_SimpleRootNode() {
		growLeaf("5");
	}
	
	
	private void growLeaf(String leaf) {
		tree.grow(leaf);
	}
	
	private void growLeaves(String leaf1, String leaf2) {
		tree.grow(leaf1);
		tree.grow(leaf2);
	}
	
	private void growNode(String arg) {
		tree.grow(arg);
	}
	
	private void growNodeWithTwoLeaves(String node, String leaf1, String leaf2) {
		tree.grow(node);
		tree.grow(leaf1);
		tree.grow(leaf2);
	}
	
	private void growNodeWithLeftLeafAndRightNode(String node1, String leaf, String node2) {
		tree.grow(node1);
		tree.grow(leaf);
		tree.grow(node2);
	}
	
	private void growNodeWithLeftNode(String node1, String node2) {
		tree.grow(node1);
		tree.grow(node2);
	}

}
