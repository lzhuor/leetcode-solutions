/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    var mergedArray = [];
    if(nums1[nums1.length-1] < nums2[0]) {
        mergedArray.concat(nums1, nums2);
        return getMedian(mergedArray);
    } else if (nums1[0] > nums2[nums2.length-1]) {
        mergedArray.concat(nums2, nums1);
        return getMedian(mergedArray);
    } else {
        
    }
};

var getMedian = (mergedArray) => {
    if(mergedArray.length % 2 === 0 && mergedArray.length !== 0) {
        let lowerPosition = mergedArray.length / 2;
        return ( mergedArray[lowerPosition] + mergedArray[lowerPosition + 1] ) / 2;
    } else if(mergedArray.length % 2 === 1) {
        return mergedArray[ mergedArray.length / 2 ];
    } else {
        return 0;
    }
};
