package jsjf;

import java.util.Iterator;

//have a good copy of array unordered list to display the tree
//
import jsjf.exceptions.*;

/**
 * LinkedBinaryTree is a linked node-based implementation of Binary Tree
 *
 * @author Lewis and Chase
 * @version 4.0
 * @param <T> Type of element stored in this tree
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> 
{

   /**
    * Root node for this tree.
    */
   protected BinaryTreeNode<T> root;

   /**
    * Creates an empty binary tree.
    */
   public LinkedBinaryTree() 
   {
      root = null;
   }

   /**
    * Creates a binary tree with the specified element as its root.
    *
    * @param element Element that will be held at the root (and only) node in
    * this tree.
    */
   public LinkedBinaryTree(T element) 
   {
      root = new BinaryTreeNode<T>(element);
   }

   /**
    * Creates a binary tree with the specified node as its root.
    *
    * @param node Node that will be used as the root of this tree.
    */
   public LinkedBinaryTree(BinaryTreeNode<T> node) 
   {
      root = node;
   }

   /**
    * Creates a binary tree with the specified element as its root and the
    * given trees as its left child and right child
    *
    * @param element the element that will become the root of the binary tree
    * @param left the left subtree of this tree
    * @param right the right subtree of this tree
    */
   public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) 
   {
      root = new BinaryTreeNode<T>(element);
      root.setLeft(left.root);
      root.setRight(right.root);
   }

   /**
    * Returns a reference to the element at the root
    *
    * @return a reference to the specified target
    * @throws EmptyCollectionException Exception thrown if there is no root
    * element
    */
   public T getRootElement() throws EmptyCollectionException 
   {
      if (isEmpty()) 
      {
         throw new EmptyCollectionException("LinkedBinaryTree");
      }
      return root.getElement();
   }

   /**
    * Returns a reference to the node at the root or null if the tree is empty
    *
    * @return Root node for this tree or null if the tree is empty.
    */
   protected BinaryTreeNode<T> getRootNode() 
   {
      return root;
   }

   /**
    * Specifies a new root node when a subclass needs this to change.
    *
    * @param newRoot The new node to be used as the root for this tree.
    */
   protected void setRootNode(BinaryTreeNode<T> newRoot) 
   {
      root = newRoot;
   }

   /**
    * Returns true if this binary tree is empty and false otherwise.
    *
    * @return true if this binary tree is empty, false otherwise
    */
   public boolean isEmpty() 
   {
      return (root == null);
   }

   /**
    * Returns the number of elements in this tree
    *
    * @return Size of this data structure
    */
   public int size() 
   {
      if (root == null) 
      {
         return 0;
      } 
      else 
      {
         return 1 + root.numChildren();
      }
   }

   /**
    * Returns the height of this tree.
    *
    * @return The longest path in this tree from the root node to a leaf node.
    */
   public int getHeight() 
   {
      return height(root);
   }

   /**
    * Private method which computes the height of the given node within this
    * RECURSIVE data structure (hint, hint). Note: I am not being subtle.
    *
    * @param node the node from which to calculate the height
    * @return the height of the tree
    */
   private static int height(BinaryTreeNode<?> node) 
   {
      if (node == null) 
      {
         return 0;
      } 
      else 
      {
         int leftHeight = height(node.getLeft());
         int rightHeight = height(node.getRight());
         return (1 + Math.max(leftHeight, rightHeight));
      }
   }

   /**
    * Returns true if this tree contains the specified element and false
    * otherwise..
    *
    * @param targetElement Element which we are searching for.
    * @return True a node in this tree contains an element equal to the
    * parameter, false otherwise.
    */
   public boolean contains(T targetElement) 
   {
      return findNode(targetElement, root) != null;
   }

   /**
    * Returns a reference to the specified target element if it is found in
    * this binary tree. Throws a ElementNotFoundException if the specified
    * target element is not found in the binary tree.
    *
    * @param targetElement the element being sought in this tree
    * @return a reference to the specified target
    * @throws ElementNotFoundException if the element is not in the tree
    */
   public T find(T targetElement) throws ElementNotFoundException 
   {
      BinaryTreeNode<T> current = findNode(targetElement, root);
   
      if (current == null) 
      {
         throw new ElementNotFoundException("LinkedBinaryTree");
      }
   
      return (current.getElement());
   }

   /**
    * Returns a reference to the specified target element if it is found in
    * this binary tree.
    *
    * @param targetElement Element being sought in this tree
    * @param next Root of the subtree from which we start our searching
    * @param <T> Type of element stored in these nodes.
    * @return Node in the subtree whose element equals {@code targetElement};
    * null if no such node exists.
    */
   private static <T> BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) 
   {
      if (next == null) 
      {
         return null;
      }
   
      if (next.getElement().equals(targetElement)) 
      {
         return next;
      }
   
      BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
   
      if (temp == null) 
      {
         temp = findNode(targetElement, next.getRight());
      }
   
      return temp;
   }

   /**
    * Returns an iterator over the elements in this tree using the
    * iteratorInOrder method
    *
    * @return an in order iterator over this binary tree
    */
   public Iterator<T> iterator() 
   {
      return iteratorInOrder();
   }

   /**
    * Performs an inorder traversal on this binary tree by calling an
    * overloaded, recursive inorder method that starts with the root.
    *
    * @return an in order iterator over this binary tree
    */
   public Iterator<T> iteratorInOrder() 
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      inOrder(root, tempList);
   
      return tempList.iterator();
   }

   /**
    * Performs a recursive inorder traversal.
    *
    * @param node the node to be used as the root for this traversal
    * @param tempList the temporary list for use in this traversal
    */
   private void inOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) 
   {
      if (node != null) 
      {
         inOrder(node.getLeft(), tempList);
         tempList.addToRear(node.getElement());
         inOrder(node.getRight(), tempList);
      }
   }

   /**
    * Performs an preorder traversal on this binary tree by calling an
    * overloaded, recursive preorder method that starts with the root.
    *
    * @return a pre order iterator over this tree
    */
   public Iterator<T> iteratorPreOrder() 
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      preOrder(root, tempList);
   
      return tempList.iterator();
   }

   /**
    * Performs a recursive preorder traversal.
    *
    * @param node the node to be used as the root for this traversal
    * @param tempList the temporary list for use in this traversal
    */
   private void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList)
   {
      if (node != null) 
      {
         tempList.addToRear(node.getElement());
         preOrder(node.getLeft(), tempList);
         preOrder(node.getRight(), tempList);
      }
   }

   /**
    * Performs an postorder traversal on this binary tree by calling an
    * overloaded, recursive postorder method that starts with the root.
    *
    * @return a post order iterator over this tree
    */
   public Iterator<T> iteratorPostOrder() 
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      postOrder(root, tempList);
   
      return tempList.iterator();
   }

   /**
    * Performs a recursive postorder traversal.
    *
    * @param node the node to be used as the root for this traversal
    * @param tempList the temporary list for use in this traversal
    */
   protected void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) 
   {
      if (node != null) 
      {
         postOrder(node.getLeft(), tempList);
         postOrder(node.getRight(), tempList);
         tempList.addToRear(node.getElement());
      }
   }

   /**
    * Performs a levelorder traversal on this binary tree, using a templist.
    *
    * @return a levelorder iterator over this binary tree
    */
   public Iterator<T> iteratorLevelOrder() 
   {
      ArrayUnorderedList<BinaryTreeNode<T>> nodes = new ArrayUnorderedList<BinaryTreeNode<T>>();
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      BinaryTreeNode<T> current;
   
      nodes.addToRear(root);
   
      while (!nodes.isEmpty()) 
      {
         current = nodes.removeFirst();
      
         if (current != null) 
         {
            tempList.addToRear(current.getElement());
            if (current.getLeft() != null) 
            {
               nodes.addToRear(current.getLeft());
            }
            if (current.getRight() != null) 
            {
               nodes.addToRear(current.getRight());
            }
         } 
         else 
         {
            tempList.addToRear(null);
         }
      }
      return tempList.iterator();
   }
}
