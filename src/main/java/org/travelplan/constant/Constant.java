package org.travelplan.constant;

import java.util.EnumMap;
import java.util.Map;

public class Constant {
	public enum UserRoles {USER, ADMIN}
	
	public static Map<UserRoles, String> userRolesMap = new EnumMap<UserRoles, 
			String>(UserRoles.class);
	
	static {
		userRolesMap.put(UserRoles.USER, "ROLE_USER");
		userRolesMap.put(UserRoles.ADMIN, "ROLE_ADMIN");
	}
	
	public static String getUserRole(UserRoles userRoles) {
		return userRolesMap.get(userRoles);
	}
	
	private static Integer idCurrentUser;

	public static Integer getIdCurrentUser() {
		return idCurrentUser;
	}

	public static void setIdCurrentUser(Integer idCurrentUser) {
		Constant.idCurrentUser = idCurrentUser;
	}
}
