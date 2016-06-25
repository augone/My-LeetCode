class Solution {
	public static void main(String[] args )
	{
		String str = "123";
		sop(isAdditiveNumber(str));
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static boolean isAdditiveNumber(String num) {
        if(num.length() < 3)
			return false;
		//sop(num.substring(1));
		int Len = num.length();
		
		//sop(Long.parseLong(num.substring(1)));
		for(int i = 1; i < Len+1/2;i++)
		{
			String sub1 = num.substring(0,i);
			sop("sub1:"+sub1);
			if(i > 1&&sub1.startsWith("0"))
				return false;
				
			for(int j = 1, l = Len - i - j; l>=i&&l>=j&&j<Len; j++ )
			{
				if(!(l>=i&&l>=j))
					break;
				String sub2 = num.substring(i,i+j);
				sop("sub2:"+sub2);

				if(j>1&&sub2.startsWith("0"))
					break;
				Long num1 = Long.parseLong(sub1);
				Long num2 = Long.parseLong(sub2);
				if(isAdditive(num1,num2,num.substring(i+j)))
					return true;
			}
		}
		return false;
    }
	public static boolean isAdditive(Long num1, Long num2, String str)
	{
		if(str.equals(""))
			return true;
		sop("String is : "+str+"  length :"+str.length());
		Long num3 = num1 + num2;
		sop("num3:"+num3);
		String s = ((Long)num3).toString();
		if(str.startsWith(s))
			return isAdditive(num2,num3,str.substring(s.length()));
		return false;
	}
}