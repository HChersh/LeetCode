package leetcode;

public class Nodes extends Node {
	Nodes random;
    public Nodes(int value,Nodes next,Nodes random){
    	super(value,next);
        this.random = random;
    }
  public Nodes(int value){
	  this.value = value;
  }
}
