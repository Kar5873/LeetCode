package com.atguigu.stucture;

import java.io.*;

/**
 * @author kar
 * @create 2021-11-20 17:01
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 11;
        arr[2][2] = 12;
        arr[4][3] = 13;
        SparseArray array = new SparseArray();
        int[][] ints = array.toSparseArray(arr);
        String fileName = array.save(ints);

        int[][] ints1 = array.toOriginal(array.read(fileName));
        for (int[] anInt : ints1) {
            for (int i : anInt) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

    }

    public int[][] toSparseArray(int[][] nums) {
        int sum = 0, row = nums.length, col = nums[0].length;
        for (int[] num : nums) {
            for (int i : num) {
                if (i > 0) {
                    sum++;
                }
            }
        }
        int[][] res = new int[sum + 1][3];
        res[0][0] = row;
        res[0][1] = col;
        res[0][2] = sum;
        int count = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] > 0) {
                    res[count][0] = i;
                    res[count][1] = j;
                    res[count][2] = nums[i][j];
                    count++;
                }
            }
        }
        return res;
    }

    public int[][] toOriginal(int[][] sparseArray) {
        int[][] res = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            res[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return res;
    }

    public String save(int[][] arr) {
        ObjectOutputStream oos = null;
        String fileName = "map.data";
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            Content content = new Content(arr);
            oos.writeObject(content);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos == null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public int[][] read(String fileName) {
        ObjectInputStream ois = null;
        Content content = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            content = (Content) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content != null ? content.getArr() : null;
    }
    /**
     * 假设一个可序列化的对象包括对某个不可序列化的对象的引用，那么整个序列化操作将会失败，
     * 而且会抛出一个NotSerializableException.
     *
     * 非静态内部类拥有对外部类的全部成员的全然訪问权限，包含实例字段和方法。
     * 为实现这一行为，非静态内部类存储着对外部类的实例的一个隐式引用。
     * 序列化时要求全部的成员变量是Serializable,如今外部的类并没有implements Serializable,
     * 所以就抛出java.io.NotSerializableException异常。
     *
     * 解决的方法：
     * 1.将内部类写成静态的。
     * 2.将外部类也序列化。
     * 3.将内部类单独写一个.java档 implements Serializable
     */
    // final class Content implements Serializable {
    //     private int[][] arr;
    //
    //     public Content(int[][] arr) {
    //         this.arr = arr;
    //     }
    //
    //     public int[][] getArr() {
    //         return arr;
    //     }
    // }
}
final class Content implements Serializable {
    private int[][] arr;

    public Content(int[][] arr) {
        this.arr = arr;
    }

    public int[][] getArr() {
        return arr;
    }
}