package com.codingdojo.springjava.tries;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        
        System.out.println(trie.isPrefixValid("tr"));
        System.out.println(trie.isPrefixValid("to"));
        
        System.out.println(trie.isWordValid("car"));
        System.out.println(trie.isWordValid("doggy"));
        System.out.println(trie.isWordValid("hating"));
        System.out.println(trie.isWordValid("joker"));
        System.out.println(trie.isWordValid("trie"));
    }
}
