package BST;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

public class SerializeAndDeserialize {
	
	private static final int MARKER = Integer.MIN_VALUE;
	
	public static void serialize(Node root, ObjectOutputStream stream) throws IOException {
		
		if(root == null) {
			stream.writeInt(MARKER);
			return;
		}
		
		// Traverse pre-order
		stream.writeInt(root.key);
		serialize(root.left, stream);
		serialize(root.right, stream);
		
	}
	
	public static Node deserialize(ObjectInputStream stream) throws IOException {
		
		int val = stream.readInt();
		if(val == MARKER) {
			return null;
		}
		
		Node root = new Node(val);
		root.left = deserialize(stream);
		root.right = deserialize(stream);
		
		return root;
	}

	public static void main(String[] args) throws IOException {
		
		/* BST 1*/
		Node root1 = new Node(100);
		root1.left = new Node(50);
		root1.right = new Node(300);
		root1.left.left = new Node(20);
		root1.left.right = new Node(70);
		
		/*OutputStream out = null;
		ObjectInputStream st = new ObjectOutputStream(out);
		
		serialize(root1, st);
		Node newRoot = deserialize(st);
		*/

	}

}
