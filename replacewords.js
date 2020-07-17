//Objective is to replace words in the sentence with a word in the dictionary if
//the word in the dictionary is the sentence word's prefix

let dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"


//O(n) solution where n is the length of the sentence

//Build the trie
let root = buildTrie(dict)
    
function buildTrie(array) {
    let root = {}
    
    for (let word of array) {
        let node = root
        for (let char of word) {
            if (!node[char]) {
                node[char] = {}
            }
            node = node[char]
        }
        node.wordEnd = true
    }
    
    return root
}

//Check each word in the sentence, if the prefix exists in the trie,
//push the prefix instead
let array = sentence.split(' ')
let result = []
for (let word of array) {
    result.push(searchPrefix(word) != null ? searchPrefix(word) : word)
}

function searchPrefix(word) {
    let temp = root
    let string = ''
    
    for (let char of word) {
        if (!temp[char]) {
            return null
        } else {
            string += char
            temp = temp[char]
            
            if (temp.wordEnd == true) {
                return string
            }
        }
    }
}

return result.join(' ')