
public class InsertSort {
	public static void main(String[] args)
	{
		int a[]={1,3,6,4,19,2};
		System.out.println("交换之前：");
		for(int num:a)
		{
			System.out.print(num+" ");
		}
		 
		//因为第一个已经拿出来，要从第二个开始比较，所以直接从i=1开始，
		//整个过程可以看作是从无序队列往有序队列里放数的过程
		
		//无序队列
		for(int i=1;i<a.length;i++)
		{
			int j;
			int temp=a[i];
			//有序队列
			for(j=i-1;j>=0&&temp<a[j];j--)
			{
				//如果无序队列新加入的数比有序队列里面最后一个数小，则最后一个数向右移动一个
				//如果新加入的数比最后一个数还大，就不用和前面的数比较了
				a[j+1]=a[j];
			}
			//如果无序队列新加入的数比有序队列里面左后一个数大，则新加入的数直接排在最后面
			a[j+1]=temp;
		}
		
		System.out.println();
		System.out.println("排序之后:");
		for(int num:a)
		{
			System.out.print(num+" ");
		}
	}
}
