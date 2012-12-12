package org.travelplan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.PlaceDAO;
import org.travelplan.entity.Place;


@Repository("PlaceDAO")
@Transactional
public class PlaceDAOImpl extends CommonDAOImpl<Place>  implements PlaceDAO {
	       
	public PlaceDAOImpl() {
		super(Place.class);
	}

	public Place findByCoordinates(Float latitude, Float longitude) {
    	return (Place) getSession().createCriteria(Place.class).
    			add(Restrictions.eq("latitude", latitude)).
    			add(Restrictions.eq("longitude", longitude)).
    			uniqueResult();       		 
    }
}
