public class TrainingData {
 private double[] input;
 private double[] target;

 public TrainingData(double[] input, double[] target) {
   this.input = input;
   this.target = target;
  }
  //getters
 public double[] getInput() {
  return input;
 }

 public double[] getTarget() {
  return target;
 }

 //setters
 public void setInput(double[] input) {
  this.input = input;
 }

 public void setTarget(double[] target) {
  this.target = target;
 }
}