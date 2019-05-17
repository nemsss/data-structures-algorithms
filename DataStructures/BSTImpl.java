/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.*;

/**
 *
 * @author chinemeremenumah
 */

class Node{
    
    int data;
    Node left;
    Node right;
    Node parent;
    boolean visited;
    
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
  
}

class BST{
    
    Node root;

    BST(Node root){
        this.root = root;
    }
    
    Node insertIterative(Node node, int data){
        if(root == null){
            return new Node (data);
        }

        Node curr = root;
        while(true){
            if(curr.data > data){
                if(curr.left == null){
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if(curr.right == null){
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }

        if(curr.data > data){
            curr.left = new Node(data);
        } else {
            curr.right = new Node(data);
        }

        return root;
    }

    Node insert(Node node, int val){
        if(node == null){
            return new Node(val);
        }

        if(val > node.data){
            node.right = insert(node.right, val);
        }
        else if(val < node.data){
            node.left = insert(node.left, val);
        }
        else {
            return node;
        }

        return node;
    }

    public static void topView(Node root) {
        List<Integer> rList = new ArrayList<>();rList.add(root.data);

        Node r = root.right;

        while (true){
            System.out.println(rList);
            if(r!= null){
                rList.add(r.data);
                r = r.right;
            }

            if(r==null){
                break;
            }
        }

        for(int i : rList){
            System.out.print(i+" ");
        }
    }

    int height (Node node){
        if(node == null){
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static boolean isBST (Node root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        return isBST(root.left, min, root.data)
                && isBST(root.right, root.data, max);
    }

    Node lcaRecursive(Node node, int n1, int n2) {
    //https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
    // O(n) + O(h)
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return lcaRecursive(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2)
            return lcaRecursive(node.right, n1, n2);

        return node;
    }

    Node lcaIterative(Node node, int n1, int n2){
        while (node != null) {
            // If both n1 and n2 are smaller than root, then LCA lies in left
            if (node.data > n1 && node.data > n2) {
                node = node.left;
            }

            // If both n1 and n2 are greater than root, then LCA lies in right
            else if (node.data < n1 && node.data < n2) {
                node = node.right;
            }

            else break;
        }
        return node;
    }

    Node LCAHashMap(Node n1, Node n2) {
        // Creata a map to store ancestors of n1
        Map<Node, Boolean> ancestors = new HashMap<>();

        // Insert n1 and all its ancestors in map
        while (n1 != null) {
            ancestors.put(n1, Boolean.TRUE);
            n1 = n1.parent;
        }

        // Check if n2 or any of its ancestors is in
        // map.
        while (n2 != null) {
            if (ancestors.containsKey(n2) != ancestors.isEmpty())
                return n2;
            n2 = n2.parent;
        }

        return null;
    }

    private int depth(Node node) {
        int d = -1;
        while (node != null) {
            ++d;
            node = node.parent;
        }
        return d;
    }

    Node LCAUsingHeightDifference (Node n1, Node n2){
         // Find depths of two nodes and differences
        int d1 = depth(n1), d2 = depth(n2);
        int diff = d1 - d2;

        // If n2 is deeper, swap n1 and n2
        if (diff < 0) {
            Node temp = n1;
            n1 = n2;
            n2 = temp;
            diff = -diff;
        }

        // Move n1 up until it reaches the same level as n2
        while (diff-- != 0)
            n1 = n1.parent;

        // Now n1 and n2 are at same levels
        while (n1 != null && n2 != null) {
            if (n1 == n2)
                return n1;
            n1 = n1.parent;
            n2 = n2.parent;
        }

        return null;
    }

    Node delete(Node head, int val){
        if(head == null){
            return head;
        }

        if(head.data > val){
            head.left = delete(head.left, val);
        }
        else if(head.data < val){
            head.right = delete(head.right, val);
        }
        else {
            if(head.left == null && head.right == null){
                head = null;
            }
            else if(head.left == null){
                head = head.right;
            }
            else if(head.right == null){
                head = head.left;
            }
            else {
                head.data = maximumLeft(head).data;
                head.left = delete(head.left, head.data);
            }
        }

        return head;
    }

    private Node maximumLeft(Node head) {
        return head.right == null ? head : maximumLeft(head.right);
    }

    static boolean search(Node node, int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            return true;
        } else if(node.data <= data){
            return search(node.right, data);
        } else {
            return search(node.left, data);
        }
    }

    static Node min(Node node){
        if(node == null || node.left == null){
            return node;
        }

        return min(node.left);
    }

    static Node max(Node node){
        if(node == null || node.right == null){
            return node;
        }

        return max(node.right);
    }

    static void preOrder(Node root){
        if(root== null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if(root== null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root== null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelOrder(Node root){
        if(root == null){
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while(!queue.isEmpty()){
            Node current = queue.getFirst();
            System.out.print(current.data + " ");
            if(current.left != null) {
                queue.addLast(current.left);
            }
            if(current.right != null) {
                queue.addLast(current.right);
            }

            queue.removeFirst();
        }
    }
}

public class BSTImpl {
    public static void main(String[] args) {
//        Node root = new Node(5);
//        root.left = new Node(3);
//        root.left.left = new Node(1);
//        root.right = new Node(9);
//        root.right.left = new Node(8);
//        BST.preOrder(root);
//        System.out.println();System.out.println("----------------");
//        BST.inOrder(root);
//        System.out.println();System.out.println("----------------");
//        BST.postOrder(root);
//        System.out.println();System.out.println("----------------");
//        BST.levelOrder(root);
//        System.out.println();System.out.println("----------------");
//
//        System.out.println(BST.search(root, 1));
//        System.out.println(BST.search(root, 7));
//
//
//        System.out.println(BST.min(root));
//        System.out.println(BST.max(root));
//
//        System.out.println(BST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//
        BST tree = new BST(new Node(3));
        Node root2 = tree.root;
        tree.insertIterative(root2, 5);
        tree.insertIterative(root2, 7);
        tree.insertIterative(root2, 1);
        tree.insertIterative(root2, 2);
        tree.insertIterative(root2, 0);
        tree.insertIterative(root2, 9);
        tree.insertIterative(root2, 6);
        System.out.println(root2);

        tree.delete(root2, 7);
        System.out.println(root2);
        BST.topView(root2);
//
//        BST tree3 = new BST(new Node(13));
//        String[] input = "105 278 16 60 135 47 129 234 372 271 179 189 103 302 71 377 4 112 195 360 151 348 125 393 351 236 409 68 371 210 149 255 37 24 259 243 10 91 98 126 160 308 229 297 107 95 353 175 172 191 163 379 137 386 49 67 405 257 110 199 15 327 416 184 22 38 148 383 374 200 138 263 158 339 19 132 50 79 370 401 230 34 190 48 176 41 162 346 28 64 202 414 222 161 334 76 127 244 306 96 399 177 88 239 33 73 356 344 3 45 58 219 311 332 231 156 284 204 106 178 59 44 194 237 226 354 247 99 335 304 186 410 266 114 185 81 341 92 113 375 368 55 256 396 78 218 281 197 7 72 143 395 277 46 358 282 382 142 187 251 310 290 285 57 328 292 352 317 180 82 323 364 89 260 128 119 217 100 153 397 388 164 173 345 8 43 343 196 155 307 331 117 144 301 26 272 340 324 134 240 120 337 77 391 407 201 168 250 312 17 289 53 35 5 303 14 270 192 108 208 369 390 253 147 299 305 213 400 363 373 181 295 261 309 145 298 205 408 349 29 269 152 367 413 279 238 62 102 116 392 40 51 254 140 74 227 165 330 27 63 315 54 258 85 12 104 357 118 241 31 193 198".split(" ");
//        for (String s : input){
//            tree3.insertIterative(tree3.root, Integer.parseInt(s));
//        }
//17 1 2 3 4 13 105 278 372 377 393 409 416 418
//        BST.topView(tree3.root);

    }
}
