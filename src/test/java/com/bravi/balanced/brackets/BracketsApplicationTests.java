package com.bravi.balanced.brackets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BracketsApplicationTests {

	@Autowired
	Balanced balanced;
	String sequence;

	@Test
	public void contextLoads() {
	}

	//tests with
	//Examples:
	//● (){}[] is valid
	//● [{()}](){} is valid
	//● []{() is not valid
	//● [{)] is not valid

	@Test
	public void testValidExampleOne(){
		sequence = "(){}[]";
		assertTrue(balanced.isBalanced(sequence));
	}

	@Test
	public void tesValidtExampleTwo(){
		sequence = "[{()}](){}";
		assertTrue(balanced.isBalanced(sequence));
	}

	@Test
	public void testInvalidExampleThree(){
		sequence = "[]{()";
		assertFalse(balanced.isBalanced(sequence));
	}

	@Test
	public void testInvalidExampleFour(){
		sequence = "[{)]";
		assertFalse(balanced.isBalanced(sequence));
	}

	//tests with valid sentences
	@Test
	public void testValidSequenceOne(){
		sequence = "()";
		assertTrue(balanced.isBalanced(sequence));
	}

	@Test
	public void testValidSequenceTwo(){
		sequence = "[[]]";
		assertTrue(balanced.isBalanced(sequence));
	}

	@Test
	public void testValidSequenceThree(){
		sequence = "{{{}}}";
		assertTrue(balanced.isBalanced(sequence));
	}

	@Test
	public void testValidSequenceFour(){
		sequence = "[[[[]]]]";
		assertTrue(balanced.isBalanced(sequence));
	}

	@Test
	public void testValidSequenceFive(){
		sequence = "{{[[(())]]}}";
		assertTrue(balanced.isBalanced(sequence));
	}

	@Test
	public void testValidSequenceSix(){
		sequence = "{{[[((()()()[][][]))]]}}";
		assertTrue(balanced.isBalanced(sequence));
	}

	//Tests with invalid sentences

	@Test
	public void testInalidSequenceOne(){
		sequence = "(";
		assertFalse(balanced.isBalanced(sequence));
	}

	@Test
	public void testInalidSequenceTwo(){
		sequence = "[}";
		assertFalse(balanced.isBalanced(sequence));
	}

	@Test
	public void testInalidSequenceThree(){
		sequence = "{{[]})";
		assertFalse(balanced.isBalanced(sequence));
	}



}
