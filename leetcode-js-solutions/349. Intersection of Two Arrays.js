/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    const dict = {};
    const resultSet = new Set();
    
    nums1.forEach(each => dict[each] = true);
    nums2.filter(each => each in dict)
        .forEach(each => resultSet.add(each));
    
    return Array.from(resultSet);
};
