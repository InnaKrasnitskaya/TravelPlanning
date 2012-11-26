package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.Profile;

public interface ProfileDAO {
	public void add(Profile profile);
    public List<Profile> getList();
    public void remove(Integer id);
    public void update(Profile profile);
    public Profile findById(Integer id);
}
