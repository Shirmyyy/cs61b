
public class Palindrome {

	public Deque<Character> wordToDeque(String word){
		Deque word_deque = new LinkedListDeque<Character>();
		for (int i = 0; i < word.length(); i++){
		    char c = word.charAt(i);        
		    word_deque.addLast(c);
		}
		return word_deque;
	}
	
    public boolean isPalindrome(String word) {
        Deque list = wordToDeque(word);
        return isPalindromehelper(list);
    }

    public boolean isPalindromehelper(Deque list) {
        if (list.size()<=1) {
            return true;
        }else if (list.removeFirst()==list.removeLast()) {
            return isPalindromehelper(list);
        }else {
            return false;
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
    	Deque list = wordToDeque(word);
        return isPalindromehelper2(list, cc);
    }
    
    public boolean isPalindromehelper2(Deque list, CharacterComparator cc) {
        if (list.size()<=1) {
            return true;
        }else if (cc.equalChars((char)list.removeFirst(),(char)list.removeLast())){
            return isPalindromehelper2(list,cc);
        }else {
            return false;
        }
    }
}
