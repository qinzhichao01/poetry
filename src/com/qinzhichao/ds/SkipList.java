package com.qinzhichao.ds;

import java.util.Random;

/**
 * @author qinzhichao02
 * create 2023/4/20 12:36
 */
public class SkipList<T> {

    Node<T> head;
    int highLevel;

    Random random;
    final int MAX_LEVEL = 32;


    public T get(int key) {
        Node node = head;
        while (node != null) {
            if (key == node.key) {
                return (T) node.value;
            }
            if (node.right == null) {
                node = node.down;
            } else {
                if (node.right.key > key) {
                    node = node.right;
                } else {
                    node = node.right;
                }
            }
        }
        return null;
    }

    public T delete(int key) {
        Node node = head;
        T deletedVal = null;
        while (node != null) {
            if (node.right == null) {
                node = node.down;
            } else if (node.right.key == key) {
                deletedVal = (T) node.right.value;
                node.right = node.right.right;
                node = node.down;
            } else if (node.right.key > key) {
                node = node.down;
            } else {
                node = node.right;
            }
        }
        return deletedVal;
    }

    private static class Node<T> {
        int key;
        T value;
        Node<T> right;
        Node<T> down;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
        }
    }


}
