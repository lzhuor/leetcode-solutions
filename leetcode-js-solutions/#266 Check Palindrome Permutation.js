function checkIfPalindromePermutation(string) {
    const charArr = string.split('');

    const allChars = charArr.reduce((map, char) => {
        if (char in map) {
            map[char]++;
        } else {
            map[char] = 1;
        }

        return map;

    }, {});

    numOfOddOccurances = Object.values(allChars).filter(each => each % 2 !== 0);
    
    const result = numOfOddOccurances.length === 1 ? true : false;
    
    return result;    
}

checkIfPalindromePermutation('ssass')
