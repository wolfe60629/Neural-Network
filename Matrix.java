package src;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    //Class Data
    private int rows;
    private int cols;
    private double[][] matrix;

    public Matrix(int rows, int cols) {
        /****************
         * Constructor  *
         ****************/
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];

        //Adding 0's to the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    public static Matrix fromArray(double[] arr) {
        /*********************************************
         * Take an input array and convert to Matrix *
         *********************************************/
    	Matrix m = new Matrix(arr.length,1);
    	  for (int i = 0; i < arr.length; i++) {
              m.matrix[i][0] = arr[i];
          }
    	  return m;
    }
    public double[] toArray() {
        /*********************************************
         * Take an input array and convert to Matrix *
         *********************************************/
    	double[] arr = new double[getFullLength()];
    	 for (int i = 0; i < this.rows; i++) {
             for (int j = 0; j < this.cols; j++) {
               arr[(i*this.cols)+ j] = this.matrix[i][j];
             }
         }
    	 return arr;
    }
    
    public Matrix multiply(int n) {
        /*******************************************
         * Scale the matrix up by a certain value  *
         *******************************************/
        Matrix temp = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                temp.setInteger(i, j, this.matrix[i][j] * n);
            }
        }
        return temp;
    }
    public static Matrix multiply(Matrix a, Matrix b) {
        /*******************************************
         *  Scale the matrix up by another matrix  *
         *******************************************/
        if (a.cols == b.rows && a.cols != b.cols) {
            //Matrix Product if sizes are different
            Matrix temp = new Matrix(a.rows, b.cols);
            for (int i = 0; i < a.rows; i++) {
                for (int j = 0; j < b.cols; j++) {
                    double sum = 0.00;
                    for (int k = 0; k < a.cols; k++) {
                        sum += a.getInteger(i, k) * b.getInteger(k, j);
                    }
                    temp.setInteger(i, j, sum);
                }
            }
            return temp;
        } else if(a.cols == b.cols && a.rows == b.rows) {
            //Scalar Product if size is the same
            Matrix temp = new Matrix(a.rows, a.cols);
            for (int i = 0; i < a.rows; i++) {
                for (int j = 0; j < a.cols; j++) {
                    temp.setInteger(i, j, a.getInteger(i, j) * b.getInteger(i, j));
                }
            }
            return temp;
        } else { 
        	System.out.println("Matrix cannot be multiplied due to a size mismatch");
        	return a;
        }
    }
    
    public void sigmoid(){
        /***************************************************
         * Apply the sigmoid function to another function  *
         ***************************************************/    	
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	//  1 / (1 + e^-x)
                matrix[i][j]= 1 / (1 + Math.exp(-matrix[i][j]));
            }
        }
    }

    public Matrix add(int n) {
        /*******************************************
         * Add the matrix up by a certain value    *
         *******************************************/
        Matrix temp = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.setInteger(i, j, matrix[i][j] + n);
            }
        }
        return temp;
    }
    public Matrix add(Matrix n) {
        /********************************************
         * Add the matrix up by a another matrix    *
         *******************************************/
        Matrix temp = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.setInteger(i, j, matrix[i][j] + n.getInteger(i, j));
            }
        }
        return temp;
    }
    public Matrix transpose() {
    	/********************************************
         *  Transpose the matrix into its inverse   *
         *******************************************/
    	Matrix temp = new Matrix(cols, rows);
    		for(int i=0; i < this.rows ; i++) {
    			for(int j=0; j < this.cols; j++) {
    				temp.setInteger(j, i, this.matrix[i][j]);
    			}
    		}
    	return temp;
    }
    public void randomize() {
    	/********************************************
         *       Randomizes the int matrix          *
         *******************************************/
        Random ran = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ran.nextDouble() * 2 - 1;
            }
        }
    }
    public String toString() {
    	/********************************************
         *Outputs a string of the matrix to console *
         *******************************************/
        return Arrays.deepToString(matrix);
    }

    //Accessors
    public int getFullLength() {
        return rows * cols;
    }
    public double getInteger(int row, int col) {
        return matrix[row][col];
    }

    //Mutators
    public void setInteger(int row, int col, double value) {
        matrix[row][col] = value;
    }

}