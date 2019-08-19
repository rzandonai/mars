package br.com.rzandonai.mars.enums;

public enum DirectionEnum {
	NORTH,
	EAST,
	SOUTH,
	WEST;

	public int customOrdinal() {
		switch (this) {
		case SOUTH:
			return 2;
		case WEST:
			return 3;
		case EAST:
			return 1;
		}
		return 0;
	}

	public String abbreviation() {

		switch (this) {
		case SOUTH:
			return "S";
		case WEST:
			return "W";
		case EAST:
			return "E";
		}
		return "N";
	}
}
