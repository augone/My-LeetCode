import java.util.*;
class CountNumberswithUniqueDigits
{
	public static void main(String[] args )
	{
		int result = count(3);
		sop("result is "+ result);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int count(int input)
	{
		int result = 0;
		int upper = input>10?10:input;
		for(int i = 0 ; i <= upper; i++)
		{
			if(i == 0)
				result += 1;
			else if (i == 1)
				result += 9 ;
			else result += 9*factorial(i-1);
			sop(result);
		}
		return result;
	}
	public static int factorial(int input)
	{
		int result = 1;
		int i=9;
		while(input !=0)
		{
			result *= i--;
			input--;
		}
		return result;
	}
}