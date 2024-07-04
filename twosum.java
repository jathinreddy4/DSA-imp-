import java.util.*;

public class twosum 
{
    public static void main(String[] args) {
        int arr[] = {2,6,5,8,11};
        int target = 14;
        
        String ans = brute(arr, target);
        System.out.println(ans);

        ArrayList<Integer> ans1 = brute1(arr, target);
        System.out.println("The number that sum up to target are :" + ans1);

        String ans2 = better(arr, target);
        System.out.println(ans2);

        String ans3 = better1(arr, target);
        System.out.println(ans3);

        String ans4 = bestmethopd(target, arr);
        System.out.println(ans4);
    }
    
    public static String brute(int arr[], int target)  // 1st variant 
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j =0; j<arr.length; j++)
            {
                if(arr[i] + arr[j] == target)
                {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static ArrayList<Integer> brute1(int arr[], int target) 
    {
        ArrayList<Integer> ls = new ArrayList<>();    
        for(int i=0; i<arr.length; i++)               
        {
            for(int j=0; j<arr.length; j++)
            {
                if(arr[i] + arr[j] == target)
                {
                    if(!ls.contains(arr[i]))
                    {
                        ls.add(arr[i]);
                        ls.add(arr[j]);
                    }
                }
            }
        }
        return ls;
    }

    public static String better(int arr[], int target)   //2nd variant to return numbers
    {                                               // but there is a prb here that it can choose the same index twise
        // arr[i] = 6 and target = 12, while checking in hashset it can select 6 on same index, different index is ok
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++)
        {
            hs.add(arr[i]);
        }

        for(int i=0; i<arr.length; i++)
        {
            int num = arr[i];
            int moreneeded = target - num;

            if(hs.contains(moreneeded) && moreneeded != num)
            {
                return "YES";
            }
        }
        return "NO";
    }


    // using a hashmap
    public static String better1(int arr[], int target)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0; i<arr.length; i++)
        {
            int moreneeded = target - arr[i];
            if(hm.containsValue(moreneeded))
            {
                return "YES The pair exists";
            }

            hm.put(arr[i], i);
        }
        return "NO ";
    }

    public static String bestmethopd(int target, int arr[])
    {
        Arrays.sort(arr);
        int n = arr.length;

        int leftptr = 0 ;
        int rightptr = n-1;

        while(leftptr < rightptr)
        {
            int sum = arr[leftptr] + arr[rightptr];

            if(sum == target)
            {
                return "YES the pair exits";
            }
            else if(arr[leftptr] + arr[rightptr] > sum)
            {
                rightptr --;
            }
            else 
            {
                leftptr++;
            }
        }
        return "NIO";
    }
}

