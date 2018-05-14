/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    const dict = {}
    nums1.forEach(each => dict[each] = true);
    return nums2.filter(each => each in dict);
};
