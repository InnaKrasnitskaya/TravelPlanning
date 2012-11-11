package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.Profile;

public interface ProfileDAO {
	public void addProfile(Profile profile);
    public List<Profile> listProfile();
    public void removeProfile(Integer id);
}
