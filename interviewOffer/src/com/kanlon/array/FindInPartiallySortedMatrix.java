package com.kanlon.array;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 例如下面的二维数组就是每行、每列都递增排序。如果在这个数组中查找数字7，则返回true；如果查找数字5，由于数组不含有该数字，则返回false。
 * <p>
 * 1 2 8 9
 * <p>
 * 2 4 9 12
 * <p>
 * 4 7 10 13
 * <p>
 * 6 8 11 15
 * <p>
 * 解题思路：从角落开始查找，首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；如果该数字大于要查找的数字，剔除这个数字所在的列；如果该数字小于要查找的数字，剔除这个数字所在的行。
 *
 * @author zhangcanlong
 * @date 2018年9月21日
 */
public class FindInPartiallySortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		FindInPartiallySortedMatrix findDemo = new FindInPartiallySortedMatrix();
		boolean flag = findDemo.find(matrix, 4, 4, 12);
		System.out.println(flag);
	}

	/**
	 * 查找的二维数组中的某元 素
	 *
	 * @param matrix
	 *            二维数组
	 * @param rows
	 *            二维数组的行数
	 * @param columns
	 *            二维数组的列数
	 * @param number
	 *            要查找的元素
	 * @return
	 */
	public Boolean find(int[][] matrix, int rows, int columns, int number) {
		// 定义初始是否找到标注
		Boolean found = false;

		// 限制输入错误
		if (matrix != null && rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			// 当还没有查找完
			while (row < rows && column >= 0) {
				// 如果该行该列的数字等于要查找的元素，返回
				if (matrix[row][column] == number) {
					found = true;
					break;
				} else if (matrix[row][column] > number) {
					// 如果该元素大于要查找的元素，则减少该列
					column--;
				} else if (matrix[row][column] < number) {
					// 如果该元素小于要查找的元素，则减少该行，即增加该行号
					row++;
				}
			}
		}
		return found;
	}
}
