/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let strSet = new Set();
    let rmvIdx = curIdx = longestStr = 0;
    while(curIdx < s.length) {
		let l = s[curIdx];
        if(!strSet.has(l)) {
          strSet.add(l);
          curIdx++;
          longestStr = Math.max(strSet.size, longestStr); 
        } else {
          strSet.delete(s[rmvIdx]);
          rmvIdx++;
        }
    }
    return longestStr;
};
