package assignment2.task1;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2018/02/04 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	public int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	public int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */

	public int acessCounter = 0;

	public char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	public int getAccessCounter() {
		return acessCounter;
	}

	public int getISize() {
		return iSize;
	}

	public int getITop() {
		return iTop;
	}

	public boolean isEmpty()
	{
		return (this.iTop == -1);
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		acessCounter++;
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		acessCounter++;
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock)
	{
		acessCounter++;
		this.acStack[++this.iTop] = pcBlock;
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop()
	{
		acessCounter++;
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		return cBlock;
	}
}

// EOF
