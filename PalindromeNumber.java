// Determine whether an integer is a palindrome. Do this without extra space.

// click to show spoilers.

// Some hints:
// Could negative integers be palindromes? (ie, -1)

// If you are thinking of converting the integer to string, note the restriction of using extra space.

// You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

// There is a more generic way of solving this problem.
// 1234321
public class Solution {
    public boolean isPalindrome(int x) {
    	if(x==Integer.MIN_VALUE||x==Integer.MAX_VALUE){
    		return false;
    	}
        Stack<Integer> s = new Stack<Integer>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		while(Math.abs(x)>0){
			int temp = x%10;
			s.push(temp);
			q.add(temp);
			x = x/10;
		}

		while(!s.isEmpty()){
			if(s.pop()!=q.poll()){
				return false;
			}
		}
		return true;
    }
}