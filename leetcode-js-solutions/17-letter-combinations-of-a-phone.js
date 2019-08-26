// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
const KV_PAIRS = {
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z']
}

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if (digits.length === 0) return []
    if (digits.length === 1) return KV_PAIRS[digits]
        
    const digitsList = digits.split('')
    const j = digits.length
    
    return combine(KV_PAIRS[digitsList[0]], 1, digitsList)
};

var combine = (leftArr, index, digitsList) => {
    if (index === digitsList.length) return leftArr
    
    const newLeftArr = []
    const currentDigit = digitsList[index]
    const letters = KV_PAIRS[currentDigit]
    
    letters.forEach(letter => {
        leftArr.forEach(val => {
            newLeftArr.push(val + letter)
        })
    })
        
    return combine(newLeftArr, index + 1, digitsList)
}
