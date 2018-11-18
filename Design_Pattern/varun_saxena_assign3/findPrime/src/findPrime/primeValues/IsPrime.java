package findPrime.primeValues;

public class IsPrime
{
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
}
