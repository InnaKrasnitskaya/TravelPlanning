package org.travelplan.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.ProfileDAO;
import org.travelplan.entity.Profile;

@Repository("profileDAO")
@Transactional
public class ProfileDAOImpl extends CommonDAOImpl<Profile> implements ProfileDAO {

	public ProfileDAOImpl() {
		super(Profile.class);
	}
}
