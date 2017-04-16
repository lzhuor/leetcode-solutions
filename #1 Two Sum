/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let matchTable = new Map(); 
    let result = [];
    for(let index in nums) {
        let num = nums[index];
        if(matchTable.get(num)){
            result[0] = Number(matchTable.get(num)); 
            result[1] = Number(index); // Index is string in JavaScript here
            return result;
        }
        matchTable.set(target - num, index);
    }
};
