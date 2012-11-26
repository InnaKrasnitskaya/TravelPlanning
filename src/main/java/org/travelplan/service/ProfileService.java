package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.Profile;

public interface ProfileService {
	public List<Profile> getList();
	public void add(Profile profile);
    public void remove(Integer id);
    public void update(Profile profile);
    public Profile findById(Integer id);
}
