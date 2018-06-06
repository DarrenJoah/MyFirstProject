
//ʱ�临�Ӷ�O(logN)

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
//			int index = binarySearch_1(nums,5);//�������к��ܽ���
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
			int m = s + (h-1)/2; // mid = (s + h) / 2 ���ܳ��ּӷ����
			if(nums[m] >= key)
				h = m;
			else
				s = m + 1;
		}
		return s;//���û���ҵ������뵽��Ӧ��λ�õ�����

}
	public static int binarySearch(int[] nums,int key)
	{
		int  s = 0, h = nums.length - 1;
		while(s <= h)
		{
			int m = s + (h-1)/2; // mid = (s + h) / 2 ���ܳ��ּӷ����
			if(nums[m] == key)
				return m;
			else if(nums[m] > key)
				h = m - 1;
			else
				s = m + 1;
		}
		return s;//���û���ҵ������뵽��Ӧ��λ�õ�����
	}
	//���ֲ��ҿ����кܶ���֣�����ʵ��Ҫ��ע��߽�ֵ���жϡ�������һ�����ظ�Ԫ�ص������в��� key ������λ�õ�ʵ�����£�

	//��Ŀ����������һ��������ַ����� letters ��һ���ַ� target��Ҫ���ҳ� letters �д��� target ����С�ַ���letters �ַ�������ѭ�����顣
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
	��Ŀ������һ����������ֻ��һ�������������Σ��ҳ��������Ҫ���� O(logN) ʱ�临�ӶȽ�����⡣
	�� key Ϊ Single Element �������е�λ�á���� m Ϊż�������� m + 1 < key����ô nums[m] == nums[m + 1]��m + 1 >= key����ô nums[m] != nums[m + 1]��
	������Ĺ��ɿ���֪������� nums[m] == nums[m + 1]����ô key ���ڵ�����λ��Ϊ [m + 2, h]����ʱ�� l = m + 2����� nums[m] != nums[m + 1]����ô key ���ڵ�����λ��Ϊ [l, m]����ʱ�� h = m��
	��Ϊ h �ĸ�ֵ���ʽΪ h = m����ôѭ������Ҳ��ֻ��ʹ�� l < h ������ʽ��
	*/
	public static int singleNonDuplicate(int[] nums)
	{
			int l = 0,h = nums.length - 1;
			while(l < h)
			{
				int m = (l+h) / 2;
				if(m % 2 == 1)
					m--;//��֤l/h/m����ż��λ��ʹ�ò��������Сһֱ��������
				if(nums[m] == nums[m+1])
					 l = m + 2;
				else
					h = m;
			}
			return nums[l];
	}
			/*'
			��Ŀ����������һ��Ԫ�� n ������ [1, 2, ..., n] �汾�����Ե��� isBadVersion(int x) ֪��ĳ���汾�Ƿ����Ҫ���ҵ���һ������İ汾��
		����� m ���汾�������ʾ��һ������İ汾�� [l, m] ֮�䣬�� h = m�������һ������İ汾�� [m + 1, h] ֮�䣬�� l = m + 1��
		��Ϊ h �ĸ�ֵ���ʽΪ h = m�����ѭ������Ϊ l < h��
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
	xuanת�������С����:html Input: [3,4,5,1,2], Output: 1
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
	��������
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
		int l = 0, h = nums.length - 1;//ע��h�ĳ�ʼֵ
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

