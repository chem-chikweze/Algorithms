package Section;
/*
 * Referremces:https://algs4.cs.princeton.edu/34hash/LinearProbingHashST.java.html
 */
public class LinearProbingHash<Key, Value> {
	static int R = 31;		//Large prime number		//Number of key-value pairs in the table if known
	static int M = 13 ;				//size of linear probing  table
	Key[] keys;					//the keys
	Value[] vals;					//the values
	int load;
	int unique;				//number of unique items/ counter

	public LinearProbingHash(){
		this(M);
	}
	public LinearProbingHash(int M){
		this.M = M;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}

	public int hash(Key key) {
		if(key == null) throw new IllegalArgumentException("argument to hash() is null");
		
		return (key.hashCode() & 0x7fffffff) % getCap();
	}
	
	//Except for the function of "R" 
	 public static int hashCode(String s){	
		 if(s == null) throw new IllegalArgumentException("argument to hashCode() is null");
		 
		int hash = 0;
		int n = ((String) s).length();
		for(int l = 0; l < ((String) s).length(); l++) {
			hash = (int) (( R* Math.pow(31, --n) * hash + ((String) s).charAt(l)) % getCap());
		}
		return hash;
	 }
	
	//done
	public void resize(int cap) {
		LinearProbingHash<Key, Value> p;
		p = new LinearProbingHash<Key, Value>(cap);
		for(int i=0; i< getCap(); i++) {
			if(keys[i] != null) {
				p.insert(keys[i], vals[i]);
			}
		}
		keys = p.keys;
		vals = p.vals;
		M = p.getCap();
	}
	
	//done
	public void insert(Value string) {
		
		
	}
	public void insert(Key key, Value val){
		if(key == null) throw new IllegalArgumentException("the key cannot be null");
		
		if(val == null) {
			delete(key);
			return;
		}
		
		if (getFactor() >= getCap()/2) resize(2*getCap()); // double M (see text)
		int i;
		//changes the old val to new value. It does not affect the counter
		for (i = hash(key); keys[i] != null; i = (i + 1) % getCap()) {
			if (keys[i].equals(key)) {  vals[i] = val; return; }
		}
		
		//adds a unique key and value. Affects counter
			keys[i] = key;
			vals[i] = val;
			unique++;
		
	}
	
	public void delete(Key key) {
		if(key ==   null) throw new IllegalArgumentException("key to be deleted is null");
		if(!contains(key)) return;
		
		//find position i of key in the key[] table
		int i = hash(key);
		while(!key.equals(i)) { //continues checking for displaced location of key due to linear probing
			i = (i+ 1) % getCap();
		}
		
		//now delete the key from key[i] and set it's value in vals[i] to be null
		keys[i] = null;
		vals[i] = null;
		
		//there is now a hole in the two tables so we have to rehash everything back
		i = (i+ 1) % getCap();
		while(keys[i] != null) { //what if keys[i] == null but there are still unhashed elements?
			//store the value in a temporary variable
			Key keyTemp = keys[i];
			Value valTemp = vals[i];
			
			keys[i]= null;
			vals[i] = null;
			unique--;
			
			//insert it back
			insert(keyTemp,valTemp);
			
			i = (i +1) % getCap();
		}
	}
	
	//uses the get() method to check if the key is contained by returning null when the key is not found
	public boolean contains(Key key) {
		if(key == null) throw new IllegalArgumentException("the key that you are checking contains() is null");
		return get(key) != null;
	}
	
	 public Value get(Key key){
		 if(key == null) throw new IllegalArgumentException("argument to get() is null");
		 for (int i = hash(key); keys[i] != null; i = (i + 1) % getCap()) {
			 if (keys[i].equals(key))
				 return vals[i];
		 }
		 	return null;
	 } 

	 public Iterable<Key> keys() {
		 Queue<Key> q = new Queue<Key>();
		 for(int i = 0; i< getCap(); i++) {
			 if(keys[i] != null) q.enqueue(keys[i]);
		 }
		 return q;
	 }
	//done
	public void print() {
		for(int i = 0; i < getCap(); i++) {
			if(keys[i] == null) continue;
			else 
				System.out.println("Key "+ keys[i]+ " contains "+ vals[i]);
		}
	}

	public static void main(String [] args) {
		LinearProbingHash<String, Integer> p ;
		p = new LinearProbingHash<String, Integer>();
	
		for(int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			p.insert(key, i);
		}
		p.print();
		//System.out.println(p.hash(hashCode("Hello")));

	//	String s = "hey";
	//	p.insert(p.hashCode(s), s);
		p.print();
	}
	
	
	//getters	
	public int getFactor() {
		return unique;
	}
	
	public static int getCap() {
		return M;
	}
	
	public int loadFactor() {
		return M;
	}
	
	public int size(){
		return unique;
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	public boolean isFull() {
		return false;
	}
}