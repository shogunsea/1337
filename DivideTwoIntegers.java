public class Solution{
	public int divide(int dividend, int divisor){
		boolean neg = false;
		if((divisor<0&&dividend>0)||(divisor>0&&dividend<0)){
			neg = true;
		}
		int res = 0;
		if(dividend==Integer.MIN_VALUE){
			res = 1;
			dividend += Math.abs(divisor);
		}
		if(divisor==Integer.MIN_VALUE){
			return res;
		}
		long a = Math.abs(dividend);
		long b = Math.abs(divisor);
		while(a>=b){
			long c = b;
			for(int i = 0; a>=c; i++, c<<1){
				a -= c;
				res += 1<<i;
			}
		}
		return neg? (-1*res):res;
	}
}