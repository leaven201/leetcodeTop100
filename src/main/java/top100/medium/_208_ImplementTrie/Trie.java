package top100.medium._208_ImplementTrie;

/**
 * @author LinZebin
 * @date 2019-04-13 20:51
 */
public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    // 将一个单词插入字典树
    public void insert(String word) {
        // 从字典树的root开始，创建出一条word的路径
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            // 如果node指向letter的路径还没开辟，则创建该条路径
            if (!node.isLinkLetter(letter)) {
                node.createLetter(letter);
            }
            node = node.getLetter(letter);
        }
        // 将word路径的最尾字母对应的节点设为叶子节点
        node.setEnd();
    }

    // 判断一棵字典树是否包含单词word
    public boolean search(String word) {
        TrieNode node = root;
        // 从根结点出发，判断是否可以找到一条从头到尾的word的路径
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.isLinkLetter(letter)) {
                return false;
            }
            node = node.getLetter(letter);
        }
        // 判断最后一个字母的节点是否是叶子节点
        return node.isEnd();
    }

    // 判断字典树是否含有以prefix开始的路径
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (!node.isLinkLetter(letter)) {
                return false;
            }
            node = node.getLetter(letter);
        }
        return true;
    }

}

// 定义字典树的节点的数据结构
class TrieNode {

    // 每个字典树的节点应包含两个重要属性
    // 1.连接哪些字母
    private TrieNode[] links;
    // 2.是否是叶节点
    private boolean isEnd;

    // 构造方法，是否为叶节点初始化为false
    public TrieNode() {
        links = new TrieNode[26];
        isEnd = false;
    }

    // 判断该节点是否连接字母letter
    public boolean isLinkLetter(char letter) {
        // 若果这的节点的links[letter-'a']==null,说明与letter不相连
        if (links[letter - 'a'] == null) {
            return false;
        }
        return true;
    }

    // 为节点建立letter分支
    public void createLetter(char letter) {
        links[letter - 'a'] = new TrieNode();
    }

    // 获取该节点连接的letter节点
    public TrieNode getLetter(char letter) {
        return links[letter - 'a'];
    }

    // 将该节点设为叶子节点
    public void setEnd() {
        this.isEnd = true;
    }

    // 获取该节点是否是叶子节点
    public boolean isEnd() {
        return isEnd;
    }

}