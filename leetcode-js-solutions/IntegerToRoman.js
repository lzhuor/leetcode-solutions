// https://leetcode.com/problems/integer-to-roman/

const LETTERS = [
    ['', 'I'],
    ['V', 'X'],
    ['L', 'C'],
    ['D', 'M'],
    ['M', '']
]

const times = (n, result) => {
    let str = ''
    
    while(n > 0) {
        str += result
        n--
    }
        
    return str
}

var intToRoman = function(num) {
    const str = num.toString()
    const length = str.length
    
    let result = ''
    
    
    let i = 0
    
    while(i < length) {
        const numStr = str[i]
        const int = Number(numStr)
        const lastRight = LETTERS[length - i - 1][1]
        const left = LETTERS[length - i][0]
        const right = LETTERS[length - i][1]
    
        
        if (int > 0 && int < 4) result += times(int, lastRight)
        if (int === 4) result += (lastRight + left)
        if (int > 4 && int < 9) result += (left + times(int - 5, lastRight))
        if (int === 9) result += (lastRight + right)
        
        i++
    }
    
    return result
};
