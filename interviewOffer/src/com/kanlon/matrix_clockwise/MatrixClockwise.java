package com.kanlon.matrix_clockwise;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题20：顺序针打印矩阵。输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 由于《剑指offer》原来的这题解题思路，有点复杂，代码较多，而且比较难理解，所以，这里的解题思路是通过网上查找更好的
 *
 * @author zhangcanlong
 * @date 2018年12月26日
 */
public class MatrixClockwise {
	public static void main(String[] args) {
		MatrixClockwise test = new MatrixClockwise();
		// 功能测试（多行多列，行列相同）
		int[][] matrix1 = new int[6][6];
		int value = 1;
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				matrix1[i][j] = value;
				System.out.print(value++ + " ");
			}
			System.out.println();
		}
		System.out.println("功能测试1（多行多列）" + test.printMatrixClockwise1(matrix1));
		System.out.println("功能测试1（多行多列）" + test.printMatrixClockwise2(matrix1));

		// 功能测试（少行多列）
		int[][] matrix2 = new int[4][5];
		int value2 = 1;
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				matrix2[i][j] = value2;
				System.out.print(value2++ + " ");

			}
			System.out.println();
		}
		System.out.println("功能测试2（少行多列）" + test.printMatrixClockwise1(matrix2));
		System.out.println("功能测试2（少行多列）" + test.printMatrixClockwise2(matrix2));

		// 功能测试（多行少列）
		int[][] matrix3 = new int[5][4];
		int value3 = 1;
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix3[0].length; j++) {
				matrix3[i][j] = value3;
				System.out.print(value3++ + " ");

			}
			System.out.println();
		}
		System.out.println("功能测试3（少行多列）" + test.printMatrixClockwise1(matrix3));
		System.out.println("功能测试3（少行多列）" + test.printMatrixClockwise2(matrix3));

		// 特殊测试 一行测试
		int[][] matrix4 = { { 1, 2, 3, 4 } };
		System.out.println("特殊测试4（一行）" + test.printMatrixClockwise1(matrix4));
		System.out.println("特殊测试4（一行）" + test.printMatrixClockwise2(matrix4));

		// 特殊测试 一列测试
		int[][] matrix5 = { { 1 }, { 2 }, { 3 }, { 4 } };
		System.out.println("特殊测试5（一列）" + test.printMatrixClockwise1(matrix5));
		System.out.println("特殊测试5（一列）" + test.printMatrixClockwise2(matrix5));

		// 特殊测试 单个测试
		int[][] matrix6 = { { 1 } };
		System.out.println("特殊测试6（单个）" + test.printMatrixClockwise1(matrix6));
		System.out.println("特殊测试6（单个）" + test.printMatrixClockwise2(matrix6));

		// 特殊测试 空测试
		System.out.println("特殊测试7（空）" + test.printMatrixClockwise1(null));
		System.out.println("特殊测试7（空）" + test.printMatrixClockwise2(null));

	}

	/**
	 *
	 * 参考网上：<a>https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a?commentTags=Java<a>
	 * 这种方法代码量较少，不过逻辑较复杂，特别是判断之后一圈包含一行一列时和判断圈数时，思路比较特别，值得认真思考。
	 * <p>
	 * 解题思路1：顺时针打印就是按圈数循环打印，一圈包含两行或者两列，在打印的时候会出现某一圈中只包含一行，要判断从左向右打印和从右向左打印的时候是否会出现重复打印，
	 * 同样只包含一列时，要判断从上向下打印和从下向上打印的时候是否会出现重复打印的情况
	 *
	 * @param matrix
	 *            要打印的矩阵
	 * @return 返回顺时针打印的结果集
	 */
	public List<Integer> printMatrixClockwise1(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null) {
			return res;
		}
		// 行数
		int row = matrix.length;
		// 列数
		int column = matrix[0].length;
		// 计算打印的圈数
		int circle = ((row < column ? row : column) - 1) / 2 + 1;
		// 打印一圈
		for (int i = 0; i < circle; i++) {
			// 从左向右打印
			for (int j = i; j < column - i; j++) {
				res.add(matrix[i][j]);
			}
			// 从上往下打印
			for (int k = i + 1; k < row - i; k++) {
				res.add(matrix[k][column - i - 1]);
			}

			// 判断是否会重复打印（从右向左打印），如果最后一圈只有一行，则该行不打印。
			// row - 1 != i <<1 表示最后一圈打印的行，如果是只有一行，则该行数的2倍等于矩阵行列数中较小的数-1
			for (int m = column - i - 2; (m >= i) && (row - 1 != i >> 1); m--) {
				res.add(matrix[row - i - 1][m]);
			}
			// 判断是否会重复打印列（从下往上打印）,如果最后一圈只有一列，则不打印
			// column - 1 != i << 1 表示最后一圈打印的列，如果是只有一列，则该列数的2倍等于矩阵行列数中较小的数-1
			for (int n = row - i - 2; (n > i) && (column - 1 != i >> 1); n--) {
				res.add(matrix[n][i]);
			}
		}
		return res;
	}

	/**
	 * 参考：<a>http://www.cnblogs.com/python27/archive/2011/11/29/2267975.html<a>
	 * <p>
	 * 解题思路2：依然是先判断圈数终止条件，即判断打印多少圈，然后设置打印一圈。循环圈数结束条数是：
	 * 一个矩阵，给定起点（startX，startY）和终点（endX，endY）（即位于对角线上的两个点）就可以打印一周，
	 * <p>
	 * 然后向里进一周（即++startX,++startY,--endX,--endY）即可，如果起始点坐标<终止点坐标（即startX<endX或者startY<endY）循环结束。
	 * <p>
	 * 打印一圈的思路：就是只有三种情况，一直循环到结束，只剩下一行，只剩下一列。所以我们的函数首先判定：只有一行？打印该行；只有一列，打印该列。都不是，打印四条边上的数字。
	 *
	 * @param matrix
	 *            要打印的矩阵
	 * @return 返回打印的结果集合
	 */
	public List<Integer> printMatrixClockwise2(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null) {
			return res;
		}
		int startX = 0;
		int startY = 0;
		int endX = matrix.length - 1;
		int endY = matrix[0].length - 1;
		while (startX <= endX && startY <= endY) {
			// 因为java基本类型是值传递，方法里面修改不会改变外面参数，i++，i传进入原值，之后i+1
			printMatrixCircle(matrix, startX++, startY++, endX--, endY--, res);
		}

		return res;
	}

	/**
	 * 打印顺时针矩阵一圈
	 *
	 * @param matrix
	 *            要打印的矩阵
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @param res
	 *            返回打印矩阵的结果集
	 */
	private void printMatrixCircle(int[][] matrix, int startX, int startY, int endX, int endY, List<Integer> res) {
		// 如果矩阵是只有一行
		if (startX == endX) {
			while (startY <= endY) {
				res.add(matrix[startX][startY++]);
			}
			// 如果矩阵是只有一列
		} else if (startY == endY) {
			while (startX <= endX) {
				res.add(matrix[startX++][endY]);
			}
		} else {
			// 从左向右打印
			for (int p = startY; p < endY; p++) {
				res.add(matrix[startX][p]);
			}
			// 从上向下打印
			for (int q = startX; q < endX; q++) {
				res.add(matrix[q][endY]);
			}
			// 从右往左打印
			for (int m = endY; m > startY; m--) {
				res.add(matrix[endX][m]);
			}
			// 从下往上打印
			for (int n = endX; n > startX; n--) {
				res.add(matrix[n][startY]);
			}
		}

	}
}
