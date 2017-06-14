//插入排序
public class SelectionSort {

	public static void main(String[] args) {
		int a[]={1,3,6,4,2,22};
		System.out.println("交换之前：");
		for(int num:a)
		{
			System.out.print(num+" ");
		}
		for(int i=0;i<a.length-1;i++)
		{
			int min=i;//最小元素索引
			for(int j=min+1;j<a.length;j++)//找出最小值的索引
			{
				if(a[j]<a[min])
				{
					min=j;
					
				}
				
			}
			
			System.out.println(min);
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
		System.out.println();
		System.out.println("排序之后:");
		for(int num:a)
		{
			System.out.print(num+" ");
		}

	}

}
