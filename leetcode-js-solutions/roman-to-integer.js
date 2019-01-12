// 13. Roman to Integer https://leetcode.com/problems/roman-to-integer/

const MAP = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
    IV: 4,
    IX: 9,
    XL: 40,
    XC: 90,
    CD: 400,
    CM: 900
}

/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let n = 0
    let counter = 0    
    while (n < s.length) {
        const two =  MAP[s.slice(n, n+2)]
        if (two) {
            counter += two
            n += 2
            continue
        }
                
        counter += MAP[s.slice(n, n+1)]
        n++
    }
    
    return counter
};
