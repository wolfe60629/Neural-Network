# Neural Network
This is the baseline to my senior project. It is a multi-perceptron neural network that can learn based on the data that is fed through the algorithm. Using backpropigation, the algorithm tweaks different values, and normallizes the dataset with a sigmodial activation function. My plan is to implement this neural network inside of a drone to develop an accident avoidance system that is automomous. 




## NeuralNetwork.java

This class implements the neural network, and establishes a feed forward algorithm to insert data. It also implements a way for for the network to become trained with a seperate set of training data. Since this is a multiperceptron network, the constructor allows for variance in the amount of perceptrons between the three network layers.

## Matrix.java

This class contains all of the linear algebra required for the neural network. In the class, you can: scale a matrix, multiply two matrices, subtract two matrices, transpose a matrix, add to a matrix, and run the values of the matrix through the derivative of the sigmoid function. 

