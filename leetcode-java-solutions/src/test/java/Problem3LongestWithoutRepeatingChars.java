class Solution {
    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbbb"));  // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));  // 3
        System.out.println(lengthOfLongestSubstring("dvdf"));  // 3
    }
  
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        
        String[] strArr = s.split("");
        int longest = 0;
        int currentIdx = 0;
        int removeIdx = 0;
        HashSet<String> dict = new HashSet<>();
          
        while(currentIdx < strArr.length) {
           String str = strArr[currentIdx];
          
           if (!dict.contains(str)) {
             dict.add(str);
             currentIdx++;
             longest = Math.max(dict.size(), longest);
           } else {
             dict.remove(strArr[removeIdx]);
             removeIdx++;
           }
        }
        
        return longest;
    }
}
