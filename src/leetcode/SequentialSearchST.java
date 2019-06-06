import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric-d on 16/9/24.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private class Node{
        Key key;
        Value value;

        Node next;
        public Node(Key key, Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Value get(Key key)
        {
            for (Node x = first;x != null;x = x.next)
            {
                if (key.equals(x.key))
                {
                    return x.value;
                }
            }

            return null;
        }
    }

    public static void main(String[] args)
    {
        List<String> strList = new ArrayList<String>();

    }
}
