public class YahtzeeSortDice
{
	int first;
	int second;
	int third;
	int fourth;
	int fifth;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int a, int b, int c, int d, int e)
	{
		int f; //variable store die value that is to be moved back in order

		if (a > b)
		{
			f = b;
			b = a;
			a = f;
		}
		if (c < a)
		{
			f = c;
			c = b;
			b = a;
			a = f;
		}
		else if (c < b)
		{
			f = c;
			c = b;
			b = f;
		}

		if (d < a)
		{
			f = d;
			d = c;
			c = b;
			b = a;
			a = f;
		}
		else if (d < b)
		{
			f = d;
			d = c;
			c = b;
			b = f;
		}
		else if (d < c)
		{
			f = d;
			d = c;
			c = f;
		}
		if (e < a)
		{
			f = e;
			e = d;
			d = c;
			c = b;
			b = a;
			a = f;
		}
		else if (e < b)
		{
			f = e;
			e = d;
			d = c;
			c = b;
			b = f;
		}
		else if (e < c)
		{
			f = e;
			e = d;
			d = c;
			c = f;
		}
		else if (e < d)
		{
			f = e;
			e = d;
			d = f;
		}


		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
	}

	/* returns the minimum of the five numbers */
	public int getFirst()
	{
		return first;
	}

	/* returns the second smallest of the five number */
	public int getSecond()
	{
		return second;
	}

	/* returns the middle of the five numbers */
	public int getThird()
	{
		return third;
	}

	/* returns the second largest of the five numbers */
	public int getFourth()
	{
		return fourth;
	}

	/* returns the biggest of the five numbers */
	public int getFifth()
	{
		return fifth;
	}
}