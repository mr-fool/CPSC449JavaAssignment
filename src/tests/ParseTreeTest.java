package tests;

import static org.junit.Assert.*;

import org.ParseTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParseTreeTest {
	
	ParseTree tree;

	public ParseTreeTest() {
	}

	@Before
	public void setUp() throws Exception {
		tree = new ParseTree();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_1_simpleNode() {
		growLeaf("5");
		assertEquals("5", tree.toString());
	}
	
	@Test
	public void test_2_rootWithTwoLeaves() {
		growNodeWithTwoLeaves("add", "5", "2");
		assertEquals("add52", tree.toString());
	}
	
	@Test
	public void test_3_rootWithOneLeafAndOneArgWithTwoLeaves() {
		growNode("add");
		growLeaf("2");
		growNodeWithTwoLeaves("mult", "5", "5");
		assertEquals("add2mult55", tree.toString());
	}
	
	@Test
	public void test_4_rootWothOneArgWithTwoLeavesAndOneLeaf() {
		growNodeWithLeftNode("add", "mult");
		growLeaf("2");
		growLeaf("5");
		growLeaf("5");
		assertEquals("addmult255", tree.toString());
	}
	
	@Test
	public void test_5_rootWithTwoArgumentsWithLeavesOrSubArguments() {
		growNodeWithLeftNode("add", "mult");
		growNodeWithTwoLeaves("sub", "2", "2");
		growLeaf("5");
		growNodeWithLeftNode("add", "add");
		growLeaf("5");
		growLeaf("5");
		growLeaf("2");
		assertEquals("addmultsub225addadd552", tree.toString());
	}
	
	@Test
	public void test_6_rootWithTwoArgumentsWithLeavesOrSubArguments() {
		growNodeWithLeftNode("add", "mult");
		growLeaf("5");
		growNodeWithTwoLeaves("sub", "2", "2");
		growNodeWithLeftLeafAndRightNode("add", "2", "add");
		growLeaf("5");
		growLeaf("5");
		assertEquals("addmult5sub22add2add55", tree.toString());
	}
	
	@Test
	public void test_7_rootWithTwoArgumentsWithLeavesOrSubArguments() {
		growNodeWithLeftNode("add", "mult");
		growNodeWithTwoLeaves("sub", "5", "5");
		growNodeWithTwoLeaves("sub", "2", "2");
		growNodeWithLeftLeafAndRightNode("add", "2", "add");
		growLeaf("5");
		growLeaf("5");
		assertEquals("addmultsub55sub22add2add55", tree.toString());
	}
	
	@Test
	public void test_7c_rootWithTwoArgumentsWithLeavesOrSubArguments() {
		growNodeWithLeftNode("add", "mult");
		growNodeWithTwoLeaves("sub", "5", "5");
		growNodeWithTwoLeaves("sub", "2", "2");
		growNodeWithLeftLeafAndRightNode("add", "2", "add");
		growLeaf("5");
		growLeaf("5");
		assertEquals("addmultsub55sub22add2add55", tree.toString());
	}
	
	@Test
	public void test_8_rootWithTwoArgumentsWithLeavesOrSubArguments() {
		growNodeWithLeftNode("add", "mult");
		growNodeWithTwoLeaves("sub", "5", "5");
		growNodeWithTwoLeaves("sub", "2", "2");
		growNodeWithLeftNode("add", "sub");
		growLeaf("5");
		growLeaf("2");
		growNodeWithTwoLeaves("add", "5", "5");
		assertEquals("addmultsub55sub22addsub52add55", tree.toString());
	}
	
	@Test
	public void test_8c_rootWithTwoArgumentsWithLeavesOrSubArguments() {
		growNodeWithLeftNode("add", "mult");
		growNodeWithTwoLeaves("sub", "5", "5");
		growNodeWithTwoLeaves("sub", "2", "2");
		growNodeWithLeftNode("add", "sub");
		growLeaf("5");
		growLeaf("2");
		growNodeWithTwoLeaves("add", "5", "5");
		assertTrue(tree.isComplete());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_9_invalidDoubleNode() {
		growLeaves("5", "5");
		System.out.println(tree.toString());
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
