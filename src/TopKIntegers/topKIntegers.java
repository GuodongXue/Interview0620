package TopKIntegers;

import java.util.*;

public class topKIntegers {

    public static List<Integer> test(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)- map.get(o2);
            }
        });
        for(Integer key : map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if (map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }

    public static List<Integer> topK (int[] nums, int k){
        if(nums.length==0){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (x1,x2)-> x2.getValue().compareTo(x1.getValue()));
        for(Map.Entry entry: map.entrySet()){
            pq.add(entry);
        }
        List<Integer> res= new ArrayList<>();
        for(int i = 0; i<k; i++){
            res.add(pq.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> res = topK(nums,k);
        System.out.println(res);
    }
}
