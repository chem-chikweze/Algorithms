package Section3.Hashing;

public class LinearProbingHashST<Key, Value> {
	
	private int N;						//number of key-value pairs in the table
	private int M = 16;					//size of linear-probing table
	private Key[] keys;					//the keys
	private Value[] vals;				//the values
	
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public LinearProbingHashST(int cap) {
		M = 16;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff )% M;
	}
	
	private void resize() {
		resize(M* 2);
	}
	
	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value>(cap);
		for(int i = 0; i <M; i++)
			if (keys[i] != null)
				t.put(keys[i], vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
		
	}

	private void put(Key key, Value value) {
		// TODO Auto-generated method stub
		
	}


	
	
}
 