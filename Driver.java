import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		/*
		 * NeuralNetwork nn = new NerualNetwork(2,2,1)
		 * Input[] = [1,0]
		 * Output = nn.feedforward(Input);
		 * System.out.println(Output);
		 */
		
		
		 NeuralNetwork nn = new NeuralNetwork(2,2,1);
		 double input[] = new double[] {1,0};
		 double[] output = nn.feedforward(input);
		 System.out.println("Real Output" + Arrays.toString(output));
		 

	}

}
