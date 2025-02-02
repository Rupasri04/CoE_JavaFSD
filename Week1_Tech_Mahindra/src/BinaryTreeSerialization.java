import java.util.*;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeSerialization {

    
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    
    private static void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");  
            return;
        }
        sb.append(node.value).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    
    public static TreeNode deserialize(String data) {
        
        java.util.Queue<String> nodes = new java.util.LinkedList<>(Arrays.asList(data.split(","))); 

        return deserializeHelper(nodes);
    }

    
    private static TreeNode deserializeHelper(java.util.Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("N")) return null;  

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        
        String serializedTree = serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

       
        TreeNode deserializedRoot = deserialize(serializedTree);
        System.out.println("Deserialized Tree Root: " + deserializedRoot.value);
    }
}
