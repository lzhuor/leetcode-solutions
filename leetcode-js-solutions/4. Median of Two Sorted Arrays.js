/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
  let nextIndex = 0;
  nums1.forEach(num1 => {
    for (let i = nextIndex; i <= nums2.length; i++) {
      if (i === nums2.length) {
        nums2.splice(i, 0, num1);
        break;
      }

      if (num1 < nums2[i]) {
        nums2.splice(i, 0, num1);
        nextIndex = i + 1;
        break;
      }
    }
  })

  return getMedian(nums2);
};

var getMedian = sortedNums => {
  let median;

  const halfIndex = Math.floor(sortedNums.length / 2);

  if (sortedNums.length % 2 !== 0) {
    median = sortedNums[halfIndex];
  } else {
    median = (sortedNums[halfIndex] + sortedNums[halfIndex - 1]) / 2
  }

  return median;
}

// Test Case
const result = findMedianSortedArrays([1, 2,], [3, 4]);
console.log('result:', result); // 2.5 


