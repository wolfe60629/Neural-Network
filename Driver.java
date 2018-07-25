import java.util.Arrays;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		
		//Training Data 
		double[] ai = {0,1}; double[] at = {1};
		double[] bi = {1,0}; double[] bt = {1};
		double[] ci = {0,0}; double[] ct = {0};
		double[] di = {1,1}; double[] dt = {0};
		
		TrainingData[] training_data  = {
				new TrainingData(ai,at), 
				new TrainingData(bi,bt),
				new TrainingData(ci,ct), 
				new TrainingData(di,dt)
				};

		
		//Train Neural Network
		 NeuralNetwork nn = new NeuralNetwork(2,2,1); 
		for (int i=0 ; i < 10000 ; i++) {
			for (int j =0 ; j < training_data.length; j++)  {
			 nn.train(training_data[j].getInput(), training_data[j].getTarget());
			}
			}

		
	
		
		//Test Neural Network
		System.out.println(Arrays.toString(nn.feedforward(ai)));
		System.out.println(Arrays.toString(nn.feedforward(bi)));
		System.out.println(Arrays.toString(nn.feedforward(ci)));
		System.out.println(Arrays.toString(nn.feedforward(di)));
	}

}
