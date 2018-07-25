public class NeuralNetwork {
 //Class Data
 private int inputNodes;
 private int hiddenNodes;
 private int outputNodes;
 private Matrix weights_ih;
 private Matrix weights_ho;
 private Matrix bias_h;
 private Matrix bias_o;
 private double learningRate;

 public NeuralNetwork(int numI, int numH, int numO) {
  /***************
   * Constructor *
   ***************/
  inputNodes = numI;
  hiddenNodes = numH;
  outputNodes = numO;

  //Starting weights for feed forward
  weights_ih = new Matrix(hiddenNodes, inputNodes);
  weights_ho = new Matrix(outputNodes, hiddenNodes);
  weights_ih.randomize();
  weights_ho.randomize();

  //Starting bias for feed forward
  bias_h = new Matrix(hiddenNodes, 1);
  bias_o = new Matrix(outputNodes, 1);
  bias_o.randomize();
  bias_h.randomize();

  //Learning Rate
  learningRate = 0.1;
 }

 public double[] feedforward(double[] inputArray) {
  /********************************************************
   * Feeds Data Through The Network And Returns An Output *
   ********************************************************/

  /*______________GENERATING HIDDEN OUTPUTS_________________*/
  //Turn array into Matrix
  Matrix input = Matrix.fromArray(inputArray);
  //Multiply weights with input
  Matrix hidden = Matrix.multiply(weights_ih, input);
  //Add the bias
  hidden.add(bias_h);
  //Activation Function 
  hidden.sigmoid();

  /*_______________GENERATING REAL OUTPUTS__________________*/
  //Multiply weights with input
  Matrix output = Matrix.multiply(weights_ho, hidden);
  //Add the bias
  output.add(bias_o);
  //Activation Function 
  output.sigmoid();

  return output.toArray();
 }

 public void train(double[] inputArray, double[] targetsArray) {
	/*******************************************************************************
	* Trains the network by adjusting the weighted values (Min the cost function) *
	*******************************************************************************/	 

  /*______________GENERATING HIDDEN OUTPUTS_________________*/
  //Turn array into Matrix
  Matrix input = Matrix.fromArray(inputArray);
  //Multiply weights with input
  Matrix hidden = Matrix.multiply(weights_ih, input);

  //Add the bias
  hidden.add(bias_h);
  //Activation Function 
  hidden.sigmoid();


  /*_______________GENERATING REAL OUTPUTS__________________*/
  //Multiply weights with input
  Matrix output = Matrix.multiply(weights_ho, hidden);
  //Add the bias
  output.add(bias_o);
  //Activation Function 
  output.sigmoid();


  /*__________________Preparing Training____________________*/
  // Convert the targets into Matrix
  Matrix targets = Matrix.fromArray(targetsArray);
  //Calc output Error 
  Matrix output_error = Matrix.subtract(targets, output);
  //Calc hidden Error 
  Matrix weights_ho_t = weights_ho.transpose();
  Matrix hidden_error = Matrix.multiply(weights_ho_t, output_error);


  /*____________Train hidden --> output layer________________*/
  // Delta Weight = learningRate * error * (derivative of output)

  //Calc Gradient output layer
  Matrix gradient = Matrix.derSigmoid(output);
  gradient = Matrix.multiply(gradient, output_error);
  gradient.multiply(learningRate);

  //Calc Deltas hidden -> output layer
  Matrix hidden_t = hidden.transpose();
  Matrix weights_ho_delta = Matrix.multiply(gradient, hidden_t);

  // Train output layer
  this.weights_ho.add(weights_ho_delta);
  this.bias_o.add(gradient);


  /*_____________Train input --> hidden layer________________*/
  // Delta Weight = learningRate * error * (derivative of output)

  //Calc Gradient hidden layer
  Matrix hidden_gradient = Matrix.derSigmoid(hidden);
  hidden_gradient = Matrix.multiply(hidden_gradient, hidden_error);
  hidden_gradient.multiply(learningRate);

  //Calc Deltas input -> hidden layer
  Matrix input_t = input.transpose();
  Matrix weights_ih_delta = Matrix.multiply(hidden_gradient, input_t);

  // Train hidden layer
  this.weights_ih.add(weights_ih_delta);
  this.bias_h.add(hidden_gradient);

 }

}