
public class BubbleSort {
	public static void main(String[] args)
	{
		int a[]={1,3,6,4,19,2};
		System.out.println("交换之前：");
		for(int num:a)
		{
			System.out.print(num+" ");
		}
		for(int i=0;i<a.length-1;i++)
		{
			boolean flag=true;
			while(flag)
			{
				for(int j=0;j<a.length-1-i;j++)
				{
					if(a[j]>a[j+1])
					{
						int temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
					else
					{
						flag=false;
					}
				}
			}
			
		}
		System.out.println();
		System.out.println("排序之后:");
		for(int num:a)
		{
			System.out.print(num+" ");
		}
	}
			
}
