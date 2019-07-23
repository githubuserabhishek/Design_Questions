package com.lift;

import java.util.PriorityQueue;

public class Lift {

	private boolean isGoingUp = false;
	private boolean isActive = false;
	private Integer currentFloor = 0;
	private Integer maxFloor = 0;
	private Integer minFloor = 0;
	private Integer destinationFloor = 0;
	private boolean isGateOpen = false;
	private PriorityQueue<Integer> pq = null;

	public Lift(Integer minFloor, Integer maxFloor) {
		this.maxFloor = maxFloor;
		this.minFloor = minFloor;
		this.pq = new PriorityQueue<>();
	}
	
	public boolean isQueueEmpty() {
		return pq.isEmpty();
	}

	public Integer getTopFloorFromQueue() {
		return pq.peek();
	}

	public Integer removeTopFloorFromQueue() {
		return pq.poll();
	}

	public void addFloorToQueue(Integer floor) {
		this.pq.add(floor);
	}

	public Integer getMinFloor() {
		return minFloor;
	}

	public void setMinFloor(Integer minFloor) {
		this.minFloor = minFloor;
	}

	public Integer getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(Integer maxFloor) {
		this.maxFloor = maxFloor;
	}

	public boolean isGateOpen() {
		return isGateOpen;
	}

	public void setGateOpen(boolean isGateOpen) {
		this.isGateOpen = isGateOpen;
	}

	public boolean isGoingUp() {
		return isGoingUp;
	}

	public void setGoingUp(boolean isGoingUp) {
		this.isGoingUp = isGoingUp;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
	}

	public Integer getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloor(Integer destinationFloor) {
		this.destinationFloor = destinationFloor;
		setLiftDirection();
	}

	public void setLiftDirection() {
		isGoingUp = (getCurrentFloor() < getDestinationFloor()) ? true : false;
	}

}
