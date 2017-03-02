package hashmap;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HashMapChain {

    private FastScanner in;
    private PrintWriter out;
    
    // store all names in Hashmap with hash function as key
    private HashMap<Integer, ArrayList<String>> elemMap;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashMapChain().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        //out.flush();
    }

    private void processQuery(Query query) {
    	int key = 0;
    	if(query.s != null) {
    		key = hashFunc(query.s);
    	}
    	
    	//System.out.println("Key for String = " + query.s + " -> " + key);
    	
        switch (query.type) {
            case "add":
            	if(!elemMap.containsKey(key)) {
            		elemMap.put(key, new ArrayList<String>());
            	}
            	
            	if(!elemMap.get(key).contains(query.s)) {
            		elemMap.get(key).add(0, query.s);
            	}
                break;
            case "del":
            	if(elemMap.containsKey(key)) {
            		elemMap.get(key).remove(query.s);
            	}
                break;
            case "find":
            	boolean found = false;
            	if(elemMap.containsKey(key)) {
            		found = elemMap.get(key).contains(query.s);
            	}
                writeSearchResult(found);
                break;
            case "check":
            	//System.out.println("Query index -> " + query.ind);
            	if(elemMap.containsKey(query.ind)) {
            		if(elemMap.get(query.ind).isEmpty()) {
            			out.print("");
            		}
            		else {
            			for(String cur : elemMap.get(query.ind)) {
                			out.print(cur + " ");
                		}
            		}
            	}
            	out.println();
                /*for (String cur : elems)
                    if (hashFunc(cur) == query.ind)
                        out.print(cur + " ");
                out.println();*/
                // Uncomment the following if you want to play with the program interactively.
                //out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
    	
        elemMap = new HashMap<Integer, ArrayList<String>>();
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
        
        public Query(String type, String s, int ind) {
        	this.type = type;
        	this.s = s;
        	this.ind = ind; 
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}


