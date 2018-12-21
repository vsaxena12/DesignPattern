package genericCheckpointing.visitor;

import java.util.Vector;

public class PrimeVisitorImpl implements VisitorI
{
	private Integer[] numbers;

	public PrimeVisitorImpl(Vector<Integer> intVector)
	{
		this.numbers = new Integer[intVector.size()];

		for(int i=0; i< intVector.size(); i++)
		{
			numbers[i] = intVector.get(i);
		}
	}

	public boolean isPrime(int num)
	{
		int m = 0, flag = 0;

		m = num/2;

		if(num == 0 || num == 1)
		{
			return false;
		}
		else
		{
			for(int i = 2; i <= m; i++)
			{
				if(num%i == 0)
				{
					flag = 1;
					break;
				}
			}
			if(flag == 0)
			{
				return true;
			}
		}
		return false;

	}

	@Override
	public Integer checkVisitorPattern()
	{
		int count = 0;

		for (int i = 0; i < this.numbers.length; i++)
		{
			if (isPrime(this.numbers[i]))
				count++;
		}
		return count;
	}

}
