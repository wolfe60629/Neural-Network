package src;

import java.util.Arrays;

public class NeuralNetwork {
	//Class Data
	private int inputNodes;
	private int hiddenNodes;
	private int outputNodes;
	private Matrix weights_ih; 
	private Matrix weights_ho;
	private Matrix bias_h;
	private Matrix bias_o;
	
	public NeuralNetwork(int numI, int numH, int numO) {
		 inputNodes = numI;
		 hiddenNodes = numH;
		 outputNodes = numO;
		 
		 //Starting weights for feedforward
		 weights_ih = new Matrix(hiddenNodes, inputNodes);
		 weights_ho = new Matrix(outputNodes, hiddenNodes);
		 weights_ih.randomize();
		 weights_ho.randomize();
		 
		//Starting bias for feedforward
		 bias_h = new Matrix(hiddenNodes, 1);
		 bias_o = new Matrix(outputNodes, 1);
		 bias_o.randomize();
		 bias_h.randomize();
	}
	
	public double[] feedforward(double[] inputArray) {
		
		/*****************GENERATING HIDDEN OUTPUTS************************/
		//Turn array into Matrix
		Matrix input = Matrix.fromArray(inputArray);
		//Multiply weights with input
		Matrix hidden = Matrix.multiply(weights_ih, input);

		//Add the bias
		hidden.add(bias_h);
		//Activation Function 
		hidden.sigmoid();
		
		System.out.println("Hidden Output" + hidden.toString());
		
		/*****************GENERATING REAL OUTPUTS************************/
		//Multiply weights with input
		Matrix output = Matrix.multiply(weights_ho, hidden);
		//Add the bias
		output.add(bias_o);
		//Activation Function 
		output.sigmoid();
		
		return output.toArray();
	}
	
	public void train() {
		
	}

}
