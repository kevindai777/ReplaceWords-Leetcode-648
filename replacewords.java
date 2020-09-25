//Java Solution

class TrieNode {
    HashMap<Character, TrieNode> children;
    String word = null;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        StringBuilder result = new StringBuilder();
        
        for (String word : sentence.split("\\s+")) {
            if (result.length() > 0) {
                result.append(" ");
            }
            
            TrieNode node = root;
            
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c) || node.word != null) {
                    break;
                }
                node = node.children.get(c);
            }
            
            result.append(node.word == null ? word : node.word);
        }
        
        return result.toString();
    }
    
    public TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode node = root;
            
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            
            node.word = word;
        }
        
        return root;
    }
}