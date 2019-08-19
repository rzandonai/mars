package br.com.rzandonai.mars.services.impl;

import br.com.rzandonai.mars.dtos.PositionDTO;
import br.com.rzandonai.mars.enums.DirectionEnum;
import br.com.rzandonai.mars.exceptions.MovimentException;
import br.com.rzandonai.mars.services.MarsService;

import org.springframework.stereotype.Service;

@Service
public class MarsServiceImpl implements MarsService {

	@Override
	public PositionDTO calculatePosition(String moviment) {
		if (moviment == null || moviment.trim().length() == 0) {
			throw new MovimentException("No moviments", "please send a moviment in String format 'M' to move ahead and 'R' and 'L' to Rotate");
		}

		if (!moviment.contains("M")) {
			throw new MovimentException("No ahead moviments", "you send a rotate but not a ahead  movimente please add 'M' to move ahead ");
		}

		PositionDTO position = new PositionDTO();
		moviment.codePoints()
			.mapToObj(Character::toChars).map(String::valueOf).forEach(c -> this.execute(c, position));
		return position;
	}

	private void execute(String c, PositionDTO position) {
		// validade char
		switch (c) {
		case "M":
			moveAhead(position);
			break;
		case "L":
			moveLeft(position);
			break;
		case "R":
			moveRight(position);
			break;
		default:
			throw new MovimentException("Unrecognized movement", "you sent an unknown command");
		}
	}

	private void moveRight(PositionDTO position) {
		switch (position.getDirection().customOrdinal()) {
		case 0:
			position.setDirection(DirectionEnum.EAST);
			break;
		case 1:
			position.setDirection(DirectionEnum.SOUTH);
			break;
		case 2:
			position.setDirection(DirectionEnum.WEST);
			break;
		case 3:
			position.setDirection(DirectionEnum.NORTH);
			break;
		}
	}

	private void moveLeft(PositionDTO position) {
		switch (position.getDirection().customOrdinal()) {
		case 0:
			position.setDirection(DirectionEnum.WEST);
			break;
		case 1:
			position.setDirection(DirectionEnum.NORTH);
			break;
		case 2:
			position.setDirection(DirectionEnum.EAST);
			break;
		case 3:
			position.setDirection(DirectionEnum.SOUTH);
			break;
		}
	}

	private void moveAhead(PositionDTO position) {
		int x = position.getX();
		int y = position.getY();
		switch (position.getDirection().customOrdinal()) {
		case 0:
			y++;
			break;
		case 1:
			x++;
			break;
		case 2:
			y--;
			break;
		case 3:
			x--;
			break;
		}

		if(x < 0 || y < 0 || x > 4 || y >4){
			throw new MovimentException("Out of bounds", "the command sent causes the robot to move outside the defined area");
		}
		position.setX(x);
		position.setY(y);
	}
}
