
//时间复杂度O(logN)

public class BinarySearch
{

	public static void main(String[] args)
	{
//			int[] nums = {1,2,3,5,5,6,7,8,9,10};
//
//			char[] letters = {'c','d','e'};
//
//			char s = nextGreatestLetter(letters, 'b');
//			System.out.println(s);
//			int index = binarySearch_1(nums,5);//程序运行后不能结束
//			System.out.println(index);
//				int[] nums = {1,1,2,2,3,3,4,4,5,5,8};
//			 int single = singleNonDuplicate(nums);
//			 System.out.println(single);
//				int nums[] = {3,4,5,2};
//					int a =  findMin(nums);
//			 	System.out.println(a);
			int[] nums = {5,7,7,8,8,10};
			int[] arr = searchRange(nums,6);
			for(int s : arr)
				System.out.print(s+"\t");
	}
	public static int binarySearch_1(int[] nums,int key)
	{
		int  s = 0, h = nums.length - 1;
		while(s < h)
		{
			int m = s + (h-1)/2; // mid = (s + h) / 2 可能出现加法溢出
			if(nums[m] >= key)
				h = m;
			else
				s = m + 1;
		}
		return s;//如果没有找到，插入到相应的位置的索引

}
	public static int binarySearch(int[] nums,int key)
	{
		int  s = 0, h = nums.length - 1;
		while(s <= h)
		{
			int m = s + (h-1)/2; // mid = (s + h) / 2 可能出现加法溢出
			if(nums[m] == key)
				return m;
			else if(nums[m] > key)
				h = m - 1;
			else
				s = m + 1;
		}
		return s;//如果没有找到，插入到相应的位置的索引
	}
	//二分查找可以有很多变种，变种实现要多注意边界值的判断。例如在一个有重复元素的数组中查找 key 的最左位置的实现如下：

	//题目描述：给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符。letters 字符数组是循环数组。
	public static char nextGreatestLetter(char[] letters, char target)
	{
			int n = letters.length;
			int l = 0,h = n -1;
			while( l <= h)
			{
				int m = l + (h-1) / 2;
				if(letters[m] <= target)
					l = m + 1;
				else
					h = m - 1;
			}
			return l < n ? letters[l] : letters[0];

	}
	/*
	题目描述：一个有序数组只有一个数不出现两次，找出这个数。要求以 O(logN) 时间复杂度进行求解。
	令 key 为 Single Element 在数组中的位置。如果 m 为偶数，并且 m + 1 < key，那么 nums[m] == nums[m + 1]；m + 1 >= key，那么 nums[m] != nums[m + 1]。
	从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 key 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么 key 所在的数组位置为 [l, m]，此时令 h = m。
	因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
	*/
	public static int singleNonDuplicate(int[] nums)
	{
			int l = 0,h = nums.length - 1;
			while(l < h)
			{
				int m = (l+h) / 2;
				if(m % 2 == 1)
					m--;//保证l/h/m都在偶数位，使得查找区间大小一直都是奇数
				if(nums[m] == nums[m+1])
					 l = m + 2;
				else
					h = m;
			}
			return nums[l];
	}
			/*'
			题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。
		如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1。
		因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
		*/
		public int firstBadVersion(int n)
		{
				int l = 1,h = n;
				while(l < h)
				{
					int mid = (l + h) / 2;
				//	if(isBadVersion(mid))
						h = mid;
				//	else
					 l = mid + 1;

				}
				return l;
		}

	/*
	xuan转数组的最小数字:html Input: [3,4,5,1,2], Output: 1
	*/
	public static int findMin(int[] nums)
	{
			int l = 0,h = nums.length - 1;
			while(l < h)
			{
				int m = (l + h) / 2;

				if(nums[m] <= nums[h])
						h = m;
				else
					l = m + 1;
			}
			return nums[l];
	}
	
	/*
	查找区间
```html Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1] ```
*/

	public static int[] searchRange(int[] nums,int target)
	{
			int first = binarySearch_2(nums,target);
			int last = binarySearch_2(nums,target + 1) - 1;
			if(first == nums.length || nums[first]!=target)
				return new int[]{-1,-1};
			else
				return new int[]{first,Math.max(first,last)};
	}
	private static int binarySearch_2(int[] nums,int target)
	{
		int l = 0, h = nums.length - 1;//注意h的初始值
		while(l < h)
		{
			int m = (l + h) / 2;
			if(nums[m] >= target)
				h = m;
			else
				l = m + 1;	
		}	
		return l;
	}
}

