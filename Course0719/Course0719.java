import java.util.Arrays;
public class Course0719{
	
	public static void swap(int[] a,int i,int j){
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	
	//冒泡排序
	public static void bubbleSort(int[] a){
		for(int i=0;i<a.length;i++){
			// 无序 [0, a.length - i)
			// 有序 [a.length - i, a.length)
			// 冒泡过程
			boolean sorted=true;
			for(int j=1;j<a.length-i;j++){
				if(a[j]<a[j-1]){
					swap(a,j-1,j);
					sorted=false;
				}
				if(sorted==true){
					return;
				}
			}
		}
	}
	public static void bubbleSort2(int[] a){
		for(int i=0;i<a.length;i++){
			// 无序	[i, a.length)
			// 有序 [0, i)
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					swap(a,j,j-1);
				}
			}
		}
	}
	public static void testBubbleSort(int[] a){
		System.out.println("before:");
		System.out.println(Arrays.toString(a));
		bubbleSort2(a);
		System.out.println("after:");
		System.out.println(Arrays.toString(a));
	}
	
	//去掉最大值和最小值后，求平均值
	public static double average(int[] a){
		int sum=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int v:a){
			sum+=v;
			if(v>max){
				max=v;
			}
			if(v<min){
				min=v;
			}
		}
		return (double)(sum-min-max)/(a.length-2);
	}
	
	//偶在前，奇在后
	public static int[] sortArrayByParity(int[] a){
		int begin=0;
		int end=a.length-1;
		// [begin, end] 区间内的数是未判断的数
	    // [0, begin)	偶数
	    // [end, nums.length) 奇数
		while(begin<end){
			while(begin<end && a[begin]%2==0){
				begin++;
			}
			while(begin<end && a[end]%2!=0){
				end--;
			}
			swap(a,begin,end);
		}
		return a;
	}
	public static int[] sortArrayByParity2(int[] a){
		int d=0;
		for(int i=0;i<a.length;i++){
			if(a[i]%2==0){
				swap(a,i,d);
				d++;
			}
		}
		return a;
	}
	
	//旋转数组
	public static int[] rotate(int[] a,int k){
		k = k % a.length;
		int[] rightPart = Arrays.copyOfRange(a, a.length - k, a.length);
		//System.out.println(Arrays.toString(rightPart));
		System.arraycopy(a, 0, a, k, a.length - k);
		//System.out.println(Arrays.toString(a));
		System.arraycopy(rightPart, 0, a, 0, k);
		return a;
	}

	public static void main(String[] args){
		int[] a={1,4,5,2,8,6};

		testBubbleSort(a);
		System.out.println(average(a));
		System.out.println(Arrays.toString(sortArrayByParity2(a)));
		
		System.out.println(Arrays.toString(rotate(
			new int[] { 1, 2, 3, 4, 5 },
			3
		)));
		System.out.println(Arrays.toString(rotate(
			new int[] { 1, 2, 3, 4, 5 },
			8
		)));
		System.out.println(Arrays.toString(rotate(
			new int[] { 1, 2, 3, 4, 5, 6, 7 },
			8
		)));
		System.out.println(Arrays.toString(rotate(
			new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9},
			8
		)));
	}
}
