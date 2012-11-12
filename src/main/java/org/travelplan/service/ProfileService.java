package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.Profile;

public interface ProfileService {
	public List<Profile> getListProfile();
	public void addProfile(Profile profile);
}
