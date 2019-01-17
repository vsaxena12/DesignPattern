package genericCheckpointing.visitor;

import java.util.Vector;

public class PalindromVisitorImpl implements VisitorI
{
	private Vector<String> inputString;

	public PalindromVisitorImpl(Vector<String> inStr)
	{
		this.inputString = inStr;
	}

	public boolean isPalindrome(String str)
	{
		String inputString;

		inputString = str;

		int length  = inputString.length();
		int i, begin, end, middle;

		begin  = 0;
		end    = length - 1;
		middle = (begin + end)/2;

		for (i = begin; i <= middle; i++) {
			if (inputString.charAt(begin) == inputString.charAt(end)) {
				begin++;
				end--;
			}
			else {
				break;
			}
		}
		if (i == middle + 1) {
			System.out.println("Palindrome");
			return true;
		}
		else {
			System.out.println("Not a palindrome");
			return false;
		}
	}

	@Override
	public Vector<String> checkVisitorPattern()
	{
		Vector<String> palindromeStrings = new Vector<>();

		for (int i = 0; i < this.inputString.size(); i++)
		{
			if (isPalindrome(this.inputString.elementAt(i)))
			{
				palindromeStrings.add(this.inputString.elementAt(i));
			}
		}
		return palindromeStrings;
	}
}
