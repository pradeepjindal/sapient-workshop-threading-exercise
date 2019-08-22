package org.pra.carworkshop.task;

public class Task {

	private String name;
	private int time;
	private float fee;
	
	
	public Task(String name, int time, float fee) {
		this.name = name;
		this.time = time;
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", time=" + time + ", fee=" + fee + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}

}
