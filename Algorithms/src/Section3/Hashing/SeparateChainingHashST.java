package Section3.Hashing;

public class SeparateChainingHashST<Key, Value> {
	
	private int M;									//Hash table size
	private SequentialSearchST<Key, Value>[] st;	//array of ST objects
	
	public SeparateChainingHashST() {
		this(997);
	}
	
	public SeparateChainingHashST(int M)
	{	//Create M Linked Lists
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i = 0; i < M; i++)
			st[i] = new SequentialSearchST();
	}
	
	public int hash(Key key)
	{	return  (key.hashCode() & 0x7fffffff) % M; }
	
	public Value get(Key key)
	{	return   (Value) st[hash(key)].get(key); }
	
	public void put(Key key, Value val)
	{	st[hash(key)].put(key, val);	}
	
	public Iterable<Key> keys(){
		return null;
	//See Exercise 3.4.19;
	
	}
}
