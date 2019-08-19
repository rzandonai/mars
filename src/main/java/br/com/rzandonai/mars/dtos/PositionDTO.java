package br.com.rzandonai.mars.dtos;

import br.com.rzandonai.mars.enums.DirectionEnum;

public class PositionDTO {
	private int x;
	private int y;
	private DirectionEnum direction;

	public PositionDTO() {
		x = 0;
		y = 0;
		direction = DirectionEnum.NORTH;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d, %s)", x, y, direction.abbreviation());
	}
}
